import java.util.ArrayList;
import java.util.List;

public class CombustiblePrecio {
    private String nombre;
    private String octanaje;
    private String unidadMedida;
    private double precioMinimo;
    private double precioMaximo;
    private String usoComun;

    public CombustiblePrecio(String nombre, String octanaje, double precioMinimo, double precioMaximo, String usoComun) {
        this.nombre = nombre;
        this.octanaje = octanaje;
        this.unidadMedida = "Galón";
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
        this.usoComun = usoComun;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOctanaje() {
        return octanaje;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public double getPrecioMinimo() {
        return precioMinimo;
    }

    public double getPrecioMaximo() {
        return precioMaximo;
    }

    public String getUsoComun() {
        return usoComun;
    }

    public double obtenerPrecioPromedio() {
        return (this.precioMinimo + this.precioMaximo) / 2.0;
    }

    public static List<CombustiblePrecio> obtenerPreciosRegistrados() {
        List<CombustiblePrecio> lista = new ArrayList<>();

        lista.add(new CombustiblePrecio(
            "Gasohol Regular", 
            "90 Octanos", 
            16.29, 
            21.79, 
            "Automóviles particulares y comerciales estándar."
        ));

        lista.add(new CombustiblePrecio(
            "Gasohol Premium", 
            "95/98 Octanos", 
            17.28, 
            23.99, 
            "Vehículos modernos o de alta gama."
        ));

        lista.add(new CombustiblePrecio(
            "Diésel B5 S-50 UV", 
            "Petróleo Diésel", 
            18.49, 
            25.19, 
            "Transporte público masivo y carga pesada."
        ));

        return lista;
    }
}