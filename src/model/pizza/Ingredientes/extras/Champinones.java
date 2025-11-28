package model.pizza.Ingredientes.extras;

public class Champinones extends Extras{
    private String nombre;
    private Double precio;

    public Champinones() {
        this.nombre = "Champiñones";
        this.precio = 10.0;
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
