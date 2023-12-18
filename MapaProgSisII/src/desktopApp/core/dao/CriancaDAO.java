package desktopApp.core.dao;
import desktopApp.core.dao.conexao.ConexaoJDBC;
import desktopApp.core.entity.CriancaEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 *  Camada DAO para Criança
 */
public class CriancaDAO {
	/* Cadastra uma entidade Criança no banco de dados.
	 * Lança uma exceção caso ocorra um SQLException
	 * @param CriancaEntity crianca
	 */
	public void cadastrarCrianca(CriancaEntity crianca) {
		String sql = "INSERT INTO crianca (cpf_responsavel, nome, data_nascimento, sexo) VALUES(?, ?, ?, ?)";
		// Variável que executará o cadastro no banco de dados
		PreparedStatement ps;
	
		try {
			// Conecta no banco de dados e prepara a inserção sql
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			// Cadasta os dados da entidade Crianca
			ps.setString(1, crianca.getResponsavel().getCPF());
			ps.setString(2, crianca.getNome());
			ps.setDate(3, Date.valueOf(crianca.getDataNascimento()));
			ps.setString(4, crianca.getSexo());
			// Executa o cadastro
			ps.execute();
			// Fecha a conexão
			ps.close();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
