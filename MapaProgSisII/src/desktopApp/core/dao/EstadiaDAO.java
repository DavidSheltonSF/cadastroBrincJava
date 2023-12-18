package desktopApp.core.dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import desktopApp.core.dao.conexao.ConexaoJDBC;
import desktopApp.core.entity.EstadiaEntity;

public class EstadiaDAO {
	public void cadastrarEstadia(EstadiaEntity estadia) {
		String sql = "INSERT INTO estadia (cpf_responsavel, nome_crianca, data, tempo, taxa, valor) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
		
		try {
		
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			ps.setString(1, estadia.getResponsavel().getCPF());
			ps.setString(2, estadia.getCrianca().getNome());
			ps.setDate(3, Date.valueOf(estadia.getData()));
			ps.setInt(4, estadia.getTempo());
			ps.setFloat(5, (float) estadia.getTaxa());
			ps.setFloat(6, (float) estadia.getValor());
			ps.execute();
			ps.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
