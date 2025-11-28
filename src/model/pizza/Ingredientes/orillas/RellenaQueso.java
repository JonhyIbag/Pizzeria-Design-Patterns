package model.pizza.Ingredientes.orillas;

public class RellenaQueso extends Orilla{
    private String nombre;
    private Double precio;

    public RellenaQueso() {
        this.nombre = "Rellena de Queso";
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
