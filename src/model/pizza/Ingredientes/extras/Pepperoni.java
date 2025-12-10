package model.pizza.ingredientes.extras;

/**
 * Ingrediente Concreto de Extras. Es creado a traves de ExtrasFabrica.
 * @author Triplets
 */
public class Pepperoni extends Extras{
    private final String nombre;
    private final Double precio;

    public Pepperoni() {
        this.nombre = "Pepperoni";
        this.precio = 15.0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Double getPrecio() {
        return precio;
    }
}   