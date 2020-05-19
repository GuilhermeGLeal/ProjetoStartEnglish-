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
import startenglish.db.Entidades.Turma;

public class FXMLTurmasController implements Initializable 
{

    @FXML
    private AnchorPane pndados;
    @FXML
    private JFXTextField txID;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private TableView<Turma> tabela;
    @FXML
    private JFXComboBox<String> cbProfessor;
    @FXML
    private JFXComboBox<String> cbCurso;
    @FXML
    private JFXTextField txPesquisaIni;
    @FXML
    private JFXTextField txPesquisaFim;
    @FXML
    private TableColumn<Turma,String> tabelaTurma;
    @FXML
    private TableColumn<Turma,String> tabelaProfessor;
    @FXML
    private TableColumn<Turma,String> tabelaCurso;
    @FXML
    private TableColumn<Turma,String> tabelaIni;
    @FXML
    private TableColumn<Turma,String> tabelaFim;
    @FXML
    private TableColumn<Turma,String> tabelaAtivo;
    @FXML
    private JFXTextField txHorIni;
    @FXML
    private JFXTextField txHorFim;
    @FXML
    private JFXDatePicker dtIni;
    @FXML
    private JFXCheckBox checkAtivo;
    @FXML
    private JFXTextField txTurma;
    @FXML
    private JFXCheckBox checkSegunda;
    @FXML
    private JFXTextField txVagas;
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

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       
    }    


    @FXML
    private void evtPesquisar(ActionEvent event)
    {
        
    }

    @FXML
    private void evtClickTabela(MouseEvent event)
    {
        
    }
    
}
