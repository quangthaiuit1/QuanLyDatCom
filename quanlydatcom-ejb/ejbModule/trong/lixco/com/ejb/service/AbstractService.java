package trong.lixco.com.ejb.service;

import java.util.List;

import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractService<T> implements ImplAbstract<T> {

	protected abstract Class<T> getEntityClass();

	protected abstract EntityManager getEntityManager();

	protected abstract SessionContext getUt();

	@Override
	public T create(T entity) {
		getEntityManager().persist(entity);
		return getEntityManager().merge(entity);
	}

	@Override
	public T update(T account) {
		return getEntityManager().merge(account);

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean delete(T account) {
		boolean result = true;
		try {
			getEntityManager().remove(getEntityManager().merge(account));
			getEntityManager().flush();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
//			getLogger().error(e.getLocalizedMessage());
			getUt().setRollbackOnly();
		}
		return result;
	}

	@Override
	public T findById(long id) {
		return getEntityManager().find(getEntityClass(), id);
	}

	@Override
	public T findByIdLockWrite(long id) {
		return getEntityManager().find(getEntityClass(), id, LockModeType.PESSIMISTIC_WRITE);
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		Root<T> root = cq.from(getEntityClass());
		cq.select(root);
		TypedQuery<T> query = getEntityManager().createQuery(cq);

		return query.getResultList();
	}

}
