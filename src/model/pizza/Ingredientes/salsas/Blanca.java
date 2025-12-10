package model.pizza.ingredientes.salsas;

/**
 * Ingrediente Concreto de Salsas. Es creado a traves de SalsasFabrica.
 * @author Triplets
 */
public class Blanca extends Salsa {
    private String nombre;
    private Double precio;

    public Blanca() {
        this.nombre = "Salsa Blanca";
        this.precio = 20.0;
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
