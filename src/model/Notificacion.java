package model;

/**
 * Esta clase representa una notificación para un cliente específico. El cliente es registrado y gracias a nuestras clases
 * que implementan el patron observer podemos notificarlo cuando haya cambios relevantes.
 * @author Triplets
 */

import model.abst.Observador;

public class Notificacion implements Observador{
    private Cliente cliente;
    
    public Notificacion(Cliente cliente){
        this.cliente = cliente;
    }

    /**
     * Método que actualiza al cliente con un mensaje específico. Este metodo es llamada por nuestro sujeto observado.
     * @param mensaje El mensaje que se enviará al cliente.
     */
    @Override
    public void update(String mensaje){
        System.out.println(mensaje);
    }

    public Cliente getCliente(){
        return cliente;
    }
}
