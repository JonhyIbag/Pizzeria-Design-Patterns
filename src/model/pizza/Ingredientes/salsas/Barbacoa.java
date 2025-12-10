package model.pizza.ingredientes.salsas;

/**
 * Ingrediente Concreto de Salsas. Es creado a traves de SalsasFabrica.
 * @author Triplets
 */
public class Barbacoa extends Salsa {
    private String nombre;
    private Double precio;

    public Barbacoa() {
        this.nombre = "Salsa Barbacoa";
        this.precio = 25.0;
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