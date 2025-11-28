package model.estadoPedido;

import model.abst.EstadoPedido;

public class Pedido {
    protected EstadoPedido estadoActual;
    protected EstadoPedido sinPedido;
    protected EstadoRecibido estadoRecibido;
    protected EstadoPreparado estadoPreparado;
    protected EstadoHorneando estadoHorneando;
    protected EstadoTerminado estadoTerminado;
    protected EstadoEntregado estadoEntregado;

    public Pedido() {
        sinPedido = new EstadoVacio(this);
        estadoRecibido = new EstadoRecibido(this);
        estadoPreparado = new EstadoPreparado(this);
        estadoHorneando = new EstadoHorneando(this);
        estadoTerminado = new EstadoTerminado(this);
        estadoEntregado = new EstadoEntregado(this);

        estadoActual = sinPedido;
    }

    public void recibirPedido() {
        estadoActual.recibirPedido();
    }

    public void prepararPedido() {
        estadoActual.prepararPedido();
    }

    public void cocinarPedido() {
        estadoActual.cocinarPedido();
    }

    public void empaquetarPedido() {
        estadoActual.empaquetarPedido();
    }

    public void entregarPedido() {
        estadoActual.entregarPedido();
    }
}
