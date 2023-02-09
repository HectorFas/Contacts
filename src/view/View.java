package view;

import controller.AgendaDTO;
import controller.ContactoDTO;
import model.Agenda;
import model.Contacto;

import java.util.List;
import java.util.Scanner;

public class View {
    public Scanner scanner = new Scanner(System.in);


    public int pedirOpcion() {
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
        System.out.println("Introduzca el nombre y telefono de su contacto: ");
        String nombre = scanner.next();
        String telefono = scanner.next();
        return new ContactoDTO(nombre, telefono);
    }


    public ContactoDTO eliminarContacto() {
        String nombreEliminar = scanner.next();
        String telefonoEliminar = scanner.next();
        return new ContactoDTO(nombreEliminar, telefonoEliminar);
    }

    public void imprimirMenuPrincipal() {
        System.out.println("-- Bienvenido a tu agenda --");
        System.out.println("1. Mostrar Agendas");
        System.out.println("2. Añadir Agenda");
        System.out.println("3. Eliminar Agenda");
    }

    public void mostrarLsitaAgendas(List<Agenda> agendas) {
            System.out.println("Estas son tus agendas: ");
            agendas.forEach(agenda -> System.out.println(agenda.nombreAgenda + " ---- " + agenda.descripcionAgenda));
            System.out.println("¿Que agenda quieres?");
    }

    public void imprimirMenuContactos() {
        System.out.println("1. Mostrar lista de contactos");
        System.out.println("2. Añadir contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Salir de la agenda");
    }

    public AgendaDTO addAgenda() {
        String nombreAgenda = scanner.next();
        String descripcionAgenda = scanner.next();
        return  new AgendaDTO(nombreAgenda, descripcionAgenda);
    }

    public String removeAgenda() {
        String nombreAgenda = scanner.next();
        return  nombreAgenda;
    }

    public void ponloEnOtraAgenda() {
        System.out.println("¿Este contacto solo esta en esta agenda, quieres ponerlo en alguna más?");
        System.out.println("1. SI");
        System.out.println("2. NO");
    }

    public void enQueAgenda() {
        System.out.println("¿En que agenda lo pongo?");
    }
}



