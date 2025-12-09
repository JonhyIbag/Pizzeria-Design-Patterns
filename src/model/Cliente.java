/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */


public class Cliente {
    private int idCliente;

    public Cliente(int idCliente){
        this.idCliente = idCliente;
    }

    public int getIdCliente(){
        return idCliente;
    }

    public String toString(){
        return "Cliente: " + idCliente;
    }

}
