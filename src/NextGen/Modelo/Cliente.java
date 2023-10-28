package NextGen.Modelo;

import java.text.DecimalFormat;

/**
 * Clase abstracta que representa un cliente con sus atributos.
 */
public abstract class Cliente {
    private String nif;
    private String nombre;
    private String email;
    private String direccion;
    /**
     * Constructor para crear un objeto Cliente con los detalles especificados.
     * @param nif El NIF del cliente.
     * @param nombre El nombre del cliente.
     * @param email El correo electrónico del cliente.
     * @param direccion La dirección de envío del cliente.
     */
    public Cliente(String nif, String nombre, String email, String direccion) {
        this.nif = nif;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    /**
     * Obtiene el NIF del cliente.
     * @return El NIF del cliente.
     */
    public String getNif() { return nif; }
    /**
     * Establece el NIF del cliente.
     * @param nif El nuevo NIF del cliente.
     */
    public void setNif(String nif) { this.nif = nif;}
    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() { return nombre;}
    /**
     * Establece el nombre del cliente.
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
    /**
     * Obtiene el correo electrónico del cliente.
     * @return El correo electrónico del cliente.
     */
    public String getEmail() {return email;}
    /**
     * Establece el correo electrónico del cliente.
     * @param email El nuevo correo electrónico del cliente.
     */
    public void setEmail(String email) {this.email = email; }
    /**
     * Obtiene la dirección de envío del cliente.
     * @return La dirección de envío del cliente.
     */
    public String getDireccion() {return direccion;}
    /**
     * Establece la dirección de envío del cliente.
     * @param direccion La nueva dirección de envío del cliente.
     */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /**
     * Devuelve el tipo de cliente.
     * @return El tipo de cliente.
     */
    public abstract String tipoCliente();
    /**
     * Calcula la cuota anual del cliente.
     * @return La cuota anual del cliente.
     */
    public abstract float calcAnual();
    /**
     * Calcula el descuento en el envío para el cliente.
     * @return El descuento en el envío como un valor entre 0 y 1.
     */
    public abstract float descuentoEnv();
    /**
     * Representación en forma de tabla del cliente con los detalles.
     * @return Una cadena que muestra los detalles del cliente en forma de tabla.
     */
    @Override
    public String toString() {
        String separator = " | ";
        String header = "NIF          | Nombre                    | Email                               | Dirección de Envío                  | Tipo de Cliente | Cuota Anual  | Descuento Envío";
        DecimalFormat df = new DecimalFormat("#.##");
        String data = String.format("%-12s" + separator + "%-26s" + separator + "%-34s" + separator + "%-38s" + separator + "%-15s" + separator + "%-13s" + separator + "%-15s",
                nif, nombre, email, direccion, tipoCliente(), df.format(calcAnual()) + "€", df.format((descuentoEnv() * 100)) + "%");
        return header + "\n" + data;
    }
}
