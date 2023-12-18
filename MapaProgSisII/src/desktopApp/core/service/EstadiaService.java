package desktopApp.core.service;
import desktopApp.core.entity.EstadiaEntity;
import desktopApp.core.dao.EstadiaDAO;

/*
 * Camada service para Estadia
 */
public class EstadiaService {
	/* Cadastra uma estadia na camada DAO
	 * @param EstadiaEntity estadia anos
	 */
	public void cadastrarResponsavel(EstadiaEntity estadia) {
		EstadiaDAO estadiaDAO = new EstadiaDAO();
		estadiaDAO.cadastrarEstadia(estadia);
	}
}
