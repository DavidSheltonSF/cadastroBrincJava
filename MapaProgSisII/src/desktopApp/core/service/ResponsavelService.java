package desktopApp.core.service;
import desktopApp.core.entity.ResponsavelEntity;
import java.util.ArrayList;
import desktopApp.core.dao.ResponsavelDAO;

public class ResponsavelService {
	public void cadastrarResponsavel(ResponsavelEntity responsavel) throws IdadeNaoPermitidaException{
		
		// Obtem a idade do responvável
		int idade = responsavel.getIdade();
		
		// Verifica se é +18
		if(idade >= 18) {
			// Instancia a camada DAO e cadastra o responsável nela
			ResponsavelDAO responsavelDAO = new ResponsavelDAO();
			responsavelDAO.cadastrarResponsavel(responsavel);
		}
		// Caso não, lança uma exceção
		else {
			throw new IdadeNaoPermitidaException("Precisa ser maior de idade para ser Responsável!");
		}
		
	}
	
	/* Retorna uma lista de responsáveis da camada DAO
	 * @return ArrayList<ResponsavelEntity>
	 */
	public ArrayList<ResponsavelEntity> listarResponsavel(){
		return new ResponsavelDAO().listarResponsavel();
	}
}
