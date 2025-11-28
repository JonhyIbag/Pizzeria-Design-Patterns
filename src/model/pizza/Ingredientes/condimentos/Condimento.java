package model.pizza.Ingredientes.condimentos;

import model.abst.Ingrediente;

public abstract class Condimento implements Ingrediente {
    private String tipo="condimento";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Nombre: " + getNombre() + ", Precio: " + getPrecio();
    }
}
