/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.salsas;

/**
 *
 * @author Usuario
 */
public class Blanca extends Salsa {
    private String nombre;
    private Double precio;

    public Blanca() {
        this.nombre = "Salsa Blanca";
        this.precio = 20.0;
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
