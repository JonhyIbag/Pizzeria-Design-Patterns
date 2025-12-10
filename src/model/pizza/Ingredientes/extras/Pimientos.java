package model.pizza.ingredientes.extras;


/**
 * Ingrediente Concreto de Extras. Es creado a traves de ExtrasFabrica.
 * @author Triplets
 */
public class Pimientos extends Extras{
    private final String nombre;
    private final Double precio;

    public Pimientos() {
        this.nombre = "Pimientos";
        this.precio = 17.0;
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