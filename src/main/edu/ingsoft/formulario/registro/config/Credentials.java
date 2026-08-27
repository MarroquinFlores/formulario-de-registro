package main.edu.ingsoft.formulario.registro.config;

//nunca exponer credenciales en github
public class Credentials {
    public static final String DATA_BASE = System.getenv("DATA BASE");
    public static final String URL_DB = System.getenv("URL_MYSQL_DB") + DATA_BASE;
    public static final String USER_DB = System.getenv("USER_MYSQL_DB");
    public static final String PASS_DB = System.getenv("PASS_MYSQL_DB");
}


    
    
    
    
    
    
    
    
    
    
    //public static final String URL_DB = ("jdbc:mysql://localhost:3306/colegio_gotitas_del_saber_in4bm");
  //  public static final String USER_DB = ("root");
   // public static final String PASS_DB = ("MiSQL2026");
    

