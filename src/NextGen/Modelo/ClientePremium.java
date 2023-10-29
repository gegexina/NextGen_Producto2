package NextGen.Modelo;
/**
 * Clase que representa un cliente premium. Hereda de la clase abstracta Cliente.
 */
public class ClientePremium extends Cliente {
    private double cuota;
    private double descuento;
    /**
     * Constructor para crear un cliente premium con los detalles especificados.
     * @param nif El NIF del cliente.
     * @param nombre El nombre del cliente.
     * @param email El correo electrónico del cliente.
     * @param direccion La dirección de envío del cliente.
     */
    public ClientePremium(String nif, String nombre, String email, String direccion) {
        super(nif, nombre, email, direccion);
        this.cuota = calcAnual();
        this.descuento = descuentoEnv();
    }
    /**
     * Obtiene la cuota anual del cliente premium.
     * @return La cuota anual del cliente premium.
     */
    public double getCuota() { return cuota;}
    /**
     * Establece la cuota anual del cliente premium.
     * @param cuota La nueva cuota anual del cliente premium.
     */
    public void setCuota(double cuota) { this.cuota = cuota;}
    /**
     * Obtiene el descuento en el envío aplicado al cliente premium.
     * @return El descuento en el envío como un valor entre 0 y 1.
     */
    public double getDescuento() {return descuento; }
    /**
     * Establece el descuento en el envío del cliente premium.
     * @param descuento El nuevo descuento en el envío del cliente premium.
     */
    public void setDescuento(double descuento) {this.descuento = descuento;}

    /**
     * Obtiene el tipo de cliente.
     * @return El tipo de cliente, que es "Premium" para esta clase.
     */
    public String tipoCliente() {
        return "Premium";
    }
    /**
     * Calcula la cuota anual del cliente premium. En este caso, siempre devuelve 30.
     * @return La cuota anual del cliente premium, que es 30€.
     */
    public float calcAnual() { return 30; }
    /**
     * Calcula el descuento en el envío para el cliente premium. En este caso, siempre devuelve 0.2.
     * @return El descuento en el envío como un valor entre 0 y 1, que es 0.2.
     */
    public float descuentoEnv() { return 5.99f; }
    /**
     * Representación en forma de tabla del cliente premium con los detalles y cuota anual.
     * @return Una cadena que muestra los detalles del cliente premium en forma de tabla, junto con su cuota anual y descuento en envío.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nSu cuota anual es de:        " + calcAnual() + "€" +
                "\nSe le aplica un descuento de:" + (descuentoEnv() * 100) + "%";
    }
}
