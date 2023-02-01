package view;

import controller.ContactoDTO;
import model.Agenda;
import model.Contacto;
import model.Model;

import java.util.List;
import java.util.Scanner;

public class View {
    public Scanner scanner = new Scanner(System.in);


    public void imprimir() {
        System.out.println("Agenda.contactos");
    }

    public int pedirOpcion() {
        System.out.println("Introduzca su opcion:");
        int opcion = scanner.nextInt();
        return opcion;
    }

    public void mostrarContactos(List<Contacto> contactos) {
        System.out.println("Estos son tus contactos: ");
        contactos.forEach(contacto -> System.out.println(contacto.nombre + " ----- " + contacto.telefono));

    }

    // public List <Biblio> obtenerListaDeBibliotecas() {
    // return;  }

    public ContactoDTO addContacto() {
        String nombre = scanner.next();
        String telefono = scanner.next();
        return new ContactoDTO(nombre, telefono);
    }


    public ContactoDTO eliminarContacto() {
        String nombreEliminar = scanner.next();
        String telefonoEliminar = scanner.next();
        return new ContactoDTO(nombreEliminar, telefonoEliminar);
    }
}
