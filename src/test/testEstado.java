package test;

import model.Cliente;
import model.Pedido;

public class testEstado {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(0);
        Pedido pedido = new Pedido(cliente);
        pedido.recibirPedido();
    }
}
