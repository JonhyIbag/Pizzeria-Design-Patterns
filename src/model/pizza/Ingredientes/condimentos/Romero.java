package model.pizza.ingredientes.condimentos;


/**
 * Ingrediente Concreto de Condimento. Es creado a traves de FabricaCondimentos.
 * @author Triplets
 */
public class Romero extends Condimento{
    private final String nombre;
    private final Double precio;

    public Romero() {
        this.nombre = "Romero";
        this.precio = 5.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}

