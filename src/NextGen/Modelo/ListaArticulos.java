package NextGen.Modelo;
/**
 * Clase que representa una lista de artículos. Esta clase hereda de la clase genérica Lista<Articulo>.
 */
public class ListaArticulos extends Lista<Articulo> {
    /**
     * Constructor para la lista de artículos. Inicializa una lista de artículos vacía.
     */
    public ListaArticulos() {
        super();
    }

    /**
     * Busca un artículo en la lista por su código.
     * @param codigo El código del artículo que se desea buscar.
     * @return El artículo con el código especificado, o null si no se encuentra.
     */
    public Articulo buscarPorCodigo(String codigo) {
        for (Articulo articulo : lista) {
            if (articulo.getCodigo() == codigo) {
                return articulo;
            }
        }
        return null;
    }
}