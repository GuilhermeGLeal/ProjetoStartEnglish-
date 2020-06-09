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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    private JFXButton btEstorno;
    @FXML
    private JFXButton btCancelarOperacoes;
    @FXML
    private JFXButton btFinalizar;

    private boolean alterou;
    private Recebimentos recebAtual;
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
        
        btSelecionarRecebimentos.setDisable(true);
        estadoEdicao();
        pnRegistro.setDisable(true);
        btFinalizar.setDisable(true);
        
        estadoOriginalPesquisa();
    }
    
    private void estadoEdicao(){
        
        txNomeAluno.clear();
        txValor.clear();
        dtDataReceb.setValue(null);
        txValorPago.clear();
        
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
    
    private void setTextFieldErro(JFXTextField nome) {

        nome.setStyle("-fx-border-color: red; -fx-border-width: 2;"
                + "-fx-background-color: #BEBEBE;"
                + "-fx-font-weight: bold;");
    }

    private void setTextFieldnormal(JFXTextField nome) {

        nome.setStyle("-fx-border-width: 0;"
                + "-fx-background-color: #BEBEBE;"
                + "-fx-font-weight: bold;");

    }
    
     private void setDataErro(JFXDatePicker nome) {

        nome.setStyle("-fx-border-color: red; -fx-border-width: 2;"
                + "-fx-background-color: #BEBEBE;"
                + "-fx-font-weight: bold;");
    }

    private void setDataNormal(JFXDatePicker nome) {

        nome.setStyle("-fx-border-width: 0;"
                + "-fx-background-color: #BEBEBE;"
                + "-fx-font-weight: bold;");

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

        String filtro = cbSelecionarFiltro.getSelectionModel().getSelectedItem();
        String nomeAluno;
        LocalDate ini, fim;
        List<Recebimentos> novaLista = new ArrayList();

        if (cbStatus.isArmed()) { //PAGOS

            if (filtro.contains("Nome do Aluno")) {

                nomeAluno = txAlunoFiltro.getText();

                for (int i = 0; i < recebs.size(); i++) {

                    if (recebs.get(i).getMat().getAluno().getNome().toLowerCase().contains(nomeAluno) && recebs.get(i).getPago().equals("Pago")) {
                        novaLista.add(recebs.get(i));
                    }
                }
            } else {

                 if (filtro.contains("Emissão")) {

                    ini = dtEmissIni.getValue();
                    fim = dtEmissFim.getValue();

                    for (int i = 0; i < recebs.size(); i++) {

                        if ((recebs.get(i).getDtemissoa().isAfter(ini) || recebs.get(i).getDtemissoa().isEqual(ini)) 
                             && (recebs.get(i).getDtemissoa().isBefore(fim) || recebs.get(i).getDtemissoa().isEqual(fim))
                                && recebs.get(i).getPago().equals("Pago")) {
                            
                            novaLista.add(recebs.get(i));
                        }
                    }

                } else if (filtro.contains("Vencimento")) {
                    
                    ini = dtVencIni.getValue();
                    fim = dtVencFim.getValue();

                    for (int i = 0; i < recebs.size(); i++) {

                        if ((recebs.get(i).getDtvencimento().isAfter(ini) || recebs.get(i).getDtvencimento().isEqual(ini)) 
                             && (recebs.get(i).getDtvencimento().isBefore(fim) || recebs.get(i).getDtvencimento().isEqual(fim))
                                && recebs.get(i).getPago().equals("Pago")) {
                            
                            novaLista.add(recebs.get(i));
                        }
                    }

                } else {

                    ini = dtPagaIni.getValue();
                    fim = dtPagFim.getValue();

                    for (int i = 0; i < recebs.size(); i++) {

                        if (recebs.get(i).getDtreceb() != null) {

                            if ((recebs.get(i).getDtreceb().isAfter(ini) || recebs.get(i).getDtreceb().isEqual(ini))
                                    && (recebs.get(i).getDtreceb().isBefore(fim) || recebs.get(i).getDtreceb().isEqual(fim))
                                    && recebs.get(i).getPago().equals("Pago")) {

                                novaLista.add(recebs.get(i));
                            }
                        }

                    }
                }
            }
        } else { // NAO PAGOS

            if (filtro.contains("Nome do Aluno")) {

                nomeAluno = txAlunoFiltro.getText();

                for (int i = 0; i < recebs.size(); i++) {

                    if (recebs.get(i).getMat().getAluno().getNome().toLowerCase().contains(nomeAluno) &&recebs.get(i).getPago().equals("Não Pago")) {
                        novaLista.add(recebs.get(i));
                    }
                }
            } else {

                if (filtro.contains("Emissão")) {

                    ini = dtEmissIni.getValue();
                    fim = dtEmissFim.getValue();

                    for (int i = 0; i < recebs.size(); i++) {

                        if ((recebs.get(i).getDtemissoa().isAfter(ini) || recebs.get(i).getDtemissoa().isEqual(ini)) 
                             && (recebs.get(i).getDtemissoa().isBefore(fim) || recebs.get(i).getDtemissoa().isEqual(fim))
                                && recebs.get(i).getPago().equals("Não Pago")) {
                            
                            novaLista.add(recebs.get(i));
                        }
                    }

                } else if (filtro.contains("Vencimento")) {
                    
                    ini = dtVencIni.getValue();
                    fim = dtVencFim.getValue();

                    for (int i = 0; i < recebs.size(); i++) {

                        if ((recebs.get(i).getDtvencimento().isAfter(ini) || recebs.get(i).getDtvencimento().isEqual(ini)) 
                             && (recebs.get(i).getDtvencimento().isBefore(fim) || recebs.get(i).getDtvencimento().isEqual(fim))
                                && recebs.get(i).getPago().equals("Não Pago")) {
                            
                            novaLista.add(recebs.get(i));
                        }
                    }

                } else {

                    ini = dtPagaIni.getValue();
                    fim = dtPagFim.getValue();

                    for (int i = 0; i < recebs.size(); i++) {

                        if (recebs.get(i).getDtreceb() != null) {

                            if ((recebs.get(i).getDtreceb().isAfter(ini) || recebs.get(i).getDtreceb().isEqual(ini))
                                    && (recebs.get(i).getDtreceb().isBefore(fim) || recebs.get(i).getDtreceb().isEqual(fim))
                                    && recebs.get(i).getPago().equals("Não Pago")) {

                                novaLista.add(recebs.get(i));
                            }
                        }

                    }
                }
            }
        }

        tabelaRecibmentos.setItems(FXCollections.observableArrayList(novaLista));
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
        
        if (alterou) {
            evtFinalizar(event);
        }

        FXMLPrincipalController.snprincipal.setCenter(null);
        FXMLPrincipalController.nome.setText("");
    }

    @FXML
    private void evtSelecionar(ActionEvent event) {
        
        if(tabelaRecibmentos.getSelectionModel().getFocusedIndex() >=0){
            
            Recebimentos receb = tabelaRecibmentos.getSelectionModel().getSelectedItem();
            
            txNomeAluno.setText(receb.getMat().getAluno().getNome());
            txValor.setText(""+receb.getValor());
            dtDataReceb.setValue(LocalDate.now());
            txValorPago.setText(""+receb.getValor());
         
            recebAtual = receb;
            estadoEdicao();
        }
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
        
        alterou = true;
        btFinalizar.setDisable(false);
    }

    @FXML
    private void evtCancelar(ActionEvent event) {

       estadoEdicao();
       pnRegistro.setDisable(true);
    }

    @FXML
    private void evtEstorno(ActionEvent event) {
        
        alterou = true;
        btFinalizar.setDisable(false);
    }

    @FXML
    private void evtCancelarOperacoes(ActionEvent event) {
        
         Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Deseja cancelar todas as operações realizadas?", ButtonType.YES,ButtonType.NO);
        
        if(a.showAndWait().get() == ButtonType.YES){            
          
            carregaTabela('I');
            btFinalizar.setDisable(true);
            estadoOriginal();
        }
    }

    @FXML
    private void evtFinalizar(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Deseja salvar todas modificações?", ButtonType.YES, ButtonType.NO);
        boolean ok = false;
        
        if (a.showAndWait().get() == ButtonType.YES) {

            DALRecebimento dale = new DALRecebimento();
            ok = dale.InserirTudo(recebs);

            Alert b = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
            if (ok) {
                b.setContentText("Todas informações salvas com sucesso!");
            } else {
                b.setContentText("Problemas ao salvar as informações!");
            }
            
            b.showAndWait();
        }

        if (ok) {
            FXMLPrincipalController.snprincipal.setCenter(null);
            FXMLPrincipalController.nome.setText("");
        }
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
