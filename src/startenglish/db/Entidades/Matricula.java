package startenglish.db.Entidades;


public class Matricula 
{
    
    private int nummat;
    private Livro livro;
    private int turmaID;
    private Aluno aluno;
    private char ativo;
    private double valor;

    public Matricula() 
    {
        
    }

    public Matricula(int nummat, Livro livro, int turmaID, Aluno aluno, char ativo, double valor) {
        this.nummat = nummat;
        this.livro = livro;
        this.turmaID = turmaID;
        this.aluno = aluno;
        this.ativo = ativo;
        this.valor = valor;
    }
    
    public int getNummat() {
        return nummat;
    }

    public void setNummat(int nummat) {
        this.nummat = nummat;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getTurmaID() {
        return turmaID;
    }

    public void setTurmaID(int turmaID) {
        this.turmaID = turmaID;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
