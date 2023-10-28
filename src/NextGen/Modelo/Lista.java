package NextGen.Modelo;
import java.util.ArrayList;
/**
 * Clase genérica que representa una lista para gestionar objetos de tipo T.
 * @param <T> El tipo de objetos que se almacenan en la lista.
 */
public class Lista<T> {
    protected ArrayList<T> lista;
    /**
     * Constructor que inicializa la lista.
     */
    public Lista() {
        lista = new ArrayList<>();
    }
    /**
     * Obtiene el tamaño de la lista.
     * @return El número de elementos en la lista.
     */
    public int getSize() {
        return lista.size();
    }
    /**
     * Agrega un elemento a la lista.
     * @param t El elemento a agregar a la lista.
     */
    public void add(T t) {
        lista.add(t);
    }
    /**
     * Borra un elemento de la lista.
     * @param t El elemento a borrar de la lista.
     */
    public void borrar(T t) {
        lista.remove(t);
    }
    /**
     * Obtiene un elemento de la lista en una posición específica.
     * @param position La posición del elemento en la lista.
     * @return El elemento en la posición especificada.
     */
    public T getAt(int position) {
        return lista.get(position);
    }
    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    public void clear() {
        lista.clear();
    }
    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    /**
     * Obtiene una copia de la lista en forma de un nuevo ArrayList.
     * @return Una copia de la lista como un nuevo ArrayList.
     */
    public ArrayList<T> getArrayList() {
        return new ArrayList<>(lista);
    }
}