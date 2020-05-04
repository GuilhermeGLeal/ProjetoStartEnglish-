package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALAluno;
import startenglish.db.DAL.DALLivro;
import startenglish.db.Entidades.Aluno;
import startenglish.db.Entidades.Livro;

public class FXMLAlunoController implements Initializable {

    @FXML
    private TableView<Aluno> tabela;
    @FXML
    private TableColumn<Aluno,String> tabelaNome;
    @FXML
    private TableColumn<Aluno,String> tabelaCPF;
    @FXML
    private TableColumn<Aluno,String> tabelaTelefone;
    @FXML
    private TableColumn<Aluno,String> tabelaEmail;
    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txTelefone;
    @FXML
    private JFXTextField txEmail;
    @FXML
    private JFXTextField txRg;
    @FXML
    private JFXTextField txCpf;
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
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXTextField txIDEnd;
    @FXML
    private JFXTextField txID;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private AnchorPane pndados;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    private void EstadoOriginal()
    {        
        btNovo.setDisable(false);
        btAlterar.setDisable(true);
        btExcluir.setDisable(true);
        btCancelar.setDisable(false);
        btConfirmar.setDisable(true);
        txPesquisa.clear();
        pndados.setDisable(true);
        ObservableList <Node> componentes=pndados.getChildren(); //”limpa” os componentes
        for(Node n : componentes)
        {
            if (n instanceof TextInputControl)  // textfield, textarea e htmleditor
                ((TextInputControl)n).setText("");
            if(n instanceof ComboBox)
                ((ComboBox)n).getItems().clear();
        }
      
        CarregaTabela("");
    }
    private void EstadoEdicao()
    {
        pndados.setDisable(false);
        btConfirmar.setDisable(false);
        btExcluir.setDisable(true);
        btAlterar.setDisable(true);
        txPesquisa.clear();
        txNome.requestFocus();
        
    }
    
    private void CarregaTabela(String filtro)
    {
        DALAluno dalL = new DALAluno();       
        List <Aluno> listaAluno = dalL.get(filtro);
        listaAluno = dalL.get(filtro);           
        ObservableList <Aluno> modelo;
        modelo = FXCollections.observableArrayList(listaAluno);       
        tabela.setItems(modelo);
    }
    
    @FXML
    private void evtNovo(ActionEvent event) {
    }

    @FXML
    private void evtAlterar(ActionEvent event) {
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtCancelar(ActionEvent event) 
    {
        if (!pndados.isDisabled())
        {
            EstadoOriginal();
        } 
        else{
            
            FXMLPrincipalController.snprincipal.setCenter(null);
            FXMLPrincipalController.nome.setText("");
           
        }
    }
    
}
