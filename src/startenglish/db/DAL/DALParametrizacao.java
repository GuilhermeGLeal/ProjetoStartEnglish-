package startenglish.db.DAL;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
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
       
    
    public boolean gravarFoto(String nome,File arq) throws FileNotFoundException{
        
         FileInputStream imagem = null;
         
        if(arq != null){
             imagem = new FileInputStream(arq);
            try
            {
                PreparedStatement ps = Banco.getCon().getConnect().
                prepareStatement("UPDATE Parametrizacao set Logotipo = ? where NomeEmpresa= ?");
                ps.setBinaryStream(1, imagem);
                ps.setString(2, nome);
                ps.executeUpdate();
                ps.close();
                imagem.close();
            }
            catch(Exception e)
            {
                return false;
            }
        }
        else{
             try
            {
                PreparedStatement ps = Banco.getCon().getConnect().
                prepareStatement("UPDATE Parametrizacao set Logotipo = null where NomeEmpresa = ?");
                ps.setString(1, nome);
                ps.executeUpdate();
                ps.close();
                imagem.close();
            }
            catch(Exception e)
            {
                return false;
            }
            
        }
        
        return true;
    }
    
    public InputStream getFoto(String nome){
         
        InputStream is=null;
        
        try
        {
            PreparedStatement ps = Banco.getCon().getConnect().
            prepareStatement("SELECT Logotipo from Parametrizacao where NomeEmpresa=?");
            ps.setString(1,nome);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next())
            {
                byte[] bytes=rs.getBytes("Logotipo");
                is=new ByteArrayInputStream(bytes);
            }
            ps.close();
        }
        catch(Exception e)
        {
            return null;
        }
        
        return is;
     }
}
