package DistribuidoraPetroPeru;
import java.util.ArrayList;
import java.util.List;

public class GestionPedidos {
    private static GestionPedidos instance;
    private final List<Pedido> historialPedidos;

    private GestionPedidos() {
        historialPedidos = new ArrayList<>();
    }

    public static synchronized GestionPedidos getInstance() {
        if (instance == null) {
            instance = new GestionPedidos();
        }
        return instance;
    }

    public void registrarPedido(String cliente, List<Producto> items) {
        List<Producto> itemsClonados = new ArrayList<>(items);
        Pedido nuevoPedido = new Pedido(cliente, itemsClonados);
        historialPedidos.add(nuevoPedido);
    }

    public List<Pedido> getHistorialPedidos() {
        return historialPedidos;
    }
    
    public Pedido getUltimoPedido() {
        if (historialPedidos.isEmpty()) return null;
        return historialPedidos.get(historialPedidos.size() - 1);
    }
}
