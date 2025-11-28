package model.pizza.Ingredientes.masas;

import model.abst.Ingrediente;

public abstract class Masa implements Ingrediente {
    private String tipo="masa";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Nombre: " + getNombre() + ", Precio: " + getPrecio();
    }
}
