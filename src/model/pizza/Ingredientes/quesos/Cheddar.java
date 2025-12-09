/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.quesos;

/**
 *
 * @author Usuario
 */
public class Cheddar extends Queso{
    private String nombre;
    private Double precio;

    public Cheddar() {
        this.nombre = "Queso Cheddar";
        this.precio = 30.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}