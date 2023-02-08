package model;

import controller.AgendaDTO;
import controller.ContactoDTO;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public ArrayList<Contacto> listaAContactos = new ArrayList<>();
    public ArrayList<Agenda> listaDeAgendas = new ArrayList<>();

    public void addContacto(ContactoDTO datos) {
        listaAContactos.add(new Contacto(datos.nombre, datos.telefono));
    }

    public List<Contacto> listaContactos() {
        return listaAContactos;

    }

    public void removeContacto(ContactoDTO eliminado) {
       listaAContactos.removeIf(contacto -> contacto.nombre.equals(eliminado.nombre) || contacto.telefono.equals(eliminado.telefono));
    }

    public void addAgenda(AgendaDTO datos) {
        listaDeAgendas.add(new Agenda(datos.nombreAgenda, datos.descripcionAgenda));

    }

    public void removeAgenda(String eliminado) {
        listaAContactos.removeIf(contacto -> contacto.nombre.equals(eliminado));
    }
}
