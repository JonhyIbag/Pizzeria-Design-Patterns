/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.abst;

/**
 *
 * @author Usuario
 */
public interface EstadoPedido {
    public void recibirPedido();
    public void prepararPedido();
    public void cocinarPedido();
    public void empaquetarPedido();
    public void entregarPedido();
}

