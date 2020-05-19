
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
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
import startenglish.db.DAL.DALAgenda;
import startenglish.db.DAL.DALAluno;
import startenglish.db.DAL.DALProfessor;
import startenglish.db.Entidades.Agenda;
import startenglish.db.Entidades.Aluno;
import startenglish.db.Entidades.Professor;


public class FXMLAgendarProvaController implements Initializable {

    @FXML
    private JFXComboBox<Professor> cbProfessor;
    @FXML
    private JFXComboBox<String> cbLocal;
    @FXML
    private JFXComboBox<String> cbHorario;
    @FXML
    private JFXComboBox<Aluno> cbAluno;
    @FXML
    private JFXComboBox<String> cbStatus;
    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXDatePicker dtDataAgend;
    @FXML
    private JFXButton btInserir;
    @FXML
    private TableColumn<Agenda, String> tcNomeAluno;
    @FXML
    private TableColumn<Agenda, String> tcCPF;
    @FXML
    private TableColumn<Agenda, String> tcProfessor;
    @FXML
    private TableColumn<Agenda, Date> tcData;
    @FXML
    private TableColumn<Agenda, String> tcHorario;
    @FXML
    private TableColumn<Agenda, String> tcStatus;
    @FXML
    private JFXButton btVoltar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btSalvarOp;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private JFXDatePicker dtDataFIMf;
    @FXML
    private JFXDatePicker dtDataInif;
   @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXButton btLimpar;
    @FXML
    private TableView<Agenda> tabela;
    @FXML
    private JFXTextField txAluno;
    @FXML
    private JFXComboBox<Professor> cbProfessorF;
    
    private boolean alterou;
    private List<Agenda> listaauxliar;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        seta_comboboxBanco();
        seta_combobox();
        estadoOriginal();
        seta_pesquisa();
        seta_tabela();
        listaauxliar = new ArrayList();
        alterou = false;
        carregaTabela("", 'I');

    }

    public void seta_tabela() {

        tcNomeAluno.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAluno().getNome()));
        tcCPF.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAluno().getCpf()));
        tcData.setCellValueFactory(new PropertyValueFactory("dataProva"));
        tcHorario.setCellValueFactory(new PropertyValueFactory("horario"));
        tcProfessor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfessor().getFunc().getNome()));
        tcStatus.setCellValueFactory(new PropertyValueFactory("status"));
    }

    public void seta_combobox() {

        List<String> Local = new ArrayList();
        List<String> Horario = new ArrayList();
        List<String> Status = new ArrayList();
        List<String> Filtro = new ArrayList();

        Status.add("Esperando");
        Status.add("Faltou");
        Status.add("Realizou");
        Filtro.add("Aluno");
        Filtro.add("Data");
        Filtro.add("Professor");
        Local.add("Sede");
        Horario.add("13:30 as 15:30");
        Horario.add("08:30 as 10:30");

        ObservableList<String> modelostatus = FXCollections.observableArrayList(Status);
        ObservableList<String> modelolocal = FXCollections.observableArrayList(Local);
        ObservableList<String> modelofiltro = FXCollections.observableArrayList(Filtro);
        ObservableList<String> modelohorario = FXCollections.observableArrayList(Horario);

        cbStatus.setItems(modelostatus);
        cbFiltro.setItems(modelofiltro);
        cbLocal.setItems(modelolocal);
        cbHorario.setItems(modelohorario);

        cbStatus.setValue("Realizou");
        cbFiltro.setValue("Aluno");
        cbHorario.setValue("08:30 as 10:30");
        cbLocal.setValue("Sede");
    }

    public void carregaTabela(String filtro, char chamada) {

        DALAgenda dalcurso = new DALAgenda();
        List<Agenda> agenda;
        agenda = dalcurso.get(filtro);

        if (chamada == 'I') {
            listaauxliar = agenda;
        } else if (chamada == 'L') {
            tabela.setItems(FXCollections.observableArrayList(listaauxliar));
        }

    }
    
    private void estado_edicao(){
        
        dtDataAgend.setValue(null);
        dtDataAgend.requestFocus();
        cbProfessor.getSelectionModel().select(0);
        cbLocal.getSelectionModel().select(0);
        cbHorario.getSelectionModel().select(0);
        cbAluno.getSelectionModel().select(0);
        cbStatus.getSelectionModel().select(0);
    }
    
    private void seta_pesquisa(){
        
        cbProfessorF.setDisable(true);
        txAluno.clear();
        txAluno.setDisable(false);
        cbFiltro.setValue("Aluno");
        dtDataInif.setDisable(true);
        dtDataFIMf.setDisable(true);
        dtDataInif.setValue(LocalDate.now());
        dtDataFIMf.setValue(LocalDate.now().plusDays(30));
        
    }
    
    private void estadoOriginal(){
        
        btAlterar.setDisable(true);
        btApagar.setDisable(true);
        btSalvarOp.setDisable(true);
        dtDataAgend.requestFocus();
    }
    
    public void seta_comboboxBanco(){
     
        DALProfessor dalp = new DALProfessor();
        DALAluno dala = new DALAluno();
        List<Professor> profs = new ArrayList();
        List<Aluno> alunos =  new ArrayList();
        
        profs = dalp.get("");
        alunos = dala.get("");
        
        ObservableList<Professor> modelopf =  FXCollections.observableArrayList(profs);
        ObservableList<Aluno> modeloaluno =  FXCollections.observableArrayList(alunos);
        
        cbProfessor.setItems(modelopf);
        cbAluno.setItems(modeloaluno);
        cbProfessorF.setItems(modelopf);
        
    }
    
    @FXML
    private void evtNovo(ActionEvent event) {
        
        estado_edicao();
    }

    @FXML
    private void evtDataPesq(MouseEvent event) {
        
        List<Agenda> agendadata = new ArrayList();
        LocalDate age = dtDataAgend.getValue();
        
        for (int i = 0; i < listaauxliar.size(); i++) {
            
            if(listaauxliar.get(i).getDataProva().equals(age))
                agendadata.add(listaauxliar.get(i));
        }
        
        tabela.setItems(FXCollections.observableArrayList(agendadata));
        
    }

    @FXML
    private void evtInserir(ActionEvent event) {
    }

    @FXML
    private void evtVoltar(ActionEvent event) {

        if (alterou) {
            evtSalvarOp(event);
        }

        FXMLPrincipalController.snprincipal.setCenter(null);
        FXMLPrincipalController.nome.setText("");
    }

    @FXML
    private void evtCancelarOP(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Deseja cancelar todas as operações realizadas?", ButtonType.YES,ButtonType.NO);
        
        if(a.showAndWait().get() == ButtonType.YES){
            
            alterou = false;
            listaauxliar = new ArrayList();
            btSalvarOp.setDisable(true);
        }
    }

    @FXML
    private void evtSalvarOp(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Deseja salvar todas modificações?", ButtonType.YES,ButtonType.NO);
        
        if(a.showAndWait().get() == ButtonType.YES){
            
        }        
        
        FXMLPrincipalController.snprincipal.setCenter(null);
        FXMLPrincipalController.nome.setText("");
    }

    @FXML
    private void evtFiltroComb(ActionEvent event) {

        String filtro = cbFiltro.getSelectionModel().getSelectedItem();

        if (filtro.contains("Data")) {

            dtDataInif.setDisable(false);
            dtDataFIMf.setDisable(false);
            txAluno.setDisable(true);
            cbProfessorF.setDisable(true);
        } else {

            dtDataInif.setDisable(true);
            dtDataFIMf.setDisable(true);

            if (filtro.contains("Aluno")) {

                txAluno.setDisable(false);
                cbProfessorF.setDisable(true);
            } else {

                txAluno.setDisable(true);
                cbProfessorF.setDisable(false);
            }

        }
    }

    @FXML
    private void evtApagar(ActionEvent event) {
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Confirmar exclusão?", ButtonType.YES,ButtonType.NO);
        
        if(a.showAndWait().get() == ButtonType.YES){
            
            listaauxliar.remove(tabela.getSelectionModel().getSelectedItem());
            carregaTabela("", 'L');
        }
    }

    @FXML
    private void evtAlterar(ActionEvent event) {
        
          if(tabela.getSelectionModel().getSelectedItem() != null){
        
            Agenda a = tabela.getSelectionModel().getSelectedItem();
            
            dtDataAgend.setValue(a.getDataProva());
            cbProfessor.getSelectionModel().select(a.getProfessor());
            cbLocal.getSelectionModel().select(a.getLocal());
            cbHorario.getSelectionModel().select(a.getHorario());
            cbAluno.getSelectionModel().select(a.getAluno());
            cbStatus.getSelectionModel().select(a.getStatus());

            dtDataAgend.requestFocus();
          }
    }
    
    @FXML
    private void evtPesquisar(ActionEvent event) {
      
        String filtro = cbFiltro.getSelectionModel().getSelectedItem();
        LocalDate dataini, datafim;
        List<Agenda> novasagendas = new ArrayList();
        String nome_aluno;
        Professor paux;
        
        
        if(filtro.contains("Data")){
            
            dataini = dtDataInif.getValue();
            datafim = dtDataFIMf.getValue();
            
            for (int i = 0; i < listaauxliar.size(); i++) {
                
                if(listaauxliar.get(i).getDataProva().isAfter(dataini) && listaauxliar.get(i).getDataProva().isBefore(datafim))
                    novasagendas.add(listaauxliar.get(i));
            }
        }
        else{
            
            if(filtro.contains("Aluno")){
                
                nome_aluno = txAluno.getText();

                for (int i = 0; i < listaauxliar.size(); i++) {

                    if (listaauxliar.get(i).getAluno().getNome().contains(nome_aluno)) {
                        novasagendas.add(listaauxliar.get(i));
                    }
                }
                
            }
            else{
                
                paux = cbProfessorF.getSelectionModel().getSelectedItem();
                
                for (int i = 0; i < listaauxliar.size(); i++) {

                    if (listaauxliar.get(i).getProfessor().getFunc().getID() == paux.getFunc().getID()) {
                        novasagendas.add(listaauxliar.get(i));
                    }
                }
            }
        }
        
        tabela.setItems(FXCollections.observableArrayList(novasagendas));
    }

    @FXML
    private void evtLimpar(ActionEvent event) {
        
        seta_pesquisa();
        carregaTabela("",'L');
    }

    @FXML
    private void evTabela(MouseEvent event) {

        if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btApagar.setDisable(false);
            btAlterar.setDisable(false);
        } else {

            btApagar.setDisable(true);
            btAlterar.setDisable(true);
        }
    }
    
}
