package mapping;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class MyIdentityStore implements IdentityStore {

	@Inject
	private CustomerManager customerManager;

	@Override
	public CredentialValidationResult validate(Credential credential) {

		List<Customer> users = customerManager.loadAllCustomers();

		String userName = ((UsernamePasswordCredential) credential).getCaller();
		String userPswd = ((UsernamePasswordCredential) credential).getPasswordAsString();
		for (Customer c : users)
			if (c.getFirstName().equals(userName) && c.getPassword().equals(userPswd))
				return new CredentialValidationResult(userName, new HashSet<>(asList("USER")));
		return CredentialValidationResult.INVALID_RESULT;
	}
}
