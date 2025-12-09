/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.condimentos;

/**
 *
 * @author Usuario
 */
public class Oregano extends Condimento{
    private final String nombre;
    private final Double precio;

    public Oregano() {
        this.nombre = "Oregano";
        this.precio = 5.0;
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
