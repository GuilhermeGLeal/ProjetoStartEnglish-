
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import startenglish.db.Entidades.Livro;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
