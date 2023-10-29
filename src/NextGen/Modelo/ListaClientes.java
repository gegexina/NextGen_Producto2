package NextGen.Modelo;
/**
 * Clase que representa una lista de clientes. Esta clase hereda de la clase genérica Lista<Cliente>.
 */
public class ListaClientes extends Lista<Cliente> {
    /**
     * Constructor para la lista de clientes. Inicializa una lista de clientes vacía.
     */
    public ListaClientes() {
        super();
    }
    /**
     * Busca un cliente en la lista por su NIF.
     * @param nif El NIF del cliente que se desea buscar.
     * @return El cliente con el NIF especificado, o null si no se encuentra.
     */
    public Cliente buscarPorNif(String nif) {
        for (Cliente cliente : lista) {
            if (cliente.getNif().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }
}