package startenglish.db.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import startenglish.db.Entidades.Aluno;
import startenglish.db.Entidades.Livro;
import startenglish.db.Entidades.Matricula;
import startenglish.db.Entidades.Turma;
import startenglish.db.util.Banco;

public class DALMatricula {

    public Matricula get(int cod) {
        String sql = "select * from matricula where numeroMatricula = " + cod;

        Matricula aux = null;
        ResultSet rs = Banco.getCon().consultar(sql);
        Turma tu;
        Aluno alu;
        Livro livro;
        DALTurma dalt = new DALTurma();
        DALLivro dall = new DALLivro();
        DALAluno dala = new DALAluno();

        try {
            while (rs.next()) {

                alu = dala.get(rs.getInt("alunoID"));
                livro = dall.get(rs.getInt("livroID"));
                tu =  dalt.get(rs.getInt("turmaID"));
                aux = new Matricula(rs.getInt("numeromatricula"), livro,tu, alu, rs.getString("ativo").charAt(0), rs.getDouble("valor"));

                //aux.add(new Falta(dalt.get(rs.getInt("turmaid")), , data, ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return aux;
    }

}
