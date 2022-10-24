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
    C_interface __c = new C_interface();
    
    @FXML
    private Button LoadTxt;
    @FXML
    private Button intento_B;
    @FXML
    private TextField t_f;
    @FXML
    private TabPane __tabs = new TabPane();


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void cargaI(String all_html){
        //System.out.println(all_html);
        String[] temp=(all_html.split("-_-"));
        for(int i=0;i<temp.length;i++){//System.out.println(temp[i]+"[1]");System.out.println(aux1+"[2]");System.out.println(aux2+"[3]");
            
            String aux1 = temp[i].split("@@@")[0];
            String aux2 = temp[i].split("@@@")[1];
            
            Tab __tabNew = new Tab(aux1);
            HTMLEditor ed = new HTMLEditor();
            ed.setHtmlText(aux2);
            __tabNew.setContent(ed);
            __tabs.getTabs().add(__tabNew);
            //Nodo_D_E_C nodo = new Nodo_D_E_C(aux1,__tabNew);
            //this.__lis.add_n_first(nodo);
            System.out.println("y ahora esto porque no funca");
            
        }
    }
    
    @FXML
    private void bBb(ActionEvent event) {
        String d = this.t_f.getText();
        String[] temp=(this.__c.send(d)).split("|");
        for(String t : temp){
            String aux1 = t.split("@@@")[0];
            String aux2 = t.split("@@@")[1];
            Nodo_D_E_C nodo = add_tap(aux1);
            configtab(nodo,t);
        }
    }
    
    @FXML
    private void ltxt(ActionEvent event) {
        String d = "FILECHOOSER";
        this.__c.send(d);
    }
    
    private Nodo_D_E_C add_tap(String a){
        Tab __tabN = new Tab();
        __tabN.setText(a);
        HTMLEditor ed = new HTMLEditor();
        __tabN.setContent(ed);
        this.__tabs.getTabs().add(__tabN);
        Nodo_D_E_C nodo = new Nodo_D_E_C(a,__tabN);
        this.__lis.add_n_first(nodo);
        return nodo;
    }
    
    private void configtab(Nodo_D_E_C n, String i){
        try{
            Tab a = (Tab) n.getData();
            //a.setText(i.split("@@@")[0]);
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
