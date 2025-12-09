/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Controladores;

import java.io.IOException;

/**
 *
 * @author Usuario
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Pedido;
import model.PizzeriaFacade;
import model.abst.Observador;

public class VentanaEstadoControlador implements Observador{

    @FXML private Label lblIdPedido;
    @FXML private Label lblCliente;

    // Puntos
    @FXML private Label puntoRecibido;
    @FXML private Label puntoPreparando;
    @FXML private Label puntoHorneando;
    @FXML private Label puntoTerminado;
    @FXML private Label puntoEntregado;

    // Líneas entre puntos
    @FXML private Label linea1;
    @FXML private Label linea2;
    @FXML private Label linea3;
    @FXML private Label linea4;

    @FXML private Button btnSalir;

    //private Pedido pedido;

    // Estilos para puntos y líneas
    private static final String PUNTO_ACTIVO =
            "-fx-background-color: #ff4a5a;" +
            "-fx-min-width: 16; -fx-min-height: 16;" +
            "-fx-max-width: 16; -fx-max-height: 16;" +
            "-fx-background-radius: 8;";

    private static final String PUNTO_INACTIVO =
            "-fx-background-color: #d3d3d3;" +
            "-fx-min-width: 16; -fx-min-height: 16;" +
            "-fx-max-width: 16; -fx-max-height: 16;" +
            "-fx-background-radius: 8;";

    private static final String LINEA_ACTIVA =
            "-fx-background-color: #ff4a5a;" +
            "-fx-min-width: 4; -fx-max-width: 4;" +
            "-fx-min-height: 24; -fx-max-height: 24;" +
            "-fx-background-radius: 2;";

    private static final String LINEA_INACTIVA =
            "-fx-background-color: #d3d3d3;" +
            "-fx-min-width: 4; -fx-max-width: 4;" +
            "-fx-min-height: 24; -fx-max-height: 24;" +
            "-fx-background-radius: 2;";

    private PizzeriaFacade pizzeria;

    @FXML
    public void initialize() {
        pizzeria = PizzeriaFacade.getInstance();
        Pedido pedido = pizzeria.getPedidos().getLast();
        
        Label[] puntos = {
                puntoRecibido,
                puntoPreparando,
                puntoHorneando,
                puntoTerminado,
                puntoEntregado
        };

        Label[] lineas = { linea1, linea2, linea3, linea4 };

        for (Label p: puntos) {  
            if (p != null) p.setStyle(PUNTO_INACTIVO);        
        }
        for (Label l: lineas) {  
            if (l != null) l.setStyle(LINEA_INACTIVA);        
        }
        pedido.registerObservers(this);

        //iniciarPedido(pedido);
        //pizzeria.recibirPedido(pedido);
    }

    private void iniciarPedido(Pedido pedido) {
        
        try {
            pedido.recibirPedido();
            Thread.sleep(2000);
            pedido.prepararPedido();
            Thread.sleep(5000);
            pedido.cocinarPedido();
            Thread.sleep(8000);
            pedido.empaquetarPedido();
            Thread.sleep(2000);
            pedido.entregarPedido();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSalir() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaPrincipal.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) btnSalir.getScene().getWindow();
            stage.setTitle("Pizzeria UAM");
            stage.setScene(new Scene(root));


        }catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana Principal.");
            alerta.show();
        }
    }

    @Override
    public void update(String mensaje) {
        if(mensaje.equals("Recibido")){
            puntoRecibido.setStyle(PUNTO_ACTIVO);
        } else if (mensaje.equals("Preparando")){
            puntoPreparando.setStyle(PUNTO_ACTIVO);
            linea1.setStyle(LINEA_ACTIVA);
        } else if (mensaje.equals("Horneando")){
            puntoHorneando.setStyle(PUNTO_ACTIVO);
            linea2.setStyle(LINEA_ACTIVA);
        } else if (mensaje.equals("Terminado")){
            puntoTerminado.setStyle(PUNTO_ACTIVO);
            linea3.setStyle(LINEA_ACTIVA);
        } else if (mensaje.equals("Entregado")){
            puntoEntregado.setStyle(PUNTO_ACTIVO);
            linea4.setStyle(LINEA_ACTIVA);
        }
    }
}

