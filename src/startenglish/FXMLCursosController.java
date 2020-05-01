package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALCurso;
import startenglish.db.Entidades.Cursos;
import startenglish.db.util.Banco;
import startenglish.util.MaskFieldUtil;


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
    private TableColumn<Cursos, String> tabelaNomeCurso;
    @FXML
    private TableColumn<Cursos, Double> tabelaPreco;
    @FXML
    private TableView<Cursos> tableview;
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
    private AnchorPane pnpesquisa;
    @FXML
    private JFXDatePicker dtpDataLanc;
    @FXML
    private JFXDatePicker dtpDataEnc;
    @FXML
    private JFXCheckBox cEncerrar;
    @FXML
    private JFXTextField txEtapa;
    @FXML
    private JFXCheckBox cPesquisar;
    @FXML
    private TableColumn<Cursos, String> tabelaEtapa;
    @FXML
    private TableColumn<Cursos, Date> tabelaData;
    @FXML
    private TableColumn<Cursos, Date> tabelaEncerramento;
    @FXML
    private JFXDatePicker dtFiltro;
    @FXML
    private JFXComboBox<String> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tabelaNomeCurso.setCellValueFactory(new PropertyValueFactory("nomeCurso"));
        tabelaPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        tabelaEtapa.setCellValueFactory(new PropertyValueFactory("etapa"));
        tabelaData.setCellValueFactory(new PropertyValueFactory("data_lancamento"));
        tabelaEncerramento.setCellValueFactory(new PropertyValueFactory("data_encerramento"));
        
        MaskFieldUtil.maxField(txNomeCurso, 20);
        MaskFieldUtil.maxField(txDescricao, 50);
        MaskFieldUtil.maxField(txPreco, 10);
        MaskFieldUtil.maxField(txEtapa,10);
                
        estadoOriginal();
    }    

    private void carregaTabela(String filtro){
        
        DALCurso dalcurso = new DALCurso();
        List<Cursos> cursos = new ArrayList();
        cursos = dalcurso.get(filtro);
        ObservableList<Cursos> modelo;
        modelo = FXCollections.observableArrayList(cursos);
        tableview.setItems(modelo);
     
        
    }
    
    private void estadoOriginal(){
     
        txPesquisa.setDisable(true);
        btPesquisar.setDisable(true);
        pndados.setDisable(true);
        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        btAlterar.setDisable(true);
        btExcluir.setDisable(true);
        btNovo.setDisable(false);
       
        ObservableList <Node> componentes=pndados.getChildren(); 
        for(Node n : componentes)
        {
            if (n instanceof TextInputControl) 
                ((TextInputControl)n).setText("");
            if(n instanceof ComboBox)
                ((ComboBox)n).getItems().clear();
        }
      
        dtpDataEnc.setValue(LocalDate.now());
        dtpDataLanc.setValue(LocalDate.now());
        carregaTabela("");
    }
    
    private void estadoedicao(){
        
        txPesquisa.setDisable(false);
        btPesquisar.setDisable(false);
        pndados.setDisable(false);
        btConfirmar.setDisable(false);
        btExcluir.setDisable(true);
        btExcluir.setDisable(true);
        txNomeCurso.requestFocus();
    }
    
    @FXML
    private void evtNovo(ActionEvent event) {
        
        estadoedicao();
    }

    @FXML
    private void evtAlterar(ActionEvent event) {
        
        if(tableview.getSelectionModel().getSelectedItem() != null){
        
            Cursos c = tableview.getSelectionModel().getSelectedItem();
            
            txId.setText(""+c.getCursoID());
            txNomeCurso.setText(c.getNomeCurso());
            txDescricao.setText(c.getDescricao());
            txPreco.setText(""+c.getPreco());
            txEtapa.setText(c.getEtapa());
            dtpDataEnc.setValue(c.getData_encerramento());
            dtpDataLanc.setValue(c.getData_lancamento());
            
            estadoedicao();
        }
        
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Confirmar exclusão?", ButtonType.YES,ButtonType.NO);
        boolean ok = true;
        
        if(a.showAndWait().get() == ButtonType.YES){
            
            Cursos c = new Cursos();
            DALCurso dalc = new DALCurso();
            
            c = tableview.getSelectionModel().getSelectedItem();
            
            try{
                
                Banco.getCon().getConnect().setAutoCommit(false);
                
                ok = dalc.apagar(c.getCursoID());
                
                if(ok){
                    
                     Banco.getCon().getConnect().commit();
                    a =  new Alert(Alert.AlertType.CONFIRMATION," Exclusão ocorrida com sucesso!!", ButtonType.OK);
                }
                else{
                    
                    Banco.getCon().getConnect().rollback();
                    a =  new Alert(Alert.AlertType.ERROR, "Erro ao deletar curso, verificar em turmas e lista de espera", ButtonType.OK);
                }
                
                a.showAndWait();
                
            }catch(SQLException ex){System.out.println(ex.getMessage());}
            
            estadoedicao();    
            carregaTabela("");
        }
    }

     private void setTextFieldErro(JFXTextField nome){
        
        nome.setStyle("-fx-border-color: red; -fx-border-width: 2;"
                    + "-fx-background-color: #BEBEBE;"
                    + "-fx-font-weight: bold;");
    }
    
    private void setTextFieldnormal(JFXTextField nome){
    
        nome.setStyle("-fx-border-width: 0;"
                    + "-fx-background-color: #BEBEBE;"
                    + "-fx-font-weight: bold;");
        
    }
    
     
    private boolean validarNome(String nome){
        
        boolean ok = true;
        
        if(nome.isEmpty()){
          
            ok = false;
            setTextFieldErro(txNomeCurso);
            Alert a = new Alert(Alert.AlertType.WARNING, "Nome do curso obrigatório!!", ButtonType.CLOSE);
            txNomeCurso.requestFocus();
            a.showAndWait();
        }
        else
            setTextFieldnormal(txNomeCurso);
        
        return ok;
    }
    
    private boolean validaPreco(String preco){
        
        double preco_inserido = 0;
        Alert a = null;
        boolean ok = true,problema = false;
        
        try{
            
            preco_inserido = Double.parseDouble(preco);
            
        }catch(NumberFormatException ex){problema = true;}
        
        if(preco.isEmpty()){
            
            ok = false;
            setTextFieldErro(txPreco);
            a = new Alert(Alert.AlertType.WARNING, "Preço obrigatório!!", ButtonType.CLOSE);
            txPreco.requestFocus();
            
        }
        else if(!preco.isEmpty() && problema){
            
            ok = false;
            setTextFieldErro(txPreco);
            a = new Alert(Alert.AlertType.WARNING, "Preço inválido!", ButtonType.CLOSE);
            txPreco.requestFocus();
        }
        else if(!preco.isEmpty() && preco_inserido <=0){
            
            ok = false;
            setTextFieldErro(txPreco);
            a = new Alert(Alert.AlertType.WARNING, "Preço igual ou menor que 0!", ButtonType.CLOSE);
            txPreco.requestFocus();
        }
        else
            setTextFieldnormal(txNomeCurso);
        
        if(a != null)
               a.showAndWait();
        return ok;
    }
    
    private boolean validaEtapa(String etapa){
        
        boolean ok = true;
        
        if(etapa.isEmpty()){
          
            ok = false;
            setTextFieldErro(txEtapa);
            Alert a = new Alert(Alert.AlertType.WARNING, "Etapa obrigatória!!", ButtonType.CLOSE);
            txEtapa.requestFocus();
            a.showAndWait();
        }
        else
            setTextFieldnormal(txEtapa);
        
        return ok;
    }
    
    private boolean validaDataLanc(LocalDate date_lanc){
        
        boolean ok = true;
         
        if(date_lanc == null){
            
            ok = false;
       
            Alert a = new Alert(Alert.AlertType.WARNING, "Data do lançamento do curso obrigatório!!", ButtonType.CLOSE);
            dtpDataLanc.requestFocus();
            a.showAndWait();
        }
        
        return ok;
    }
    
    private boolean validaDataEncerrameento(LocalDate date_ence){
        
        boolean ok = true;
        
        if(date_ence == null){
                          
            ok = false;
            Alert a = new Alert(Alert.AlertType.WARNING, "Data do encerramento do curso obrigatório!!", ButtonType.CLOSE);
            dtpDataEnc.requestFocus();
            a.showAndWait();
        }
        else if(date_ence.isBefore(dtpDataLanc.getValue())){
            
            ok = false;
            Alert a = new Alert(Alert.AlertType.WARNING, "Data do encerramento está antes da data de lançamento!!", ButtonType.CLOSE);
            dtpDataEnc.requestFocus();
            a.showAndWait();
        }
        
         
        return ok;
    }
    
    
    @FXML
    private void evtConfirmar(ActionEvent event) {
             
        double preco = 0;
        int cod;
        boolean ok = true,encerrado = false,validado = false;
        
        
        if (validarNome(txNomeCurso.getText())) {

            if (validaPreco(txPreco.getText())) {

                if (validaDataLanc(dtpDataLanc.getValue())) {

                    if (cEncerrar.isSelected()) {
                        encerrado = true;
                    }

                    if (encerrado) {
                        validado = validaDataEncerrameento(dtpDataEnc.getValue());
                    }

                    if (!encerrado || validado) {

                        if (validaEtapa(txEtapa.getText())) {

                            try {

                                preco = Double.parseDouble(txPreco.getText());
                                cod = Integer.parseInt(txId.getText());
                                    
                                
                            } catch (NumberFormatException ex) {
                                cod = 0;
                            }

                            DALCurso dalc = new DALCurso();
                            Cursos c = new Cursos();

                            c.setCursoID(cod);
                            c.setNomeCurso(txNomeCurso.getText());
                            c.setPreco(preco);
                            c.setEtapa(txEtapa.getText());
                            c.setData_lancamento(dtpDataLanc.getValue());

                            if(encerrado)
                                c.setData_encerramento(dtpDataEnc.getValue());
                            
                            if (!txDescricao.getText().isEmpty()) {
                                c.setDescricao(txDescricao.getText());
                            }

                            Alert a = null;
                            try {

                                Banco.getCon().getConnect().setAutoCommit(false);

                                if (cod == 0) { // inserindo

                                    ok = dalc.gravar(c);

                                    if (ok) {
                                        a = new Alert(Alert.AlertType.CONFIRMATION, "Curso inserido!!", ButtonType.OK);
                                    } else {
                                        a = new Alert(Alert.AlertType.ERROR, "Problemas ao inserir o curso!!", ButtonType.OK);
                                    }

                                } else { // alterando

                                    ok = dalc.alterar(c);

                                    if (ok) {
                                        a = new Alert(Alert.AlertType.CONFIRMATION, "Curso atualizado!!", ButtonType.OK);
                                    } else {
                                        a = new Alert(Alert.AlertType.ERROR, "Problemas ao atualizar o curso!!", ButtonType.OK);
                                    }

                                }

                                a.showAndWait();
                                if (ok) {

                                    Banco.getCon().getConnect().commit();
                                    estadoOriginal();
                                    carregaTabela("");
                                } else {
                                    Banco.getCon().getConnect().rollback();
                                }

                            } catch (SQLException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                }

            }

        }

    }

    @FXML
    private void evtCancelar(ActionEvent event) {
        
        if (!pndados.isDisabled())
        {
            estadoOriginal();
        } 
       
    }

    @FXML
    private void evtPesquisa(ActionEvent event) {
        
        carregaTabela("upper(nomecurso) like '%"+txPesquisa.getText().toUpperCase()+"%'");
    }

    @FXML
    private void clicktabela(MouseEvent event) {
        
         if(tableview.getSelectionModel().getSelectedIndex()>=0)
        {
           btAlterar.setDisable(false);
           btExcluir.setDisable(false);
        }
    }

    @FXML
    private void evtEncerrar(MouseEvent event) {
    }

    @FXML
    private void evtComboBox(MouseEvent event) {
    }

    @FXML
    private void evtEncerrados(MouseEvent event) {
    }
    
}
