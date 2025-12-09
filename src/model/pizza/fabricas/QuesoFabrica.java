/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.pizza.fabricas;

/**
 *
 * @author Usuario
 */

import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.ingredientes.quesos.*;

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
