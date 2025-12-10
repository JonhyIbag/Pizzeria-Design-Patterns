package model.pizza.fabricas;
import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.ingredientes.salsas.*;

/**
 * Fabrica concreta para crear ingredientes de tipo salsa.
 * Hereda de IngredienteFabrica e implementa el metodo crearSalsa.
 * @author Triplets
 */
public class SalsaFabrica extends IngredienteFabrica {
    @Override
    public Ingrediente crearMasa(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }

    /**
     * Crea una instancia de un ingrediente de salsa basado en el tipo proporcionado.
     * @param tipo El tipo de salsa a crear (Tomate, Blanca, Barbacoa).
     * @return Una instancia del ingrediente de salsa correspondiente, o null si el tipo no es valido.
     */
    @Override
    public Ingrediente crearSalsa(String tipo) {
        switch (tipo) {
            case "Tomate" -> {
                return new Tomate();
            }
            case "Blanca" -> {
                return new Blanca();
            }
            case "Barbacoa" -> {
                return new Barbacoa();
            }
            default -> System.out.println("Tipo de salsa no valido");
        }
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

