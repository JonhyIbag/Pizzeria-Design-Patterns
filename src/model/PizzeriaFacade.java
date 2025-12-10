package model;

import java.util.ArrayList;
import java.util.List;
import model.abst.Ingrediente;
import model.pizza.fabricas.CondimentoFabrica;
import model.pizza.fabricas.ExtrasFabrica;
import model.pizza.fabricas.MasaFabrica;
import model.pizza.fabricas.OrillaFabrica;
import model.pizza.fabricas.QuesoFabrica;
import model.pizza.fabricas.SalsaFabrica;

/**
 * PizzeriaFacade es la clase que implementa el patron Facade para simplificar
 * la interacción con el sistema de pedidos y pizzas. Proporciona métodos para
 * crear
 * pedidos, armar pizzas, gestionar el estado de los pedidos y calcular totales.
 * Es el principal punto de acceso al sistema y elo que permite la ocmunicacion
 * entre el modelo y la vista.
 * Implementa el patrón Singleton para asegurar que solo exista una instancia de
 * la fachada y podamos manejar los pedidos de manera centralizada.
 * 
 * @author Triplets
 * @version 1.0
 */
public class PizzeriaFacade {
    /**
     * Instancia única de PizzeriaFacade (Singleton)
     */
    private static PizzeriaFacade unicaInstancia;
    /**
     * Lista de pedidos gestionados por la pizzería
     */
    private final List<Pedido> pedidos = new ArrayList<>();
    /**
     * Contador para asignar IDs únicos a los clientes sin necesidad de hacer un
     * registro previo.
     */
    private int idCliente = 0;

    /**
     * Constructor privado para evitar instanciación externa (Singleton)
     */
    private PizzeriaFacade() {
    }

    /**
     * Obtiene la instancia única de PizzeriaFacade, si no existe la crea, si ya
     * existe la retorna.
     * 
     * @return Instancia única de PizzeriaFacade
     */
    public static PizzeriaFacade getInstance() {
        if (unicaInstancia == null) {
            unicaInstancia = new PizzeriaFacade();
        }
        return unicaInstancia;
    }

    /**
     * Crea un nuevo pedido para un cliente dado y lo agrega a la lista de pedidos.
     * Al mismo tiempo crea la notificación para el cliente y lo registra como
     * observador del pedido.
     * 
     * @param cliente El cliente que realiza el pedido, este es asignado
     *                automaticamente por la fachada.
     * @return El nuevo pedido creado
     */
    public Pedido crearPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        Notificacion notificacion = new Notificacion(cliente);
        pedido.registerObservers(notificacion);
        pedido.estadoActual = pedido.estadoRecibido;
        pedidos.add(pedido);
        return pedido;
    }

    /**
     * Crea las fábricas necesarias para cada tipo de ingrediente y utiliza estas 
     * fábricas para crear los ingredientes correspondientes. Posterioremente,
     * arma una pizza con los ingredientes especificados y la agrega al pedido dado.
     * 
     * @param pedido
     * @param tipoMasa
     * @param tipoSalsa
     * @param tipoQueso
     * @param tipoOrilla
     * @param tipoCondimentos
     * @param tipoOtros
     */
    public void armarPizza(Pedido pedido, String tipoMasa, String tipoSalsa, String tipoQueso, String tipoOrilla,
            List<String> tipoCondimentos, List<String> tipoOtros) {
        MasaFabrica masaFabrica = new MasaFabrica();
        SalsaFabrica salsaFabrica = new SalsaFabrica();
        QuesoFabrica quesoFabrica = new QuesoFabrica();
        OrillaFabrica orillaFabrica = new OrillaFabrica();
        CondimentoFabrica condimentoFabrica = new CondimentoFabrica();
        ExtrasFabrica extraFabrica = new ExtrasFabrica();

        Ingrediente masa = masaFabrica.crearMasa(tipoMasa);
        Ingrediente salsa = salsaFabrica.crearSalsa(tipoSalsa);
        Ingrediente queso = quesoFabrica.crearQueso(tipoQueso);
        Ingrediente orilla = orillaFabrica.crearOrilla(tipoOrilla);

        List<Ingrediente> condimentos = new ArrayList<>();
        if (tipoCondimentos != null) {
            for (String i : tipoCondimentos) {
                Ingrediente condimento = condimentoFabrica.crearCondimento(i);
                if (condimento != null) {
                    condimentos.add(condimento);
                }
            }
        }

        List<Ingrediente> otros = new ArrayList<>();
        if (tipoOtros != null) {
            for (String i : tipoOtros) {
                Ingrediente otro = extraFabrica.crearOtro(i);
                if (otro != null) {
                    otros.add(otro);
                }
            }
        }

        Pizza pizza = new Pizza(masa, salsa, queso, orilla, condimentos, otros);
        pedido.agregarPizza(pizza);
    }

    /**
     * Calcula el total del pedido sumando los totales de cada pizza en el pedido.
     * @param pedido El pedido del cual se calculará el total
     * @return El total del pedido
     */
    public double calcularTotal(Pedido pedido) {
        double total = 0.0;
        if (pedido.getPizzas() == null) {
            return 0.0;
        } else {
            for (Pizza p : pedido.getPizzas()) {
                total += p.calcularTotal();
            }
            return total;
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public int getIdCliente() {
        idCliente++;
        return idCliente;
    }
}
