/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tiendanike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author neon
 */
public class VentanaSuetersController implements Initializable {

    @FXML
    private Button VPrincipal;
    @FXML
    private Button Zapatos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void VentanaPrin(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        openWindow("VentanaPrincipal.fxml", stage);
    }
    
    private void openWindow(String fxmlFileName, Stage stage) throws IOException {
        // Crear un nuevo cargador de FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        // Cargar el archivo FXML y asignarlo como la raíz de la ventana
        Parent root = loader.load();
        // Crear una nueva escena con la raíz cargada
        Scene scene = new Scene(root);
        // Establecer la nueva escena como la escena de la ventana
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void VentanaZapatos(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        openWindow("VentanaZapatos.fxml", stage);
    }
    
}
