/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.masas;

/**
 *
 * @author Usuario
 */
public class Romana extends Masa{
    private String nombre;
    private Double precio;

    public Romana() {
        this.nombre = "Masa Romana";
        this.precio = 70.0;
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
