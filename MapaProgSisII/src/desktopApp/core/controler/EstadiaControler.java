package desktopApp.core.controler;
import desktopApp.core.entity.EstadiaEntity;
import desktopApp.core.service.EstadiaService;

/*
 *  Camada controler para Estadia
 */
public class EstadiaControler {
	/*
	 * Chama cadastra a entidade Estadia na camada service
	 * @param EstadiaEntity estadia
	 */
	public void cadastrarEstadia(EstadiaEntity estadia) {
		EstadiaService estadiaService = new EstadiaService();
		estadiaService.cadastrarResponsavel(estadia);
	}
}
