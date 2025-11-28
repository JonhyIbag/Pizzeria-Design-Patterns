package model.pizza.Ingredientes.quesos;

import model.abst.Ingrediente;

public abstract class Queso implements Ingrediente {
    private String tipo="Queso";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Nombre: " + getNombre() + ", Precio: " + getPrecio();
    }
}
