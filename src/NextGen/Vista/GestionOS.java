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
                case '1' -> gestionArticulos();
                case '2' -> gestionClientes();
                case '3' -> gestionPedidos();
                case '0' -> salir = true;
                default ->
                        System.out.println("\u001B[31m" + "Opción inválida. Por favor, elija una opción válida." + "\u001B[0m");
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
                case '1' -> controlador.listarArticulos();
                case '2' -> controlador.agregarArticulo();
                case '3' -> controlador.eliminarArticulo();
                case '0' -> salir = true;
                default ->
                        System.out.println("\u001B[31m" + "Opción inválida. Por favor, elija una opción válida." + "\u001B[0m");
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
            System.out.println("║ 5. Eliminar Cliente          ║");
            System.out.println("║ 0. Salir                     ║");
            System.out.println("╚══════════════════════════════╝");
            opcion = pedirOpcion();
            switch (opcion) {
                case '1' -> controlador.listarClientes();
                case '2' -> controlador.listarClienteEstandard();
                case '3' -> controlador.listarClientePremium();
                case '4' -> controlador.agregarCliente();
                case '5' -> controlador.eliminarCliente();
                case '0' -> salir = true;
                default ->
                        System.out.println("\u001B[31m" + "Opción inválida. Por favor, elija una opción válida." + "\u001B[0m");
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
                case '1' -> controlador.agregarPedido();
                case '2' -> controlador.listarPedidos();
                case '3' -> controlador.listarPedidosPendientes();
                case '4' -> controlador.listarPedidosEnviados();
                case '5' -> controlador.eliminarPedido();
                case '0' -> salir = true;
                default ->
                        System.out.println("\u001B[31m" + "Opción inválida. Por favor, elija una opción válida." + "\u001B[0m");
            }
        } while (!salir);
    }
}
