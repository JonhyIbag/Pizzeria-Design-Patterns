/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.quesos;

/**
 *
 * @author Usuario
 */
public class Parmesano extends Queso{
    private String nombre;
    private Double precio;

    public Parmesano() {
        this.nombre = "Queso Parmesano";
        this.precio = 20.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}
