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
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
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
    @FXML
    private JFXCheckBox checkVerif;
  
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
        
        List<Livro> comboLivros = new ArrayList();
        DALLivro liv = new DALLivro();
        comboLivros=liv.get("");
        ObservableList<Livro> modeloLiv = FXCollections.observableArrayList(comboLivros);
        cbLivro.setItems(modeloLiv);
        cbLivro.getSelectionModel().selectFirst();
        EstadoOriginal();
    }    
    
    private void EstadoOriginal()
    {
        cbAluno.setDisable(true);
        txEmail.setDisable(true);
        txCPF.setDisable(true);
        txNomeResp.setDisable(true);
        txEscola.setDisable(true);
        txNivel.setDisable(true);
        txHorIni.setDisable(true);
        txHorFim.setDisable(true);
        txValor.setDisable(true);
        txDesconto.setDisable(true);
        txCausa.setDisable(true);
        cbLivro.setDisable(true);
        cbParcelas.setDisable(true);
        cbVencimentos.setDisable(true);
        checkAtivo.setDisable(true);
        checkSegunda.setDisable(true);
        checkTerca.setDisable(true);
        checkQuarta.setDisable(true);
        checkQuinta.setDisable(true);
        checkSexta.setDisable(true);
        checkSabado.setDisable(true);
        checkDomingo.setDisable(true);       
        checkAtivo.setSelected(false);
        checkSegunda.setSelected(false);
        checkTerca.setSelected(false);
        checkQuarta.setSelected(false);
        checkQuinta.setSelected(false);
        checkSexta.setSelected(false);
        checkSabado.setSelected(false);
        checkDomingo.setSelected(false);
        checkVerif.setSelected(false);
        btVerificar.setDisable(true);
        btGerar.setDisable(true);
        btInserir.setDisable(false);
        btAlterar.setDisable(true);
        btExcluir.setDisable(true);
        btCancelar.setDisable(false);
        btConfirmar.setDisable(true);
        txPesquisa.clear();
        cbFiltro.setDisable(true);
        ObservableList <Node> componentes=pndados.getChildren();
        for(Node n : componentes)
        {
            if (n instanceof TextInputControl)  // textfield, textarea e htmleditor
                ((TextInputControl)n).setText("");
        }
    }
    private void EstadoEdicao()
    {
        cbAluno.setDisable(false);
        cbLivro.setDisable(false);
        txNomeResp.setDisable(false);
        txEscola.setDisable(false);
        txHorIni.setDisable(false);
        txHorFim.setDisable(false);
        txNivel.setDisable(false);
        checkAtivo.setDisable(false);
        checkSegunda.setDisable(false);
        checkTerca.setDisable(false);
        checkQuarta.setDisable(false);
        checkQuinta.setDisable(false);
        checkSexta.setDisable(false);
        checkSabado.setDisable(false);
        checkDomingo.setDisable(false);
        btInserir.setDisable(true);
        btAlterar.setDisable(true);
        btExcluir.setDisable(true);
        btCancelar.setDisable(false);
        btConfirmar.setDisable(false);
        txValor.setDisable(false);
        txDesconto.setDisable(false);
        btVerificar.setDisable(false);
        btGerar.setDisable(false);
    }
    
    @FXML
    private void evtInserir(ActionEvent event) 
    {
        EstadoEdicao();
        checkAtivo.setSelected(true);
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
    private void evtClickTabela(MouseEvent event) 
    {
        if(tabela.getSelectionModel().getSelectedIndex()>=0)
        {
           btAlterar.setDisable(false);
           btExcluir.setDisable(false);
        }
    }

    @FXML
    private void notVerifica(ActionEvent event) 
    {
        checkVerif.setSelected(false);
    }

    @FXML
    private void notVerifica(InputMethodEvent event) 
    {
        checkVerif.setSelected(false);
    }

    @FXML
    private void evtPreenche(ActionEvent event)
    {
        txCPF.setText(cbAluno.getSelectionModel().getSelectedItem().getCpf());
        txEmail.setText(cbAluno.getSelectionModel().getSelectedItem().getEmail());
    }
    
}
