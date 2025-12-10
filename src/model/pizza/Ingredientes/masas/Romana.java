package model.pizza.ingredientes.masas;

/**
 * Ingrediente Concreto de Masas. Es creado a traves de MasasFabrica.
 * @author Triplets
 */
public class Romana extends Masa{
    private String nombre;
    private Double precio;

    public Romana() {
        this.nombre = "Masa Romana";
        this.precio = 70.0;
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
