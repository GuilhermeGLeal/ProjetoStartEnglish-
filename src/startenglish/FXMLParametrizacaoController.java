package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import startenglish.db.DAL.DALEndereco;
import startenglish.db.DAL.DALParametrizacao;
import startenglish.db.Entidades.Endereco;
import startenglish.db.Entidades.Parametrizacao;
import startenglish.db.util.Banco;
import startenglish.util.MaskFieldUtil;


public class FXMLParametrizacaoController implements Initializable {

    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXButton btEscolheArquivo;
    @FXML
    private JFXButton btLimparFoto;
    @FXML
    private JFXTextField txTelefone;
    @FXML
    private JFXTextField txRazao;
    @FXML
    private JFXTextField txEmail;
    @FXML
    private JFXTextField txIDendereco;
    @FXML
    private JFXTextField txRua;
    @FXML
    private JFXTextField txCEP;
    @FXML
    private JFXTextField txBairro;
    @FXML
    private JFXTextField txNumero;
    @FXML
    private JFXTextField txCidade;
    @FXML
    private TableView<Parametrizacao> tabela;
    @FXML
    private TableColumn<Parametrizacao, String> coluaNome;
    @FXML
    private TableColumn<Parametrizacao, String> colunaRazaoSocial;
    @FXML
    private TableColumn<Parametrizacao, String> ColunaTelefone;
    @FXML
    private AnchorPane pndados;
    @FXML
    private ImageView img;

    private File arq;
    private boolean flag;
    private Image aux;
    private Parametrizacao atualizando;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        coluaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaRazaoSocial.setCellValueFactory(new PropertyValueFactory("RazaoSocial"));
        ColunaTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        
        MaskFieldUtil.maxField(txNome, 30);
        MaskFieldUtil.foneField(txTelefone);
        MaskFieldUtil.maxField(txRazao, 20);
        MaskFieldUtil.maxField(txEmail, 20);
        MaskFieldUtil.maxField(txRua, 20);
        MaskFieldUtil.cepField(txCEP);
        MaskFieldUtil.maxField(txBairro, 30);
        MaskFieldUtil.numericField(txNumero);
        MaskFieldUtil.maxField(txCidade, 20);
        
        estadoOriginal();
    }    

    private void carregarTabela(String filtro){
     
        DALParametrizacao dalpar = new DALParametrizacao();
        Parametrizacao para = new Parametrizacao();
        para = dalpar.get();
        tabela.setItems((ObservableList<Parametrizacao>) para);
    }
    
    private void estadoOriginal(){
               
        flag = false;
        pndados.setDisable(true);
        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        btApagar.setDisable(true);
        btAlterar.setDisable(true);
        btNovo.setDisable(false);
        txNumero.setDisable(true);
        
        ObservableList <Node> componentes=pndados.getChildren(); 
        for(Node n : componentes)
        {
            if (n instanceof TextInputControl)  
                ((TextInputControl)n).setText("");
            if(n instanceof ComboBox)
                ((ComboBox)n).getItems().clear();
        }
    }
    
    private void estadoedicao(){
        
        pndados.setDisable(false);
        btConfirmar.setDisable(false);
        btApagar.setDisable(true);
        btAlterar.setDisable(true);
        txNome.requestFocus();
         
    }
    
    @FXML
    private void evtNovo(ActionEvent event) {
        
          estadoedicao();    
    }

    @FXML
    private void evtAlterar(ActionEvent event) {
               
        if(tabela.getSelectionModel().getSelectedItem() != null){
            
             DALParametrizacao dalpar = new DALParametrizacao();
             DALEndereco dale = new DALEndereco();
             Parametrizacao p;
             Endereco e;
             
             p = tabela.getSelectionModel().getSelectedItem();
             atualizando = p;
             
             txNome.setText(p.getNome());
             txTelefone.setText(p.getTelefone());
             txRazao.setText(p.getRazaoSocial());
             txEmail.setText(p.getEmail());
             
             e = dale.get(p.getEndereco().getEnderecoID());
             
             txIDendereco.setText(""+e.getEnderecoID());
             if(!e.getRua().isEmpty())
                  txRua.setText(e.getRua());
             txCEP.setText(e.getCEP());
             
            if(!e.getBairro().isEmpty())
                txBairro.setText(e.getBairro());
            if(e.getNumero() != 0)
                txNumero.setText(""+e.getNumero());
            if(!e.getCidade().isEmpty())
                txCidade.setText(e.getCidade());
               
            InputStream in;  
            in = dalpar.getFoto(p.getNome());
            
            if(in != null){
                
                BufferedImage bimagem;
                try 
                {           
                    bimagem = ImageIO.read(in);
                    img.setImage(SwingFXUtils.toFXImage(bimagem, null));
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(FXMLParametrizacaoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
               estadoedicao();
             
        }
    }

    @FXML
    private void evtApagar(ActionEvent event) {
        
        boolean ok = true;
          Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Confirmar exclusão?", ButtonType.YES,ButtonType.NO),b;
          
          if(a.showAndWait().get() == ButtonType.YES){
              
              DALParametrizacao dalpar = new DALParametrizacao();
              DALEndereco dale = new DALEndereco();
              Parametrizacao p;
              
              p = tabela.getSelectionModel().getSelectedItem();
              
              try{
                  
                   Banco.getCon().getConnect().setAutoCommit(false);
                   
                   ok = dalpar.apagar(p);
                   
                    if(ok){

                       ok = dale.apagar(p.getEndereco().getEnderecoID());
                                   
                    }
                    else
                       ok = false;
              }
              catch(SQLException ex){System.out.println(ex.getMessage()); ok = false;}
                    
             try{
                 
                 if(ok){
                 
                   b = new Alert(Alert.AlertType.CONFIRMATION,"Parametrizacao Excluído!!", ButtonType.OK);
                   b.showAndWait();
                   Banco.getCon().getConnect().commit();
                } 
                else{
                     
                    b = new Alert(Alert.AlertType.CONFIRMATION,"Problemas ao deletar a parametrizacao, verificar no banco!!", ButtonType.OK);
                    b.showAndWait();
                    Banco.getCon().getConnect().rollback();
                }
             }
             catch(SQLException ex){}
             
               carregarTabela("");
          }
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
        
        if (!pndados.isDisabled())
        {
            img.setImage(null);
            estadoOriginal();
        } 
    }

    @FXML
    private void evtEscolher(ActionEvent event) {
        
         FileChooser fs = new FileChooser();
        arq = fs.showOpenDialog(null);
        
        if(arq != null){
            
            flag = true;
            aux=new Image(arq.toURI().toString());
            img.setImage(aux);
            img.setFitWidth(aux.getWidth());
            img.setFitHeight(aux.getHeight());
        }
    
    }

    @FXML
    private void evtLimpar(ActionEvent event) {
        
        img.setImage(null);
    }

    @FXML
    private void clickTabela(MouseEvent event) {
        
          if(tabela.getSelectionModel().getSelectedIndex()>=0){
            
            btAlterar.setDisable(false);
            btApagar.setDisable(false);
        }
    }
    
}
