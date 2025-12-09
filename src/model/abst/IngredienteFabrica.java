package model.abst;

public abstract class IngredienteFabrica {
    public abstract Ingrediente crearMasa(String tipo);
    public abstract Ingrediente crearSalsa(String tipo);
    public abstract Ingrediente crearQueso(String tipo);
    public abstract Ingrediente crearCondimento(String tipo);
    public abstract Ingrediente crearOrilla(String tipo);
    public abstract Ingrediente crearOtro(String tipo);
}
