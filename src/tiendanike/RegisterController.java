package tiendanike;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class RegisterController implements Initializable {

    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private Button regis;

    private static final String FILE_NAME = "src/tiendanike/Registro.txt";
    @FXML
    private Button CANCELAR;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void guardarregistro(ActionEvent event) {
        String campo1 = t1.getText();
        String campo2 = t2.getText();

        if (!registroExiste(campo1, campo2)) {
            guardarEnArchivo(campo1, campo2);
            mostrarMensaje("Registro guardado correctamente.");
        } else {
            mostrarError("El registro ya existe.");
        }
    }

    @FXML
    private void Cance(ActionEvent event) throws IOException{
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        openWindow("Login.fxml", stage);
    }

    private boolean registroExiste(String campo1, String campo2) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] campos = line.split(","); // Suponiendo que los campos están separados por coma (puedes ajustarlo según tu estructura)
                if (campos.length >= 2 && campos[0].equals(campo1) && campos[1].equals(campo2)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void guardarEnArchivo(String campo1, String campo2) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            writer.println(); // Agrega un salto de línea después de cada registro
            writer.println(campo1 + "," + campo2); // Se asume el mismo formato de separación por coma
            t1.setText("");
            t2.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
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
}
