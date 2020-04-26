package startenglish.db.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import startenglish.db.Entidades.Cursos;
import startenglish.db.util.Banco;


public class DALCurso {
 
    public boolean gravar(Cursos c){
     
        String sql = "insert into curso(ativo,nomecurso,descricao,preco) values('#1','#2','#3',#4)";
        sql = sql.replaceAll("#1",""+c.getAtivo());
        sql = sql.replaceAll("#2",c.getNomeCurso());
        sql = sql.replaceAll("#3",c.getDescricao());
        sql = sql.replaceAll("#4",""+c.getPreco());
        
        return Banco.getCon().manipular(sql);
    }
    
     public boolean alterar(Cursos c){
        
       String sql = "update curso set ativo = '#1', nomecurso = '#2', descricao='#3', preco= #4 where cursoid = "+c.getCursoID();
       sql = sql.replaceAll("#1",""+c.getAtivo());
       sql = sql.replaceAll("#2",c.getNomeCurso());
       sql = sql.replaceAll("#3",c.getDescricao());
       sql = sql.replaceAll("#4",""+c.getPreco());
        
        return Banco.getCon().manipular(sql);
    }
     
    public boolean apagar(int cod){
        
        return Banco.getCon().manipular("delete from curso where cursoid="+cod);
    }
    
     public Cursos get(int cod){
     
        Cursos curso = null;
        ResultSet rs = Banco.getCon().consultar("select * from curso where cursoid="+cod);
        
        try{
            
            if(rs.next())
            {
                curso = new Cursos(rs.getString("ativo").charAt(0), rs.getString("nomecurso"), rs.getString("descricao"), rs.getDouble("preco"));
                 
             }
        }
        catch(SQLException e ){System.out.println(e.getMessage());}
        
        return curso;
    }
    
    public List<Cursos> get(String filtro){
        
       String sql="select *from curso";
       
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        
        List <Cursos> aux = new ArrayList();
        ResultSet rs = Banco.getCon().consultar(sql);
        try 
        {
            while(rs.next())
            {
                aux.add(new Cursos(rs.getString("ativo").charAt(0), rs.getString("nomecurso"), rs.getString("descricao"), rs.getDouble("preco")));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        return aux;
    }
}
