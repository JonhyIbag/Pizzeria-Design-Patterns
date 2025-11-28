package model.pizza.Ingredientes.masas;

public class Americana extends Masa{
    private String nombre;
    private Double precio;

    public Americana() {
        this.nombre = "Masa Americana";
        this.precio = 40.0;
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
