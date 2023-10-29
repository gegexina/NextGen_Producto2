package NextGen.Modelo;

import java.time.LocalDateTime;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Clase que representa un pedido realizado por un cliente.
 */
public class Pedido {
    private static int numeroPedido;
    private Date fechaHora;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private boolean enviado;
    /**
     * Constructor para crear un pedido con los detalles especificados.
     * @param numeroPedido El número de pedido.
     * @param fechaHora La fecha y hora del pedido.
     * @param cliente El cliente que realizó el pedido.
     * @param articulo El artículo pedido.
     * @param cantidad La cantidad de unidades del artículo en el pedido.
     */
    public Pedido(int numeroPedido, Date fechaHora, Cliente cliente, Articulo articulo, int cantidad) {
        this.numeroPedido = numeroPedido;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.enviado = false;
    }
    /**
     * Obtiene el número de pedido.
     * @return El número de pedido.
     */
    public static int getNumeroPedido() {
        return numeroPedido;
    }
    /**
     * Establece el número de pedido.
     * @param numeroPedido El nuevo número de pedido.
     */
    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    /**
     * Obtiene la fecha y hora del pedido.
     * @return La fecha y hora del pedido.
     */
    public Date getFechaHora() {
        return fechaHora;
    }
    /**
     * Establece la fecha y hora del pedido.
     * @param fechaHora La nueva fecha y hora del pedido.
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    /**
     * Obtiene el cliente que realizó el pedido.
     * @return El cliente del pedido.
     */
    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Establece el cliente que realizó el pedido.
     * @param cliente El nuevo cliente del pedido.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /**
     * Obtiene el artículo pedido.
     * @return El artículo pedido.
     */
    public Articulo getArticulo() {
        return articulo;
    }
    /**
     * Establece el artículo pedido.
     * @param articulo El nuevo artículo pedido.
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    /**
     * Obtiene la cantidad de unidades del artículo en el pedido.
     * @return La cantidad de unidades.
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Establece la cantidad de unidades del artículo en el pedido.
     * @param cantidad La nueva cantidad de unidades.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Comprueba si el pedido ha sido enviado.
     * @return true si el pedido ha sido enviado, false de lo contrario.
     */
    public boolean isEnviado() {
        return enviado;
    }
    /**
     * Establece si el pedido ha sido enviado.
     * @param enviado true si el pedido ha sido enviado, false de lo contrario.
     */
    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }
    /**
     * Calcula el precio total del pedido, incluyendo el costo del artículo y el envío.
     * @return El precio total del pedido.
     */
    public float precioTotal() {
        return (float) (cantidad * articulo.getPrecio() + precioEnvio());
    }
    /**
     * Comprueba si el pedido ha sido enviado.
     * @return true si el pedido ha sido enviado, false de lo contrario.
     */
    //public boolean pedidoEnviado() {
        //LocalDateTime horaPreparacion = fechaHora.plusMinutes(articulo.getPreparacionEnMin());
        //LocalDateTime horaActual = LocalDateTime.now();

        //return horaActual.isAfter(horaPreparacion);
    //}
    /**
     * Calcula el costo de envío del pedido.
     * @return El costo de envío del pedido.
     */
    public float precioEnvio() {
        float descuento = cliente.descuentoEnv();
        float precioEnvioConDescuento = (float) (articulo.getGastosEnvio() * (1 - descuento));
        return precioEnvioConDescuento;
    }
    /**
     * Convierte el pedido en una representación de tabla.
     * @return Una cadena que representa el pedido en formato de tabla.
     */
    @Override
    public String toString() {
        String separator = " | ";
        String header = "Número de Pedido | Fecha y Hora          | NIF Cliente | Nombre Cliente         | Código Artículo | Descripción Artículo | Cantidad | Precio Artículo | Costo de Envío | Precio Total | Enviado";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return String.format("%-17s" + separator + "%-22s" + separator + "%-11s" + separator + "%-23s" + separator + "%-16s" + separator + "%-22s" + separator + "%-8s" + separator + "%-15s" + separator + "%-13s" + separator + "%-7s",
                numeroPedido, dateFormat.format(fechaHora), cliente.getNif(), cliente.getNombre(), articulo.getCodigo(), articulo.getDescripcion(), cantidad, articulo.getPrecio() + "€", precioEnvio() + "€", precioTotal() + "€", enviado);
    }
}