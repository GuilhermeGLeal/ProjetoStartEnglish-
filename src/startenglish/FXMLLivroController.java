
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALFuncionario;
import startenglish.db.DAL.DALProfessor;
import startenglish.db.Entidades.Funcionario;
import startenglish.db.Entidades.Livro;
import startenglish.db.Entidades.Professor;
import startenglish.util.MaskFieldUtil;

public class FXMLLivroController implements Initializable {

    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private TableView<Livro> tabela;
    @FXML
    private TableColumn<Livro,String> tabelaNome;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXTextField txID;
    @FXML
    private TableColumn<Livro, Double> tabelaValor;
    @FXML
    private JFXTextField txEditora;
    @FXML
    private JFXTextField txVolume;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private TableColumn<Livro,String> tabelaEditora;
    @FXML
    private TableColumn<Livro,String> tabelaVolume;
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
    @FXML
    private AnchorPane pnbusca;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        tabelaNome.setCellValueFactory(new PropertyValueFactory("Nome"));
        tabelaValor.setCellValueFactory(new PropertyValueFactory("Valor"));
        tabelaEditora.setCellValueFactory(new PropertyValueFactory("Editora"));
        tabelaVolume.setCellValueFactory(new PropertyValueFactory("Volume"));
        
        MaskFieldUtil.maxField(txEditora, 25);
        MaskFieldUtil.maxField(txVolume, 5);
        MaskFieldUtil.maxField(txNome, 30);
        MaskFieldUtil.numericField(txValor);    
        
        EstadoOriginal();
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
      
        //CarregaTabela("");
    }
    private void EstadoEdicao()
    {
        pnbusca.setDisable(true);
        pndados.setDisable(false);
        btConfirmar.setDisable(false);
        btExcluir.setDisable(true);
        btAlterar.setDisable(true);
        txPesquisa.clear();
        txNome.requestFocus();
        
    }
    
    private void CarregaTabela(String filtro)
    {
        DALFuncionario dalF = new DALFuncionario();
        DALProfessor dalP = new DALProfessor();
        Professor prof = new Professor();
        
        List <Funcionario> listaFunc = dalF.get(filtro);
        
        for (int i = 0; i < listaFunc.size() ; i++) {
            prof = dalP.get(listaFunc.get(i).getID());
            if(prof != null)
                listaFunc.get(i).setProfessor(Boolean.TRUE);
            else
                listaFunc.get(i).setProfessor(Boolean.FALSE);
            
        }
        ObservableList <Funcionario> modelo;
        modelo = FXCollections.observableArrayList(listaFunc);
        
        //tabela.setItems(modelo);
    }

    @FXML
    private void evtNovo(ActionEvent event) 
    {
        EstadoEdicao();
    }
}
