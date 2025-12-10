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

/**
 * Controlador para la ventana de revisar pedido. Permite al usuario ver,
 * modificar o eliminar pizzas del pedido actual, así como continuar al estado del pedido.
 * @author Triplets
 */
public class VentanaRevisarPedidoControlador {

    /**
     * Componentes de la tabla de pizzas en el pedido.
     */
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

    /**
     * Etiqueta para mostrar el total general del pedido.
     */
    @FXML
    private Label lblTotalGeneral;
    
    /**
     * Botones de la interfaz.
     */
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnContinuar;

    /**
     * Instancia de la fachada de la pizzería para acceder a la lógica del negocio.
     */
    private PizzeriaFacade pizzeria;

    /**
     * Inicializa la ventana de revisar pedido, configurando la tabla y cargando los datos del pedido actual.
     * El pedido actual se obtiene como el último pedido en la lista de pedidos de la pizzería.
     */
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

    
    /**
     * Maneja el evento de regresar a la ventana de ordenar pizza.
     */
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

    /**
     * Maneja el evento de continuar a la ventana de estado del pedido.
     * Utiliza el metodo setPedido del controlador de la ventana de estado para pasar el pedido actual
     * y poder mostrar su estado.
     */
    @FXML
    private void handleContinuar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaEstado.fxml"));
            Parent root = loader.load();

            VentanaEstadoControlador controlador = loader.getController();
            controlador.setPedido(pizzeria.getPedidos().getLast());

            Stage stage = (Stage) btnContinuar.getScene().getWindow();
            stage.setTitle("Estado Pedido");
            stage.setScene(new Scene(root));

        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana de Estado pedido.");
            alerta.show();
        }
    }

    /**
     * Maneja el evento de eliminar una pizza seleccionada del pedido.
     * Muestra una alerta de confirmación antes de eliminar la pizza.
     * Si no hay ninguna pizza seleccionada, muestra una alerta de advertencia.
     */
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

    /**
     * Maneja el evento de modificar una pizza seleccionada del pedido.
     * Navega de vuelta a la ventana de ordenar pizza para permitir la modificación.
     * Si ocurre un error al cargar la ventana, muestra una alerta de error.
     */
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
