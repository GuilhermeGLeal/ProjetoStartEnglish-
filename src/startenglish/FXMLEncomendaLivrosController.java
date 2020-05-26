/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startenglish;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import startenglish.db.DAL.DALFuncionario;
import startenglish.db.DAL.DALLivro;
import startenglish.db.Entidades.EncomendaDeLivros;
import startenglish.db.Entidades.Funcionario;
import startenglish.db.Entidades.ItemEncomenda;
import startenglish.db.Entidades.Livro;
import startenglish.util.MaskFieldUtil;

/**
 * FXML Controller class
 *
 * @author azeve
 */
public class FXMLEncomendaLivrosController implements Initializable {

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
    private AnchorPane pndados;
    @FXML
    private JFXTextField txtID;
    @FXML
    private ComboBox<Funcionario> cbFuncionario;
    @FXML
    private JFXDatePicker dtPEncomenda;
    @FXML
    private JFXDatePicker dtPPrevisao;
    @FXML
    private JFXTextField txtFornecedor;
    @FXML
    private JFXTextField txtValorTotal;
    @FXML
    private TableView<ItemEncomenda> tabelaItens;
    @FXML
    private TableColumn<ItemEncomenda, Livro> tbItensLivro;
    @FXML
    private TableColumn<ItemEncomenda, Integer> tbItensQtd;
    @FXML
    private TableColumn<ItemEncomenda, Double> tbItensValor;
    @FXML
    private ComboBox<Livro> cbLivro;
    @FXML
    private JFXTextField txtValorUni;
    @FXML
    private JFXButton btAdicionar;
    @FXML
    private JFXTextField txtQtd;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXDatePicker dtpdataini;
    @FXML
    private JFXDatePicker dtpdatafim;
    @FXML
    private JFXComboBox<String> comboBox;
    @FXML
    private JFXButton btPesquisar;
    @FXML
    private TableView<EncomendaDeLivros> tabela;
    @FXML
    private TableColumn<EncomendaDeLivros, Integer> tabelaID;
    @FXML
    private TableColumn<EncomendaDeLivros, String> tabelaFornecedor;
    @FXML
    private TableColumn<EncomendaDeLivros, Funcionario> tabelaFuncionario;
    @FXML
    private TableColumn<EncomendaDeLivros, Date> tabelaDataEncomenda;
    @FXML
    private TableColumn<EncomendaDeLivros, Double> tabelaValor;
    @FXML
    private JFXButton btRemover;
    @FXML
    private TableColumn<EncomendaDeLivros, Date> tabelaPrevisao;
    
    private List<ItemEncomenda> listaItens;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setaComponentes();
        seta_combobox();
        
    }
    
    private void setaComponentes()
    {
        tbItensLivro.setCellValueFactory(new PropertyValueFactory("livro"));
        tbItensQtd.setCellValueFactory(new PropertyValueFactory("quantidade"));
        tbItensValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tabelaID.setCellValueFactory(new PropertyValueFactory("codigoEnc"));
        tabelaFornecedor.setCellValueFactory(new PropertyValueFactory("fornecedor"));
        tabelaFuncionario.setCellValueFactory(new PropertyValueFactory("func"));
        tabelaDataEncomenda.setCellValueFactory(new PropertyValueFactory("dataEncomenda"));
        tabelaPrevisao.setCellValueFactory(new PropertyValueFactory("previsaoEntrega"));
        tabelaValor.setCellValueFactory(new PropertyValueFactory("valor"));
        
        
        
        MaskFieldUtil.maxField(txtFornecedor, 30);
        //MaskFieldUtil.monetaryField(txtValorTotal);
        //MaskFieldUtil.monetaryField(txtValorUni);
        
    }
    
    private void seta_combobox()
    {
        List<String> listaPesquisa = new ArrayList<>();
        listaPesquisa.add("Usuario");
        listaPesquisa.add("Status");
        
        comboBox.setItems(FXCollections.observableArrayList(listaPesquisa));
        
        List<String> listaAux = new ArrayList<>();
        listaAux.add("Ativo");
        listaAux.add("Inativo");
        
           
           DALFuncionario dale = new DALFuncionario();
           List<Funcionario> lista = dale.get("");           
        
           ObservableList<Funcionario> modelo = FXCollections.observableArrayList(lista);
           cbFuncionario.setItems(modelo);
           
           DALLivro dall = new DALLivro();
           List<Livro> lista2 = dall.get("");           
        
           ObservableList<Livro> modelo2 = FXCollections.observableArrayList(lista2);
           
           cbLivro.setItems(modelo2);                   
        
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
      
        //CarregaTabela("");
    }
    private void EstadoEdicao()
    {
        pndados.setDisable(false);
        btConfirmar.setDisable(false);
        btExcluir.setDisable(true);
        btAlterar.setDisable(true);
        txPesquisa.clear();
        cbLivro.requestFocus();
        
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
    private void evtClickTabela(MouseEvent event) {
    }

    @FXML
    private void evtPesquisa(ActionEvent event) {
    }

    @FXML
    private void evtComboBox(ActionEvent event) {
    }

    @FXML
    private void evtLimparFiltros(ActionEvent event) {
    }

    @FXML
    private void evtSelLivro(ActionEvent event) {
        Livro livroaux = cbLivro.getSelectionModel().getSelectedItem();
        
        txtValorUni.setText(""+livroaux.getValor());
        txtFornecedor.setText(livroaux.getEditora());
    }

    @FXML
    private void evtAdd(ActionEvent event) {
        ItemEncomenda item = new ItemEncomenda();
        item.setLivro(cbLivro.getValue());
        item.setQuantidade(Integer.parseInt(txtQtd.getText()));
        item.setValor(item.getQuantidade()*item.getLivro().getValor());
        
        if(listaItens.isEmpty())
        {
           listaItens.add(item); 
        }
        else{
            int flag = -1;
            for (int i = 0; i < listaItens.size()&& flag == -1; i++) 
                if(listaItens.get(i).getLivro().equals(item.getLivro()))
                    flag=i;
            if(flag != -1)
                listaItens.get(flag).setQuantidade(listaItens.get(flag).getQuantidade()+Integer.parseInt(txtQtd.getText()));
            else
                listaItens.add(item);
        }
        tabelaItens.setItems(FXCollections.observableArrayList(listaItens));
    }

    @FXML
    private void evtRemove(ActionEvent event) {
    }
    
}
