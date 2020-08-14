package trong.lixco.com.jpa.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class Configuage {
	@PersistenceContext(unitName = "quanlydatcom")
	private EntityManager em;
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}