package c_interface;

import aux.Lista_D_E_C;
import aux.Nodo_D_E_C;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    Lista_D_E_C __lis = new Lista_D_E_C();
    C_interface __a = new C_interface();
    
    @FXML
    private Button LoadTxt;
    @FXML
    private Button intento_B;
    @FXML
    private TextField t_f;
    @FXML
    private TabPane __tab;


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
        String temp=__a.send(d);
        Nodo_D_E_C actual = this.__lis.getHead();
        while(this.__lis.getHead()!=null && actual.get_N()!=this.__lis.getHead()){
            add_tap(d);
            configtab(actual,temp);
            actual = actual.get_N();
        }
        
    }
    
    @FXML
    private void ltxt(ActionEvent event) {
        String d = "FILECHOOSER";
        this.__a.send(d);
    }
    
    private void add_tap(String a){
        Tab __tabN = new Tab();
        __tabN.setText(a);
        __tab.getTabs().add(__tabN);
        HTMLEditor ed = new HTMLEditor();
        __tabN.setContent(ed);
        Nodo_D_E_C nodo = new Nodo_D_E_C("fghj",__tabN);
        this.__lis.add_n_first(nodo);
    }
    
    private void configtab(Nodo_D_E_C n, String i){
        try{
            Tab a = (Tab) n.getData();
            a.setText(i.split("@@@")[0]);
            HTMLEditor htmle = (HTMLEditor) a.getContent();
            htmle.setHtmlText(i.split("@@@")[1]);
        }catch(Exception e){
            Alert Aa = new Alert(Alert.AlertType.ERROR);
            Aa.setHeaderText(null);
            Aa.setTitle("Error");
            Aa.setContentText("hubo un error cargando el texto");
            Aa.showAndWait();
            System.out.println(e);
        }
    }
}
