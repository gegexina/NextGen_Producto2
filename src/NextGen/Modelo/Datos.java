package NextGen.Modelo;
/**
 * Clase que contiene instancias de listas para gestionar artículos, clientes y pedidos.
 */
public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    /**
     * Constructor que inicializa las listas de artículos, clientes y pedidos.
     */
    public Datos() {
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();
    }
    /**
     * Obtiene la lista de artículos.
     * @return La lista de artículos.
     */
    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }
    /**
     * Establece la lista de artículos.
     * @param listaArticulos La nueva lista de artículos.
     */
    public void setListaArticulos(ListaArticulos listaArticulos) {
        this.listaArticulos = listaArticulos;
    }
    /**
     * Obtiene la lista de clientes.
     * @return La lista de clientes.
     */
    public ListaClientes getListaClientes() {
        return listaClientes;
    }
    /**
     * Establece la lista de clientes.
     * @param listaClientes La nueva lista de clientes.
     */
    public void setListaClientes(ListaClientes listaClientes) {
        this.listaClientes = listaClientes;
    }
    /**
     * Obtiene la lista de pedidos.
     * @return La lista de pedidos.
     */
    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }
    /**
     * Establece la lista de pedidos.
     * @param listaPedidos La nueva lista de pedidos.
     */
    public void setListaPedidos(ListaPedidos listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
