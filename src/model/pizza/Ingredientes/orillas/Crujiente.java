package model.pizza.ingredientes.orillas;

/**
 * Ingrediente Concreto de Orillas. Es creado a traves de OrillasFabrica.
 * @author Triplets
 */
public class Crujiente extends Orilla{
    private String nombre;
    private Double precio;

    public Crujiente() {
        this.nombre = "Crujiente";
        this.precio = 40.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}