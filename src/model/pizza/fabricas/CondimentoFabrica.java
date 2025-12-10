package model.pizza.fabricas;
import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.ingredientes.condimentos.*;

/**
 * Fabrica concreta para crear ingredientes de tipo condimento.
 * Hereda de IngredienteFabrica e implementa el metodo crearCondimento.
 * @author Triplets
 */
public class CondimentoFabrica extends IngredienteFabrica {

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

    /**
     * Crea una instancia de un ingrediente de condimento basado en el tipo proporcionado.
     * @param tipo El tipo de condimento a crear (Oregano, Albahaca, Romero).
     * @return Una instancia del ingrediente de condimento correspondiente, o null si el tipo no es valido.
     */
    @Override
    public Ingrediente crearCondimento(String tipo) {
        switch (tipo) {
            case "Oregano":
                return new Oregano();
            case "Albahaca":
                return new Albahaca();
            case "Romero":
                return new Romero();
            default:
                System.out.println("Tipo de salsa no valido");
                break;
        }
        return null;
    }

    @Override
    public Ingrediente crearOrilla(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }

    @Override
    public Ingrediente crearOtro(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }
    
}

