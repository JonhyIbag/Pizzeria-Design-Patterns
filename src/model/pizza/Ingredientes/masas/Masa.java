package model.pizza.ingredientes.masas;
import model.abst.Ingrediente;

/**
 * Clase abstracta que representa la masa en la pizza.
 * Hereda de la interfaz Ingrediente.
 * Proporciona una implementación común para los métodos getTipo() y toString().
 * @author Triplets
 */
public abstract class Masa implements Ingrediente {
    private String tipo="masa";

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return getNombre() + "\nPrecio: " + getPrecio();
    }
}
