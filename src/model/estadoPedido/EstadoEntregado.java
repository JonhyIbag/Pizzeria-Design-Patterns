package model.estadoPedido;
import model.Pedido;

/**
 * Esta clase representa el estado "Entregado" de un pedido en el sistema de gestión de pedidos.
 * Nos ayuda a manejar el comportamiento del pedido cuando se encuentra en este estado.
 * @author Triplets
 */
public class EstadoEntregado implements model.abst.EstadoPedido {
    /**
     * Referencia al pedido asociado con este estado. utilizado para poder realizar los cambios de estado y notificaciones correspondientes.
     */
    private Pedido pedido;

    /**
     * Constructor de la clase EstadoEntregado.
     * @param pedido
     */
    public EstadoEntregado(Pedido pedido){
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

    @Override
    public void empaquetarPedido() {
    }

    /**
     * Método que maneja la acción de entregar el pedido cuando está en el estado "Entregado".
     * Notifica a los observadores que el pedido ha sido entregado.
     */
    @Override
    public void entregarPedido() {
        pedido.notifyObservers("Entregado");
    }

    /**
     * Método que devuelve el nombre del estado actual.
     * @return Nombre del estado "Entregado".
     */
    @Override
    public String getEstadoNombre() {
        return "Entregado";
    }
    
}
