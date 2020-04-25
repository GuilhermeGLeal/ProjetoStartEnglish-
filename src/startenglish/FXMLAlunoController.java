/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLAlunoController implements Initializable {

    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> tabelaNome;
    @FXML
    private TableColumn<?, ?> tabelaCPF;
    @FXML
    private TableColumn<?, ?> tabelaTelefone;
    @FXML
    private TableColumn<?, ?> tabelaEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
