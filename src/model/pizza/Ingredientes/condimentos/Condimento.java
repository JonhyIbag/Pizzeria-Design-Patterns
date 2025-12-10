package model.pizza.ingredientes.condimentos;
import model.abst.Ingrediente;

/**
 * Clase abstracta que representa un condimento en la pizza.
 * Hereda de la interfaz Ingrediente.
 * Proporciona una implementación común para los métodos getTipo() y toString().
 * @author Triplets
 */
public abstract class Condimento implements Ingrediente {
    private String tipo="condimento";

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return getNombre() + "\nPrecio: " + getPrecio();
    }
}
