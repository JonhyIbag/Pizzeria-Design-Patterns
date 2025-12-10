package model.pizza.fabricas;
import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.ingredientes.orillas.*;

/**
 * Fabrica concreta para crear ingredientes de tipo orilla.
 * Hereda de IngredienteFabrica e implementa el metodo crearOrilla.
 * @author Triplets
 */
public class OrillaFabrica extends IngredienteFabrica {

    @Override
    public Ingrediente crearMasa(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }

    @Override
    public Ingrediente crearSalsa(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }

    @Override
    public Ingrediente crearQueso(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }

    @Override
    public Ingrediente crearCondimento(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }

    /**
     * Crea una instancia de un ingrediente de orilla basado en el tipo proporcionado.
     * @param tipo El tipo de orilla a crear (RellenaQueso, Tradicional, Crujiente).
     * @return Una instancia del ingrediente de orilla correspondiente, o null si el tipo no es valido.
     */
    @Override
    public Ingrediente crearOrilla(String tipo) {
        switch (tipo) {
            case "RellenaQueso" -> {
                return new RellenaQueso();
            }
            case "Tradicional" -> {
                return new Tradicional();
            }
            case "Crujiente" -> {
                return new Crujiente();
            }
            default -> System.out.println("Tipo de orilla no valido");
        }
        return null;
    }

    @Override
    public Ingrediente crearOtro(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }
    
}
