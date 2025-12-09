/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Usuario
 */


import java.util.ArrayList;
import java.util.List;

import model.abst.Ingrediente;

public class Pizza {
    private Ingrediente masa;
    private Ingrediente salsa;
    private Ingrediente queso;
    private Ingrediente orilla;

    private List<Ingrediente> condimentos;
    private List<Ingrediente> otros;

    public Pizza(Ingrediente masa, Ingrediente salsa, Ingrediente queso, Ingrediente orilla, 
        List<Ingrediente> condimentos, List<Ingrediente> otros){
            this.masa= masa;
            this.salsa= salsa;
            this.queso= queso;
            this.orilla= orilla; 
            this.condimentos = (condimentos != null) ? condimentos : new ArrayList<>();
            this.otros = (otros != null) ? otros : new ArrayList<>();
    }

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
