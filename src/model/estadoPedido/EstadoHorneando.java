package model.estadoPedido;
import model.Pedido;

/**
 * Esta clase representa el estado "Entregado" de un pedido en el sistema de gestión de pedidos.
 * Nos ayuda a manejar el comportamiento del pedido cuando se encuentra en este estado.
 * @author Triplets
 */
public class EstadoHorneando implements model.abst.EstadoPedido {
    private Pedido pedido;

    /**
     * Constructor de la clase EstadoHorneando.
     * @param pedido
     */
    public EstadoHorneando(Pedido pedido){
        this.pedido = pedido;
    }

    @Override
    public void recibirPedido() {
    }

    @Override
    public void prepararPedido() {
    }

    /**
     * Método que maneja la acción de entregar el pedido cuando está en el estado "Horneando".
     * Notifica a los observadores que el pedido ha sido horneado.
     */
    @Override
    public void cocinarPedido() {
        pedido.notifyObservers("Horneando");
        pedido.estadoActual = pedido.estadoTerminado;
    }

    @Override
    public void empaquetarPedido() {
    }

    @Override
    public void entregarPedido() {
    }

    /**
     * Método que devuelve el nombre del estado actual.
     * @return Nombre del estado "Horneando".
     */
    @Override
    public String getEstadoNombre() {
        return "Horneando";
    }
}