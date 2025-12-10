package model.abst;

/**
 * Interface que representa un ingrediente en la pizzería.
 * Todos los tipos de ingredientes van a impementar esta interfaz para poder tener un buen manejo de los ingredientes.
 * @author Triplets
 * @version 1.0
 */
public abstract class IngredienteFabrica {
    /**
     * Cada uno de los siguientes métodos es responsable de crear un tipo específico de ingrediente.
     * Cada subclase concreta de IngredienteFabrica implementará estos métodos para producir ingredientes específicos.
     */
    public abstract Ingrediente crearMasa(String tipo);
    public abstract Ingrediente crearSalsa(String tipo);
    public abstract Ingrediente crearQueso(String tipo);
    public abstract Ingrediente crearCondimento(String tipo);
    public abstract Ingrediente crearOrilla(String tipo);
    public abstract Ingrediente crearOtro(String tipo);
}
