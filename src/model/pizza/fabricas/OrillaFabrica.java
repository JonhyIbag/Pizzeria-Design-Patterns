package model.pizza.fabricas;

import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.Ingredientes.orillas.*;

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

    @Override
    public Ingrediente crearOrilla(String tipo) {
        switch (tipo) {
            case "RellenaQueso":
                return new RellenaQueso();
            case "Tradicional":
                return new Tradicional();
            case "Crujiente":
                return new Crujiente();
            default:
                System.out.println("Tipo de orilla no valido");
                break;
        }
        return null;
    }

    @Override
    public Ingrediente crearOtro(String tipo) {
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }
    
}
