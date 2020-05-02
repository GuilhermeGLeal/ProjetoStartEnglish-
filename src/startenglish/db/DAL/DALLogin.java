package startenglish.db.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import startenglish.db.Entidades.Login;
import startenglish.db.util.Banco;


public class DALLogin {
    public boolean gravar(Login l){
        
        String sql = "insert into login(usuario,senha,status,nivel,funcid)values('#1','#2','#3',#4,#5)";
        sql = sql.replaceAll("#1", l.getUser());
        sql = sql.replaceAll("#2", l.getSenha());
        sql = sql.replaceAll("#3",""+l.getStatus());
        sql = sql.replaceAll("#4", ""+l.getNivel());
        sql = sql.replaceAll("#5", ""+l.getFunc().getID());
        
        return Banco.getCon().manipular(sql);
        
    }
    
    public boolean alterar(Login l){
        
       String sql = "update login set usuario = '#1', senha = '#2', status='#3', nivel= #4, funcid=#5 where usuario = "+l.getUser();
        sql = sql.replaceAll("#1", l.getUser());
        sql = sql.replaceAll("#2", l.getSenha());
        sql = sql.replaceAll("#3",""+l.getStatus());
        sql = sql.replaceAll("#4", ""+l.getNivel());
        sql = sql.replaceAll("#5", ""+l.getFunc().getID());
        
        return Banco.getCon().manipular(sql);
    }
    
    public boolean apagar(Login l){
        
        return Banco.getCon().manipular("delete from login where usuario="+l.getUser());
    }
    
    public Login get(String usuario){
     
        Login log = null;
        ResultSet rs = Banco.getCon().consultar("select * from login where usuario= '"+usuario+"'");
        
        try{
            
            if(rs.next())
            {
                DALFuncionario dalf = new DALFuncionario();
                log = new Login(rs.getString("usuario"), rs.getString("senha"), rs.getString("Status").charAt(0), rs.getInt("nivel"), dalf.get(rs.getInt("funcid")));
                 
             }
        }
        catch(SQLException e ){System.out.println(e.getMessage());}
        
        return log;
    }
}
