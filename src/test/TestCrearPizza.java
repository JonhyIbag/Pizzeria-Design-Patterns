package test;

import java.util.ArrayList;
import java.util.List;

import model.Pizza;
import model.abst.Ingrediente;
import model.abst.IngredienteFabrica;
import model.pizza.fabricas.*;

public class TestCrearPizza {
    public static void main(String[] args) {
        List<Ingrediente> extras = new ArrayList<Ingrediente>();
        List<Ingrediente> condimentos = new ArrayList<Ingrediente>();

        IngredienteFabrica fabrica = new MasaFabrica();
        Ingrediente masa = fabrica.crearMasa("Napolitana");

        fabrica = new SalsaFabrica();
        Ingrediente salsa = fabrica.crearSalsa("Tomate");

        fabrica = new QuesoFabrica();
        Ingrediente queso = fabrica.crearQueso("Cheddar");

        fabrica = new OrillaFabrica();
        Ingrediente orilla = fabrica.crearOrilla("RellenaQueso");

        fabrica = new CondimentoFabrica();
        Ingrediente cond = fabrica.crearCondimento("Oregano");
        condimentos.add(cond);

        fabrica = new ExtrasFabrica();
        Ingrediente ex = fabrica.crearOtro("Pepperoni");
        extras.add(ex);
        ex = fabrica.crearOtro("Pepperoni");
        extras.add(ex);

        Pizza pizza = new Pizza(masa, salsa, queso, orilla, condimentos, extras);

        System.out.println("Precio total de la pizza: $" + pizza.calcularTotal());
    }
}
