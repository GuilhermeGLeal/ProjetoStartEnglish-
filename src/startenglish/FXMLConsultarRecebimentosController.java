package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALRecebimento;
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

    private boolean alterou;
    private boolean alterando;
    private List<Recebimentos>recebs;
    @FXML
    private JFXDatePicker dtPagFim;
    @FXML
    private JFXTextField txAlunoFiltro;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
        setaTabela();
        estadoOriginal();
        setaCombobox();
        carregaTabela('I');
    }    

    private void estadoOriginal(){
        
        alterou = false;
        alterando = false;
        btSelecionarRecebimentos.setDisable(true);
        pnRegistro.setDisable(true);
        btFinalizar.setDisable(true);
        
        estadoOriginalPesquisa();
    }
    
    private void estadoEdicao(){
        
        pnRegistro.setDisable(false);
    }
    
    private void carregaTabela(char chamada) {

        DALRecebimento dalRECEB = new DALRecebimento();
        List<Recebimentos> recebimentos;
        recebimentos = dalRECEB.get("");

        if (chamada == 'I') {
            recebs = recebimentos;
            tabelaRecibmentos.setItems(FXCollections.observableArrayList(recebs));
        } else if (chamada == 'L') {
            
            tabelaRecibmentos.setItems(FXCollections.observableArrayList(recebs));
        }

    }
    
    private void setaCombobox(){
        
        List<String> Filtros = new ArrayList();
        
        Filtros.add("Data de Emissão");
        Filtros.add("Data de Vencimento");
        Filtros.add("Data de Pagamento");
        Filtros.add("Nome do Aluno");
        
        ObservableList<String> modeloFiltros = FXCollections.observableArrayList(Filtros);
        cbSelecionarFiltro.setItems(modeloFiltros);      
        
    }
    
    private void setaTabela(){
        
        tcValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tcValorPago.setCellValueFactory(new PropertyValueFactory("valorpago"));
        tcDataEmissao.setCellValueFactory(new PropertyValueFactory("dtemissoa"));
        tcDataVencimento.setCellValueFactory(new PropertyValueFactory("dtvencimento"));
        tcDataPagamentoo.setCellValueFactory(new PropertyValueFactory("dtreceb"));
        tcNumMat.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getMat().getNummat()));
        tcNomeAluno.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMat().getAluno().getNome()));
        tcStatus.setCellValueFactory(new PropertyValueFactory("pago"));
    }
    
    private void estadoOriginalPesquisa(){
        
        cbSelecionarFiltro.getSelectionModel().select("Data de Emissão");
        dtEmissFim.setDisable(false);
        dtEmissIni.setDisable(false);
        dtPagaIni.setDisable(true);
        dtPagFim.setDisable(true);
        dtVencIni.setDisable(true);
        dtVencFim.setDisable(true);
        txAlunoFiltro.clear();
        txAlunoFiltro.setDisable(true);
        
        dtEmissIni.setValue(LocalDate.now());
        dtEmissFim.setValue(LocalDate.now().plusDays(30));
        
        cbStatus.disarm();
    }
    

    @FXML
    private void evtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtLimpar(ActionEvent event) {
        
        carregaTabela('L');
        estadoOriginalPesquisa();
    }

    @FXML
    private void evtTabela(MouseEvent event) {
        
        if(tabelaRecibmentos.getSelectionModel().getFocusedIndex() >=0){
            btSelecionarRecebimentos.setDisable(false);
        }
        else{
            btSelecionarRecebimentos.setDisable(true);
        }
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

    private void setaDatas(boolean flag, char data) {

        switch (data) {
            case 'E':
                dtEmissFim.setDisable(!flag);
                dtEmissIni.setDisable(!flag);
                dtVencIni.setDisable(flag);
                dtVencFim.setDisable(flag);
                dtPagFim.setDisable(flag);
                dtPagaIni.setDisable(flag);
                break;
            case 'V':
                dtEmissFim.setDisable(flag);
                dtEmissIni.setDisable(flag);
                dtVencIni.setDisable(!flag);
                dtVencFim.setDisable(!flag);
                dtPagFim.setDisable(flag);
                dtPagaIni.setDisable(flag);
                break;
            case 'P':
                dtEmissFim.setDisable(flag);
                dtEmissIni.setDisable(flag);
                dtVencIni.setDisable(flag);
                dtVencFim.setDisable(flag);
                dtPagFim.setDisable(!flag);
                dtPagaIni.setDisable(!flag);
                break;
            default:
                 dtEmissFim.setDisable(flag);
                dtEmissIni.setDisable(flag);
                dtVencIni.setDisable(flag);
                dtVencFim.setDisable(flag);
                dtPagFim.setDisable(flag);
                dtPagaIni.setDisable(flag);
                break;
        }

    }
    
    @FXML
    private void evtCBfiltro(ActionEvent event) {
        
        String filtro = cbSelecionarFiltro.getSelectionModel().getSelectedItem();
        
        if(filtro.contains("Data")){
            
            txAlunoFiltro.setDisable(true);
            
            if(filtro.contains("Emissão")){
               setaDatas(true,'E');
            }
            else if(filtro.contains("Vencimento")){
                setaDatas(true,'V');
            }
            else
                setaDatas(true,'P');
        }
        else{
            
            txAlunoFiltro.setDisable(false);
            setaDatas(true,'a');
        }
    }
    
}
