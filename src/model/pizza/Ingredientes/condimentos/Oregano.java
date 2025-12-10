package model.pizza.ingredientes.condimentos;

/**
 * Ingrediente Concreto de Condimento. Es creado a traves de FabricaCondimentos.
 * @author Triplets
 */
public class Oregano extends Condimento{
    private final String nombre;
    private final Double precio;

    public Oregano() {
        this.nombre = "Oregano";
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
