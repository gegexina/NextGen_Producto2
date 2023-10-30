package NextGen.Controlador;

import NextGen.Modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Clase que actúa como el controlador principal de la aplicación.
 */
public class Controlador {
    /**
     * Atributo que representa la instancia de Datos.
     */
    private final Datos datos;
    Scanner teclado = new Scanner(System.in);
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
        ListaArticulos listaArticulos = datos.getListaArticulos();
        if (listaArticulos.isEmpty()) {
            System.out.println("\u001B[31m" + "No hay artículos registrados." + "\u001B[0m");
        } else {
            System.out.println("\u001B[34m" + "Lista de artículos:");
            for (Articulo articulo : listaArticulos.getArrayList()) {
                System.out.println("Los articulos son los siguientes:\n " + "\u001B[0m" + articulo.toString());
            }
        }
    }
    /**
     * Método para agregar un artículo a la lista
     * El artículo que se desea agregar a la lista.
     */
    public void agregarArticulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[34m" + "Agregar un nuevo artículo:" + "\u001B[0m");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        ListaArticulos listaArticulos = datos.getListaArticulos();
        for (Articulo articuloExistente : listaArticulos.getArrayList()) {
            if (articuloExistente.getCodigo().equals(codigo)) {
                System.out.println("\u001B[31m" + "¡Error! Ya existe un artículo con el mismo código." + "\u001B[0m");
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

        listaArticulos.add(nuevoArticulo);

        System.out.println("\u001B[34m" + "Datos del artículo agregado:" + "\u001B[0m");
        System.out.println("+---------------------+-----------------------+");
        System.out.println("  Campo               | Valor                  ");
        System.out.println("+---------------------+-----------------------+");
        System.out.printf("  Código              | %s%n", nuevoArticulo.getCodigo());
        System.out.printf("  Descripción         | %s%n", nuevoArticulo.getDescripcion());
        System.out.printf("  Precio              | %.2f€%n", nuevoArticulo.getPrecio());
        System.out.printf("  Gastos de Envío     | %.2f€%n", nuevoArticulo.getGastosEnvio());
        System.out.printf("  Preparación (min)   | %d min%n", nuevoArticulo.getPreparacionEnMin());
        System.out.println("+---------------------+-----------------------+");
    }

    /**
     * Método para eliminar un artículo de la lista
     */
    public void eliminarArticulo() {
        System.out.println("\u001B[34m" + "Escoge un articulo de la lista de articulos disponibles:" + "\u001B[0m");
        ListaArticulos listaArticulos = datos.getListaArticulos();
        for (Articulo articulo : listaArticulos.getArrayList()) {
            System.out.println("Código:       " + articulo.getCodigo());
            System.out.println("Descripción:  " + articulo.getDescripcion());
            System.out.println("------------------------");
        }

        System.out.print("\u001B[34m" + "Ingrese el código del articulo que desea eliminar: " + "\u001B[0m");
        String codigoArticulo = teclado.nextLine();

        Articulo articulo = listaArticulos.buscarPorCodigo(codigoArticulo);

        if (articulo != null) {
            System.out.println("\u001B[33m" + "¿Está seguro de que desea eliminar al siguiente articulo?" + "\u001B[0m");
            System.out.println("Código:       " + articulo.getCodigo());
            System.out.println("Descripción:  " + articulo.getDescripcion());
            System.out.print("Confirme (Si/No): ");
            String confirmacion = teclado.nextLine();

            if (confirmacion.equalsIgnoreCase("Si")) {
                listaArticulos.borrar(articulo);
                System.out.println("\u001B[33m" + "Articulo eliminado con éxito." + "\u001B[0m");
            } else {
                System.out.println("\u001B[32m" + "Eliminación de articulo cancelada." + "\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31m" + "¡Error! No se encontró un articulo con el código especificado." + "\u001B[0m");
        }
    }

    /**
     * Lista y muestra todos los clientes presentes en la lista.
     */
    public void listarClientes() {
        ListaClientes listaClientes = datos.getListaClientes();
        if (listaClientes.isEmpty()) {
            System.out.println("\u001B[31m" + "No hay clientes registrados.\n" + "\u001B[0m");
        } else {
            System.out.println("\u001B[34m" + "Lista de clientes:\n");
            for (Cliente cliente: listaClientes.getArrayList()) {
                System.out.println("Los clientes son los siguientes:\n " + "\u001B[0m" + cliente.toString());
            }
        }
    }
    /**
     * Lista y muestra todos los clientes estándar presentes en la lista.
     */
    public void listarClienteEstandard () {
        ListaClientes listaClientes = datos.getListaClientes();
        if (listaClientes.isEmpty()) {
            System.out.println("\u001B[31m" + "No hay clientes estándar.\n" + "\u001B[0m");
        } else {
            System.out.println("\u001B[34m" + "Lista de clientes estándar:\n" + "\u001B[0m");
            for (Cliente cliente : listaClientes.getArrayList()) {
                if (cliente instanceof ClienteEstandard) {
                    System.out.println(cliente);
                }
            }
        }
    }
    /**
     * Lista y muestra todos los clientes premium presentes en la lista.
     */
    public void listarClientePremium () {
        ListaClientes listaClientes = datos.getListaClientes();
        if (listaClientes.isEmpty()) {
            System.out.println("\u001B[31m" + "No hay clientes premium.\n" + "\u001B[0m");
        } else {
            System.out.println("\u001B[34m" + "Lista de clientes premium :\n" + "\u001B[0m");
            for (Cliente cliente : listaClientes.getArrayList()) {
                if (cliente instanceof ClientePremium) {
                    System.out.println(cliente);
                }
            }
        }
    }
    /**
     * Agrega un nuevo cliente a la lista de clientes solicitando al usuario los datos necesarios.
     */
    public void agregarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[34m" + "Agregar un nuevo cliente:" + "\u001B[0m");

        System.out.print("NIF: ");
        String nif = scanner.nextLine();

        ListaClientes listaClientes = datos.getListaClientes();
        for (Cliente clienteExistente : listaClientes.getArrayList()) {
            if (clienteExistente.getNif().equals(nif)) {
                System.out.println("\u001B[31m" + "¡Error! Ya existe un cliente con el mismo NIF." + "\u001B[0m");
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
            System.out.println("\u001B[33m" + "Tipo de cliente no válido. Por favor, ingrese 'Estandard' o 'Premium'." + "\u001B[0m");

            do {
                System.out.print("Tipo de cliente (Estandard/Premium): ");
                tipoCliente = scanner.nextLine();
            } while (!tipoCliente.equalsIgnoreCase("Estandard") && !tipoCliente.equalsIgnoreCase("Premium"));

            if (tipoCliente.equalsIgnoreCase("Estandard")) {
                nuevoCliente = new ClienteEstandard(nif, nombre, email, direccion);
            } else {
                nuevoCliente = new ClientePremium(nif, nombre, email, direccion);
            }
        }

        listaClientes.add(nuevoCliente);

        System.out.println("\u001B[34m" + "Cliente agregado con éxito:" + "\u001B[0m");
        System.out.println("+---------------------+-----------------------+");
        System.out.println(" Campo               | Valor");
        System.out.println("+---------------------+-----------------------+");
        System.out.printf(" NIF                 | %s%n", nuevoCliente.getNif());
        System.out.printf(" Nombre              | %s%n", nuevoCliente.getNombre());
        System.out.printf(" Email               | %s%n", nuevoCliente.getEmail());
        System.out.printf(" Dirección de envío  | %s%n", nuevoCliente.getDireccion());
        System.out.printf(" Tipo de Cliente     | %s%n", tipoCliente);
        System.out.println("+---------------------+-----------------------+");
    }
    /**
     * Método para eliminar un cliente de la lista
     * El cliente que se desea eliminar de la lista
     */
    public void eliminarCliente() {
        System.out.println("\u001B[34m" + "Escoge un cliente de la lista de clientes disponibles:" + "\u001B[0m");
        ListaClientes listaClientes = datos.getListaClientes();
        for (Cliente cliente : listaClientes.getArrayList()) {
            System.out.println("NIF:     " + cliente.getNif());
            System.out.println("Nombre:  " + cliente.getNombre());
            System.out.println("------------------------");
        }

        System.out.print("\u001B[34m" + "Ingrese el NIF del Cliente que desea eliminar: " + "\u001B[0m");
        String nifCliente = teclado.nextLine();

        Cliente cliente = listaClientes.buscarPorNif(nifCliente);

        if (cliente != null) {
            System.out.println("\u001B[33m" + "¿Está seguro de que desea eliminar al siguiente cliente?" + "\u001B[0m");
            System.out.println("NIF:     " + cliente.getNif());
            System.out.println("Nombre:  " + cliente.getNombre());
            System.out.print("Confirme (Si/No): ");
            String confirmacion = teclado.nextLine();

            if (confirmacion.equalsIgnoreCase("Si")) {
                listaClientes.borrar(cliente);
                System.out.println("\u001B[33m" + "Cliente eliminado con éxito." + "\u001B[0m");
            } else {
                System.out.println("\u001B[32m" + "Eliminación de cliente cancelada." + "\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31m" + "¡Error! No se encontró un cliente con el NIF especificado." + "\u001B[0m");
        }
    }
    /**
     * Lista y muestra todos los pedidos presentes en la lista.
     */
    public void listarPedidos() {
        ListaPedidos listaPedidos = datos.getListaPedidos();
        if (listaPedidos.isEmpty()) {
            System.out.println("\u001B[31m" + "No hay pedidos registrados.\n" + "\u001B[0m");
        } else {
            System.out.println("\u001B[34m" + "Lista de pedidos:");
            for (Pedido pedido: listaPedidos.getArrayList()) {
                System.out.println("Los pedidos realizados son los siguientes:\n " + "\u001B[0m" + pedido.toString());
            }
        }
    }
    /**
     * Lista y muestra todos los pedidos pendientes presentes en la lista.
     */
    public void listarPedidosPendientes() {
        ListaPedidos listaPedidos = datos.getListaPedidos();
        if (listaPedidos.isEmpty()) {
            System.out.println("\u001B[34m" + "No hay pedidos pendientes registrados.\n" + "\u001B[0m");
        } else {
            System.out.println("\u001B[31m" + "Lista de pedidos pendientes:\n" + "\u001B[0m");
            for (Pedido pedido : listaPedidos.getArrayList()) {
                if (!pedido.isEnviado()) {
                    System.out.println(pedido);
                }
            }
        }
    }
    /**
     * Lista y muestra todos los pedidos enviados presentes en la lista.
     */
    public void listarPedidosEnviados() {
        ListaPedidos listaPedidos = datos.getListaPedidos();
        if (listaPedidos.isEmpty()) {
            System.out.println("\u001B[31m" + "No hay pedidos enviados registrados.\n" + "\u001B[0m");
        } else {
            System.out.println("\u001B[34m" + "Lista de pedidos enviados:\n" + "\u001B[0m");
            for (Pedido pedido : listaPedidos.getArrayList()) {
                if (pedido.isEnviado()) {
                    System.out.println(pedido);
                }
            }
        }
    }
    /**
     * Agrega un nuevo pedido a la lista de pedidos solicitando al usuario los datos necesarios.
     */
    public void agregarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[34m" + "Agregar un nuevo pedido:" + "\u001B[0m");

        System.out.print("Número de Pedido: ");
        int numeroPedido = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Fecha y Hora (yyyy-MM-dd HH:mm:ss): ");
        String fechaHoraStr = scanner.nextLine();
        Date fechaHora;

        try {
            fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHoraStr);
        } catch (ParseException e) {
            System.out.println("\u001B[33m" + "Formato de fecha y hora no válido. El pedido se creará con la fecha y hora actual." + "\u001B[0m");
            fechaHora = new Date();
        }

        System.out.println("\u001B[34m" + "Escoge un cliente de la lista de clientes disponibles:" + "\u001B[0m");
        ListaClientes listaClientes = datos.getListaClientes();
        for (Cliente cliente : listaClientes.getArrayList()) {
            System.out.println("NIF:          " + cliente.getNif());
            System.out.println("Nombre:       " + cliente.getNombre());
            System.out.println("Email:        " + cliente.getEmail());
            System.out.println("Dirección:    " + cliente.getDireccion());
            System.out.println("Tipo cliente: " + cliente.getDireccion());
            System.out.println("------------------------");
        }

        System.out.print("\u001B[34m" + "Ingrese el NIF del Cliente (o escriba " + "\u001B[33m" + "'nuevo'" + "\u001B[0m" + "\u001B[34m" + " para crear uno nuevo): " + "\u001B[0m");
        String nifCliente = scanner.nextLine();

        if (nifCliente.equalsIgnoreCase("nuevo")) {
            agregarCliente();
            System.out.print("Ingrese el NIF del Cliente y continua con el pedido: ");
            nifCliente = scanner.nextLine();
        }

        Cliente cliente = listaClientes.buscarPorNif(nifCliente);

        if (cliente == null) {
            System.out.println("\u001B[31m" + "¡Error! No se encontró un cliente con el NIF especificado." + "\u001B[0m");
            return;
        }

        System.out.println("\u001B[34m" + "Escoge un articulo de la lista de artículos disponibles:" + "\u001B[0m");
        ListaArticulos listaArticulos = datos.getListaArticulos();
        for (Articulo articulo : listaArticulos.getArrayList()) {
            System.out.println("Código:                 " + articulo.getCodigo());
            System.out.println("Descripción:            " + articulo.getDescripcion());
            System.out.println("Precio:                 " + articulo.getPrecio() + "€");
            System.out.println("Gastos de Envío:        " + articulo.getGastosEnvio() + "€");
            System.out.println("Preparación en Minutos: " + articulo.getPreparacionEnMin() + " min");
            System.out.println("------------------------");
        }

        System.out.print("Ingrese el Código del Artículo deseado: ");
        String codigoArticulo = scanner.nextLine();
        Articulo articulo = datos.getListaArticulos().buscarPorCodigo(codigoArticulo);

        if (articulo == null) {
            System.out.println("\u001B[31m" + "¡Error! No se encontró un artículo con el código especificado." + "\u001B[0m");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        Pedido nuevoPedido = new Pedido(numeroPedido, fechaHora, cliente, articulo, cantidad);

        ListaPedidos listaPedidos = datos.getListaPedidos();
        listaPedidos.add(nuevoPedido);

        System.out.println("\u001B[34m" + "Pedido agregado con éxito:" + "\u001B[0m");
        System.out.println("+---------------------+-----------------------+");
        System.out.println("  Campo               | Valor                 ");
        System.out.println("+---------------------+-----------------------+");
        System.out.printf("  Número de Pedido     | %s%n", Pedido.getNumeroPedido());
        System.out.printf("  Fecha y Hora         | %s%n", nuevoPedido.getFechaHora());
        System.out.printf("  NIF del Cliente      | %s%n", nuevoPedido.getCliente().getNif());
        System.out.printf("  Nombre del Cliente   | %s%n", nuevoPedido.getCliente().getNombre());
        System.out.printf("  Código del Artículo  | %s%n", nuevoPedido.getArticulo().getCodigo());
        System.out.printf("  Descripción Artículo | %s%n", nuevoPedido.getArticulo().getDescripcion());
        System.out.printf("  Cantidad             | %d%n", nuevoPedido.getCantidad());
        System.out.printf("  Precio Articulo      | %d%n", nuevoPedido.getArticulo().getPrecio());
        System.out.printf("  Costo de envío       | %.2f€%n", nuevoPedido.precioEnvio());
        System.out.printf("  Precio Total         | %.2f€%n", nuevoPedido.precioTotal());
        System.out.println("+---------------------+-----------------------+");
    }
    /**
     * Método para eliminar un pedido de la lista
     */
    public void eliminarPedido() {
        System.out.println("\u001B[34m" + "Elija un pedido de la lista de pedidos disponibles:" + "\u001B[0m");
        ListaPedidos listaPedidos = datos.getListaPedidos();
        for (Pedido pedido : listaPedidos.getArrayList()) {
            System.out.println("Número de Pedido:   " + Pedido.getNumeroPedido());
            System.out.println("Nombre del Cliente: " + pedido.getCliente().getNombre());
            System.out.println("------------------------");
        }

        System.out.print("\u001B[34m" + "Introduzca el Número de Pedido del pedido que desea eliminar: " + "\u001B[0m");
        Scanner scanner = new Scanner(System.in);
        int numeroPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = listaPedidos.buscarPorNumeropedido(numeroPedido);

        if (pedido != null) {
            System.out.println("\u001B[33m" + "¿Está seguro de que desea eliminar el siguiente pedido?" + "\u001B[0m");
            System.out.println("Número de Pedido: " + Pedido.getNumeroPedido());
            System.out.println("Nombre del Cliente: " + pedido.getCliente().getNombre());
            System.out.print("Confirme (Si/No): ");
            String confirmacion = scanner.nextLine();

            if (confirmacion.equalsIgnoreCase("Si")) {
                listaPedidos.borrar(pedido);
                System.out.println("\u001B[33m" + "Pedido eliminado con éxito." + "\u001B[0m");
            } else {
                System.out.println("\u001B[32m" + "Eliminación de pedido cancelada." + "\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31m" + "¡Error! No se encontró un pedido con el Número de Pedido especificado." + "\u001B[0m");
        }

    }

}