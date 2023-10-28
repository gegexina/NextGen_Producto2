package NextGen.Vista;

import NextGen.Controlador.Controlador;
import java.util.Scanner;

public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() {
        controlador = new Controlador();
    }

    public void inicio() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
                    gestionArticulos();
                    break;
                case '2':
                    gestionClientes();
                    break;
                case '3':
                    gestionPedidos();
                    break;
                case '0':
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        } while (!salir);
    }

    private char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0): ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    public void gestionArticulos() {
        //FALTA IMPLEMENTAR LA FUCNIÓN
    }

    public void gestionClientes() {
        //FALTA IMPLEMENTAR LA FUCNIÓN
    }

    public void gestionPedidos() {
        //FALTA IMPLEMENTAR LA FUCNIÓN
    }
}
