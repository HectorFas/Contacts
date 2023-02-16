package controller;

import model.Agenda;
import model.Contacto;
import model.Model;
import view.View;

import java.util.List;

public class Controller {
    public View view = new View();
    public Model model = new Model();
    int opcion;
    int opcionAgenda;

    public void acorrer() {
        for (; ; ) {
            view.imprimirMenuPrincipal();
            opcion = view.pedirOpcion();
            if (opcion == 1) {
                List<Agenda> agendas = model.listaDeAgendas;
                view.mostrarLsitaAgendas(agendas);
                opcionAgenda = view.pedirOpcion();
                for (; ; ) {
                    view.imprimirMenuContactos();
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
                                opcionAgenda = view.pedirOpcion();
                                model.addContacto(datos, opcionAgenda);
                            }
                        }
                    } else if (opcion == 3) {
                        String busqueda = view.buscarContactoModificar();
                        List<Contacto> contactosEncontrados = model.buscarContactos(busqueda, opcionAgenda);
                        int contactoModificar = view.imprimirContactosModificar(contactosEncontrados);
                        opcion = view.pedirOpcion();
                        if (opcion == 1) {
                          String nombre = view.pedirNombreModificar();
                          model.modificarNombre(contactosEncontrados, contactoModificar, nombre);
                        } else {
                            String telefono = view.pedirTelefonoModificar();
                            model.modificarTelefono(contactosEncontrados, contactoModificar, telefono);
                        }
                    } else if (opcion == 4) {
                        String busqueda = view.buscarContacto();
                        List<Contacto> contactosEncontrados = model.buscarContactos(busqueda, opcionAgenda);
                        view.imprimirContactosEncontrados(contactosEncontrados);
                    } else if (opcion == 5) {
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
            } else if (opcion == 3) {
                String eliminado = view.removeAgenda();
                model.removeAgenda(eliminado);
            }
        }
    }
}

// Buscar Contactos,
