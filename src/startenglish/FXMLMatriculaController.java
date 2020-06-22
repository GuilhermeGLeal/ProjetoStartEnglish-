package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLMatriculaController implements Initializable 
{

    @FXML
    private AnchorPane pndados;
    @FXML
    private JFXTextField txHorIni;
    @FXML
    private JFXTextField txHorFim;
    @FXML
    private JFXButton btInserir;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXCheckBox checkSegunda;
    @FXML
    private JFXCheckBox checkDomingo;
    @FXML
    private JFXCheckBox checkSabado;
    @FXML
    private JFXCheckBox checkSexta;
    @FXML
    private JFXCheckBox checkQuinta;
    @FXML
    private JFXCheckBox checkQuarta;
    @FXML
    private JFXCheckBox checkTerca;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<?> cbFiltro;
    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> tabelaTurma;
    @FXML
    private TableColumn<?, ?> tabelaProfessor;
    @FXML
    private TableColumn<?, ?> tabelaCurso;
    @FXML
    private TableColumn<?, ?> tabelaIni;
    @FXML
    private TableColumn<?, ?> tabelaFim;
    @FXML
    private TableColumn<?, ?> tabelaAtivo;
    @FXML
    private JFXTextField txNumMatricula;
    @FXML
    private JFXComboBox<?> cbAluno;
    @FXML
    private JFXTextField txCPF;
    @FXML
    private JFXTextField txNomeResp;
    @FXML
    private JFXTextField txEscola;
    @FXML
    private JFXTextField txEmail;
    @FXML
    private JFXTextField txNivel;
    @FXML
    private JFXCheckBox checkAtivo;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXTextField txDesconto;
    @FXML
    private JFXComboBox<?> cbParcelas;
    @FXML
    private JFXComboBox<?> cbVencimentos;
    @FXML
    private JFXComboBox<?> cbLivro;
    @FXML
    private JFXTextField txNomeResp1;
    @FXML
    private JFXButton btAlterar1;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void evtInserir(ActionEvent event) {
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
    private void evtCancelar(ActionEvent event) {
    }

    @FXML
    private void evtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtFiltroTxt(ActionEvent event) {
    }

    @FXML
    private void evtClickTabela(MouseEvent event) {
    }
    
}
