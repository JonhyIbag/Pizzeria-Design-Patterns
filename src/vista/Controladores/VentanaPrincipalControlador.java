/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Controladores;

import java.io.IOException;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
import model.Cliente;
import model.Pedido;
import model.PizzeriaFacade;
import model.abst.EstadoPedido;
import model.estadoPedido.*;

public class VentanaPrincipalControlador {

    // Configuracion de todo la tabla
    @FXML
    private TableView<Pedido> tablaPedidos;
    @FXML
    private TableColumn<Pedido, String> colId;
    @FXML
    private TableColumn<Pedido, String> colCliente;
    @FXML
    private TableColumn<Pedido, String> colEstado;
    @FXML
    private TableColumn<Pedido, String> colTotal;

    // solo botoes
    @FXML
    public Button btnNuevo;
    @FXML
    public Button btnActualizar;
    @FXML
    public Button btnVerEstado;
    @FXML
    public Button btnSalir;
    // acceso a logica de fachada
    private PizzeriaFacade fachada = PizzeriaFacade.getInstance();
    // datos al observador
    private ObservableList<Pedido> pedidosData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // aqui cargo lista de los pedidos
        pedidosData.setAll(fachada.getPedidos());
        tablaPedidos.setItems(pedidosData);

        // crear las columnas

        colId.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue().getCliente();
            String id = (cliente != null) ? String.valueOf(cliente.getIdCliente()) : "";
            return new SimpleStringProperty(id);
        });

        colCliente.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue().getCliente();
            String nombre = (cliente != null) ? cliente.toString() : "";
            return new SimpleStringProperty(nombre);
        });

        colEstado.setCellValueFactory(cellData -> {
            EstadoPedido estado = cellData.getValue().getEstadoActual();
            return new SimpleStringProperty(estadoToString(estado));
        });

        colTotal.setCellValueFactory(cellData -> {
            double total = fachada.calcularTotal(cellData.getValue());
            String txt = "$" + String.format("%.2f", total);
            return new SimpleStringProperty(txt);
        });

        // configuracion de las acciones de los botones

        btnNuevo.setOnAction(e -> onNuevoPedido());
        btnVerEstado.setOnAction(e -> onVerEstado());
        btnSalir.setOnAction(e -> onSalir());

    }

    // traer estados
    private String estadoToString(EstadoPedido estado) {
        if (estado instanceof EstadoVacio)
            return "Sin pedido";
        if (estado instanceof EstadoRecibido)
            return "En proceso";
        if (estado instanceof EstadoPreparando)
            return "Preparando";
        if (estado instanceof EstadoHorneando)
            return "Horneando";
        if (estado instanceof EstadoTerminado)
            return "Terminado";
        if (estado instanceof EstadoEntregado)
            return "Entregado";
        return "";
    }

    // acciones boton

    private void onNuevoPedido() {
        try {
            // llamar a al venta de ordenar
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaOrdenarPizza.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnNuevo.getScene().getWindow();
            stage.setTitle("Ordenar Pizza");
            stage.setScene(new Scene(root));

        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana de Ordenar Pizza.");
            alerta.show();
        }
    }

    private void onVerEstado() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaEstado.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnVerEstado.getScene().getWindow();
            stage.setTitle("Ordenar Pizza");
            stage.setScene(new Scene(root));

        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana de estado.");
            alerta.show();
        }

    }

    private void onSalir() {
        Platform.exit();
    }

}