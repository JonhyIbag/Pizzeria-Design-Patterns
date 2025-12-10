package model.pizza.ingredientes.quesos;

/**
 * Ingrediente Concreto de Quesos. Es creado a traves de QuesosFabrica.
 * @author Triplets
 */
public class Cheddar extends Queso{
    private String nombre;
    private Double precio;

    public Cheddar() {
        this.nombre = "Queso Cheddar";
        this.precio = 30.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}