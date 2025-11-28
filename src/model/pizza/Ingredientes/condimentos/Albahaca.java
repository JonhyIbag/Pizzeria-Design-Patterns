package model.pizza.Ingredientes.condimentos;

public class Albahaca extends Condimento{
    private String nombre;
    private Double precio;

    public Albahaca() {
        this.nombre = "Albahaca";
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
