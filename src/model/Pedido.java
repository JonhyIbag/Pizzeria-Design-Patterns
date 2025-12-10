package model;

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

/**
 * Es una de las clases principales del sistema, representa un pedido de pizzas realizado por un cliente.
 * Utiliza el patrón de diseño State para manejar los diferentes estados del pedido. 
 * De igual manera implementa el patrón Observer para notificar a los observadores sobre los cambios en el estado del pedido.
 * Tiene una composición con la clase Cliente y una lista de pizzas asociadas al pedido.
 * @author Triplets
 */
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

    /**
     * Constructor por defecto que inicializa los estados del pedido y establece el estado inicial como "sinPedido".
     * @param cliente El cliente que realiza el pedido.
     */
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.pizzas = new ArrayList<>();
        sinPedido = new EstadoVacio(this);
        estadoRecibido = new EstadoRecibido(this);
        estadoPreparado = new EstadoPreparando(this);
        estadoHorneando = new EstadoHorneando(this);
        estadoTerminado = new EstadoTerminado(this);
        estadoEntregado = new EstadoEntregado(this);

        estadoActual = sinPedido;
    }

    /**
     * Método para realizar la accion correspondiente al estado de "recibido".
     */
    public void recibirPedido() {
        estadoActual.recibirPedido();
    }

    /**
     * Método para realizar la accion correspondiente al estado de "preparando".
     */
    public void prepararPedido() {
        estadoActual.prepararPedido();
    }

    /**
     * Método para realizar la accion correspondiente al estado de "recibido".
     */
    public void cocinarPedido() {
        estadoActual.cocinarPedido();
    }

    /**
     * Método para realizar la accion correspondiente al estado de "empaquetar".
     */
    public void empaquetarPedido() {
        estadoActual.empaquetarPedido();
    }

    /**
     * Método para realizar la accion correspondiente al estado de "entregado".
     */
    public void entregarPedido() {
        estadoActual.entregarPedido();
    }

    /**
     * Metodo implementados de la interfaz Subject para el patron Observer.
     * @param o Observador que se desea registrar.
     */
    public void registerObservers(Observador o){
        observers.add(o);
    }

    /**
     * Metodos implementados de la interfaz Subject para el patron Observer.
     * @param o Observador que se desea eliminar.
     */
    public void removeObservers(Observador o){
        observers.remove(o);
    }

    /**
     * Metodos implementados de la interfaz Subject para el patron Observer.
     * @param mensaje Mensaje que se desea enviar a los observadores.
     */
    public void notifyObservers(String mensaje){
        for(Observador o: observers){
            o.update(mensaje);
        }
    }

    /**
     * Agrega una pizza al pedido.
     * @param pizza Pizza que se desea agregar al pedido.
     */
    public void agregarPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }
    public void setPizzas(ArrayList<Pizza> pizzas){
        this.pizzas = pizzas;
    }

    public EstadoPedido getEstadoActual() {
        return estadoActual;
    }

    public Cliente getCliente(){
        return cliente;
    }
}
