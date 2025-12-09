/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.orillas;

/**
 *
 * @author Usuario
 */
public class RellenaQueso extends Orilla{
    private String nombre;
    private Double precio;

    public RellenaQueso() {
        this.nombre = "Rellena de Queso";
        this.precio = 40.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}