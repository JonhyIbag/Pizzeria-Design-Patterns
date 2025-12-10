package model.pizza.ingredientes.quesos;
import model.abst.Ingrediente;

/**
 * Clase abstracta que representa el queso en la pizza.
 * Hereda de la interfaz Ingrediente.
 * Proporciona una implementación común para los métodos getTipo() y toString().
 * @author Triplets
 */
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