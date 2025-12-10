package model.pizza.ingredientes.masas;

/**
 * Ingrediente Concreto de Masas. Es creado a traves de MasasFabrica.
 * @author Triplets
 */
public class Americana extends Masa{
    private String nombre;
    private Double precio;

    public Americana() {
        this.nombre = "Masa Americana";
        this.precio = 40.0;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
}
