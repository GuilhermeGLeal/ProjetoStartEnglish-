/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALFuncionario;
import startenglish.db.Entidades.Funcionario;
import startenglish.db.Entidades.Login;
import startenglish.util.MaskFieldUtil;

/**
 * FXML Controller class
 *
 * @author azeve
 */
public class FXMLControleLoginController implements Initializable {

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
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txUsuario;
    @FXML
    private JFXTextField txStatus;
    @FXML
    private JFXPasswordField txSenha;
    @FXML
    private JFXComboBox<Funcionario> cbFuncionario;
    @FXML
    private AnchorPane pnBusca;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private TableView<Login> tabela;
    @FXML
    private TableColumn<Login, String> tabelaUser;
    @FXML
    private TableColumn<Login, String> tabelaSenha;
    @FXML
    private TableColumn<Login, String> tabelaStatus;
    @FXML
    private TableColumn<Login, Integer> tabelaNivel;
    @FXML
    private TableColumn<Login, String> tabelaNome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          tabelaUser.setCellFactory(new PropertyValueFactory("usuario"));
          tabelaSenha.setCellFactory(new PropertyValueFactory("senha"));
          tabelaStatus.setCellFactory(new PropertyValueFactory("status"));
          tabelaNivel.setCellFactory(new PropertyValueFactory("nivel"));
          tabelaNome.setCellFactory(new PropertyValueFactory("funcionario"));
          
        try {
           DALFuncionario dale = new DALFuncionario();
           ObservableList<Funcionario> modelo = FXCollections.observableArrayList(dale.get(""));
           
           cbFuncionario.setItems(modelo);
           
        } catch (Exception e) {
        }
         
          
          MaskFieldUtil.maxField(txUsuario, 20);
          MaskFieldUtil.maxField(txSenha, 10);
          MaskFieldUtil.maxField(txStatus, 1);
         
       
        EstadoOriginal();
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
      
        //CarregaTabela("");
    }
    
    private void EstadoEdicao()
    {
        pnBusca.setDisable(true);
        pnDados.setDisable(false);
        btConfirmar.setDisable(false);
        btExcluir.setDisable(true);
        btAlterar.setDisable(true);
        txPesquisa.clear();
        txUsuario.requestFocus();
        
    }
    
    private void CarregaTabela(String filtro)
    {
        
        
//        DALFuncionario dalF = new DALFuncionario();
//        DALProfessor dalP = new DALProfessor();
//        Professor prof = new Professor();
//        
//        List <Funcionario> listaFunc = dalF.get(filtro);
//        
//        for (int i = 0; i < listaFunc.size() ; i++) {
//            prof = dalP.get(listaFunc.get(i).getID());
//            if(prof != null)
//                listaFunc.get(i).setProfessor(Boolean.TRUE);
//            else
//                listaFunc.get(i).setProfessor(Boolean.FALSE);
//            
//        }
//        ObservableList <Funcionario> modelo;
//        modelo = FXCollections.observableArrayList(listaFunc);
//        
//        tabela.setItems(modelo);
    }

    @FXML
    private void evtNovo(ActionEvent event) {
        EstadoEdicao();
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
    private void evtClicarTabela(MouseEvent event) {
    }
    
}
