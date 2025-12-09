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
import model.pizza.ingredientes.masas.*;

public class MasaFabrica extends IngredienteFabrica {

    @Override
    public Ingrediente crearMasa(String tipo) {
        switch (tipo) {
            case "Napolitana":
                return new Napolitana();
            case "Romana":
                return new Romana();
            case "Americana":
                return new Americana();
            default:
                System.out.println("Tipo de masa no valido");
                break;
        }
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
        System.out.println("Operacion Invalida, Accediste a la fabrica equivocada");
        return null;
    }
    
}
