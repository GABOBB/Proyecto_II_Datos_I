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
    
    @FXML
    private void ltxt(ActionEvent event) {
        String d = "FILECHOOSER";
        String html = this.__c.send(d);
        configtab(html);
    }
    
    public void cargaI(String all_html){
        //System.out.println(all_html);
        String[] temp=(all_html.split("-_-"));
        for(int i=0;i<temp.length;i++){
            
            String aux1 = temp[i].split("@@@")[0];
            String aux2 = temp[i].split("@@@")[1];
            
            Tab __tabNew = new Tab(aux1);
            HTMLEditor ed = new HTMLEditor();
            ed.setHtmlText(aux2);
            
            __tabNew.setContent(ed);
            this.__tabs.getTabs().add(__tabNew);
            Nodo_D_E_C nodo = new Nodo_D_E_C(aux1,__tabNew);
            this.__lis.add_n_last(nodo); 
        }
    }
    
    @FXML
    private void bBb(ActionEvent event) {
        String d = this.t_f.getText();
        String html_text = __c.send(d);
        configtab(html_text);
    }
    
    private void configtab(String i){
        String[] temp = i.split("-_-");
        System.out.println("--"+temp.length);
        Nodo_D_E_C nodo = this.__lis.getHead();
        for(int j=0;j<temp.length;j++){
            
            String aux1 = temp[j].split("@@@")[0];
            String aux2 = temp[j].split("@@@")[1];
            try{
                if(nodo!=null){
                    Tab _tab_ = (Tab) nodo.getData();
                    _tab_.setText(aux1);
                    HTMLEditor ed = new HTMLEditor();
                    ed.setHtmlText(aux2);
                    _tab_.setContent(ed);
                    nodo = nodo.get_N();
                }else{
                    Tab new_tab = new Tab(aux1);
                    HTMLEditor ed = new HTMLEditor();
                    ed.setHtmlText(aux2);

                    new_tab.setContent(ed);
                    this.__tabs.getTabs().add(new_tab);
                    Nodo_D_E_C new_nodo = new Nodo_D_E_C(aux1,new_tab);
                    this.__lis.add_n_first(new_nodo);
                }
            }catch(Exception e){System.err.println(e);}
        }
    }
}
