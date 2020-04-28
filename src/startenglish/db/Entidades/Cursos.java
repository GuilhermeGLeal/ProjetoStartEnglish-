package startenglish.db.Entidades;

import java.util.Date;


public class Cursos {
    
    private int CursoID;
    private String etapa;
    private Date data_lancamento;
    private Date data_encerramento;
    private String nomeCurso;
    private String descricao;
    private double preco;

    public Cursos(int CursoID, String etapa, Date data_lancamento, Date data_encerramento, String nomeCurso, String descricao, double preco) {
        this.CursoID = CursoID;
        this.etapa = etapa;
        this.data_lancamento = data_lancamento;
        this.data_encerramento = data_encerramento;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Cursos(String etapa, Date data_lancamento, Date data_encerramento, String nomeCurso, String descricao, double preco) {
        this.etapa = etapa;
        this.data_lancamento = data_lancamento;
        this.data_encerramento = data_encerramento;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.preco = preco;
    }

   
    public Cursos() {
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public Date getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(Date data_encerramento) {
        this.data_encerramento = data_encerramento;
    }

    
    
    public int getCursoID() {
        return CursoID;
    }

    public void setCursoID(int CursoID) {
        this.CursoID = CursoID;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
