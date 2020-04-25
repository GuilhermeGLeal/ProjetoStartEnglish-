/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import startenglish.db.Entidades.Funcionario;

/**
 * FXML Controller class
 *
 * @author azeve
 */
public class FXMLFuncionarioController implements Initializable {

    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
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
    private JFXTextField txId;
    @FXML
    private JFXTextField txBairro;
    @FXML
    private JFXTextField txNumero;
    @FXML
    private JFXTextField txCidade;
    @FXML
    private JFXTextField txIdFunc;
    @FXML
    private CheckBox checkProf;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private TableView<Funcionario> tabela;
    @FXML
    private TableColumn<Funcionario, String> tabelaNome;
    @FXML
    private TableColumn<Funcionario, String> tabelaCPF;
    @FXML
    private TableColumn<Funcionario, String> tabelaTelefone;
    @FXML
    private TableColumn<Funcionario, String> tabelaEmail;
    @FXML
    private TableColumn<Funcionario, CheckBox> tabelaCheck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
