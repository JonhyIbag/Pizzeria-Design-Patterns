package model.estadoPedido;
import model.Pedido;

/**
 * Esta clase representa el estado "Preparando" de un pedido en el sistema de gestión de pedidos.
 * Nos ayuda a manejar el comportamiento del pedido cuando se encuentra en este estado.
 * @author Triplets
 */
public class EstadoPreparando implements model.abst.EstadoPedido {
    /**
     * Referencia al pedido asociado con este estado. utilizado para poder realizar los cambios de estado y notificaciones correspondientes.
     */
    private Pedido pedido;

    /**
     * Constructor de la clase EstadoPreparando.
     * @param pedido
     */
    public EstadoPreparando(Pedido pedido){
        this.pedido = pedido;
    }

    @Override
    public void recibirPedido() {

    }

    /**
     * Método que maneja la acción de entregar el pedido cuando está en el estado "Preparando".
     * Notifica a los observadores que el pedido ha sido preparado.
     */
    @Override
    public void prepararPedido() {
        pedido.notifyObservers("Preparando");
        pedido.estadoActual = pedido.estadoHorneando;
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
     * @return Nombre del estado "Preparando".
     */
    @Override
    public String getEstadoNombre() {
        return "Preparando";
    }
    
}
