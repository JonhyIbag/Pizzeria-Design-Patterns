package model.pizza.ingredientes.orillas;

/**
 * Ingrediente Concreto de Orillas. Es creado a traves de OrillasFabrica.
 * @author Triplets
 */
public class RellenaQueso extends Orilla{
    private String nombre;
    private Double precio;

    public RellenaQueso() {
        this.nombre = "Rellena de Queso";
        this.precio = 40.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}