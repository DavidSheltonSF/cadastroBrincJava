package desktopApp.core.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoJDBC {
	private static final String URL = "jdbc:mysql://localhost:3306/zonadiversao";
	private static final String USER = "root";
	private static final String PASSWORD = "dav96538004";
	
	private static Connection conn;
	
	public static Connection getConexao() {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				return conn;
			}
			else {
				return conn;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Houve um erro ao tentar conectar com o banco de dados");
			return null;
		}
	}
}
