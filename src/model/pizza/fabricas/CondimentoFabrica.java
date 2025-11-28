package model.pizza.fabricas;

import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.Ingredientes.condimentos.*;

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
