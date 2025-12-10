package model.pizza.ingredientes.extras;

/**
 * Ingrediente Concreto de Extras. Es creado a traves de ExtrasFabrica.
 * @author Triplets
 */
public class Champinones extends Extras{
    private final String nombre;
    private final Double precio;

    public Champinones() {
        this.nombre = "Champiñones";
        this.precio = 10.0;
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
