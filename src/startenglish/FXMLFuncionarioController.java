/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.imageio.ImageIO;
import startenglish.db.DAL.DALEndereco;
import startenglish.db.DAL.DALFuncionario;
import startenglish.db.DAL.DALProfessor;
import startenglish.db.Entidades.Endereco;
import startenglish.db.Entidades.Funcionario;
import startenglish.db.Entidades.Professor;
import startenglish.db.util.Banco;
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
                
        tabelaNome.setCellValueFactory(new PropertyValueFactory("Nome"));
        tabelaCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        tabelaEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tabelaTelefone.setCellValueFactory(new PropertyValueFactory("fone"));
        tabelaCheck.setCellValueFactory(new PropertyValueFactory("professor"));
        
        MaskFieldUtil.cepField(txCEP);
        MaskFieldUtil.cpfField(txCpf);
        MaskFieldUtil.foneField(txTelefone);
        
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
        EstadoEdicao();
    }

    @FXML
    private void evtAlterar(ActionEvent event) {
        if(tabela.getSelectionModel().getSelectedIndex() >= 0)
        {
            Funcionario f = (Funcionario)tabela.getSelectionModel().getSelectedItem();
            txIdFunc.setText(""+f.getID());
            txNome.setText(f.getNome());
            txRg.setText(f.getRg());
            txCpf.setText(f.getCpf());
            txEmail.setText(f.getEmail());
            txTelefone.setText(f.getFone());
            txId.setText(""+f.getEndereco().getEnderecoID());
            txRua.setText(f.getEndereco().getRua());
            txNumero.setText(""+f.getEndereco().getNumero());
            txCEP.setText(f.getEndereco().getCEP());
            txBairro.setText(f.getEndereco().getBairro());
            txCidade.setText(f.getEndereco().getCidade());
           
            DALProfessor dale = new DALProfessor();
            Professor p = new Professor();
            
            p = dale.get(f.getID());
            
            if(p != null)
                checkProf.arm();
            else
                checkProf.disarm();
            
            EstadoEdicao();
        }
    }

    @FXML
    private void evtExcluir(ActionEvent event) {
        boolean ok;
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Confirma a exclusão");
        if (a.showAndWait().get() == ButtonType.OK) {
            DALFuncionario dalf = new DALFuncionario();
            DALProfessor dalp = new DALProfessor();
            DALEndereco dale = new DALEndereco();
            Funcionario f;
            f = tabela.getSelectionModel().getSelectedItem();
            a = new Alert(Alert.AlertType.INFORMATION);
            try{

                   Banco.getCon().getConnect().setAutoCommit(false);

                   ok = dalf.apagar(f);

                    if(ok){

                       ok = dale.apagar(f.getEndereco().getEnderecoID());
                       
                       if(ok)
                           ok = dalp.apagar(f.getID());
                       else ok = false;

                    }
                    else
                       ok = false;
              }
              catch(SQLException ex){System.out.println(ex.getMessage()); ok = false;}

             try{

                 if(ok){

                   a = new Alert(Alert.AlertType.CONFIRMATION,"Funcionário excluído!!", ButtonType.OK);
                   Banco.getCon().getConnect().commit();
                } 
                else{
                      a = new Alert(Alert.AlertType.CONFIRMATION,"Problemas ao deletar funcionário!!", ButtonType.OK);
                      Banco.getCon().getConnect().rollback();
                }
             }
             catch(SQLException ex){}
             
            a.showAndWait();
            CarregaTabela("");
        }
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
        int cod,codEnd;
        boolean ok;
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        Endereco end = new Endereco();
        DALEndereco dale = new DALEndereco();
        DALFuncionario dalf = new DALFuncionario();
        DALProfessor dalp = new DALProfessor();
        
        try 
        {
            cod = Integer.parseInt(txIdFunc.getText());
            codEnd = Integer.parseInt(txId.getText());
        } 
        catch (Exception e) 
        {
            cod = 0;
            codEnd = 0;
        }
        
        Funcionario f = new Funcionario();
        f.setID(cod);
        if(!txNome.getText().isEmpty())
            if(!txCpf.getText().isEmpty())
                if(!txCEP.getText().isEmpty())
                {
                    try 
                    {
                        cod = Integer.parseInt(txIdFunc.getText());
                        codEnd = Integer.parseInt(txId.getText());
                    } 
                    catch (Exception e) 
                    {
                        cod = 0;
                        codEnd = 0;
                    }
                    
                    f.setNome(txNome.getText());
                    f.setCpf(txCpf.getText());
                    
                    
                    end.setCEP(txCEP.getText());
                    
                    f.setEndereco(end);
                }
            
            
            
                
        if(checkProf.isArmed())
        {
            Professor p = new Professor();
            p.setFunc(f);
            try{

                   Banco.getCon().getConnect().setAutoCommit(false);

                   ok = dalf.gravar(f);

                    if(ok){

                       ok = dale.gravar(end);
                       
                       if(ok)
                           ok = dalp.gravar(p);
                       else ok = false;

                    }
                    else
                       ok = false;
              }
              catch(SQLException ex){System.out.println(ex.getMessage()); ok = false;}

             try{

                 if(ok){

                   a = new Alert(Alert.AlertType.CONFIRMATION,"Professor salvo!!", ButtonType.OK);
                   Banco.getCon().getConnect().commit();
                } 
                else{
                      a = new Alert(Alert.AlertType.CONFIRMATION,"Problemas ao gravar professor!!", ButtonType.OK);
                      Banco.getCon().getConnect().rollback();
                }
             }
             catch(SQLException ex){}
        }
        else
        {
                try{

                   Banco.getCon().getConnect().setAutoCommit(false);

                   ok = dalf.gravar(f);

                    if(ok){

                       ok = dale.gravar(end);
                    }
                    else
                       ok = false;
              }
              catch(SQLException ex){System.out.println(ex.getMessage()); ok = false;}

             try{

                 if(ok){

                   a = new Alert(Alert.AlertType.CONFIRMATION,"Funcionário excluído!!", ButtonType.OK);
                   Banco.getCon().getConnect().commit();
                } 
                else{
                      a = new Alert(Alert.AlertType.CONFIRMATION,"Problemas ao deletar funcionário!!", ButtonType.OK);
                      Banco.getCon().getConnect().rollback();
                }
             }catch(SQLException ex){}
        }
        
        a.showAndWait();
        CarregaTabela("");
        
    }

    @FXML
    private void evtCancelar(ActionEvent event) {
    }

    @FXML
    private void evtPesquisar(ActionEvent event) {
        CarregaTabela("upper(gar_nome) like '%"+txPesquisa.getText().toUpperCase()+"%'");
    }

    @FXML
    private void evtClicarTabela(MouseEvent event) {
        if(tabela.getSelectionModel().getSelectedIndex()>=0){
            
            btAlterar.setDisable(false);
            btExcluir.setDisable(false);
        }
    }
    
}
