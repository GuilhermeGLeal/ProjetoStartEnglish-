package startenglish;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class FXMLPrincipalController implements Initializable {
    
    private Label label;
    @FXML
    private MenuButton btCadastro;
    @FXML
    private BorderPane pnMudanca;
    
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void evtCadastro(MouseEvent event) {
        try {
            Parent aux = FXMLLoader.load(getClass().getResource("FXMLFuncionario.fxml"));
            pnMudanca.setCenter(aux);
            
        } catch (Exception e) {
            //System.out.println("Jorge");
            System.out.println(e.getMessage());
        }
        
    }
    
}
