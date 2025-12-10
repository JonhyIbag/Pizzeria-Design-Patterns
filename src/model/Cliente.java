package model;

/**
 * Esta clase nos permite tener el registro de los clientes que usan el sistema.
 * Cada cliente tiene un id unico.
 * @author Triplets
 */
public class Cliente {
    private int idCliente;

    public Cliente(int idCliente){
        this.idCliente = idCliente;
    }

    public int getIdCliente(){
        return idCliente;
    }

    public String toString(){
        return "Cliente: " + idCliente;
    }

}
