package model;

public class EstadoVacio implements model.abst.EstadoPedido {
    private Pedido pedido;

    public EstadoVacio(Pedido pedido){
        this.pedido = pedido;
    }

    @Override
    public void recibirPedido() {
        pedido.estadoActual = pedido.estadoRecibido;
        pedido.recibirPedido();
    }

    @Override
    public void prepararPedido() {
        System.out.println("No hay pedido.");
    }

    @Override
    public void cocinarPedido() {
        System.out.println("No hay pedido.");
    }

    @Override
    public void empaquetarPedido() {
        System.out.println("No hay pedido.");
    }

    @Override
    public void entregarPedido() {
        System.out.println("No hay pedido.");
    }
}