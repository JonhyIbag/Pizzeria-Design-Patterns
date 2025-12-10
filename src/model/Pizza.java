package model;

import java.util.ArrayList;
import java.util.List;
import model.abst.Ingrediente;
/**
 * Representa una pizza con sus ingredientes y métodos para calcular su precio total.
 * @author Triplets
 */
public class Pizza {
    /**
     * Ingredientes de la pizza de los cuales solo puede haber uno de cada tipo principal (masa, salsa, queso, orilla).
     */
    private Ingrediente masa;
    private Ingrediente salsa;
    private Ingrediente queso;
    private Ingrediente orilla;

    /**
     * Ingredientes de la pizza de los cuales puede haber 0 o mas de cada tipo (condimentos y otros).
     */
    private List<Ingrediente> condimentos;
    private List<Ingrediente> otros;

    /**
     * Constructor de la clase Pizza.
     * @param masa
     * @param salsa
     * @param queso
     * @param orilla
     * @param condimentos
     * @param otros
     */
    public Pizza(Ingrediente masa, Ingrediente salsa, Ingrediente queso, Ingrediente orilla, 
        List<Ingrediente> condimentos, List<Ingrediente> otros){
            this.masa= masa;
            this.salsa= salsa;
            this.queso= queso;
            this.orilla= orilla; 
            this.condimentos = (condimentos != null) ? condimentos : new ArrayList<>();
            this.otros = (otros != null) ? otros : new ArrayList<>();
    }

    /**
     * Metodo que nos permite recorrer todos los ingredientes de la pizza y calcular el precio total.
     * @return El precio total de la pizza.
     */
    public double calcularTotal(){
        double cantidadTotal = 0;
        cantidadTotal += masa.getPrecio();
        cantidadTotal += salsa.getPrecio();
        cantidadTotal += queso.getPrecio();
        cantidadTotal += orilla.getPrecio();

        for(Ingrediente i: condimentos){
            cantidadTotal += i.getPrecio();
        }
        for(Ingrediente i: otros){
            cantidadTotal += i.getPrecio();
        }
        return cantidadTotal; 
    }

    public double getPrecio(){
        return calcularTotal();
    }

    public Ingrediente getMasa(){
        return masa;
    }
    public Ingrediente getSalsa(){
        return salsa;
    }
    public Ingrediente getQueso(){
        return queso;
    }
    public Ingrediente getOrilla(){
        return orilla;
    }
    public List<Ingrediente> getCondimentos(){
        return condimentos;
    }
    public List<Ingrediente> getOtros(){
        return otros;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n----------Pizza Generada-----------\n");
        sb.append("Masa: ").append(masa.getNombre()).append("\n");
        sb.append("Salsa: ").append(salsa.getNombre()).append("\n");
        sb.append("Queso: ").append(queso.getNombre()).append("\n");
        sb.append("Orilla: ").append(orilla.getNombre()).append("\n");

        sb.append("Condimentos: ");
        for(Ingrediente i: condimentos){
            sb.append(i.getNombre()).append(", ");
        }
        sb.append("\n");

        sb.append("Otros: ");
        for(Ingrediente i: otros){
            sb.append(i.getNombre()).append(", ");
        }
        sb.append("\n");

        return sb.toString();
    }
}
