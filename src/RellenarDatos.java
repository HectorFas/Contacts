import model.Agenda;
import model.Contacto;

import java.util.List;

public class RellenarDatos {
    void rellenar(List<Agenda> agendaList, List<Contacto> contactos) {
        Agenda agenda1 = new Agenda("Trabajo", "Mis amiguitos del trabajo");
        Agenda agenda2 = new Agenda("Personal", "Mis amiguitos");

        agendaList.add(agenda1);
        agendaList.add(agenda2);

        Contacto contacto1 = new Contacto("Pep", "3234323");
        Contacto contacto2 = new Contacto("Jon", "98789");
        Contacto contacto3 = new Contacto("Ana", "12321");


        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);

        agenda1.contactosDeCadaAgenda.add(contacto1);
        agenda1.contactosDeCadaAgenda.add(contacto2);
        agenda1.contactosDeCadaAgenda.add(contacto3);

        agenda2.contactosDeCadaAgenda.add(contacto3);

    }
}
