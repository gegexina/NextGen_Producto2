package NextGen.Controlador;

import NextGen.Modelo.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Clase que actúa como el controlador principal de la aplicación.
 */
public class Controlador {
    private Datos datos;
    private Iterable<? extends Articulo> lista;

    /**
     * Constructor que inicializa una instancia de Datos.
     */
    public Controlador() {
        datos = new Datos();
    }
    /**
     * Lista y muestra todos los articulos presentes en la lista.
     */
    public void listarArticulos() {
        for (Articulo articulo : lista) {
            System.out.println(articulo);
        }
    }
    /**
     * Método para agregar un artículo a la lista
     * @param articulo El artículo que se desea agregar a la lista.
     */
    public void agregarArticulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agregar un nuevo artículo:");

        System.out.print("Código: ");
        String codigo = String.valueOf(scanner.nextInt());
        scanner.nextLine();

        ListaArticulos listaArticulos = datos.getListaArticulos();
        for (Articulo articuloExistente : listaArticulos.getArrayList()) {
            if (articuloExistente.getCodigo() == codigo) {
                System.out.println("¡Error! Ya existe un artículo con el mismo código.");
                return;
            }
        }

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Gastos de Envío: ");
        double gastosEnvio = scanner.nextDouble();

        System.out.print("Preparación en Minutos: ");
        int preparacionEnMin = scanner.nextInt();

        Articulo nuevoArticulo = new Articulo(codigo, descripcion, precio, gastosEnvio, preparacionEnMin);

        listaArticulos.agregar(nuevoArticulo);

        System.out.println("Datos del artículo agregado:");
        System.out.println("+---------------------+-----------------------+");
        System.out.println("| Campo               | Valor                 |");
        System.out.println("+---------------------+-----------------------+");
        System.out.println(String.format("| Código              | %d                   |", nuevoArticulo.getCodigo()));
        System.out.println(String.format("| Descripción         | %s          |", nuevoArticulo.getDescripcion()));
        System.out.println(String.format("| Precio              | %.2f€                 |", nuevoArticulo.getPrecio()));
        System.out.println(String.format("| Gastos de Envío     | %.2f€                 |", nuevoArticulo.getGastosEnvio()));
        System.out.println(String.format("| Preparación (min)   | %d min                |", nuevoArticulo.getPreparacionEnMin()));
        System.out.println("+---------------------+-----------------------+");
    }

    /**
     * Método para eliminar un artículo de la lista
     * @param articulo El artículo que se desea eliminar de la lista.
     */
    public void eliminarArticulo(Articulo articulo) {
        lista.remove(articulo);
    }


    /**
     * Lista y muestra todos los clientes presentes en la lista.
     */
    public void listarClientes() {
        for (Cliente cliente : lista) {
            System.out.println(cliente);
        }
    }
    /**
     * Agrega un nuevo cliente a la lista de clientes solicitando al usuario los datos necesarios.
     */
    public void agregarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agregar un nuevo cliente:");

        System.out.print("NIF: ");
        String nif = scanner.nextLine();

        ListaClientes listaClientes = datos.getListaClientes();
        for (Cliente clienteExistente : listaClientes.getArrayList()) {
            if (clienteExistente.getNif().equals(nif)) {
                System.out.println("¡Error! Ya existe un cliente con el mismo NIF.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Dirección de envío: ");
        String direccion = scanner.nextLine();

        System.out.print("Tipo de cliente (Estandard/Premium): ");
        String tipoCliente = scanner.nextLine();

        Cliente nuevoCliente;

        if (tipoCliente.equalsIgnoreCase("Estandard")) {
            nuevoCliente = new ClienteEstandard(nif, nombre, email, direccion);
        } else if (tipoCliente.equalsIgnoreCase("Premium")) {
            nuevoCliente = new ClientePremium(nif, nombre, email, direccion);
        } else {
            System.out.println("Tipo de cliente no válido. Se creará como cliente estándard por defecto.");
            nuevoCliente = new ClienteEstandard(nif, nombre, email, direccion);
        }

        listaClientes.agregar(nuevoCliente);

        System.out.println("Cliente agregado con éxito:");
        System.out.println("+---------------------+-----------------------+");
        System.out.println("| Campo               | Valor                 |");
        System.out.println("+---------------------+-----------------------+");
        System.out.println(String.format("| NIF                 | %s            |", nuevoCliente.getNif()));
        System.out.println(String.format("| Nombre              | %s                 |", nuevoCliente.getNombre()));
        System.out.println(String.format("| Email               | %s          |", nuevoCliente.getEmail()));
        System.out.println(String.format("| Dirección de envío  | %s    |", nuevoCliente.getDireccion()));
        System.out.println(String.format("| Tipo de Cliente     | %s             |", tipoCliente));
        System.out.println("+---------------------+-----------------------+");
    }
    /**
     * Método para eliminar un cliente de la lista
     * @param cliente El cliente que se desea eliminar de la lista
     */
    public void eliminarCliente(Cliente cliente) {
        lista.remove(cliente);
    }


    /**
     * Lista y muestra todos los pedidos presentes en la lista.
     */
    public void listarPedidos() {
        for (Pedido pedido : lista) {
            System.out.println(pedido);
        }
    }
    /**
     * Agrega un nuevo pedido a la lista de pedidos solicitando al usuario los datos necesarios.
     */
    public void agregarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agregar un nuevo pedido:");

        System.out.print("Número de Pedido: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Fecha y Hora (yyyy-MM-dd HH:mm:ss): ");
        String fechaHoraStr = scanner.nextLine();
        Date fechaHora = null;

        try {
            fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHoraStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha y hora no válido. El pedido se creará con la fecha y hora actual.");
            fechaHora = new Date();
        }

        System.out.print("NIF del Cliente: ");
        String nifCliente = scanner.nextLine();
        Cliente cliente = datos.getListaClientes().buscarPorNIF(nifCliente);

        if (cliente == null) {
            System.out.println("¡Error! No se encontró un cliente con el NIF especificado.");
            return;
        }

        System.out.print("Código del Artículo: ");
        int codigoArticulo = scanner.nextInt();
        scanner.nextLine();
        Articulo articulo = datos.getListaArticulos().buscarPorCodigo(codigoArticulo);

        if (articulo == null) {
            System.out.println("¡Error! No se encontró un artículo con el código especificado.");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        Pedido nuevoPedido = new Pedido(numeroPedido, fechaHora, cliente, articulo, cantidad);

        ListaPedidos listaPedidos = datos.getListaPedidos();
        listaPedidos.agregar(nuevoPedido);

        System.out.println("Pedido agregado con éxito:");
        System.out.println("+---------------------+-----------------------+");
        System.out.println("| Campo               | Valor                 |");
        System.out.println("+---------------------+-----------------------+");
        System.out.println(String.format("| Número de Pedido     | %d             |", nuevoPedido.getNumeroPedido()));
        System.out.println(String.format("| Fecha y Hora         | %s       |", nuevoPedido.getFechaHora()));
        System.out.println(String.format("| NIF del Cliente      | %s            |", nuevoPedido.getCliente().getNif()));
        System.out.println(String.format("| Nombre del Cliente   | %s                 |", nuevoPedido.getCliente().getNombre()));
        System.out.println(String.format("| Código del Artículo  | %s            |", nuevoPedido.getArticulo().getCodigo()));
        System.out.println(String.format("| Descripción Artículo | %s              |", nuevoPedido.getArticulo().getDescripcion()));
        System.out.println(String.format("| Cantidad             | %d             |", nuevoPedido.getCantidad()));
        System.out.println(String.format("| Precio Total         | %.2f€            |", nuevoPedido.precioTotal()));
        System.out.println("+---------------------+-----------------------+");
    }
    /**
     * Método para eliminar un pedido de la lista
     * @param numeroPedido El pedido que se desea eliminar de la lista
     */
    public void eliminarPedido(Pedido pedido) {
        lista.remove(pedido);
    }

}