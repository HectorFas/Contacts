package model;

import java.util.List;

public class Agenda {
    public String nombreAgenda;
    public String descripcionAgenda;
    public List<Contacto> contactos;

    public Agenda(String nombreAgend, String descripcionAgend) {
        this.nombreAgenda = nombreAgend;
        this.descripcionAgenda = descripcionAgend;
    }
}
