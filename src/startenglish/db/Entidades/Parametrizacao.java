package startenglish.db.Entidades;


public class Parametrizacao {
    
    private String nome;
    private String telefone;
    private String email;
    private String RazaoSocial;
    private Endereco endereco;

    public Parametrizacao(String nome, String telefone, String email, String RazaoSocial, Endereco endereco) {
        
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.RazaoSocial = RazaoSocial;
        this.endereco = endereco;
    }

    private Parametrizacao(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
