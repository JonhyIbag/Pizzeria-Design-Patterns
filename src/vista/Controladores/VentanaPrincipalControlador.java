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
import model.Cliente;
import model.Pedido;
import model.PizzeriaFacade;
import model.abst.EstadoPedido;
import model.estadoPedido.*;


/**
 * Controlador para la ventana principal de la aplicacion de pizzeria. Muestra una lista de pedidos y permite al usuario crear nuevos pedidos,
 * ver el estado de los pedidos existentes y salir de la aplicacion.
 * Los pedidos se muestran en una tabla con columnas para el ID del cliente, el nombre del cliente, el estado del pedido y el total del pedido.
 * @author Triplets
 */
public class VentanaPrincipalControlador {

    /**
     * Configuracion de la tabla
    */
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

    /**
     * solo botones
    */
    @FXML
    public Button btnNuevo;
    @FXML
    public Button btnActualizar;
    @FXML
    public Button btnVerEstado;
    @FXML
    public Button btnSalir;

    /** 
     * fachada de pizzeria
    */
    private PizzeriaFacade fachada = PizzeriaFacade.getInstance();
    /** 
     * lista observable de pedidos
    */
    private ObservableList<Pedido> pedidosData = FXCollections.observableArrayList();

    /**
     * Inicializa el controlador de la ventana principal. Configura la tabla de pedidos y los botones.
     */
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

    /**
     * Convierte el estado del pedido a una representacion de cadena legible.
     * @param estado
     * @return String representacion del estado
     */
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

    /**
     * Maneja la accion de crear un nuevo pedido. Abre la ventana de ordenar pizza.
     */
    private void onNuevoPedido() {
        try {
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

    /**
     * Maneja la accion de ver el estado del pedido seleccionado. Abre la ventana de estado del pedido.
     * Para poder abrir la ventana, se debe seleccionar un pedido en la tabla, el cual se pasa a la nueva ventana para mostrar su estado.
     * Si no se selecciona ningun pedido, se muestra una alerta al usuario.
     */
    private void onVerEstado() {
        try {
            Pedido pedidoSeleccionado = tablaPedidos.getSelectionModel().getSelectedItem();
            if(pedidoSeleccionado == null){
                Alert alerta = new Alert(Alert.AlertType.WARNING, "Por favor, seleccione un pedido para ver su estado.");
                alerta.show();
                return;
            }
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaEstado.fxml"));
            Parent root = loader.load();

            VentanaEstadoControlador controlador = loader.getController();
            controlador.setPedido(pedidoSeleccionado);

            Stage stage = (Stage) btnVerEstado.getScene().getWindow();
            stage.setTitle("Ordenar Pizza");
            stage.setScene(new Scene(root));

        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana de estado.");
            alerta.show();
        }

    }

    /**
     * Maneja la accion de salir de la aplicacion.
     */
    private void onSalir() {
        Platform.exit();
    }

}