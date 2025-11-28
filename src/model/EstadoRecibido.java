package model;

public class EstadoRecibido implements model.abst.EstadoPedido {
    private Pedido pedido;

    public EstadoRecibido(Pedido pedido){
        this.pedido = pedido;
    }

    @Override
    public void recibirPedido() {
        System.out.println("El pedido ya ha sido recibido.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pedido.estadoActual = pedido.estadoPreparado;
        pedido.prepararPedido();
    }

    @Override
    public void prepararPedido() {
        System.out.println("El pedido está siendo preparado.");
    }

    @Override
    public void cocinarPedido() {
        System.out.println("El pedido está siendo horneado.");
    }

    @Override
    public void empaquetarPedido() {
        System.out.println("El pedido ya esta empaquetado y listo.");
    }

    @Override
    public void entregarPedido() {
        System.out.println("El pedido ya ha sido entregado.");
    }
    
}
