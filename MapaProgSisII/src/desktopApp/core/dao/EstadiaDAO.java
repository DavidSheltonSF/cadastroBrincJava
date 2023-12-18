package desktopApp.core.dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import desktopApp.core.dao.conexao.ConexaoJDBC;
import desktopApp.core.entity.EstadiaEntity;

/*
 *  Camada DAO para Estadia
 */
public class EstadiaDAO {
	/* Cadastra uma entidade Estadia no banco de dados.
	 * Lança uma exceção caso ocorra um SQLException
	 * @param EstadiaEntity estadia
	 */
	public void cadastrarEstadia(EstadiaEntity estadia) {
		String sql = "INSERT INTO estadia (cpf_responsavel, nome_crianca, data, tempo, taxa, valor) VALUES (?, ?, ?, ?, ?, ?)";
		// Variável que executará o cadastro no banco de dados
		PreparedStatement ps;
		
		try {
			// Conecta no banco de dados e prepara a inserção sql
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			// Cadasta os dados da entidade Estadia
			ps.setString(1, estadia.getResponsavel().getCPF());
			ps.setString(2, estadia.getCrianca().getNome());
			ps.setDate(3, Date.valueOf(estadia.getData()));
			ps.setInt(4, estadia.getTempo());
			ps.setFloat(5, (float) estadia.getTaxa());
			ps.setFloat(6, (float) estadia.getValor());
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
