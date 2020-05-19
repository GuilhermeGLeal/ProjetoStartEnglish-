package startenglish.db.Entidades;

import java.util.Date;


public class Recebimentos {
    
    private int recebimentoid;
    private Caixa caixa;
    private Matricula mat;
    private Date dtvencimento;
    private Date dtreceb;
    private Date dtemissoa;
    private double valor;
    private double valorpago;
    private String pago;

    public Recebimentos(int recebimentoid, Caixa caixa, Matricula mat, Date dtvencimento, Date dtreceb, Date dtemissoa, double valor, double valorpago) {
        this.recebimentoid = recebimentoid;
        this.caixa = caixa;
        this.mat = mat;
        this.dtvencimento = dtvencimento;
        this.dtreceb = dtreceb;
        this.dtemissoa = dtemissoa;
        this.valor = valor;
        this.valorpago = valorpago;
        if(valorpago > 0 )
            this.pago = "Pago";
    }

    public Recebimentos() {
        
        this(0,new Caixa(),new Matricula(),null,null,null,0.0,0.0);
        this.pago = "Não pago";
    }

    public int getRecebimentoid() {
        return recebimentoid;
    }

    public void setRecebimentoid(int recebimentoid) {
        this.recebimentoid = recebimentoid;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Matricula getMat() {
        return mat;
    }

    public void setMat(Matricula mat) {
        this.mat = mat;
    }

    public Date getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(Date dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public Date getDtreceb() {
        return dtreceb;
    }

    public void setDtreceb(Date dtreceb) {
        this.dtreceb = dtreceb;
    }

    public Date getDtemissoa() {
        return dtemissoa;
    }

    public void setDtemissoa(Date dtemissoa) {
        this.dtemissoa = dtemissoa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }
    
    

   
    
}
