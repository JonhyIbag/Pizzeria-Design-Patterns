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

import model.abst.EstadoPedido;
import model.abst.Ingrediente;
import model.pizza.fabricas.CondimentoFabrica;
import model.pizza.fabricas.ExtrasFabrica;
import model.pizza.fabricas.MasaFabrica;
import model.pizza.fabricas.OrillaFabrica;
import model.pizza.fabricas.QuesoFabrica;
import model.pizza.fabricas.SalsaFabrica;

public class PizzeriaFacade {
    private static PizzeriaFacade unicaInstancia;
    private final List<Pedido> pedidos = new ArrayList<>();
    private int idCliente = 0;

    // para la instancia del Singleton
    public static PizzeriaFacade getInstance(){
        if(unicaInstancia == null){
            unicaInstancia = new PizzeriaFacade();
        }
        return unicaInstancia;
    }
    // Crear pedido
    public Pedido crearPedido(Cliente cliente){
        Pedido pedido = new Pedido(cliente);
        Notificacion notificacion = new Notificacion(cliente);
        pedido.registerObservers(notificacion);
        pedidos.add(pedido);
        return pedido; 
    }
    // Armar pizza
    public void armarPizza(Pedido pedido, String tipoMasa,String tipoSalsa, String tipoQueso, String tipoOrilla, 
        List<String> tipoCondimentos, List<String> tipoOtros){
            MasaFabrica masaFabrica = new MasaFabrica();
            SalsaFabrica salsaFabrica = new SalsaFabrica();
            QuesoFabrica quesoFabrica = new QuesoFabrica();
            OrillaFabrica orillaFabrica= new OrillaFabrica();
            CondimentoFabrica condimentoFabrica = new CondimentoFabrica();
            ExtrasFabrica extraFabrica = new ExtrasFabrica(); 

            Ingrediente masa= masaFabrica.crearMasa(tipoMasa);
            Ingrediente salsa = salsaFabrica.crearSalsa(tipoSalsa);
            Ingrediente queso = quesoFabrica.crearQueso(tipoQueso);
            Ingrediente orilla = orillaFabrica.crearOrilla(tipoOrilla);

            List<Ingrediente> condimentos = new ArrayList<>();
            if(tipoCondimentos != null){
                for(String i: tipoCondimentos){
                    Ingrediente condimento = condimentoFabrica.crearCondimento(i);
                    if(condimento != null){
                        condimentos.add(condimento);
                    }
                }
            }

            List<Ingrediente> otros = new ArrayList<>();
            if(tipoOtros != null){
                for(String i: tipoOtros){
                    Ingrediente otro = extraFabrica.crearOtro(i);
                    if(otro != null){
                        otros.add(otro);
                    }
                }
            }

            Pizza pizza = new Pizza(masa, salsa, queso, orilla, condimentos, otros);
            //agregar al pedido
            pedido.agregarPizza(pizza);
        }
        
    // recibirPedido
    public void recibirPedido(Pedido pedido){
        pedido.recibirPedido();
    }
    // prepararPedido
    public void prepararPedido(Pedido pedido){
        pedido.prepararPedido();
    }
    // cocinarPedido
    public void cocinarPedido(Pedido pedido){
        pedido.cocinarPedido();
    }
    // empaquetarPedido
    public void empaquetarPedido(Pedido pedido){
        pedido.empaquetarPedido();
    }
    // entregarPedido
    public void entregarPedido(Pedido pedido){
        pedido.entregarPedido();
    }
    // consultarEstado
    public EstadoPedido consultarEstado(Pedido pedido){
        return pedido.estadoActual;
    }

    // calcularTotal
    public double calcularTotal(Pedido pedido){
        double total = 0.0;
        if(pedido.getPizzas() == null){
            return 0.0;
        } else{
            for(Pizza p : pedido.getPizzas()){
                // System.out.println( p.toString() );
                total += p.calcularTotal();
            }
            return total;
        }
    }
    
    //metodo para devoler los pedidos a la GUI 
    public List<Pedido> getPedidos(){
        return pedidos;
    }

    public int getIdCliente(){
        idCliente++;
        return idCliente;
    }
}
