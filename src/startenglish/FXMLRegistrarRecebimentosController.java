package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import startenglish.db.Entidades.Recebimentos;


public class FXMLRegistrarRecebimentosController implements Initializable {

    @FXML
    private JFXButton btBuscarRecebimentos;
    @FXML
    private TableView<Recebimentos> tabelaReceb;
    @FXML
    private TableColumn<Recebimentos, String> tcNome;
    @FXML
    private TableColumn<Recebimentos, Double> tcValor;
    @FXML
    private TableColumn<Recebimentos, Date> tcDataEmi;
    @FXML
    private TableColumn<Recebimentos, Date> tcDataVenc;
    @FXML
    private JFXButton btGerenciarSele;
    @FXML
    private JFXButton btDeleterSele;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btFinalizar;
    @FXML
    private JFXButton btCancelarOperacoes;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btRefazer;
    @FXML
    private JFXButton btEstorno;
    @FXML
    private JFXTextField txNomeReceb;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXDatePicker dtDataReceb;
    @FXML
    private JFXTextField txValorPago;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void evtBuscar(ActionEvent event) {
    }

    @FXML
    private void evtTabela(MouseEvent event) {
    }

    @FXML
    private void evtGerenciar(ActionEvent event) {
    }

    @FXML
    private void evtDeletar(ActionEvent event) {
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
    }

    @FXML
    private void evtFinalizar(ActionEvent event) {
    }

    @FXML
    private void evtCancelarOperacoes(ActionEvent event) {
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
    }

    @FXML
    private void evtRefazerOperacao(ActionEvent event) {
    }

    @FXML
    private void evtEstorno(ActionEvent event) {
    }
    
}
