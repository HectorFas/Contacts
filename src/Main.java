import controller.Controller;

public class Main {
    public static void main (String[] args) {

        Controller controller = new Controller();
        RellenarDatos rellenarDatos = new RellenarDatos();
        rellenarDatos.rellenar(controller.model.listaDeAgendas);

       controller.acorrer();


    }
}