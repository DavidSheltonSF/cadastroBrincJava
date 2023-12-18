package desktopApp.core.controler;
import desktopApp.core.entity.EstadiaEntity;
import desktopApp.core.service.EstadiaService;

public class EstadiaControler {
	public void cadastrarEstadia(EstadiaEntity estadia) {
		EstadiaService estadiaService = new EstadiaService();
		estadiaService.cadastrarResponsavel(estadia);
	}
}
