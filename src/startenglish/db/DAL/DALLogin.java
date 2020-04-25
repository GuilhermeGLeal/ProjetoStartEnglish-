package startenglish.db.DAL;

import startenglish.db.Entidades.Login;
import startenglish.db.util.Banco;


public class DALLogin {
    public boolean gravar(Login l){
        
        String sql = "insert into Login(Usuario,Senha,Status,Nivel,FuncID)values('#1','#2','#3',#4,#5)";
        sql = sql.replaceAll("#1", l.getUser());
        sql = sql.replaceAll("#2", l.getSenha());
        sql = sql.replaceAll("#3",""+l.getStatus());
        sql = sql.replaceAll("#4", ""+l.getNivel());
        sql = sql.replaceAll("#5", ""+l.getFunc().getID());
        
        return Banco.getCon().manipular(sql);
        
    }
    
    public boolean alterar(Login l){
        
       String sql = "update Login set Usuario = '#1', Senha = '#2', Status='#3', Nivel= #4, FuncID=#5 where user = "+l.getUser();
        sql = sql.replaceAll("#1", l.getUser());
        sql = sql.replaceAll("#2", l.getSenha());
        sql = sql.replaceAll("#3",""+l.getStatus());
        sql = sql.replaceAll("#4", ""+l.getNivel());
        sql = sql.replaceAll("#5", ""+l.getFunc().getID());
        
        return Banco.getCon().manipular(sql);
    }
    
    public boolean apagar(Login l){
        
        return Banco.getCon().manipular("delete from Login where user="+l.getUser());
    }
}
