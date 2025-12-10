package model.estadoPedido;
import model.Pedido;

/**
 * Esta clase representa el estado "Vacio" de un pedido en el sistema de gestión de pedidos.
 * Nos ayuda a manejar el comportamiento del pedido cuando se encuentra en este estado.
 * @author Triplets
 */

public class EstadoVacio implements model.abst.EstadoPedido {
    /**
     * Referencia al pedido asociado con este estado. urilizado para poder realizar los cambios de estado y notificaciones correspondientes.
     */
    private Pedido pedido;

    /**
     * Constructor de la clase EstadoVacio.
     * @param pedido
     */
    public EstadoVacio(Pedido pedido){
        this.pedido = pedido;
    }

    /**
     * Método que maneja la acción de recibir el pedido cuando está en el estado "Vacio".
     * Notifica a los observadores que el pedido ha sido recibido.
     */
    @Override
    public void recibirPedido() {
        pedido.estadoActual = pedido.estadoRecibido;
        pedido.recibirPedido();
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
     * @return Nombre del estado "Vacio".
     */
    @Override
    public String getEstadoNombre() {
        return "Vacio";
    }
}
