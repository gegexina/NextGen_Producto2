package NextGen.Modelo;
/**
 * Clase que representa una lista de pedidos. Esta clase hereda de la clase genérica Lista<Pedido>.
 */
public class ListaPedidos extends Lista<Pedido> {
    /**
     * Busca un pedido en la lista por su número de pedido.
     * @param numeroPedido El número del pedido que se desea buscar.
     * @return El pedido con el número especificado, o null si no se encuentra.
     */
    public Pedido buscarPorNumeropedido(int numeroPedido) {
        for (Pedido pedido : lista) {
            if (Pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }

}