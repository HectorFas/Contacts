package model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    public String nombreAgenda;
    public String descripcionAgenda;
    public List<Contacto> contactosDeCadaAgenda = new ArrayList<>();

    public Agenda(String nombreAgend, String descripcionAgend) {
        this.nombreAgenda = nombreAgend;
        this.descripcionAgenda = descripcionAgend;
    }
}
