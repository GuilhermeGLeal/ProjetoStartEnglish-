package startenglish.db.DAL;

import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import startenglish.db.Entidades.Parametrizacao;
import startenglish.db.util.Banco;


public class DALParametrizacao {
    
    public boolean gravar(Parametrizacao p){
        
        String sql = "insert into Parametrizacao(NomeEmpresa,Telefone,RazaoSocial,E-mail,EnderecoID) values('#1','#2','#3','#4',#5)";
        sql = sql.replaceAll("#1",p.getNome());
        sql = sql.replaceAll("#2",p.getTelefone());
        sql = sql.replaceAll("#3",p.getRazaoSocial());
        sql = sql.replaceAll("#4",p.getEmail());
        sql = sql.replaceAll("#5",""+p.getEndereco().getEnderecoID());
             
        return Banco.getCon().manipular(sql);
        
    }
    
    public boolean alterar(Parametrizacao p){
        
        String sql = "update Parametrizacao set NomeEmpresa = '#1', Telefone = '#2', RazaoSocial='#3', E-mail= '#4', EnderecoID=#5 where NomeEmpresa = "+p.getNome();
        sql = sql.replaceAll("#1",p.getNome());
        sql = sql.replaceAll("#2",p.getTelefone());
        sql = sql.replaceAll("#3",p.getRazaoSocial());
        sql = sql.replaceAll("#4",p.getEmail());
        sql = sql.replaceAll("#5",""+p.getEndereco().getEnderecoID());
        
        return Banco.getCon().manipular(sql);
    }
    
    public boolean apagar(Parametrizacao p){
        
        return Banco.getCon().manipular("delete from Parametrizacao where NomeEmpresa="+p.getNome());
    }
    
    public Parametrizacao get(){
        
        Parametrizacao paramet = null;
        ResultSet rs = Banco.getCon().consultar("select NomeEmpresa,Telefone,RazaoSociala,E-mail,EnderecoID from Parametrizacao");
        
        DALEndereco dal = new DALEndereco();
        
        try{
            
            if(rs.next())
            {
                paramet = new Parametrizacao(rs.getString("NomeEmpresa"),rs.getString("NomeEmpresa"),rs.getString("NomeEmpresa"),rs.getString("NomeEmpresa"),
                        dal.get(rs.getInt("EnderecoID")));
                 
             }
        }
        catch(SQLException e ){System.out.println(e.getMessage());}
        
        return paramet;
    }
       
    
    public boolean gravarFoto(int cod,File arq){
        
        return false;
    }
    
    public InputStream getFoto(int cod){
         
        return null;
     }
}
