package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
    private JFXComboBox<?> cbFiltro;
    @FXML
    private TableView<?> tabela;
    @FXML
    private JFXComboBox<?> cbProfessor;
    @FXML
    private JFXComboBox<?> cbCurso;
    @FXML
    private JFXTextField txID1;
    @FXML
    private JFXTextField txID11;
    @FXML
    private JFXTextField txPesquisaIni;
    @FXML
    private JFXTextField txPesquisaFim;
    @FXML
    private JFXTextField txID12;
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

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       
    }    


    @FXML
    private void evtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtClickTabela(MouseEvent event) {
    }
    
}
