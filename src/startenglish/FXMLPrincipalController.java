package startenglish;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import startenglish.db.DAL.DALParametrizacao;
import startenglish.db.Entidades.Parametrizacao;


public class FXMLPrincipalController implements Initializable {
    
    public static BorderPane snprincpial = null;
    public static Label nome = null;
    

    @FXML
    private BorderPane pnMudanca;
    @FXML
    private ImageView imglogo;
    @FXML
    private Label labelNome;
    
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        verificaParametrizacao();
       
        snprincpial = pnMudanca;
        nome = labelNome;
        
    }    
   
    private void verificaParametrizacao(){
        
        DALParametrizacao dalp = new DALParametrizacao();
        
        if(dalp.get() == null){
            JOptionPane.showMessageDialog(null,"Dados da empresa estão vazios! Necessita-se preenche-los");
            evtParametriz(null);
        }
        else
             chamaimagem();
         
    }
    
    private void chamaimagem(){
        
        DALParametrizacao dalp = new DALParametrizacao();
        Parametrizacao p;
        p = dalp.get();
        
        InputStream in;  
        in = dalp.getFoto(p.getNome());
            
            if(in != null){
                
                BufferedImage bimagem;
                try 
                {           
                    bimagem = ImageIO.read(in);
                    imglogo.setImage(SwingFXUtils.toFXImage(bimagem, null));
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(FXMLParametrizacaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    

    @FXML
    private void evtParametriz(ActionEvent event) {
        
        try {
            Parent aux = FXMLLoader.load(getClass().getResource("view/FXMLParametrizacao.fxml"));
            pnMudanca.setRight(aux);
            labelNome.setText("Gerenciamento da Parametrização");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
       
    }

    @FXML
    private void evtCurso(ActionEvent event) {
        
         try {
            Parent aux = FXMLLoader.load(getClass().getResource("view/FXMLCurso.fxml"));
            pnMudanca.setRight(aux);
            labelNome.setText("Gerenciamento dos Cursos");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void evtFunc(ActionEvent event) {
        
         try {
            Parent aux = FXMLLoader.load(getClass().getResource("FXMLFuncionario.fxml"));
            pnMudanca.setRight(aux);
            labelNome.setText("Gerenciamento dos Funcionários");
            
        } catch (Exception e) {
          
        }
    }
    
}
