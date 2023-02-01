package controller;

import model.Agenda;
import model.Contacto;
import model.Model;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    View view = new View();
    Model model = new Model();


    public void acorrer() {
      for (;;) {
          int opcion = view.pedirOpcion();
          System.out.println();

          if (opcion == 1) {
              List<Contacto> contactos = model.listaContactos;
              view.mostrarContactos(contactos);
          } else if (opcion == 2) {
              ContactoDTO datos = view.addContacto();
              model.addContacto(datos);
          } else if (opcion == 3) {
              ContactoDTO eliminado = view.eliminarContacto();
              model.removeContacto(eliminado);
          }
          System.out.println();
      }
    }
}
