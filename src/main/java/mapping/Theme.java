package mapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> themes;
	private String internalTheme;

	@PostConstruct
	public void init() {
		themes = new ArrayList<>(Arrays.asList(
				"cerulean",
				"cosmo",
				"cyborg",
				"darkly",
				"default",
				"flatly",
				"journal",
				"lumen",
				"other",
				"paper",
				"patternfly",
				"readable",
				"sandstone",
				"simplex",
				"slate",
				"spacelab",
				"superhero",
				"united",
				"yeti"));
		internalTheme = "default";
	}

	public void changeTheme(Integer index) {
		try {
			internalTheme = themes.get(index);
		} catch (Exception e) {
			internalTheme = "default";
		}
	}

	public List<String> getThemes() {
		return themes;
	}

	public void setThemes(List<String> themes) {
		this.themes = themes;
	}

	public String getInternalTheme() {
		return internalTheme;
	}

	public void setInternalTheme(String internalTheme) {
		this.internalTheme = internalTheme;
	}

}