package model.pizza.ingredientes.salsas;
import model.abst.Ingrediente;

/**
 * Clase abstracta que representa la salsa en la pizza.
 * Hereda de la interfaz Ingrediente.
 * Proporciona una implementación común para los métodos getTipo() y toString().
 * @author Triplets
 */
public abstract class Salsa implements Ingrediente {
    private String tipo="salsa";

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return getNombre() + "\nPrecio: " + getPrecio();
    }
}