package startenglish.db.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import startenglish.db.Entidades.Endereco;
import startenglish.db.util.Banco;


public class DALEndereco {
 
     public boolean gravar(Endereco e){
        
        String sql = "insert into Endereco(Rua,CEP,Bairro,Numero,Cidade) values('#1','#2','#3',#4,'#5')";
        sql = sql.replaceAll("#1", ""+e.getRua());
        sql = sql.replaceAll("#2", ""+e.getCEP());
        sql = sql.replaceAll("#3", ""+e.getBairro());
        sql = sql.replaceAll("#4", ""+e.getNumero());
        sql = sql.replaceAll("#5", ""+e.getCidade());
        
        return Banco.getCon().manipular(sql);
        
    }
    
    public boolean alterar(Endereco e){
        
       String sql = "update Endereco set Rua = '#1', CEP = '#2', Bairro='#3', Numero= #4, Cidade='#5' where EnderecoID = "+e.getEnderecoID();
        sql = sql.replaceAll("#1", e.getRua());
        sql = sql.replaceAll("#2", e.getCEP());
        sql = sql.replaceAll("#3", e.getBairro());
        sql = sql.replaceAll("#4", ""+e.getNumero());
        sql = sql.replaceAll("#5", e.getCidade());
        
        return Banco.getCon().manipular(sql);
    }
      
   public boolean apagar(int cod){       

        return Banco.getCon().manipular("delete from Endereco where EnderecoID="+cod);

    }
    
    public Endereco get(int cod){
     
        Endereco ender = null;
        ResultSet rs = Banco.getCon().consultar("select * from Endereco where EnderecoID="+cod);
        
        try{
            
            if(rs.next())
            {
                ender = new Endereco(rs.getInt("EnderecoID"), rs.getString("Rua"), rs.getString("CEP"), rs.getString("Bairro"), rs.getInt("Numero"), rs.getString("Cidade"));
                 
             }
        }
        catch(SQLException e ){System.out.println(e.getMessage());}
        
        return ender;
    }
    
    public List<Endereco> get(String filtro){
        
       String sql="select *from Endereco";
       
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        
        List <Endereco> aux = new ArrayList();
        ResultSet rs = Banco.getCon().consultar(sql);
        try 
        {
            while(rs.next())
            {
                aux.add(new Endereco(rs.getInt("EnderecoID"), rs.getString("Rua"), rs.getString("CEP"), rs.getString("Bairro"), rs.getInt("Numero"), rs.getString("Cidade")));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        return aux;
    }
}
