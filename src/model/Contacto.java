package model;

import controller.ContactoDTO;

import java.util.ArrayList;

public class Contacto {
    public String nombre;
    public String telefono;

    public Contacto(String nomConctacto, String telefContacto) {
        this.nombre = nomConctacto;
        this.telefono = telefContacto;
    }


}
