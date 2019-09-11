package mapping;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

//import org.glassfish.soteria.identitystores.annotation.Credentials;
//import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

@CustomFormAuthenticationMechanismDefinition(
	loginToContinue= @LoginToContinue(
		loginPage = "/login.xhtml",
		useForwardToLogin= false,
		errorPage=""
	)
)

//@DatabaseIdentityStoreDefinition(
//	dataSourceLookup = "java:app/SecurityEE",
//	callerQuery="SELECT password FROM public.customer where firstName=?",
//	groupsQuery="SELECT firstName FROM public.customer where firstName=?"
//)
//
//@DataSourceDefinition(
//name="java:app/SecurityEE",
//className="org.h2.jdbcx.JdbcDataSource",
//url="jdbc:h2:C:/Users/Artur/eclipse-workspace/crudJSF/crud"
//)

//@EmbeddedIdentityStoreDefinition({
//	@Credentials(
//		callerName="artur",
//		password="artur",
//		groups= {"USER"}
//	)
//})

@FacesConfig
@ApplicationScoped
public class ApplicationConfig{}
