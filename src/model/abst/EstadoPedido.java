package model.abst;

public interface EstadoPedido {
    public void recibirPedido();
    public void prepararPedido();
    public void cocinarPedido();
    public void empaquetarPedido();
    public void entregarPedido();
}
