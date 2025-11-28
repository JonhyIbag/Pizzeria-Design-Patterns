package model.pizza.Ingredientes.extras;

public class Pimientos extends Extras{
    private String nombre;
    private Double precio;

    public Pimientos() {
        this.nombre = "Pimientos";
        this.precio = 17.0;
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
