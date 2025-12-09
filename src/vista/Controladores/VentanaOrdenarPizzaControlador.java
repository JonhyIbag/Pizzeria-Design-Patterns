package vista.Controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Cliente;
import model.Pedido;
import model.Pizza;
import model.PizzeriaFacade;


public class VentanaOrdenarPizzaControlador {

    // botones de cantidad de pizza
    @FXML private TextField txtCantidad;
    @FXML private Button btnMenos;
    @FXML private Button btnMas;

    // botones de masa
    @FXML private RadioButton rbMasaNapolitana;
    @FXML private RadioButton rbMasaRomana;
    @FXML private RadioButton rbMasaAmericana;

    // botones salsa
    @FXML private RadioButton rbSalsaTomate;
    @FXML private RadioButton rbSalsaBlanca;
    @FXML private RadioButton rbSalsaBarbacoa;

    // botones queso
    @FXML private RadioButton rbQuesoParmesano;
    @FXML private RadioButton rbQuesoMozzarella;
    @FXML private RadioButton rbQuesoCheddar;

    // botones orilla
    @FXML private RadioButton rbOrillaRellena;
    @FXML private RadioButton rbOrillaTradicional;
    @FXML private RadioButton rbOrillaCrujiente;

    // Condimentos
    @FXML private CheckBox cbOregano;
    @FXML private CheckBox cbRomero;
    @FXML private CheckBox cbAlbahaca;

    // Extras
    @FXML private CheckBox cbPepperoni;
    @FXML private CheckBox cbChampinones;
    @FXML private CheckBox cbPimientos;

    @FXML private Button btnRegresar;
    @FXML private Button btnContinuar;

    // para afrupar botones por cada tipo
    private ToggleGroup grupoMasa   = new ToggleGroup();
    private ToggleGroup grupoSalsa  = new ToggleGroup();
    private ToggleGroup grupoQueso  = new ToggleGroup();
    private ToggleGroup grupoOrilla = new ToggleGroup();
    private List<CheckBox> condimentosBoxes = new ArrayList<>();
    private List<CheckBox> extrasBoxes = new ArrayList<>();

    // Variables para ordenar pizzas
    private Cliente cliente;
    private PizzeriaFacade pizzeria;
    private Pedido pedido;

    @FXML
    public void initialize() {
        // agrupar radios
        // masa
        rbMasaNapolitana.setToggleGroup(grupoMasa);
        rbMasaRomana.setToggleGroup(grupoMasa);
        rbMasaAmericana.setToggleGroup(grupoMasa);
        // salsa
        rbSalsaTomate.setToggleGroup(grupoSalsa);
        rbSalsaBlanca.setToggleGroup(grupoSalsa);
        rbSalsaBarbacoa.setToggleGroup(grupoSalsa);
        // queso
        rbQuesoParmesano.setToggleGroup(grupoQueso);
        rbQuesoMozzarella.setToggleGroup(grupoQueso);
        rbQuesoCheddar.setToggleGroup(grupoQueso);
        // orilla
        rbOrillaRellena.setToggleGroup(grupoOrilla);
        rbOrillaTradicional.setToggleGroup(grupoOrilla);
        rbOrillaCrujiente.setToggleGroup(grupoOrilla);

        // Condimentos
        condimentosBoxes.add(cbAlbahaca);
        condimentosBoxes.add(cbOregano);
        condimentosBoxes.add(cbRomero);

        // Extras
        extrasBoxes.add(cbPepperoni);
        extrasBoxes.add(cbChampinones);
        extrasBoxes.add(cbPimientos);

        txtCantidad.setText("1");

        // Inicializar cliente
        pizzeria = PizzeriaFacade.getInstance();
        cliente = new Cliente(pizzeria.getIdCliente());
        pedido = pizzeria.crearPedido(cliente);
    }
    
    @FXML
    public void mostrar() {
    }

    @FXML
    public void incrementarCantidad(ActionEvent event) {
        int cantidad = Integer.parseInt(txtCantidad.getText());
        cantidad++;
        txtCantidad.setText(String.valueOf(cantidad));
    }

    @FXML
    public void decrementarCantidad(ActionEvent event) {
        int cantidad = Integer.parseInt(txtCantidad.getText());
        if(cantidad > 1){
            cantidad--;
        }
        txtCantidad.setText(String.valueOf(cantidad));
    }

    @FXML
    public void seleccionarMasa(String tipo) {
    }

    @FXML
    public void seleccionarSalsa(String tipo) {
    }

    @FXML
    public void seleccionarQueso(String tipo) {
    }

    @FXML
    public void seleccionarOrilla(String tipo) {
    }

    @FXML
    public void seleccionarCondimento(String condimento) {
    }

    @FXML
    public void seleccionarExtra(String extra) {
    }

    @FXML
    public void continuar(ActionEvent event) {
        try{
            String masa = leerMasa();
            String salsa = leerSalsa();
            String queso = leerQueso();
            String orilla = leerOrilla();
            List<String> tipoCondimentos = getSelectedCondimentos();
            List<String> tipoOtros = getSelectedExtras();

            pizzeria.armarPizza(pedido, masa, salsa, queso, orilla, tipoCondimentos, tipoOtros);
            if(pedido.getPizzas().size() < Integer.parseInt(txtCantidad.getText())){
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Se agrego la pizza correctamente. Por favor agregue las demas pizzas.\nPizzas agregadas: " 
                    + pedido.getPizzas().size() + "/" + Integer.parseInt(txtCantidad.getText()));
                alerta.show();
            }
            else{
                for( Pedido p : pizzeria.getPedidos()){
                    for( Pizza pizza : p.getPizzas() ){
                        System.out.println( pizza.toString() );
                        System.out.println( "---------------------" );
                        System.out.println( "Costo: $" + pizza.calcularTotal());
                    }
                    System.out.println("Total: " + pizzeria.calcularTotal(pedido));
                }

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaRevisarPedido.fxml"));
                Parent root = loader.load();
                
                Stage stage = (Stage) btnContinuar.getScene().getWindow();
                stage.setTitle("Revisar Pedido");
                stage.setScene(new Scene(root));
            }

            


        }catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana de Revisar pedido.");
            alerta.show();
        }
    }

    private String leerOrilla() {
        String orilla = grupoOrilla.getSelectedToggle() != null ? ((RadioButton) grupoOrilla.getSelectedToggle()).getText() : null;
        if(orilla == null){
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Seleccione un tipo de orilla.");
            alerta.show();
        }
        else {
            if(orilla.equals("Rellena de queso"))
                orilla = "RellenaQueso";
            System.out.println("Masa seleccionada: " + orilla);
        }
        return orilla;
    }

    private String leerQueso() {
        String queso = grupoQueso.getSelectedToggle() != null ? ((RadioButton) grupoQueso.getSelectedToggle()).getText() : null;
        if(queso == null){
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Seleccione un tipo de queso.");
            alerta.show();
        }
        else {
            System.out.println("Queso seleccionada: " + queso);
        }
        return queso;
    }

    private String leerSalsa() {
        String salsa = grupoSalsa.getSelectedToggle() != null ? ((RadioButton) grupoSalsa.getSelectedToggle()).getText() : null;
        if(salsa == null){
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Seleccione un tipo de salsa.");
            alerta.show();
        }
        else {
            System.out.println("Salsa seleccionada: " + salsa);
        }
        return salsa;
    }

    private String leerMasa() {
        String masa = grupoMasa.getSelectedToggle() != null ? ((RadioButton) grupoMasa.getSelectedToggle()).getText() : null;
        if(masa == null){
            Alert alerta = new Alert(Alert.AlertType.WARNING, "Seleccione un tipo de masa.");
            alerta.show();
        }
        else {
            System.out.println("Masa seleccionada: " + masa);
        }
        return masa;
    }

    private List<String> getSelectedExtras() {
        List<String> seleccionados = new ArrayList<>();

        for(CheckBox cb : extrasBoxes){
            if(cb.isSelected()){
                if(cb.getText().equals("Champiñones"))
                    seleccionados.add("Champinones");
                else
                    seleccionados.add(cb.getText());
                System.out.println("Extra seleccionada: " + cb.getText());
            }
        }
        return seleccionados;
    }

    private List<String> getSelectedCondimentos() {
        List<String> seleccionados = new ArrayList<>();

        for(CheckBox cb : condimentosBoxes){
            if(cb.isSelected()){
                if(cb.getText().equals("Orégano"))
                    seleccionados.add("Oregano");
                else
                    seleccionados.add(cb.getText());
                System.out.println("Condimento seleccionada: " + cb.getText());
            }
        }
        return seleccionados;
    }

    @FXML
    public void regresar(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXML/VentanaPrincipal.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) btnRegresar.getScene().getWindow();
            stage.setTitle("Pizzeria UAM");
            stage.setScene(new Scene(root));


        }catch (IOException ex) {
            ex.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al cargar la ventana Principal.");
            alerta.show();
        }
    }
}
