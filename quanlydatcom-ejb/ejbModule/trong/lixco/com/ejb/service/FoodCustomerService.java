package trong.lixco.com.ejb.service;

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

import trong.lixco.com.jpa.entity.FoodCustomer;
import trong.lixco.com.jpa.entity.QuantityFood;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FoodCustomerService extends AbstractService<FoodCustomer> {
	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;

	@Override
	protected Class<FoodCustomer> getEntityClass() {
		return FoodCustomer.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected SessionContext getUt() {
		return ct;
	}

	public List<FoodCustomer> find(long quantityFoodId) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodCustomer> cq = cb.createQuery(FoodCustomer.class);
		Root<FoodCustomer> root = cq.from(FoodCustomer.class);
		List<Predicate> queries = new ArrayList<>();
		if (quantityFoodId != 0) {
			Predicate shiftsQuery = cb.equal(root.get("quantity_food").get("id"), quantityFoodId);
			queries.add(shiftsQuery);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<FoodCustomer> query = em.createQuery(cq);
		List<FoodCustomer> results = query.getResultList();
		if (!results.isEmpty()) {
			return results;
		} else {
			return new ArrayList<FoodCustomer>();
		}
	}
}
