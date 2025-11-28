package model.pizza.Ingredientes.masas;

public class Napolitana extends Masa{
    private String nombre;
    private Double precio;

    public Napolitana() {
        this.nombre = "Masa Napolitana";
        this.precio = 50.0;
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
