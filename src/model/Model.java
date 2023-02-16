package model;

import controller.AgendaDTO;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public ArrayList<Agenda> listaDeAgendas = new ArrayList<>();

    public boolean addContacto(controller.ContactoDTO datos, int opcionAgenda) {
        listaDeAgendas.get(opcionAgenda).contactosDeCadaAgenda.add(new Contacto(datos.nombre, datos.telefono));

        for (int i = 0; i < listaDeAgendas.size(); i++) {
            if (opcionAgenda != i) {
                for (Contacto contacto : listaDeAgendas.get(i).contactosDeCadaAgenda) {
                    if (contacto.nombre.equals(datos.nombre)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<Contacto> listaContactosDeAgenda(int opcionAgenda) {
        return listaDeAgendas.get(opcionAgenda).contactosDeCadaAgenda;
    }

    public void removeContacto(controller.ContactoDTO eliminado) {
        for (Agenda agenda : listaDeAgendas) {
            agenda.contactosDeCadaAgenda.removeIf(contacto -> contacto.nombre.equals(eliminado.nombre) || contacto.telefono.equals(eliminado.telefono));
        }
    }

    public List<Contacto> buscarContactos(String busqueda, int opcionAgenda) {
        List<Contacto> contactosEncontrados = new ArrayList<>();

        for (Contacto contacto : listaDeAgendas.get(opcionAgenda).contactosDeCadaAgenda) {
            if (contacto.nombre.toLowerCase().contains(busqueda.toLowerCase()) || contacto.telefono.toLowerCase().contains(busqueda.toLowerCase())) {
                contactosEncontrados.add(contacto);
            }
        }

        return contactosEncontrados;  //Para Buscar Contactos!!!
    }

    public void addAgenda(AgendaDTO datos) {
        listaDeAgendas.add(new Agenda(datos.nombreAgenda, datos.descripcionAgenda));
    }

    public void removeAgenda(String eliminado) {
        listaDeAgendas.removeIf(Agenda -> eliminado.equals(Agenda.nombreAgenda));
    }


    public void modificarNombre(List<Contacto> contactosEncontrados, int contactoModificar, String nombre) {
        contactosEncontrados.get(contactoModificar).nombre = nombre;
    }

    public void modificarTelefono(List<Contacto> contactosEncontrados, int contactoModificar, String telefono) {
        contactosEncontrados.get(contactoModificar).telefono = telefono;
    }



}
