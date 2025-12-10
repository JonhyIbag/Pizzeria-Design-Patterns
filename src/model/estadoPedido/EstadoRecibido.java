package model.estadoPedido;
import model.Pedido;

/**
 * Esta clase representa el estado "Recibido" de un pedido en el sistema de gestión de pedidos.
 * Nos ayuda a manejar el comportamiento del pedido cuando se encuentra en este estado.
 * @author Triplets
 */
public class EstadoRecibido implements model.abst.EstadoPedido {
    /**
     * Referencia al pedido asociado con este estado. utilizado para poder realizar los cambios de estado y notificaciones correspondientes.
     */
    private Pedido pedido;

    /**
     * Constructor de la clase EstadoRecibido.
     * @param pedido
     */
    public EstadoRecibido(Pedido pedido){
        this.pedido = pedido;
    }

    /**
     * Método que maneja la acción de entregar el pedido cuando está en el estado "Recibido".
     * Notifica a los observadores que el pedido ha sido recibido.
     */
    @Override
    public void recibirPedido() {
        pedido.notifyObservers("Recibido");
        pedido.estadoActual = pedido.estadoPreparado;
    }

    @Override
    public void prepararPedido() {
    }

    @Override
    public void cocinarPedido() {
    }

    @Override
    public void empaquetarPedido() {
    }

    @Override
    public void entregarPedido() {
    }

    /**
     * Método que devuelve el nombre del estado actual.
     * @return Nombre del estado "Recibido".
     */
    @Override
    public String getEstadoNombre() {
        return "Recibido";
    }
    
}
