package desktopApp.core.controler;
import desktopApp.core.entity.CriancaEntity;
import desktopApp.core.service.CriancaService;
import desktopApp.core.service.IdadeNaoPermitidaException;

/*
 *  Camada controler para Criança
 */
public class CriancaControler {
	/*
	 * Chama cadastra a entidade Criança na camada service
	 * @param CriancaEntity criança
	 * @return Retorna null se o cadastro foi realizado com sucesso, e retorna uma exceção caso não.
	 */
	public Exception cadastrarCrianca(CriancaEntity crianca) {
		CriancaService criancalService = new CriancaService();
		try {
			criancalService.cadastrarCrianca(crianca);
			return null;
		}
		catch(IdadeNaoPermitidaException e) {
			return e;
		}
		
	}
}
