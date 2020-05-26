package startenglish.db.Entidades;

import java.util.Date;
import java.util.List;

public class EncomendaDeLivros {
    
    
    private int codigoEnc;
    private Funcionario func;
    private Date dataEncomenda;
    private String fornecedor;
    private double valor;
    private Date previsaoEntrega;
    private List<ItemEncomenda> itens;

    public EncomendaDeLivros() {
    }

    public EncomendaDeLivros(int codigoEnc, Funcionario func, Date dataEncomenda, String fornecedor, double valor, Date previsaoEntrega, List<ItemEncomenda> itens) {
        this.codigoEnc = codigoEnc;
        this.func = func;
        this.dataEncomenda = dataEncomenda;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.previsaoEntrega = previsaoEntrega;
        this.itens = itens;
    }

    public int getCodigoEnc() {
        return codigoEnc;
    }

    public void setCodigoEnc(int codigoEnc) {
        this.codigoEnc = codigoEnc;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

    public Date getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(Date dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public List<ItemEncomenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemEncomenda> itens) {
        this.itens = itens;
    }
    
    
}
