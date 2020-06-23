package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALAluno;
import startenglish.db.DAL.DALLivro;
import startenglish.db.Entidades.Aluno;
import startenglish.db.Entidades.Livro;
import startenglish.db.Entidades.Matricula;
import startenglish.db.Entidades.Turma;
import startenglish.util.MaskFieldUtil;

public class FXMLMatriculaController implements Initializable 
{

    @FXML
    private AnchorPane pndados;
    @FXML
    private JFXTextField txHorIni;
    @FXML
    private JFXTextField txHorFim;
    @FXML
    private JFXButton btInserir;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXButton btExcluir;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXCheckBox checkSegunda;
    @FXML
    private JFXCheckBox checkDomingo;
    @FXML
    private JFXCheckBox checkSabado;
    @FXML
    private JFXCheckBox checkSexta;
    @FXML
    private JFXCheckBox checkQuinta;
    @FXML
    private JFXCheckBox checkQuarta;
    @FXML
    private JFXCheckBox checkTerca;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private TableView<Matricula> tabela;
    @FXML
    private TableColumn<Matricula, String> tabelaTurma;
    @FXML
    private TableColumn<Matricula, String> tabelaAtivo;
    @FXML
    private JFXTextField txNumMatricula;
    @FXML
    private JFXComboBox<Aluno> cbAluno;
    @FXML
    private JFXTextField txCPF;
    @FXML
    private JFXTextField txNomeResp;
    @FXML
    private JFXTextField txEscola;
    @FXML
    private JFXTextField txEmail;
    @FXML
    private JFXTextField txNivel;
    @FXML
    private JFXCheckBox checkAtivo;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXTextField txDesconto;
    @FXML
    private JFXComboBox<String> cbParcelas;
    @FXML
    private JFXComboBox<String> cbVencimentos;
    @FXML
    private JFXComboBox<Livro> cbLivro;
    @FXML
    private JFXButton btGerar;
    @FXML
    private JFXButton btVerificar;
    @FXML
    private TableColumn<Matricula, String> tabelaAluno;
    @FXML
    private TableColumn<Matricula, String> tabelaEmail;
    @FXML
    private TableColumn<Matricula, String> tabelaCPF;
    @FXML
    private TableColumn<Matricula, String> tabelaNivel;
    @FXML
    private JFXComboBox<Turma> cbTurma;
    @FXML
    private JFXTextField txCausa;
    @FXML
    private JFXCheckBox checkAtivoPesq;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       tabelaAluno.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAluno().getNome()));
       tabelaEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAluno().getEmail()));
       tabelaCPF.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAluno().getCpf()));
       tabelaNivel.setCellValueFactory(new PropertyValueFactory("nivel"));
       tabelaTurma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTurmaID().getNome()));
       tabelaAtivo.setCellValueFactory(new PropertyValueFactory("ativo"));
       
       MaskFieldUtil.maxField(txNomeResp,29);
       MaskFieldUtil.maxField(txEscola,50);
       MaskFieldUtil.maxField(txNivel,15);
       MaskFieldUtil.maxField(txHorIni,5);
       MaskFieldUtil.maxField(txHorFim,5);
       MaskFieldUtil.monetaryField(txValor);
       MaskFieldUtil.numericField(txDesconto);
       MaskFieldUtil.maxField(txCausa,255);
       MaskFieldUtil.maxField(txPesquisa,29);
       
       List<String> combo = new ArrayList();
        combo.add("Aluno");
        combo.add("CPF");
        combo.add("Nível");
        
        ObservableList<String> modelo = FXCollections.observableArrayList(combo);
        cbFiltro.setItems(modelo);
        cbFiltro.setValue("Turma");
        
        List<Aluno> comboAlunos = new ArrayList();
        DALAluno prof = new DALAluno();
        comboAlunos=prof.get("");
        ObservableList<Aluno> modeloAlu = FXCollections.observableArrayList(comboAlunos);
        cbAluno.setItems(modeloAlu);
        cbAluno.getSelectionModel().selectFirst();
        
        List<Livro> comboLivros = new ArrayList();
        DALLivro liv = new DALLivro();
        comboLivros=liv.get("");
        ObservableList<Livro> modeloLiv = FXCollections.observableArrayList(comboLivros);
        cbLivro.setItems(modeloLiv);
        cbLivro.getSelectionModel().selectFirst();
    }    

    @FXML
    private void evtInserir(ActionEvent event) {
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
    private void evtPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtFiltroTxt(ActionEvent event) {
    }

    @FXML
    private void evtClickTabela(MouseEvent event) {
    }

    @FXML
    private void notVerifica(ActionEvent event) {
    }

    @FXML
    private void notVerifica(InputMethodEvent event) {
    }
    
}
