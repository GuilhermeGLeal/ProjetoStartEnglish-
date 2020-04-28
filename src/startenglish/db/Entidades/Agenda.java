package startenglish.db.Entidades;

import java.util.Date;


public class Agenda {
    
    private int ID;
    private Professor professor;
    private Aluno aluno;
    private Date dataProva;
    private String horario;
    private String local;
    private char situacao_prova;
    private double nota;

    public Agenda(int ID, Professor professor, Aluno aluno, Date dataProva, String horario, String local, char situacao_prova, double nota) {
        this.ID = ID;
        this.professor = professor;
        this.aluno = aluno;
        this.dataProva = dataProva;
        this.horario = horario;
        this.local = local;
        this.situacao_prova = situacao_prova;
        this.nota = nota;
    }

    public Agenda(Professor professor, Aluno aluno, Date dataProva, String horario, String local, char situacao_prova, double nota) {
        this.professor = professor;
        this.aluno = aluno;
        this.dataProva = dataProva;
        this.horario = horario;
        this.local = local;
        this.situacao_prova = situacao_prova;
        this.nota = nota;
    }

    public Agenda() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public char getSituacao_prova() {
        return situacao_prova;
    }

    public void setSituacao_prova(char situacao_prova) {
        this.situacao_prova = situacao_prova;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    

   
}
