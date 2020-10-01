package trong.lixco.com.ejb.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import trong.lixco.com.jpa.entity.FoodByDay;
import trong.lixco.com.jpa.entity.QuantityFood;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class QuantityFoodService extends AbstractService<QuantityFood> {
	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;

	@Override
	protected Class<QuantityFood> getEntityClass() {
		return QuantityFood.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected SessionContext getUt() {
		return ct;
	}

	public List<QuantityFood> find(java.sql.Date date, long shiftsId) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<QuantityFood> cq = cb.createQuery(QuantityFood.class);
		Root<QuantityFood> root = cq.from(QuantityFood.class);
		List<Predicate> queries = new ArrayList<>();
		if (date != null) {
			Predicate dateQuery = cb.equal(root.get("food_date"), date);
			queries.add(dateQuery);
		}
		if (shiftsId != 0) {
			Predicate shiftsQuery = cb.equal(root.get("shifts").get("id"), shiftsId);
			queries.add(shiftsQuery);
		}

		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<QuantityFood> query = em.createQuery(cq);
		List<QuantityFood> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<QuantityFood>();
		}
	}

}
