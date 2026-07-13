package DistribuidoraPetroPeru;

import java.util.Date;
import java.util.List;

public class Pedido {
    // Declaración de variables
    private String idPedido;
    private String cliente;
    private List<Producto> items;
    private double total;
    private Date fecha;
    private String estado;

    // CONSTRUCTOR LIMPIO (Sin código generado automáticamente)
    public Pedido(String idPedido, List<Producto> items, double total) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
        this.fecha = new Date(); // Fecha actual automática
        this.estado = "Procesado";
    }

    // MÉTODOS GETTER (Sin "throw new UnsupportedOperationException")
    public String getIdPedido() { return this.idPedido; }
    public String getCliente() { return this.cliente; }
    public List<Producto> getItems() { return this.items; }
    public double getTotal() { return this.total; }
    public Date getFecha() { return this.fecha; }
    public String getEstado() { return this.estado; }
    
    // MÉTODOS SETTER
    public void setEstado(String estado) { this.estado = estado; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setItems(List<Producto> items) { this.items = items; }
    public void setTotal(double total) { this.total = total; }
    public void setIdPedido(String idPedido) { this.idPedido = idPedido; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}