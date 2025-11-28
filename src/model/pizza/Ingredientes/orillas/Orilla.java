package model.pizza.Ingredientes.orillas;

import model.abst.Ingrediente;

public abstract class Orilla implements Ingrediente {
    private String tipo="orilla";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Nombre: " + getNombre() + ", Precio: " + getPrecio();
    }
}
