package startenglish.db.Entidades;


public class Cursos {
    
    private int CursoID;
    private char Ativo;
    private String nomeCurso;
    private String descricao;
    private double preco;

    public Cursos(int CursoID, char Ativo, String nomeCurso, String descricao, double preco) {
        this.CursoID = CursoID;
        this.Ativo = Ativo;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Cursos(char Ativo, String nomeCurso, String descricao, double preco) {
        this.Ativo = Ativo;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Cursos() {
    }

    
    
    public int getCursoID() {
        return CursoID;
    }

    public void setCursoID(int CursoID) {
        this.CursoID = CursoID;
    }

    public char getAtivo() {
        return Ativo;
    }

    public void setAtivo(char Ativo) {
        this.Ativo = Ativo;
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
