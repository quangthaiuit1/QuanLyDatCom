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

import trong.lixco.com.jpa.entity.CategoryFood;
import trong.lixco.com.jpa.entity.OrderFood;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoryFoodService extends AbstractService<CategoryFood> {

	@Inject
	private EntityManager em;
	@Resource
	private SessionContext ct;
	
	@Override
	protected Class<CategoryFood> getEntityClass() {
		return CategoryFood.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	protected SessionContext getUt() {
		return ct;
	}
	
	public List<CategoryFood> findByName(String foodName) {
		// primary
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CategoryFood> cq = cb.createQuery(CategoryFood.class);
		Root<CategoryFood> root = cq.from(CategoryFood.class);
		List<Predicate> queries = new ArrayList<>();
		if (foodName != null) {
			Predicate foodNameQuery = cb.equal(root.get("name"), foodName);
			queries.add(foodNameQuery);
		}
		Predicate data[] = new Predicate[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			data[i] = queries.get(i);
		}
		Predicate finalPredicate = cb.and(data);
		cq.where(finalPredicate);
		TypedQuery<CategoryFood> query = em.createQuery(cq);
		List<CategoryFood> results = query.getResultList();
		if(!results.isEmpty()) {
			return results;
		}else {
			return new ArrayList<CategoryFood>();
		}
	}
}
