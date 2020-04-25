package startenglish.db.Entidades;


public class Livro 
{
    private int LivroID;
    private String Nome;
    private double valor;

    public Livro(int LivroID, String Nome, double valor) {
        this.LivroID = LivroID;
        this.Nome = Nome;
        this.valor = valor;
    }

    public Livro(String Nome, double valor) {
        this.Nome = Nome;
        this.valor = valor;
    }

    public Livro() {
    }

    
    public int getLivroID() {
        return LivroID;
    }

    public void setLivroID(int LivroID) {
        this.LivroID = LivroID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
