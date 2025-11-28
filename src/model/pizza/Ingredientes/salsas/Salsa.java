package model.pizza.Ingredientes.salsas;

import model.abst.Ingrediente;

public abstract class Salsa implements Ingrediente {
    private String tipo="salsa";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Nombre: " + getNombre() + ", Precio: " + getPrecio();
    }
}
