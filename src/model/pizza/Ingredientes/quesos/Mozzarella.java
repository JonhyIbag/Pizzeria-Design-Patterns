package model.pizza.ingredientes.quesos;

/**
 * Ingrediente Concreto de Quesos. Es creado a traves de QuesosFabrica.
 * @author Triplets
 */
public class Mozzarella extends Queso{
    private String nombre;
    private Double precio;

    public Mozzarella() {
        this.nombre = "Queso Mozarella";
        this.precio = 25.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}
