package mapping;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerManager {
	
    @PersistenceContext(unitName="crudJSF")
    private EntityManager entityManager;
    
    public List<Customer> loadAllCustomers() {
        return this.entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
    
    public void delete(Customer customer) {
        if (entityManager.contains(customer)) {
            entityManager.remove(customer);
        } else {
            Customer managedCustomer = entityManager.find(Customer.class, customer.getId());
            if (managedCustomer != null) {
                entityManager.remove(managedCustomer);
            }
        }
    }
    public void addNewCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public void updateCustomer(Customer customer) {
    	entityManager.merge(customer);
    }
}