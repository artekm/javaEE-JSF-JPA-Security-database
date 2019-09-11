package mapping;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CustomersBacking implements Serializable {
	private static final long serialVersionUID = 1L;
	private Customer customer = new Customer();

	@Inject
	private CustomerManager customerManager;

	public void delete(Customer customer) {
		customerManager.delete(customer);
	}

	public String add() {
		customerManager.addNewCustomer(customer);
		customer = new Customer();
		return "/index.xhtml?faces-redirect=true";
	}

	public void clear() {
		customer = new Customer();
	}

	public void edit(Customer customer) {
		this.customer = customer;
	}

	public String update() {
		customerManager.updateCustomer(customer);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public List<Customer> getCustomers() {
		return customerManager.loadAllCustomers();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}