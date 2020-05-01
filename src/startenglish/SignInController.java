/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author azeve
 */
public class SignInController implements Initializable {

    @FXML
    private JFXButton btLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void evtLogin(MouseEvent event) {
        
        try {
            Parent aux = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
            FXMLLoginController.APLogin.getChildren().removeAll();
            FXMLLoginController.APLogin.getChildren().setAll(aux);
            
        } catch (Exception e) {
            //System.out.println("Jorge");
            System.out.println(e.getMessage());
        }
    }
    
}
