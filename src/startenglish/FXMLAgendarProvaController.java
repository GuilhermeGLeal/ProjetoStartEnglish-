
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import startenglish.db.Entidades.Agenda;
import startenglish.db.Entidades.Aluno;
import startenglish.db.Entidades.Professor;


public class FXMLAgendarProvaController implements Initializable {

    @FXML
    private JFXComboBox<Professor> cbProfessor;
    @FXML
    private JFXComboBox<String> cbLocal;
    @FXML
    private JFXComboBox<String> cbHorario;
    @FXML
    private JFXComboBox<Aluno> cbAluno;
    @FXML
    private JFXComboBox<String> cbStatus;
    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXDatePicker dtDataAgend;
    @FXML
    private JFXButton btInserir;
    @FXML
    private TableColumn<Agenda, String> tcNomeAluno;
    @FXML
    private TableColumn<Agenda, String> tcCPF;
    @FXML
    private TableColumn<Agenda, String> tcProfessor;
    @FXML
    private TableColumn<Agenda, Date> tcData;
    @FXML
    private TableColumn<Agenda, String> tcHorario;
    @FXML
    private TableColumn<Agenda, String> tcStatus;
    @FXML
    private JFXButton btVoltar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btSalvarOp;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private JFXDatePicker dtDataFIMf;
    @FXML
    private JFXDatePicker dtDataInif;
    @FXML
    private JFXComboBox<Aluno> cbAlunoF;
    @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXComboBox<Professor> cbProfessorF;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXButton btLimpar;
    @FXML
    private TableView<Agenda> tabela;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      
    }    

    @FXML
    private void evtNovo(ActionEvent event) {
    }

    @FXML
    private void evtDataPesq(MouseEvent event) {
    }

    @FXML
    private void evtInserir(ActionEvent event) {
    }

    @FXML
    private void evtVoltar(ActionEvent event) {
    }

    @FXML
    private void evtCancelarOP(ActionEvent event) {
    }

    @FXML
    private void evtSalvarOp(ActionEvent event) {
    }

    @FXML
    private void evtFiltroComb(ActionEvent event) {
    }

    @FXML
    private void evtApagar(ActionEvent event) {
    }

    @FXML
    private void evtAlterar(ActionEvent event) {
    }

    @FXML
    private void evtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtLimpar(ActionEvent event) {
    }
    
}
