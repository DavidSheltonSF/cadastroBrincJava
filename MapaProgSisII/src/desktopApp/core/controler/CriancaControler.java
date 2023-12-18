package desktopApp.core.controler;
import desktopApp.core.entity.CriancaEntity;
import desktopApp.core.service.CriancaService;
import desktopApp.core.service.IdadeNaoPermitidaException;

public class CriancaControler {
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
