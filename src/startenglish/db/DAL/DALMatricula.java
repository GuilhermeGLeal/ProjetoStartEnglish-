package startenglish.db.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import startenglish.db.Entidades.Matricula;
import startenglish.db.util.Banco;

public class DALMatricula {
    
    
        public Matricula get(int cod){
            String sql="select * from matricula where numeroMatricula = "+cod;
            
            Matricula aux = null;
            ResultSet rs = Banco.getCon().consultar(sql);
            try 
            {
                while(rs.next())
                {

                    DALTurma dalt = new DALTurma();
                    DALLivro dall = new DALLivro();
                    DALAluno dala = new DALAluno();
                    
                    aux = new Matricula(rs.getInt("numeroMatricula"), dall.get(rs.getInt("livroID")), dalt.get(rs.getInt("turmaID")), dala.get(rs.getInt("alunoID")), rs.getString("ativo").charAt(0), rs.getDouble("valor"));
                    
                    //aux.add(new Falta(dalt.get(rs.getInt("turmaid")), , data, ));
                }
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
            
            
            return aux;
        }  
     
     
}
