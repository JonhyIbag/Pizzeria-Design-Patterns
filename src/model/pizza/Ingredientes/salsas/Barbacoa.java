package model.pizza.Ingredientes.salsas;

public class Barbacoa extends Salsa {
    private String nombre;
    private Double precio;

    public Barbacoa() {
        this.nombre = "Salsa Barbacoa";
        this.precio = 25.0;
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
