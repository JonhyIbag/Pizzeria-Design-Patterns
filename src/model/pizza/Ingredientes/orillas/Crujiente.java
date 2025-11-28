package model.pizza.Ingredientes.orillas;

public class Crujiente extends Orilla{
    private String nombre;
    private Double precio;

    public Crujiente() {
        this.nombre = "Crujiente";
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
