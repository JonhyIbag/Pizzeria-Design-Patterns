package model.pizza.fabricas;
import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.ingredientes.quesos.*;

/**
 * Fabrica concreta para crear ingredientes de tipo queso.
 * Hereda de IngredienteFabrica e implementa el metodo crearQueso.
 * @author Triplets
 */
public class QuesoFabrica extends IngredienteFabrica {

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

    /**
     * Crea una instancia de un ingrediente de queso basado en el tipo proporcionado.
     * @param tipo El tipo de queso a crear (Mozzarella, Parmesano, Cheddar).
     * @return Una instancia del ingrediente de queso correspondiente, o null si el tipo no es valido.
     */
    @Override
    public Ingrediente crearQueso(String tipo) {
        switch (tipo) {
            case "Mozzarella":
                return new Mozzarella();
            case "Parmesano":
                return new Parmesano();
            case "Cheddar":
                return new Cheddar();
            default:
                System.out.println("Tipo de queso no valido");
                break;
        }
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
