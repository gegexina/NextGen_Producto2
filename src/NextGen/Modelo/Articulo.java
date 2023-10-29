package NextGen.Modelo;
/**
 * Clase que representa un artículo con sus atributos.
 */
public class Articulo {
    private String codigo;
    private String descripcion;
    private double precio;
    private double gastosEnvio;
    private int preparacionEnMin;
    /**
     * Constructor para crear un objeto Articulo con los detalles especificados.
     * @param codigo El código del artículo.
     * @param descripcion La descripción del artículo.
     * @param precio El precio del artículo.
     * @param gastosEnvio Los gastos de envío asociados al artículo.
     * @param preparacionEnMin El tiempo de preparación en minutos del artículo.
     */
    public Articulo(String codigo, String descripcion, double precio, double gastosEnvio, int preparacionEnMin) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastosEnvio = gastosEnvio;
        this.preparacionEnMin = preparacionEnMin;
    }
    /**
     * Obtiene el código del artículo.
     * @return El código del artículo.
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Establece el código del artículo.
     * @param codigo El nuevo código del artículo.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Obtiene la descripción del artículo.
     * @return La descripción del artículo.
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Establece la descripción del artículo.
     * @param descripcion La nueva descripción del artículo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Obtiene el precio del artículo.
     * @return El precio del artículo.
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Establece el precio del artículo.
     * @param precio El nuevo precio del artículo.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Obtiene los gastos de envío del artículo.
     * @return Los gastos de envío del artículo.
     */
    public double getGastosEnvio() { return gastosEnvio;     }
    /**
     * Establece los gastos de envío del artículo.
     * @param gastosEnvio Los nuevos gastos de envío del artículo.
     */
    public void setGastosEnvio(double gastosEnvio) { this.gastosEnvio = gastosEnvio;  }
    /**
     * Obtiene el tiempo de preparación en minutos del artículo.
     * @return El tiempo de preparación en minutos del artículo.
     */
    public int getPreparacionEnMin() { return preparacionEnMin;}
    /**
     * Establece el tiempo de preparación en minutos del artículo.
     * @param preparacionEnMin El nuevo tiempo de preparación en minutos del artículo.
     */
    public void setPreparacionEnMin(int preparacionEnMin) {this.preparacionEnMin = preparacionEnMin; }
    /**
     * Representación en forma de tabla del artículo, que incluye todos los atributos.
     * @return Una cadena que muestra los detalles del artículo.
     */
    @Override
    public String toString() {
        String separator = " | ";
        String header = "Código       | Descripción                   | Precio   | Gastos de Envío    | Preparación (min)";
        String data = String.format("%-13s" + separator + "%-29s" + separator + "%-8s" + separator + "%-18s" + separator + "%-16s",
                codigo, descripcion, precio, gastosEnvio, preparacionEnMin);
        return header + "\n" + data + "\n";
    }
}