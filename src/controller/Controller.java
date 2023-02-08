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
      for(;;) {
          view.imprimirMenuPrincipal();
          opcion = view.pedirOpcion();
          if (opcion == 1) {
                  List<Agenda> agendas = model.listaDeAgendas;
                  view.mostrarLsitaAgendas(agendas);
                  opcionAgenda = view.pedirOpcion();
                  for (;;) {
                      view.imprimirMenuContactos();
                      opcion = view.pedirOpcion();
                      System.out.println();

                      if (opcion == 1) {
                          List<Contacto> contactos = model.listaContactos();
                          view.mostrarContactos(contactos);
                      } else if (opcion == 2) {
                          ContactoDTO datos = view.addContacto();
                          model.addContacto(datos);
                      } else if (opcion == 3) {
                          ContactoDTO eliminado = view.eliminarContacto();
                          model.removeContacto(eliminado);
                      } else if (opcion == 4) {
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
