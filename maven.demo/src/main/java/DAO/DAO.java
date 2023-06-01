package dao;



import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;

public class DAO {
protected Connection connection;
	
	public DAO() {
		connection = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "CibusDatabase";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "postgres";
		String password = "87802030jp";
		boolean status = false;

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			status = (connection == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			connection.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	
	public static String toMD5(String senha) throws Exception {
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0, senha.length());
		return new BigInteger(1,m.digest()).toString(16);
	}
	
	
	
	
	/*NOVO

public interface Tipo_produtoDAO {


    void insert(Tipo_produto tipo_produto);
    void update(Tipo_produto tipo_produto);
    void delete(int id_produto);
    Tipo_produto findById(int id_produto);
    List<Tipo_produto> findAll();
}
*/
	
	
}
