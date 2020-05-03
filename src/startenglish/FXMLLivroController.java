
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALFuncionario;
import startenglish.db.DAL.DALLivro;
import startenglish.db.DAL.DALProfessor;
import startenglish.db.Entidades.Funcionario;
import startenglish.db.Entidades.Livro;
import startenglish.db.Entidades.Professor;
import startenglish.util.MaskFieldUtil;

public class FXMLLivroController implements Initializable {

    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private TableView<Livro> tabela;
    @FXML
    private TableColumn<Livro,String> tabelaNome;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXTextField txID;
    @FXML
    private TableColumn<Livro, Double> tabelaValor;
    @FXML
    private JFXTextField txEditora;
    @FXML
    private JFXTextField txVolume;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private TableColumn<Livro,String> tabelaEditora;
    @FXML
    private TableColumn<Livro,String> tabelaVolume;
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
    private AnchorPane pnbusca;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        tabelaNome.setCellValueFactory(new PropertyValueFactory("Nome"));
        tabelaValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tabelaEditora.setCellValueFactory(new PropertyValueFactory("editora"));
        tabelaVolume.setCellValueFactory(new PropertyValueFactory("volume"));
        
        MaskFieldUtil.maxField(txEditora, 25);
        MaskFieldUtil.maxField(txVolume, 5);
        MaskFieldUtil.maxField(txNome, 30);
        MaskFieldUtil.numericField(txValor);    
        
        List<String> combo = new ArrayList();
        combo.add("Nome");
        combo.add("Editora");
        
        ObservableList<String> modelo = FXCollections.observableArrayList(combo);
        cbFiltro.setItems(modelo);
        cbFiltro.setValue("Nome");
        
        EstadoOriginal();
    }    
    private void EstadoOriginal()
    {        
        btNovo.setDisable(false);
        btAlterar.setDisable(true);
        btExcluir.setDisable(true);
        btCancelar.setDisable(false);
        btConfirmar.setDisable(true);
        txPesquisa.clear();
        pndados.setDisable(true);
        ObservableList <Node> componentes=pndados.getChildren(); //”limpa” os componentes
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
        pnbusca.setDisable(true);
        pndados.setDisable(false);
        btConfirmar.setDisable(false);
        btExcluir.setDisable(true);
        btAlterar.setDisable(true);
        txPesquisa.clear();
        txNome.requestFocus();
        
    }
    
    private void CarregaTabela(String filtro)
    {
        DALLivro dalL = new DALLivro();       
        List <Livro> listaLivro = dalL.get(filtro);
        listaLivro = dalL.get(filtro);           
        ObservableList <Livro> modelo;
        modelo = FXCollections.observableArrayList(listaLivro);       
        tabela.setItems(modelo);
    }

    private boolean validaPrecoTam(String preco)
    {      
        boolean ok = false;
        int i;
        
        for (i = 0;  i<preco.length() && preco.charAt(i) != '.' ; i++){}
            
        
        if(i <=4 )
            ok = true;
        
        return ok;
    }
    
    /*private boolean validaPreco(String preco)
    {       
        double preco_inserido = 0;
        Alert a = null;
        boolean ok = true,problema = false,tamanho = true;
        
        try{
            
            preco_inserido = Double.parseDouble(preco);
            tamanho = validaPrecoTam(preco);
            
        }catch(NumberFormatException ex){problema = true;}
        
        if(preco.isEmpty())
        {           
            ok = false;
            setTextFieldErro(txValor);
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
        else if(!tamanho){
            
            ok = false;
            setTextFieldErro(txPreco);
            a = new Alert(Alert.AlertType.WARNING, "É permitido apenas 4 digitos antes da casa decimal!", ButtonType.CLOSE);
            txPreco.requestFocus();
            
        }
        else
            setTextFieldnormal(txPreco);
        
        if(a != null)
               a.showAndWait();
        return ok;
    }*/
    
    @FXML
    private void evtNovo(ActionEvent event) 
    {
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
}
