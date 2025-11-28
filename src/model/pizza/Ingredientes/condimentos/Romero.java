package model.pizza.Ingredientes.condimentos;

public class Romero extends Condimento{
    private String nombre;
    private Double precio;

    public Romero() {
        this.nombre = "Romero";
        this.precio = 5.0;
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
