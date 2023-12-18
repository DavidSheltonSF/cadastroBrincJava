package desktopApp.core.controler;
import java.util.ArrayList;
import desktopApp.core.entity.ResponsavelEntity;
import desktopApp.core.service.IdadeNaoPermitidaException;
import desktopApp.core.service.ResponsavelService;

/*
 *  Camada controler para Responsavel
 */
public class ResponsavelControler {
	/*
	 * Chama cadastra a entidade Responsavel na camada service
	 * @param ResponsavelEntity responsavel
	 * @return Retorna null se o cadastro foi realizado com sucesso, e retorna uma exceção caso não.
	 */
	public Exception cadastrarResponsavel(ResponsavelEntity responsavel) {
		ResponsavelService responsavelService = new ResponsavelService();
		try {
			responsavelService.cadastrarResponsavel(responsavel);
			return null;
		}
		catch(IdadeNaoPermitidaException e) {
			return e;
		}
	}
	
	/* Retorna uma lista de responsáveis da camada Service
	 * @return ArrayList<ResponsavelEntity>
	 */
	public ArrayList<ResponsavelEntity> listarResponsavel(){
		return new ResponsavelService().listarResponsavel();
	}
}
