package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import startenglish.db.Entidades.Cursos;


public class FXMLCursosController implements Initializable {

    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXTextField txId;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXTextField txNomeCurso;
    @FXML
    private JFXTextField txPreco;
    @FXML
    private JFXTextField txDescricao;
    @FXML
    private JFXCheckBox checkAtivo;
    @FXML
    private TableColumn<Cursos, String> tabelaNomeCurso;
    @FXML
    private TableColumn<Cursos, Double> tabelaPreco;
    @FXML
    private TableColumn<Cursos, CheckBox> tabelaAtivo;
    @FXML
    private TableView<Cursos> tableview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
