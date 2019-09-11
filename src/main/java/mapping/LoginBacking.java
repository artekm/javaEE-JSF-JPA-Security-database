package mapping;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@Named
@ViewScoped
public class LoginBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	@NotNull
	private String password;

	@Inject
	private SecurityContext securityContext;

	@Inject
	private FacesContext facesContext;

	@Inject
	ExternalContext externalContext;

	public String login() {
		switch (continueAuthentication()) {
		case SEND_CONTINUE:
			facesContext.responseComplete();
			break;

		case SEND_FAILURE:
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Login failed", null));
			break;

		case SUCCESS:
			return "/index.xhtml?faces-redirect=true";

		case NOT_DONE:
			break;
		}
		return null;
	}

	private AuthenticationStatus continueAuthentication() {
		return securityContext.authenticate(
				(HttpServletRequest) externalContext.getRequest(),
				(HttpServletResponse) externalContext.getResponse(),
				AuthenticationParameters
					.withParams()
					.credential(new UsernamePasswordCredential(name, password)));
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}