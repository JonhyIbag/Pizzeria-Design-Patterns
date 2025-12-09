/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.extras;

/**
 *
 * @author Usuario
 */
public class Pepperoni extends Extras{
    private final String nombre;
    private final Double precio;

    public Pepperoni() {
        this.nombre = "Pepperoni";
        this.precio = 15.0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Double getPrecio() {
        return precio;
    }
}   