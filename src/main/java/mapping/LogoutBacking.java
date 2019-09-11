package mapping;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@ViewScoped
public class LogoutBacking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private HttpServletRequest request;

	public String logout() throws ServletException, IOException {
		request.logout();
		return "/index.xhtml?faces-redirect=true";
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
