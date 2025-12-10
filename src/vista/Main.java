package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal para iniciar la aplicación de la pizzería.
 * 
 * @author Triplets
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/vista/FXML/VentanaPrincipal.fxml"));
        
        Scene scene = new Scene (root);
        stage.setTitle("Pizzeria UAM");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main ( String[] args){
        launch(args);
    }
    
}
