package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private JFXCheckBox checkAtivo;
    @FXML
    private TableColumn<Cursos, String> tabelaNomeCurso;
    @FXML
    private TableColumn<Cursos, Double> tabelaPreco;
    @FXML
    private TableColumn<Cursos, Character> tabelaAtivo;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tabelaNomeCurso.setCellValueFactory(new PropertyValueFactory("nomeCurso"));
        tabelaPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        tabelaAtivo.setCellValueFactory(new PropertyValueFactory("Ativo"));
        
        MaskFieldUtil.maxField(txNomeCurso, 20);
        MaskFieldUtil.maxField(txDescricao, 50);
        MaskFieldUtil.numericField(txPreco);
        MaskFieldUtil.maxField(txPreco, 10);
                
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
     
        pnpesquisa.setDisable(true);
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
      
        carregaTabela("");
    }
    
    private void estadoedicao(){
        
        pnpesquisa.setDisable(false);
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
            if(c.getAtivo()=='S')
                checkAtivo.setSelected(true);
            else
               checkAtivo.setSelected(false); 
            
            txDescricao.setText(c.getDescricao());
            txPreco.setText(""+c.getPreco());
            
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
            
            carregaTabela("");
        }
    }

    @FXML
    private void evtConfirmar(ActionEvent event) {
             
        double preco = 0;
        int cod;
        boolean ok = true;
        
        if(!txNomeCurso.getText().isEmpty()){
            
           try{
               
               preco = Double.parseDouble(txPreco.getText());
               
               if(preco > 0){
                   
                try{

                    cod = Integer.parseInt(txId.getText());

                }catch(NumberFormatException ex){cod = 0;}

                 DALCurso dalc = new DALCurso();
                 Cursos c = new Cursos();

                 c.setCursoID(cod);
                 c.setNomeCurso(txNomeCurso.getText());
                 c.setPreco(preco);

                 if(checkAtivo.isSelected())
                     c.setAtivo('S');
                 else
                     c.setAtivo('N');

                 if(!txDescricao.getText().isEmpty())
                     c.setDescricao(txDescricao.getText());
                 
                 Alert a = null;
                 try{
                     
                     Banco.getCon().getConnect().setAutoCommit(false);
                     
                     if(cod == 0){ // inserindo
                         
                        ok = dalc.gravar(c);
                        
                        if(ok)
                            a = new Alert(Alert.AlertType.CONFIRMATION,"Curso inserido!!", ButtonType.OK); 
                        else
                            a = new Alert(Alert.AlertType.ERROR,"Problemas ao inserir o curso!!", ButtonType.OK);  
                        
                     }
                     else{ // alterando
                         
                         ok = dalc.alterar(c);
                                                       
                        if(ok)
                            a = new Alert(Alert.AlertType.CONFIRMATION,"Curso atualizado!!", ButtonType.OK); 
                        else
                            a = new Alert(Alert.AlertType.ERROR,"Problemas ao atualizar o curso!!", ButtonType.OK);  
                         
                     }
                     
                    
                    a.showAndWait();
                     if(ok){
                         
                        Banco.getCon().getConnect().commit();
                        estadoOriginal();
                        carregaTabela("");
                     }
                     else
                        Banco.getCon().getConnect().rollback();
                         
                                         
                     
                 }catch(SQLException ex){System.out.println(ex.getMessage());}
               }
               else{
                   
                   Alert a = new Alert(Alert.AlertType.WARNING, "Preço igual a zero!!", ButtonType.CLOSE);
                   txPreco.requestFocus();
                   a.showAndWait();
               }
              
               
           }catch(NumberFormatException ex){
               
                Alert a = new Alert(Alert.AlertType.WARNING, "Preço obrigatório!!", ButtonType.CLOSE);
                txPreco.requestFocus();
                a.showAndWait();
           }
           
        }
        else{
            
            Alert a = new Alert(Alert.AlertType.WARNING, "Nome do curso obrigatório!!", ButtonType.CLOSE);
            txNomeCurso.requestFocus();
            a.showAndWait();
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
    
}
