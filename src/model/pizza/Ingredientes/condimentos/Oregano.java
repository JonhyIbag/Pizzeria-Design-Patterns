package model.pizza.Ingredientes.condimentos;

public class Oregano extends Condimento{
    private String nombre;
    private Double precio;

    public Oregano() {
        this.nombre = "Oregano";
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
