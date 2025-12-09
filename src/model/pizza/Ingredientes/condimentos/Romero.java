/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.condimentos;

/**
 *
 * @author Usuario
 */
public class Romero extends Condimento{
    private final String nombre;
    private final Double precio;

    public Romero() {
        this.nombre = "Romero";
        this.precio = 5.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}

