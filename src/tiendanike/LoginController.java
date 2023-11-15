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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author neon
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tx1;
    @FXML
    private TextField tx2;
    @FXML
    private Button ent;
    @FXML
    private Button sal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void openwindows(Stage previousStage) throws IOException {

        Stage newStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaPrincipal.fxml"));
        Parent root = loader.load();

        FXMLDocumentController controller = loader.getController();

        Scene scene = new Scene(root);

        newStage.setScene(scene);

        // Cierra el Stage anterior
        previousStage.close();

        // Muestra el nuevo Stage
        newStage.show();
    }

    @FXML
    private void log(ActionEvent event) throws IOException{
        if (tx1.getText().equalsIgnoreCase("NIKE") && tx2.getText().equals("1964")) {
            // Crear una nueva ventana e invocar el método openVentanaTabla
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Obten la referencia al Stage actual
            openwindows(currentStage);
            tx1.setText("");
            tx1.setText("");
        } else if ((tx1.getText() == null ? ("NIKE") != null : !tx1.getText().equalsIgnoreCase("Cooperativa")) && tx1.getText() != ("1964")) {
            // Mostrar un cuadro de diálogo de alerta si los datos de inicio de sesión son incorrectos
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Datos No Validos");
            alerta.setHeaderText("Ingrese nuevamente los datos");
            alerta.setContentText("Los datos ingresados no son validos");
            alerta.showAndWait();
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
}
