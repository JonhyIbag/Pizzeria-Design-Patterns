/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.masas;

/**
 *
 * @author Usuario
 */
public class Napolitana extends Masa{
    private String nombre;
    private Double precio;

    public Napolitana() {
        this.nombre = "Masa Napolitana";
        this.precio = 50.0;
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
