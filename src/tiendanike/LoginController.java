/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tiendanike;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
    @FXML
    private Button regis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private static final String ARCHIVO_DATOS = "datos.txt";
    private Map<String, String> datosUsuarios;

    public LoginController() {
        datosUsuarios = cargarDatos();
    }

    private Map<String, String> cargarDatos() {
        Map<String, String> datos = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/tiendanike/Registro.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String usuario = partes[0].trim();
                    String contrasena = partes[1].trim();
                    datos.put(usuario, contrasena);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public boolean verificarDatos(String usuario, String contrasena) {
        String contrasenaAlmacenada = datosUsuarios.get(usuario);
        return contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contrasena);
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
    private void log(ActionEvent event) throws IOException {
        String usuario = tx1.getText();
        String contrasena = tx2.getText();

        LoginController verificador = new LoginController();
        boolean datosValidos = verificador.verificarDatos(usuario, contrasena);

        if (datosValidos) {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            openwindows(currentStage);
            tx1.setText("");
            tx2.setText("");
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Datos No Válidos");
            alerta.setHeaderText("Ingrese nuevamente los datos");
            alerta.setContentText("Los datos ingresados no son válidos");
            alerta.showAndWait();
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
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
    private void registrar(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        openWindow("Register.fxml", stage);
    }
}
