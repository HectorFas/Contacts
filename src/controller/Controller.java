package controller;

import model.Agenda;
import model.Contacto;
import model.Model;
import view.View;

import java.util.InputMismatchException;
import java.util.List;

public class Controller {
    public View view = new View();
    public Model model = new Model();
    int opcion, opcionAgenda, opcionAgendaQueFalta;


    public void acorrer() {

        for (; ; ) {
            try {
                List<Agenda> agendas = model.listaDeAgendas;
                view.imprimirMenuPrincipal();
                opcion = view.pedirOpcion(3);
                if (opcion == 1 && agendas.size() != 0 ) {
                    view.mostrarLsitaAgendas(agendas);
                    opcionAgenda = view.pedirOpcion(agendas.size());
                    opcionAgenda-=1;
                    for (; ; ) {
                        view.imprimirMenuContactos(agendas, opcionAgenda);
                        opcion = view.pedirOpcion();
                        System.out.println();

                        if (opcion == 1) {
                            List<Contacto> contactos = model.listaContactosDeAgenda(opcionAgenda);
                            view.mostrarContactos(contactos);
                        } else if (opcion == 2) {
                            controller.ContactoDTO datos = view.addContacto();
                            boolean falta = model.addContacto(datos, opcionAgenda);
                            if (falta) {
                                view.ponloEnOtraAgenda();
                                opcion = view.pedirOpcion();
                                if (opcion == 1) {
                                    view.enQueAgenda();
                                    opcionAgendaQueFalta = view.pedirOpcion();
                                    model.addContacto(datos, opcionAgendaQueFalta);
                                }
                            }
                        } else if (opcion == 3) {
                            String busqueda = view.buscarContactoModificar();
                            List<Contacto> contactosEncontrados = model.buscarContactos(busqueda, opcionAgenda);
                            int contactoModificar = view.imprimirContactosModificar(contactosEncontrados);
                            for (; ; ) {
                                opcion = view.pedirOpcion();
                                if (opcion == 1) {
                                    String nombre = view.pedirNombreModificar();
                                    model.modificarNombre(contactosEncontrados, contactoModificar, nombre);
                                    break;
                                } else if (opcion == 2) {
                                    String telefono = view.pedirTelefonoModificar();
                                    model.modificarTelefono(contactosEncontrados, contactoModificar, telefono);
                                    break;
                                } else {
                                    view.imprimirErrorOpcionModificar();
                                }
                            }
                        } else if (opcion == 4) {
                            String busqueda = view.buscarContacto();
                            List<Contacto> contactosEncontrados = model.buscarContactos(busqueda, opcionAgenda);
                            view.imprimirContactosEncontrados(contactosEncontrados);
                        } else if (opcion == 5) {
                            List<Contacto> contactos = model.listaContactosDeAgenda(opcionAgenda);
                            view.mostrarContactos(contactos);
                            controller.ContactoDTO eliminado = view.eliminarContacto();
                            model.removeContacto(eliminado);
                        } else if (opcion == 6) {
                            break;
                        }
                        System.out.println();
                    }
                } else if (opcion == 2) {
                    AgendaDTO datos = view.addAgenda();
                    model.addAgenda(datos);
                } else if (opcion == 3 && agendas.size() != 0) {
                    String eliminado = view.removeAgenda();
                    model.removeAgenda(eliminado);
                } else  {
                    view.imprimirErrorAgendas();
                }
            } catch (IndexOutOfBoundsException exception) {
                view.imprimirErrorOpcion();
            } catch (InputMismatchException exception) {
                view.imprimirErrorOpcion();
                view.scanner.nextLine();
            }
        }
    }
}

// Buscar Contactos,
