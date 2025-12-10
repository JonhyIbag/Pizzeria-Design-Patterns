package model.pizza.ingredientes.masas;

/**
 * Ingrediente Concreto de Masas. Es creado a traves de MasasFabrica.
 * @author Triplets
 */
public class Napolitana extends Masa{
    private String nombre;
    private Double precio;

    public Napolitana() {
        this.nombre = "Masa Napolitana";
        this.precio = 50.0;
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
