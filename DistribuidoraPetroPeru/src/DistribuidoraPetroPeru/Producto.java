package DistribuidoraPetroPeru;

public class Producto {
    private String tipoCombustible;
    private double cantidadGalones;
    private double precioUnitario;

    public Producto(String tipoCombustible, double cantidadGalones, double precioUnitario) {
        this.tipoCombustible = tipoCombustible;
        this.cantidadGalones = cantidadGalones;
        this.precioUnitario = precioUnitario;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public double getCantidadGalones() {
        return cantidadGalones;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return cantidadGalones * precioUnitario;
    }
}