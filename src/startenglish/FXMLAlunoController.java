package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import startenglish.db.Entidades.Aluno;

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
    private JFXComboBox<?> cbFiltro;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
}
