package model.pizza.Ingredientes.quesos;

public class Mozzarella extends Queso{
    private String nombre;
    private Double precio;

    public Mozzarella() {
        this.nombre = "Queso Mozarella";
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
