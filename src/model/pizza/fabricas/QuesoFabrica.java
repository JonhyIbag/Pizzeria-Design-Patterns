package model.pizza.fabricas;

import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.Ingredientes.quesos.*;

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
