package model.pizza.Ingredientes.quesos;

public class Parmesano extends Queso{
    private String nombre;
    private Double precio;

    public Parmesano() {
        this.nombre = "Queso Parmesano";
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
