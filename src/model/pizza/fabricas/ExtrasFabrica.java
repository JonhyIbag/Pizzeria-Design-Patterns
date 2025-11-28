package model.pizza.fabricas;

import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.Ingredientes.extras.*;

public class ExtrasFabrica extends IngredienteFabrica {

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

    @Override
    public Ingrediente crearOrilla(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }

    @Override
    public Ingrediente crearOtro(String tipo) {
        switch (tipo) {
            case "Champinones":
                return new Champinones();
            case "Pepperoni":
                return new Pepperoni();
            case "Pimientos":
                return new Pimientos();
            default:
                System.out.println("Tipo de extra no valido");
                break;
        }
        return null;
    }
    
}
