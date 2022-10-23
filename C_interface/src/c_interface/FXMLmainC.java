package c_interface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class FXMLmainC implements Initializable {
    
    @FXML
    private Button LoadTxt;

    @FXML
    private Button intento_B;
    @FXML
    private TextField t_f;
    C_interface a = new C_interface();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bBb(ActionEvent event) {
        String d = t_f.getText();
        a.send(d);
    }
    
    @FXML
    void ltxt(ActionEvent event) {
        String d = "FILECHOOSER";
        a.send(d);
    }
}
