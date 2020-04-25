package startenglish.db.Entidades;

import java.util.Date;


public class Agenda {
    private int ID;
    private Professor professor;
    private Date dataProva;
    private String horario;
    private String local;

    public Agenda() {
    }

    public Agenda(Professor professor, Date dataProva, String horario, String local) {
        this.professor = professor;
        this.dataProva = dataProva;
        this.horario = horario;
        this.local = local;
    }

    public Agenda(int ID, Professor professor, Date dataProva, String horario, String local) {
        this.ID = ID;
        this.professor = professor;
        this.dataProva = dataProva;
        this.horario = horario;
        this.local = local;
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
}
