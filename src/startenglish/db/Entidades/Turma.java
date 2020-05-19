
package startenglish.db.Entidades;

import java.util.Date;

public class Turma 
{
    private int turmaID;
    private Professor prof;
    private Cursos cur;
    private String horario;
    private Date ano;
    private char ativo;
    private String semana;
    private int qtdvagas;

    public int getTurmaID() {
        return turmaID;
    }

    public void setTurmaID(int turmaID) {
        this.turmaID = turmaID;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public Cursos getCur() {
        return cur;
    }

    public void setCur(Cursos cur) {
        this.cur = cur;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public int getQtdvagas() {
        return qtdvagas;
    }

    public void setQtdvagas(int qtdvagas) {
        this.qtdvagas = qtdvagas;
    }

    public Turma(int turmaID, Professor prof, Cursos cur, String horario, Date ano, char ativo, String semana, int qtdvagas) {
        this.turmaID = turmaID;
        this.prof = prof;
        this.cur = cur;
        this.horario = horario;
        this.ano = ano;
        this.ativo = ativo;
        this.semana = semana;
        this.qtdvagas = qtdvagas;
    }
    
    
}
