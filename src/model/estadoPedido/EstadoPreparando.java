/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.estadoPedido;

/**
 *
 * @author Usuario
 */


import model.Pedido;

public class EstadoPreparando implements model.abst.EstadoPedido {
    private Pedido pedido;

    public EstadoPreparando(Pedido pedido){
        this.pedido = pedido;
    }

    @Override
    public void recibirPedido() {
        System.out.println("El pedido ya ha sido recibido.");
        pedido.notifyObservers("El pedido ya ha sido recibido.");
    }

    @Override
    public void prepararPedido() {
        System.out.println("El pedido está siendo preparado.");
        pedido.notifyObservers("Preparando");
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pedido.estadoActual = pedido.estadoHorneando;
        pedido.cocinarPedido();*/
    }

    @Override
    public void cocinarPedido() {
        System.out.println("El pedido está siendo horneado.");
        pedido.notifyObservers("El pedido está siendo horneado.");
    }

    @Override
    public void empaquetarPedido() {
        System.out.println("El pedido ya esta empaquetado y listo.");
        pedido.notifyObservers("El pedido ya esta empaquetado y listo.");
    }

    @Override
    public void entregarPedido() {
        System.out.println("El pedido ya ha sido entregado.");
        pedido.notifyObservers("El pedido ya ha sido entregado.");
    }
    
}
