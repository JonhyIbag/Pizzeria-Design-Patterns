/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */

import model.abst.Observador;

public class Notificacion implements Observador{
    private Cliente cliente;
    
    public Notificacion(Cliente cliente){
        this.cliente = cliente;
    }

    public void update(String mensaje){
        System.out.println(mensaje);
    }

    public Cliente getCliente(){
        return cliente;
    }
}
