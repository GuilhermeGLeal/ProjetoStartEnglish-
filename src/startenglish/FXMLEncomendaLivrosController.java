/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author azeve
 */
public class FXMLEncomendaLivrosController implements Initializable {

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
    private AnchorPane pndados;
    @FXML
    private JFXTextField txtID;
    @FXML
    private ComboBox<?> cbFuncionario;
    @FXML
    private JFXDatePicker dtPEncomenda;
    @FXML
    private JFXDatePicker dtPPrevisao;
    @FXML
    private JFXTextField txtFornecedor;
    @FXML
    private JFXTextField txtValorTotal;
    @FXML
    private TableView<?> tabelaItens;
    @FXML
    private TableColumn<?, ?> tbItensLivro;
    @FXML
    private TableColumn<?, ?> tbItensQtd;
    @FXML
    private TableColumn<?, ?> tbItensValor;
    @FXML
    private ComboBox<?> cbLivro;
    @FXML
    private JFXTextField txtValorUni;
    @FXML
    private JFXButton btAdicionar;
    @FXML
    private JFXTextField txtQtd;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXDatePicker dtpdataini;
    @FXML
    private JFXDatePicker dtpdatafim;
    @FXML
    private JFXComboBox<?> comboBox;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> tabelaID;
    @FXML
    private TableColumn<?, ?> tabelaFornecedor;
    @FXML
    private TableColumn<?, ?> tabelaFuncionario;
    @FXML
    private TableColumn<?, ?> tabelaDataEncomenda;
    @FXML
    private TableColumn<?, ?> tabelaPrevisão;
    @FXML
    private TableColumn<?, ?> tabelaValor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void evtNovo(ActionEvent event) {
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
    private void evtClickTabela(MouseEvent event) {
    }

    @FXML
    private void evtPesquisa(ActionEvent event) {
    }

    @FXML
    private void evtComboBox(ActionEvent event) {
    }

    @FXML
    private void evtLimparFiltros(ActionEvent event) {
    }
    
}
