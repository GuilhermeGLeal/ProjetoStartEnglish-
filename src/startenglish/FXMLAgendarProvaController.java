
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
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
    private JFXTextField txProf;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        seta_comboboxBanco();
        seta_combobox();
        estadoOriginal();
        seta_pesquisa();
    }

    public void seta_combobox(){
    
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

    public void carregaTabela(String filtro){
        
    }
    
    private void estado_edicao(){
        
    }
    
    private void seta_pesquisa(){
        
        txProf.clear();
        txProf.setDisable(true);
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
        
    }
    
    @FXML
    private void evtNovo(ActionEvent event) {
    }

    @FXML
    private void evtDataPesq(MouseEvent event) {
    }

    @FXML
    private void evtInserir(ActionEvent event) {
    }

    @FXML
    private void evtVoltar(ActionEvent event) {
    }

    @FXML
    private void evtCancelarOP(ActionEvent event) {
    }

    @FXML
    private void evtSalvarOp(ActionEvent event) {
    }

    @FXML
    private void evtFiltroComb(ActionEvent event) {
        
        String filtro = cbFiltro.getSelectionModel().getSelectedItem();
        
        if(filtro.contains("Data")){
            
            dtDataInif.setDisable(false);
            dtDataFIMf.setDisable(false);
            txAluno.setDisable(true);
            txProf.setDisable(true);
        }
        else{
                            
            dtDataInif.setDisable(true);
            dtDataFIMf.setDisable(true);
            
            if(filtro.contains("Aluno")){
                
                txAluno.setDisable(false);
                txProf.setDisable(true);
            }
              
        }
    }

    @FXML
    private void evtApagar(ActionEvent event) {
    }

    @FXML
    private void evtAlterar(ActionEvent event) {
    }

    @FXML
    private void evtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtLimpar(ActionEvent event) {
        
        seta_pesquisa();
    }

    @FXML
    private void evTabela(MouseEvent event) {
        
          if(tabela.getSelectionModel().getSelectedIndex()>=0)
        {
           btApagar.setDisable(false);
           btAlterar.setDisable(false);
        }
    }
    
}
