package util;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import javax.swing.JOptionPane;
 
public class Conexao {
 
   //Nome do usuário do postgresql
   private static final String USERNAME = "";
 
   //Senha do postgresql
   private static final String PASSWORD = "";
 
   //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
   private static final String DATABASE_URL = "jdbc:postgresql://localhost:PORTA/NOMEBANCO";
   
   public static Connection createConnectionToPostgreSQL() throws Exception{
      Class.forName("org.postgresql.Driver"); //Faz com que a classe seja carregada pela JVM
 
      //Cria a conexão com o banco de dados
      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
 
      return connection;
   }
   
   public static void main(String[] args) throws Exception{
 
      //Recupera uma conexão com o banco de dados
      Connection con = createConnectionToPostgreSQL();
 
      //Testa se a conexão é nula
      if(con != null){
         System.out.println("Conexão obtida com sucesso!" + con);
         con.close();
      }
 
   }
}
