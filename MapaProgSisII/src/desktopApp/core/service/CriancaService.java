package desktopApp.core.service;
import desktopApp.core.entity.CriancaEntity;
import desktopApp.core.dao.CriancaDAO;

/*
 * Camada service para Criança
 */
public class CriancaService {
	/* Cadastra uma criança na camada DAO
	 * @param CriancaEntity crianca
	 * Lança IdadeNaoPermitidaException caso a criança tenha mais de anos
	 */
	public void cadastrarCrianca(CriancaEntity crianca) throws IdadeNaoPermitidaException{

		int idade = crianca.getIdade();
		if (idade <= 10) {
			CriancaDAO criancaDao = new CriancaDAO();
			criancaDao.cadastrarCrianca(crianca); 
		}
		else {
			throw new IdadeNaoPermitidaException("A criança precisa ter 10 anos ou menos!!!");
		}
		
	}
}
