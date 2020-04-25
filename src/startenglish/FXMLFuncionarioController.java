/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALFuncionario;
import startenglish.db.DAL.DALProfessor;
import startenglish.db.Entidades.Funcionario;
import startenglish.db.Entidades.Professor;
import startenglish.util.MaskFieldUtil;

/**
 * FXML Controller class
 *
 * @author azeve
 */
public class FXMLFuncionarioController implements Initializable {

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
    private JFXTextField txNome;
    @FXML
    private JFXTextField txTelefone;
    @FXML
    private JFXTextField txEmail;
    @FXML
    private JFXTextField txRg;
    @FXML
    private JFXTextField txCpf;
    @FXML
    private JFXTextField txRua;
    @FXML
    private JFXTextField txCEP;
    @FXML
    private JFXTextField txId;
    @FXML
    private JFXTextField txBairro;
    @FXML
    private JFXTextField txNumero;
    @FXML
    private JFXTextField txCidade;
    @FXML
    private JFXTextField txIdFunc;
    @FXML
    private CheckBox checkProf;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private TableView<Funcionario> tabela;
    @FXML
    private TableColumn<Funcionario, String> tabelaNome;
    @FXML
    private TableColumn<Funcionario, String> tabelaCPF;
    @FXML
    private TableColumn<Funcionario, String> tabelaTelefone;
    @FXML
    private TableColumn<Funcionario, String> tabelaEmail;
    @FXML
    private TableColumn<Funcionario, Boolean> tabelaCheck;
    @FXML
    private AnchorPane pnBusca;
    @FXML
    private AnchorPane pnDados;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        
        
        MaskFieldUtil.cepField(txCEP);
        MaskFieldUtil.cpfField(txCpf);
        MaskFieldUtil.foneField(txTelefone);
        
    }
    
    private void EstadoOriginal()
    {        
        btNovo.setDisable(false);
        btAlterar.setDisable(true);
        btExcluir.setDisable(true);
        btCancelar.setDisable(false);
        btConfirmar.setDisable(true);
        pnBusca.setDisable(false);
        txPesquisa.clear();
        pnDados.setDisable(true);
        
        
        ObservableList <Node> componentes=pnDados.getChildren(); //”limpa” os componentes
        for(Node n : componentes)
        {
            if (n instanceof TextInputControl)  // textfield, textarea e htmleditor
                ((TextInputControl)n).setText("");
            if(n instanceof ComboBox)
                ((ComboBox)n).getItems().clear();
        }
      
        CarregaTabela("");
    }
    
    private void EstadoEdicao()
    {
        pnBusca.setDisable(true);
        pnDados.setDisable(false);
        btConfirmar.setDisable(false);
        btExcluir.setDisable(true);
        btAlterar.setDisable(true);
        txPesquisa.clear();
        txNome.requestFocus();
        
    }
    
    private void CarregaTabela(String filtro)
    {
        DALFuncionario dalF = new DALFuncionario();
        DALProfessor dalP = new DALProfessor();
        Professor prof = new Professor();
        
        List <Funcionario> listaFunc = dalF.get(filtro);
        
        for (int i = 0; i < listaFunc.size() ; i++) {
            prof = dalP.get(listaFunc.get(i).getID());
            if(prof != null)
                listaFunc.get(i).setProfessor(Boolean.TRUE);
            else
                listaFunc.get(i).setProfessor(Boolean.FALSE);
            
        }
        ObservableList <Funcionario> modelo;
        modelo = FXCollections.observableArrayList(listaFunc);
        
        tabela.setItems(modelo);
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
    private void evtPesquisar(ActionEvent event) {
    }
    
}
