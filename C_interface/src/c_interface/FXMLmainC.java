package c_interface;

import auxiliares.Lista_D_E_C;
import auxiliares.Nodo_D_E_C;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private Button AddFile;
    @FXML
    private Button intento_B;
    @FXML
    private TextField t_f;
    @FXML
    private TabPane __tabs = new TabPane();
    @FXML
    private Button serch_tipe;
    
    @FXML
    private ComboBox<String> Ordenamiento;
    @FXML
    private Button abrir_B;
    @FXML
    private Label lable_mesage;
    @FXML
    private Button Delete_F;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Ordenamiento.getItems().add("Nombre");
         Ordenamiento.getItems().add("Creacion");
         Ordenamiento.getItems().add("Palabras");
    }   
    
    @FXML
    private void change_s_t(ActionEvent event) {
        if(this.modo_b){serch_tipe.setText("Palabras");
        }else{serch_tipe.setText("Frace");}
        this.modo_b = !(this.modo_b);
    }
    
    @FXML
    void AddNewFile(ActionEvent event) throws IOException {
        String d = FileSearcher.FindFile();
        String x = this.__c.send(d + "PATH");
        this.__tabs.getTabs().clear();
        cargaI(x);
    }
    @FXML
    void MultipleFile(ActionEvent event) {
      String Find_Multiple= FileSearcher.FindMultiple();
      String x = this.__c.send(Find_Multiple);
      this.__tabs.getTabs().clear();
      cargaI(x);
      
      

    }
        
    @FXML
    private void bBb(ActionEvent event) {
        if(this.t_f.getText().equals("")){lable_mesage.setText("   _                  _\n      \\ _(???_???)_ /");}
        else{lable_mesage.setText("");}
        if(this.modo_b){
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
    @FXML
    public void OrdenamientoArchivos(ActionEvent event) {
        String y = Ordenamiento.getSelectionModel().getSelectedItem();
        String x = this.__c.send(y);
        lable_mesage.setText(y);
        this.__tabs.getTabs().clear();
        cargaI(x);
    }
    
    @FXML
    public void abrir(ActionEvent event) {
       
       Tab i = __tabs.getSelectionModel().getSelectedItem();
       String nombre=i.getText();
       System.out.println(nombre);
       this.__c.send("ruta@" +nombre);       
    }
    
    @FXML
    void DeleteFile(ActionEvent event) {
       Tab i = __tabs.getSelectionModel().getSelectedItem();
       String nombre = i.getText();
       this.__c.send("ruta2@" + nombre);
    }
}
