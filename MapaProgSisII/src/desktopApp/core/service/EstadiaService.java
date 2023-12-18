package desktopApp.core.service;
import desktopApp.core.entity.EstadiaEntity;
import desktopApp.core.dao.EstadiaDAO;

public class EstadiaService {
	public void cadastrarResponsavel(EstadiaEntity estadia) {
		EstadiaDAO estadiaDAO = new EstadiaDAO();
		estadiaDAO.cadastrarEstadia(estadia);
	}
}
