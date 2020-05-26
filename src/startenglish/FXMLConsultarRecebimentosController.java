package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.layout.AnchorPane;
import startenglish.db.Entidades.Recebimentos;


public class FXMLConsultarRecebimentosController implements Initializable {

    @FXML
    private AnchorPane pnFiltros;
    @FXML
    private JFXComboBox<String> cbSelecionarFiltro;
    @FXML
    private JFXDatePicker dtEmissIni;
    @FXML
    private JFXDatePicker dtEmissFim;
    @FXML
    private JFXTextField txNomeAluno;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXButton btLimparFiltros;
    @FXML
    private JFXDatePicker dtVencIni;
    @FXML
    private JFXDatePicker dtVencFim;
    @FXML
    private JFXDatePicker dtPagaIni;
    @FXML
    private JFXCheckBox cbStatus;
    @FXML
    private TableView<Recebimentos> tabelaRecibmentos;
    @FXML
    private JFXButton btVoltar;
    @FXML
    private JFXButton btSelecionarRecebimentos;
    @FXML
    private TableColumn<Recebimentos, Double> tcValor;
    @FXML
    private TableColumn<Recebimentos, Double> tcValorPago;
    @FXML
    private TableColumn<Recebimentos, Date> tcDataEmissao;
    @FXML
    private TableColumn<Recebimentos, Date> tcDataVencimento;
    @FXML
    private TableColumn<Recebimentos, Date> tcDataPagamentoo;
    @FXML
    private TableColumn<Recebimentos, Integer> tcNumMat;
    @FXML
    private TableColumn<Recebimentos, String> tcNomeAluno;
    @FXML
    private TableColumn<Recebimentos, String> tcStatus;
    @FXML
    private AnchorPane pnRegistro;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXDatePicker dtDataReceb;
    @FXML
    private JFXTextField txValorPago;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btRefazer;
    @FXML
    private JFXButton btEstorno;
    @FXML
    private JFXButton btCancelarOperacoes;
    @FXML
    private JFXButton btFinalizar;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    private void estadoOriginal(){
        
    }
    
    private void estadoEdicao(){
        
    }
    
    private void carregaTabela(char chamada){
        
    }
    
    private void setaCombobox(){
        
    }
    
    private void setaTabela(){
        
    }
    
    private void estadoOriginalPesquisa(){
        
        cbSelecionarFiltro.getSelectionModel().select("Data de Emissão");
    }
    

    @FXML
    private void evtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtLimpar(ActionEvent event) {
    }

    @FXML
    private void evtTabela(MouseEvent event) {
    }

    @FXML
    private void evtVoltar(ActionEvent event) {
    }

    @FXML
    private void evtSelecionar(ActionEvent event) {
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
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

    @FXML
    private void evtCancelarOperacoes(ActionEvent event) {
    }

    @FXML
    private void evtFinalizar(ActionEvent event) {
    }

    @FXML
    private void evtCBfiltro(ActionEvent event) {
    }
    
}
