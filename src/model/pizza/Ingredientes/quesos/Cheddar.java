package model.pizza.Ingredientes.quesos;

public class Cheddar extends Queso{
    private String nombre;
    private Double precio;

    public Cheddar() {
        this.nombre = "Queso Cheddar";
        this.precio = 30.0;
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
