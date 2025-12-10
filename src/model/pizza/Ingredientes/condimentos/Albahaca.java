package model.pizza.ingredientes.condimentos;

/**
 * Ingrediente Concreto de Condimento. Es creado a traves de FabricaCondimentos.
 * @author Triplets
 */
public class Albahaca extends Condimento{
    private final String nombre;
    private final Double precio;

    public Albahaca() {
        this.nombre = "Albahaca";
        this.precio = 5.0;
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

