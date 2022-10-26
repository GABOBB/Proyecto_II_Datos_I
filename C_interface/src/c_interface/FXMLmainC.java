package c_interface;

import auxiliares.Lista_D_E_C;
import auxiliares.Nodo_D_E_C;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class FXMLmainC implements Initializable {
    C_interface __c = new C_interface();
    boolean modo_b;
    
    @FXML
    private Button LoadTxt;
    @FXML
    private Button intento_B;
    @FXML
    private TextField t_f;
    @FXML
    private TabPane __tabs = new TabPane();
    @FXML
    private ComboBox Op_busqueda;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Op_busqueda.getItems().addAll("Frace","Palabras");
        
        Op_busqueda.setOnAction(event ->{
        if("Frace".equals(Op_busqueda.getSelectionModel().getSelectedItem().toString())){
            this.modo_b=true;
        }else if("Palabras".equals(Op_busqueda.getSelectionModel().getSelectedItem().toString())){
            this.modo_b=false;}});  
    }    
    
    @FXML
    private void ltxt(ActionEvent event) {
        String d = "FILECHOOSER";
        String html = this.__c.send(d);
        this.__tabs.getTabs().clear();
        cargaI(html);
    }
        
    @FXML
    private void bBb(ActionEvent event) {
        if(this.modo_b==true){
        String d = this.t_f.getText();
        String html_text = __c.send("F@@@"+d);
        this.__tabs.getTabs().clear();
        cargaI(html_text);
        }else{
        String d = this.t_f.getText();
        String html_text = __c.send("P@@@"+d);
        this.__tabs.getTabs().clear();
        cargaI(html_text);
        }
    }
    
    public void cargaI(String all_html){
        String[] temp=(all_html.split("-_-"));
        for (String temp1 : temp) {
            
            String aux1 = temp1.split("@@@")[0];
            String aux2 = temp1.split("@@@")[1];
            
            Tab __tabNew = new Tab(aux1);
            HTMLEditor ed = new HTMLEditor();
            
            ed.setHtmlText(aux2);
            __tabNew.setContent(ed);
            
            this.__tabs.getTabs().add(__tabNew);
        }
    }

}
