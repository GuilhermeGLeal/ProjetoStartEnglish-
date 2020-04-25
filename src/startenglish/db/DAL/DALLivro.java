package startenglish.db.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import startenglish.db.Entidades.Livro;
import startenglish.db.util.Banco;


public class DALLivro {
    
      public boolean gravar(Livro lv){
     
        String sql = "insert into Livro(Nome,Valor) values('#1',#2)";
        sql = sql.replaceAll("#1",lv.getNome());
        sql = sql.replaceAll("#2",""+lv.getValor());
            
        return Banco.getCon().manipular(sql);
    }
    
     public boolean alterar(Livro lv){
        
       String sql = "update Livro set Nome = '#1', Valor = #2 where LivroID = "+lv.getLivroID();
       sql = sql.replaceAll("#1",lv.getNome());
       sql = sql.replaceAll("#2",""+lv.getValor());
        
        return Banco.getCon().manipular(sql);
    }
     
    public boolean apagar(Livro lv){
        
        return Banco.getCon().manipular("delete from Livro where LivroID="+lv.getLivroID());
    }
    
     public Livro get(int cod){
     
        Livro livro = null;
        ResultSet rs = Banco.getCon().consultar("select * from Livro where LivroID="+cod);
        
        try{
            
            if(rs.next())
            {
                livro = new Livro(rs.getInt("LivroID"),rs.getString("Nome"),rs.getDouble("Preco"));
                 
             }
        }
        catch(SQLException e ){System.out.println(e.getMessage());}
        
        return livro;
    }
    
    public List<Livro> get(String filtro){
        
       String sql="select *from Livro";
       
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        
        List <Livro> aux = new ArrayList();
        ResultSet rs = Banco.getCon().consultar(sql);
        try 
        {
            while(rs.next())
            {
                aux.add(new Livro(rs.getInt("LivroID"),rs.getString("Nome"),rs.getDouble("Preco")));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        return aux;
    }
}
