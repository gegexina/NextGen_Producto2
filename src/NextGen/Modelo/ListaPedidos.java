package NextGen.Modelo;
/**
 * Clase que representa una lista de pedidos. Esta clase hereda de la clase genérica Lista<Pedido>.
 */
public class ListaPedidos extends Lista<Pedido> {
    /**
     * Constructor para la lista de pedidos. Inicializa una lista de pedidos vacía.
     */
    public ListaPedidos() {
        super();
    }
    /**
     * Busca un pedido en la lista por su número de pedido.
     * @param numeroPedido El número del pedido que se desea buscar.
     * @return El pedido con el número especificado, o null si no se encuentra.
     */
    public Pedido buscarPorNumeropedido(int numeroPedido) {
        for (Pedido pedido : lista) {
            if (cliente.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }
    /**
     * Método para agregar un pedido a la lista
     * @param numeroPedido El pedido que se desea agregar a la lista
     */
    public void agregarPedido(Pedido pedido) {
        lista.add(pedido);
    }

}