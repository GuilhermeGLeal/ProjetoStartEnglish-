package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALParametrizacao;
import startenglish.db.Entidades.Parametrizacao;
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
    }

    @FXML
    private void evtApagar(ActionEvent event) {
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
    }

    @FXML
    private void evtEscolher(ActionEvent event) {
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
