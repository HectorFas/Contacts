package model;

import controller.ContactoDTO;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public ArrayList<Contacto> listaContactos = new ArrayList<>();

    public void addContacto(ContactoDTO datos) {
        listaContactos.add(new Contacto(datos.nombre, datos.telefono));
    }

    public List<Contacto> imprimirListaContacto() {
        return listaContactos;
    }

    public void removeContacto(ContactoDTO eliminado) {
       listaContactos.removeIf(contacto -> contacto.nombre.equals(eliminado.nombre) || contacto.telefono.equals(eliminado.telefono));
    }
}
