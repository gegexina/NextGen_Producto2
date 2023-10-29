package NextGen.Vista;

import NextGen.Controlador.Controlador;
import java.util.Scanner;

public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() {
        controlador = new Controlador();
    }

    private char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción del menú: ");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
    public void inicio() {
        boolean salir = false;
        char opcion;
        do {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║        MENÚ PRINCIPAL        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Gestión Articulos         ║");
            System.out.println("║ 2. Gestión Clientes          ║");
            System.out.println("║ 3. Gestión Pedidos           ║");
            System.out.println("║ 0. Salir                     ║");
            System.out.println("╚══════════════════════════════╝");
            opcion = pedirOpcion();
            switch (opcion) {
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

    public void gestionArticulos() {
        boolean salir = false;
        char opcion;
        do {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     GESTIÓN ARTICULOS        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Listar Articulos          ║");
            System.out.println("║ 2. Añadir Articulo           ║");
            System.out.println("║ 3. Eliminar Articulo         ║");
            System.out.println("║ 0. Salir                     ║");
            System.out.println("╚══════════════════════════════╝");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    controlador.listarArticulos();
                    break;
                case '2':
                    controlador.agregarArticulo();
                    break;
                case '3':
                    controlador.eliminarArticulo(); //mirar error
                    break;
                case '0':
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        } while (!salir);
    }

    public void gestionClientes() {
        boolean salir = false;
        char opcion;
        do {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║     GESTIÓN CLIENTES         ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Listar Clientes           ║");
            System.out.println("║ 2. Listar Clientes Estandard ║");
            System.out.println("║ 3. Listar Clientes Premium   ║");
            System.out.println("║ 4. Añadir Cliente            ║");
            System.out.println("║ 5. Modificar Cliente         ║");
            System.out.println("║ 6. Eliminar Cliente          ║");
            System.out.println("║ 0. Salir                     ║");
            System.out.println("╚══════════════════════════════╝");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    controlador.listarClientes();
                    break;
                case '2':
                    controlador.listarClienteEstandard(); //FALTA AÑADIRLA
                    break;
                case '3':
                    controlador.listarClientePremium(); //FALTA AÑADIRLA
                    break;
                case '4':
                    controlador.agregarCliente();
                    break;
                case '5':
                    controlador.modificarCliente(); //FALTA CREARLA
                    break;
                case '6':
                    controlador.eliminarCliente(); //mirar error
                    break;
                case '0':
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        } while (!salir);
    }

    public void gestionPedidos() {
        boolean salir = false;
        char opcion;
        do {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║     GESTIÓN PEDIDOS            ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Crear Pedido                ║");
            System.out.println("║ 2. Listar Pedidos              ║");
            System.out.println("║ 3. Listar Pedidos Pendientes   ║");
            System.out.println("║ 4. Listar Pedidos Enviados     ║");
            System.out.println("║ 5. Eliminar Pedido             ║");
            System.out.println("║ 0. Salir                       ║");
            System.out.println("╚════════════════════════════════╝");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    controlador.agregarPedido();
                    break;
                case '2':
                    controlador.listarPedidos();
                    break;
                case '3':
                    controlador.listarPedidosPendientes(); //FALTA CREARLA
                    break;
                case '4':
                    controlador.listarPedidosEnviados(); //FALTA CREARLA
                    break;
                case '5':
                    controlador.eliminarPedido(); //MIRAR ERROR
                    break;
                case '0':
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        } while (!salir);
    }
}
