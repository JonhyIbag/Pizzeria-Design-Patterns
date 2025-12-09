/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.ingredientes.quesos;

/**
 *
 * @author Usuario
 */

import model.abst.Ingrediente;

public abstract class Queso implements Ingrediente {
    private final String tipo="Queso";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return getNombre() + "\nPrecio: " + getPrecio();
    }
}