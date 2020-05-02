/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import startenglish.db.util.Banco;


/**
 *
 * @author guilh
 */
public class StartEnglish extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLParametrizacao.fxml"));
        
        Scene scene = new Scene(root);
      
        
        stage.setScene(scene);
      
        //stage.setMaximized(true);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        if(Banco.conectar()){
            launch(args);
        }
        else{
             JOptionPane.showMessageDialog(null, "Erro: "+Banco.getCon().getMensagemErro());
        }
        
    }
    
}
