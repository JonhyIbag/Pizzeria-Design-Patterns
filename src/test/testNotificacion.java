package test;

import model.Cliente;
import model.Notificacion;
import model.Pedido;

public class testNotificacion {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(0);
        // sujeto
        Pedido pedido = new Pedido(cliente);
        // observer
        Notificacion notificacion = new Notificacion(cliente);
        pedido.registerObservers(notificacion);
        try{
            pedido.recibirPedido();
            Thread.sleep(2000);
            pedido.prepararPedido();
            Thread.sleep(2000);
            pedido.cocinarPedido();
            Thread.sleep(2000);
            pedido.empaquetarPedido();
            Thread.sleep(2000);
            pedido.entregarPedido();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
