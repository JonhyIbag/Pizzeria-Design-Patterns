/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.orillas;

/**
 *
 * @author Usuario
 */
import model.abst.Ingrediente;

public abstract class Orilla implements Ingrediente {
    private String tipo="orilla";

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return getNombre() + "\nPrecio: " + getPrecio();
    }
}
