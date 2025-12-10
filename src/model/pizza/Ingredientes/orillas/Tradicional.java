package model.pizza.ingredientes.orillas;

/**
 * Ingrediente Concreto de Orillas. Es creado a traves de OrillasFabrica.
 * @author Triplets
 */
public class Tradicional extends Orilla{
    private String nombre;
    private Double precio;

    public Tradicional() {
        this.nombre = "Tradicional";
        this.precio = 20.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}