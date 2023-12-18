package desktopApp.core.dao;

import desktopApp.core.dao.conexao.ConexaoJDBC;
import desktopApp.core.entity.ResponsavelEntity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResponsavelDAO {
	public void cadastrarResponsavel(ResponsavelEntity responsavel) {
		// String de inserção sql
		String sql = "INSERT INTO responsavel (cpf, nome, email, telefone, endereco, data_nascimento) VALUES (?, ?, ?, ?, ?, ?)";
		// Realiza a inserção
		PreparedStatement ps;
		
		try {
			// Conecta no banco de dados e prepara a inserção sql
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			// Insere os dados do objeto ResponsavelEntity na tabela sql
			ps.setString(1, responsavel.getCPF());
			ps.setString(2, responsavel.getNome());
			ps.setString(3, responsavel.getEmail());
			ps.setString(4, responsavel.getTelefone());
			ps.setString(5, responsavel.getEndereco());
			ps.setDate(6,Date.valueOf(responsavel.getDataNascimento()));
			ps.execute();
			ps.close();
		}
		catch(SQLException e) {
			System.out.println("ERRO SQL");
			e.printStackTrace();
		}
		
	}
	
	/* Retorna a lista de responsáveis cadastrados
	 * @return ArrayList<ResponsavelEntity>
	 */
	public ArrayList <ResponsavelEntity> listarResponsavel(){
		// String de consulta sql
		String sql = "SELECT cpf, nome, email, telefone, endereco, data_nascimento FROM responsavel";
		
		// Executa a consulta
		PreparedStatement ps;
		// Recebe o resultado da consulta
		ResultSet rs; 
		
		// Armazena os responsáveis
		ArrayList <ResponsavelEntity> responsaveis = new ArrayList<ResponsavelEntity>();
		
		// Tenta conectar ao banco de dados e realizar a consulta
		try {
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			// Alimenta a lista de responsáveis
			while(rs.next()) {
				// Instancia um novo objeto ResponsavelEntity
				ResponsavelEntity respon = new ResponsavelEntity();
				// Preenche o objeto com as informações obtidadas no banco
				
				respon.setCPF(rs.getString("cpf"));
				respon.setNome(rs.getString("nome"));
				respon.setEmail(rs.getString("email"));
				respon.setTelefone(rs.getString("telefone"));
				respon.setEndereco(rs.getString("endereco"));
				respon.setDataNascimento(rs.getString("data_nascimento"), "yyyy-MM-dd");


				// Adiciona o responsavel na lista
				responsaveis.add(respon);
			}
			System.out.println("Lista de responsaveis RETORNADA! ");
			// Retorna a lista
			return responsaveis;
		}
		catch(SQLException e) {
			System.out.println("Não foi retornada a lista de responsaveis");
			e.printStackTrace();
			return null;
		}
	}
}


