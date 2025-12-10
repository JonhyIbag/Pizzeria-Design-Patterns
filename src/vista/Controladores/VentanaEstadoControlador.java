package vista.Controladores;

import java.io.IOException;
import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 * VentanaEstadoControlador es el controlador de la ventana que muestra el
 * estado de un pedido en tiempo real.
 * Implementa el patrón Observador para actualizar la interfaz cuando el estado
 * del pedido cambia.
 * 
 * Para su funcionamiento, debe recibir un objeto Pedido y registrarse como
 * observador del mismo. Dicho objeto pedido lo obtiene gracias al metodo setEstado.
 * @author Triplets
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
import model.abst.Observador;

public class VentanaEstadoControlador implements Observador{

    @FXML private Label lblIdPedido;
    @FXML private Label lblCliente;

    /**
     * Puntos
     */
    @FXML private Label puntoRecibido;
    @FXML private Label puntoPreparando;
    @FXML private Label puntoHorneando;
    @FXML private Label puntoTerminado;
    @FXML private Label puntoEntregado;

    /**
     * Lineas entre puntos
     */
    @FXML private Label linea1;
    @FXML private Label linea2;
    @FXML private Label linea3;
    @FXML private Label linea4;

    
    /**
     * Boton para salir de la ventana de estado
     */
    @FXML private Button btnSalir;

    /** 
     * Estilos para puntos y líneas
     */
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

    /**
     * Pedido cuyo estado se está monitoreando
     */
    private Pedido pedido;

    @FXML
    public void initialize() {
    }

    /**
     * Configura los estilos de los puntos y líneas según el estado actual del pedido.
     * @param puntos Array de etiquetas que representan los puntos de estado
     * @param lineas Array de etiquetas que representan las líneas entre los puntos
     * @param estadoActual El estado actual del pedido
     */
    private void setLineas(Label[] puntos, Label[] lineas, String estadoActual) {
        int tam = 0;
        if(estadoActual.equals("Vacio"))
            tam=-1;
        else if(estadoActual.equals("Recibido"))
            tam=0;
        else if(estadoActual.equals("Preparando"))
            tam=1;
        else if(estadoActual.equals("Horneando"))
            tam=2;
        else if(estadoActual.equals("Terminado"))
            tam=3;
        else if(estadoActual.equals("Entregado"))
            tam=4;

        for (int i=0; i<tam; i++) {
            if (puntos[i] != null) puntos[i].setStyle(PUNTO_ACTIVO);
            if(lineas[i]!=null && i<lineas.length) lineas[i].setStyle(LINEA_ACTIVA);
        }

        for (int i=tam; i<puntos.length; i++) {
            if (puntos[i] != null) puntos[i].setStyle(PUNTO_INACTIVO);
            if(i<lineas.length){
                if(lineas[i]!=null)
                    lineas[i].setStyle(LINEA_INACTIVA); 
            }
        }
    }

    /**
     * Inicia la simulación del cambio de estado del pedido en intervalos de tiempo. Esto lo hace con ayuda de un hilo separado.
     * Esto permite que el hilo principal se encargue de la interfaz gráfica y la actualización en tiempo real del estado del pedido. 
     * Mientras tanto, el hilo secundario simula el progreso del pedido cambiando su estado en intervalos de tiempo predefinidos. 
     * Gracias al patron observer y state implementados en el modelo, cada vez que el estado del pedido cambia,
     * se notifica automáticamente a este controlador, que actualiza la interfaz gráfica en consecuencia.
     * 
     * @param pedido
     */
    private void iniciarSimulacion(Pedido pedido) {
        Task<Void> tarea = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                Thread.sleep(10000); 
                Platform.runLater(() -> pedido.recibirPedido());

                Thread.sleep(30000); 
                Platform.runLater(() -> pedido.prepararPedido());

                Thread.sleep(30000); 
                Platform.runLater(() -> pedido.cocinarPedido());

                Thread.sleep(20000);
                Platform.runLater(() -> pedido.empaquetarPedido());

                Thread.sleep(20000);
                Platform.runLater(() -> pedido.entregarPedido());

                return null;
            }
        };

        Thread hilo = new Thread(tarea);
        hilo.setDaemon(true);
        hilo.start();
    }

    /**
     * Maneja la acción del botón salir, regresando a la ventana principal.
     */
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

    /**
     * Actualiza la interfaz gráfica cuando el estado del pedido cambia.
     * Dependiendo del mensaje recibido, actualiza los puntos y líneas correspondientes.
     * 
     * @param mensaje El nuevo estado del pedido
     */
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

    /**
     * Establece el pedido cuyo estado se va a monitorear y actualiza la interfaz gráfica en consecuencia.
     * Este metodo es llamado desde la ventana principal al abrir la ventana de estado, o 
     * desde la ventana de confirmar pedido al finalizar un nuevo pedido.
     * @param pedido
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        actualizarPedido();
    }

    /**
     * Actualiza la interfaz gráfica para reflejar el estado actual del pedido.
     * Si el pedido está en estado "Recibido", inicia la simulación del cambio de estado.
     * Si el pedido ya se encuentra en algun otro estado no se inicia la simulacion para evitar 
     * la creacion de hilos innecesarios.
     */
    public void actualizarPedido(){
        Label[] puntos = {
                puntoRecibido,
                puntoPreparando,
                puntoHorneando,
                puntoTerminado,
                puntoEntregado
        };

        Label[] lineas = { linea1, linea2, linea3, linea4 };
        setLineas(puntos, lineas, pedido.estadoActual.getEstadoNombre());

        pedido.registerObservers(this);

        if(pedido.estadoActual.getEstadoNombre().equals("Recibido"))
            iniciarSimulacion(pedido);
    }
}

