package model.pizza.Ingredientes.extras;

import model.abst.Ingrediente;

public abstract class Extras implements Ingrediente {
    private String tipo="extras";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Nombre: " + getNombre() + ", Precio: " + getPrecio();
    }
}
