package view;

import controller.AgendaDTO;
import model.Agenda;
import model.Contacto;

import java.util.List;
import java.util.Scanner;

public class View {
    public Scanner scanner = new Scanner(System.in);
    int screen = 80;

    public int pedirOpcion() {
        int opcion = scanner.nextInt();
        return opcion;
    }

    public int pedirOpcion(int max) {

        while(true) {
            int opcion = scanner.nextInt();
            if (opcion > max) {
                System.out.println("Opcion incorrecta, max:" + max);
            } else {
                return opcion;
            }
        }
    }

    public void mostrarContactos(List<Contacto> contactos) {
        System.out.println("Estos son tus contactos: ");
        contactos.forEach(contacto -> System.out.println(contacto.nombre + " ----- " + contacto.telefono));

    }

    // public List <Biblio> obtenerListaDeBibliotecas() {
    // return;  }

    public controller.ContactoDTO addContacto() {
        System.out.println("Introduzca el nombre y telefono de su contacto: ");
        String nombre = scanner.next();
        String telefono = scanner.next();
        return new controller.ContactoDTO(nombre, telefono);
    }


    public controller.ContactoDTO eliminarContacto() {
        System.out.println();
        System.out.println("¿Que contacto quiere eliminar?");
        System.out.println("-Debe introducir el nombre y telefono exactos-");
        String nombreEliminar = scanner.next();
        String telefonoEliminar = scanner.next();
        return new controller.ContactoDTO(nombreEliminar, telefonoEliminar);
    }

    public void imprimirMenuPrincipal() {
        System.out.println("-- Bienvenido a tu agenda --");
        System.out.println("1. Mostrar Agendas");
        System.out.println("2. Añadir Agenda");
        System.out.println("3. Eliminar Agenda");
    }

    public void mostrarLsitaAgendas(List<Agenda> agendas) {
        System.out.println("Estas son tus agendas: ");
        agendas.forEach(agenda -> System.out.println(agenda.nombreAgenda + " ---- " + agenda.descripcionAgenda + " ---- " + agenda.contactosDeCadaAgenda.size()));
        System.out.println("¿Que agenda quieres?");


    }

    public void imprimirMenuContactos() {
        System.out.println("1. Mostrar lista de contactos");
        System.out.println("2. Añadir contacto");
        System.out.println("3. Modificar contacto");
        System.out.println("4. Buscar contacto");
        System.out.println("5. Eliminar contacto");
        System.out.println("6. Salir de la agenda");
    }

    public AgendaDTO addAgenda() {
        String nombreAgenda = scanner.next();
        String descripcionAgenda = scanner.next();
        return new AgendaDTO(nombreAgenda, descripcionAgenda);
    }

    public String removeAgenda() {
        String nombreAgenda = scanner.next();
        return nombreAgenda;
    }

    public void ponloEnOtraAgenda() {
        System.out.println("¿Este contacto solo esta en esta agenda, quieres ponerlo en alguna más?");
        System.out.println("1. SI");
        System.out.println("2. NO");
    }

    public void enQueAgenda() {
        System.out.println("¿En que agenda lo pongo?");
    }

    public String buscarContacto() {
        System.out.println("Para buscar un contacto ponga su numero o telefono: ");
        return scanner.next();
    }

    public void imprimirContactosEncontrados(List<Contacto> contactosEncontrados) {
        if (contactosEncontrados.size() > 1) {
            System.out.println("Se han encontrado estos contactos: ");
            contactosEncontrados.forEach(contacto -> System.out.println(contacto.nombre + " ----- " + contacto.telefono));
        } else if (contactosEncontrados.size() == 1) {
            System.out.println("Se ha encontrado este contacto: ");
            contactosEncontrados.forEach(contacto -> System.out.println(contacto.nombre + " ----- " + contacto.telefono));
        } else {
            System.out.println("No se han encontrado coincidencias con tu busqueda");
        }
    }

    public String buscarContactoModificar() {
        System.out.println("Escribe el nombre o el numero del contacto a modificar");
        return scanner.next();
    }

    public int imprimirContactosModificar(List<Contacto> contactosEncontrados) {
        int contactoModificar = 0;
        System.out.println("Coincidencias con tu busqueda: ");
        contactosEncontrados.forEach(contacto -> System.out.println(contacto.nombre + " ----- " + contacto.telefono));
        if (contactosEncontrados.size() > 1) {
            System.out.println("Elije el contacto a modificar (1,2,3...)");
            contactoModificar = scanner.nextInt();
        }
        System.out.println("¿Quieres modificar el nombre o el telefono?");
        System.out.println("1. El nombre");
        System.out.println("2. El telefono");
        return contactoModificar;
    }

    public String pedirNombreModificar() {
        System.out.println("Cual sera el nuevo nombre");
        return scanner.next();
    }


    public String pedirTelefonoModificar() {
        System.out.println("Cual sera el nuevo telefono");
        return scanner.next();
    }

    public void imprimirErrorOpcion() {
        System.out.println("¡Oh no, ha ocurrido un error!");
        System.out.println("Posibles causas:");
        System.out.println("1. Ha intentado a acceder a un registro inexistente");
        System.out.println("2. Le falta calle");
        System.out.println("3. No se me ocurre nada más");
        System.out.println();
    }

    public void imprimirErrorOpcionModificar() {
        System.out.println("¡Oh no, ha ocurrido un error!");
        System.out.println("Debe seleccionar una de las siguientes opciones:");
        System.out.println("1. El nombre");
        System.out.println("2. El telefono");
        System.out.println();
    }
}



