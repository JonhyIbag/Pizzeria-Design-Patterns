package vista.Controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Pedido;
import model.Pizza;
import model.PizzeriaFacade;

public class VentanaRevisarPedidoControlador {

    @FXML
    private TableView<Pizza> tablaLineas;
    @FXML
    private TableColumn<Pizza, String> colMasa;
    @FXML
    private TableColumn<Pizza, String> colSalsa;
    @FXML
    private TableColumn<Pizza, String> colOrilla;
    @FXML
    private TableColumn<Pizza, String> colQueso;
    @FXML
    private TableColumn<Pizza, String> colCondimentos;
    @FXML
    private TableColumn<Pizza, String> colExtras;
    @FXML
    private TableColumn<Pizza, String> colPrecio;

    @FXML
    private Label lblTotalGeneral;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnContinuar;

    private PizzeriaFacade pizzeria;

    @FXML
    public void initialize() {
        // Inicializar la tabla y las columnas aquí
        pizzeria = PizzeriaFacade.getInstance();
        Pedido pedido = pizzeria.getPedidos().getLast();

        colMasa.setCellValueFactory(new PropertyValueFactory<>("masa"));
        colSalsa.setCellValueFactory(new PropertyValueFactory<>("salsa"));
        colOrilla.setCellValueFactory(new PropertyValueFactory<>("orilla"));
        colQueso.setCellValueFactory(new PropertyValueFactory<>("queso"));
        colCondimentos.setCellValueFactory(new PropertyValueFactory<>("condimentos"));
        colExtras.setCellValueFactory(new PropertyValueFactory<>("otros"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaLineas.getItems().setAll(pedido.getPizzas());

        lblTotalGeneral.setText(String.format("Total: $%.2f", pizzeria.calcularTotal(pedido)));
    }

    @FXML
    private void handleRegresar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaOrdenarPizza.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnRegresar.getScene().getWindow();
            stage.setTitle("Ordenar Pizza");
            stage.setScene(new Scene(root));

        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana Ordenar.");
            alerta.show();
        }
    }

    @FXML
    private void handleContinuar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaEstado.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnContinuar.getScene().getWindow();
            stage.setTitle("Estado Pedido");
            stage.setScene(new Scene(root));

        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana de Estado pedido.");
            alerta.show();
        }
    }

    @FXML
    private void handleEliminar() {
        Pizza pizzaSeleccionada = tablaLineas.getSelectionModel().getSelectedItem();
        if (pizzaSeleccionada == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Por favor, seleccione una pizza para eliminar.");
            alerta.show();
            return;
        }
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION,
                "¿Seguro que quieres eliminar este pedido?",
                ButtonType.YES, ButtonType.NO);

        confirmacion.showAndWait();
        if(confirmacion.getResult() == ButtonType.YES){
            Pedido pedido = pizzeria.getPedidos().getLast();
            pedido.getPizzas().remove(pizzaSeleccionada);
            tablaLineas.getItems().remove(pizzaSeleccionada);
            lblTotalGeneral.setText(String.format("Total: $%.2f", pizzeria.calcularTotal(pedido)));
        }
    }

    @FXML
    private void handleModificar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaOrdenarPizza.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnRegresar.getScene().getWindow();
            stage.setTitle("Ordenar Pizza");
            stage.setScene(new Scene(root));

        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana Ordenar.");
            alerta.show();
        }
    }
}
