package startenglish.db.Entidades;

public class Aluno {
    private int ID;
    private Endereco endereco;
    private Agenda agenda;
    private String rg;
    private String cpf;
    private String email;
    private String nome;
    private String fone;
    private char SituacaoProva;
    private double notaProva;

    public Aluno(int ID, Endereco endereco, Agenda agenda, String rg, String cpf, String email, String nome, String fone, char SituacaoProva, double notaProva) {
        this.ID = ID;
        this.endereco = endereco;
        this.agenda = agenda;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.fone = fone;
        this.SituacaoProva = SituacaoProva;
        this.notaProva = notaProva;
    }

    public Aluno(Endereco endereco, Agenda agenda, String rg, String cpf, String email, String nome, String fone, char SituacaoProva, double notaProva) {
        this.endereco = endereco;
        this.agenda = agenda;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.fone = fone;
        this.SituacaoProva = SituacaoProva;
        this.notaProva = notaProva;
    }

    public Aluno() {
    }
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public char getSituacaoProva() {
        return SituacaoProva;
    }

    public void setSituacaoProva(char SituacaoProva) {
        this.SituacaoProva = SituacaoProva;
    }

    public double getNotaProva() {
        return notaProva;
    }

    public void setNotaProva(double notaProva) {
        this.notaProva = notaProva;
    }
    
    
    
}
