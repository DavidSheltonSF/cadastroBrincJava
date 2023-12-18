package desktopApp.core.dao;
import desktopApp.core.dao.conexao.ConexaoJDBC;
import desktopApp.core.entity.CriancaEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriancaDAO {
	public void cadastrarCrianca(CriancaEntity crianca) {
		String sql = "INSERT INTO crianca (cpf_responsavel, nome, data_nascimento, sexo) VALUES(?, ?, ?, ?)";
		PreparedStatement ps;
	
		try {
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			ps.setString(1, crianca.getResponsavel().getCPF());
			ps.setString(2, crianca.getNome());
			ps.setDate(3, Date.valueOf(crianca.getDataNascimento()));
			ps.setString(4, crianca.getSexo());
			ps.execute();
			ps.close();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
