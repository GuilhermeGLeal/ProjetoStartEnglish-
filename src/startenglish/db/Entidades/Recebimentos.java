package startenglish.db.Entidades;

import java.time.LocalDate;


public class Recebimentos {
    
    private int recebimentoid;
    private Caixa caixa;
    private Matricula mat;
    private LocalDate dtvencimento;
    private LocalDate dtreceb;
    private LocalDate dtemissoa;
    private double valor;
    private double valorpago;
    private String pago;

    public Recebimentos(int recebimentoid, Caixa caixa, Matricula mat, LocalDate dtvencimento, LocalDate dtreceb, LocalDate dtemissoa, double valor, double valorpago) {
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
        else
            this.pago = "Não Pago";
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
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

    public LocalDate getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(LocalDate dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public LocalDate getDtreceb() {
        return dtreceb;
    }

    public void setDtreceb(LocalDate dtreceb) {
        this.dtreceb = dtreceb;
    }

    public LocalDate getDtemissoa() {
        return dtemissoa;
    }

    public void setDtemissoa(LocalDate dtemissoa) {
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
