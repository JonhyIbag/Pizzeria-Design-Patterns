package model.pizza.Ingredientes.orillas;

public class Tradicional extends Orilla{
    private String nombre;
    private Double precio;

    public Tradicional() {
        this.nombre = "Tradicional";
        this.precio = 20.0;
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
