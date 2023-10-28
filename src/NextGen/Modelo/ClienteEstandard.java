package NextGen.Modelo;
/**
 * Clase que representa un cliente estándar. Hereda de la clase abstracta Cliente.
 */
public class ClienteEstandard extends Cliente {
    /**
     * Constructor para crear un cliente estándar con los detalles especificados.
     * @param nif El NIF del cliente.
     * @param nombre El nombre del cliente.
     * @param email El correo electrónico del cliente.
     * @param direccion La dirección de envío del cliente.
     */
    public ClienteEstandard(String nif, String nombre, String email, String direccion) {
        super(nif, nombre, email, direccion);
    }
    /**
     * Obtiene el tipo de cliente.
     * @return El tipo de cliente, que es "Estandard" para esta clase.
     */
    public String tipoCliente() {
        return "Estandard";
    }
    /**
     * Calcula la cuota anual del cliente estándar. En este caso, siempre devuelve 0.
     * @return La cuota anual del cliente, que es 0.
     */
    public float calcAnual() {return 0; }
    /**
     * Calcula el descuento en el envío para el cliente estándar. En este caso, siempre devuelve 0.
     * @return El descuento en el envío como un valor entre 0 y 1, que es 0.
     */
    public float descuentoEnv() {return 0; }

    /**
     * Representación en forma de tabla del cliente estándar con los detalles.
     * @return Una cadena que muestra los detalles del cliente estándar en forma de tabla.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
