package model.estadoPedido;
import model.Pedido;

/**
 * Esta clase representa el estado "Terminado" de un pedido en el sistema de gestión de pedidos.
 * Nos ayuda a manejar el comportamiento del pedido cuando se encuentra en este estado.
 * @author Triplets
 */
public class EstadoTerminado implements model.abst.EstadoPedido {
    /**
     * Referencia al pedido asociado con este estado. utilizado para poder realizar los cambios de estado y notificaciones correspondientes.
     */
    private Pedido pedido;

    /**
     * Constructor de la clase EstadoTerminado.
     * @param pedido
     */
    public EstadoTerminado(Pedido pedido){
        this.pedido = pedido;
    }

    @Override
    public void recibirPedido() {
    }

    @Override
    public void prepararPedido() {
    }

    @Override
    public void cocinarPedido() {
    }

    /**
     * Método que maneja la acción de entregar el pedido cuando está en el estado "Terminado".
     * Notifica a los observadores que el pedido ha sido terminado.
     */
    @Override
    public void empaquetarPedido() {
        pedido.notifyObservers("Terminado");
        pedido.estadoActual = pedido.estadoEntregado;
    }

    @Override
    public void entregarPedido() {
    }

    /**
     * Método que devuelve el nombre del estado actual.
     * @return Nombre del estado "Terminado".
     */
    @Override
    public String getEstadoNombre() {
        return "Terminado";
    }
    
}
