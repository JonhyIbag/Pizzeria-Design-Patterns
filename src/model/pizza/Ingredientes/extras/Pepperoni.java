package model.pizza.Ingredientes.extras;

public class Pepperoni extends Extras{
    private String nombre;
    private Double precio;

    public Pepperoni() {
        this.nombre = "Pepperoni";
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
