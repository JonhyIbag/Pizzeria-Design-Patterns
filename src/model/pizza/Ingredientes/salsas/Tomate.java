package model.pizza.ingredientes.salsas;

/**
 * Ingrediente Concreto de Salsas. Es creado a traves de SalsasFabrica.
 * @author Triplets
 */
public class Tomate extends Salsa {
    private String nombre;
    private Double precio;

    public Tomate() {
        this.nombre = "Salsa de Tomate";
        this.precio = 15.0;
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