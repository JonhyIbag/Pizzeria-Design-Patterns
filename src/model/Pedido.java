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

import model.abst.EstadoPedido;
import model.abst.Observador;
import model.abst.Subject;
import model.estadoPedido.EstadoEntregado;
import model.estadoPedido.EstadoHorneando;
import model.estadoPedido.EstadoPreparando;
import model.estadoPedido.EstadoRecibido;
import model.estadoPedido.EstadoTerminado;
import model.estadoPedido.EstadoVacio;

public class Pedido implements Subject{
    public EstadoPedido estadoActual;
    public EstadoPedido sinPedido;
    public EstadoRecibido estadoRecibido;
    public EstadoPreparando estadoPreparado;
    public EstadoHorneando estadoHorneando;
    public EstadoTerminado estadoTerminado;
    public EstadoEntregado estadoEntregado;

    // ArrayList de observers
    protected ArrayList<Observador> observers = new ArrayList<>();

    private Cliente cliente;
    private ArrayList<Pizza> pizzas;

    public Pedido() {
        this.pizzas = new ArrayList<>();
        sinPedido = new EstadoVacio(this);
        estadoRecibido = new EstadoRecibido(this);
        estadoPreparado = new EstadoPreparando(this);
        estadoHorneando = new EstadoHorneando(this);
        estadoTerminado = new EstadoTerminado(this);
        estadoEntregado = new EstadoEntregado(this);

        estadoActual = sinPedido;
    }

    public void recibirPedido() {
        estadoActual.recibirPedido();
    }

    public void prepararPedido() {
        estadoActual.prepararPedido();
    }

    public void cocinarPedido() {
        estadoActual.cocinarPedido();
    }

    public void empaquetarPedido() {
        estadoActual.empaquetarPedido();
    }

    public void entregarPedido() {
        estadoActual.entregarPedido();
    }

    // Observer
    public void registerObservers(Observador o){
        observers.add(o);
    }
    public void removeObservers(Observador o){
        observers.remove(o);
    }
    public void notifyObservers(String mensaje){
        for(Observador o: observers){
            o.update(mensaje);
        }
    }

    public Pedido(Cliente cliente){
        // inicializar estados
        this();
        this.cliente = cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }
    // Para pizza
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }
    public void setPizzas(ArrayList<Pizza> pizzas){
        this.pizzas = pizzas;
    }

    public void agregarPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public EstadoPedido getEstadoActual() {
        return estadoActual;
    }

}
