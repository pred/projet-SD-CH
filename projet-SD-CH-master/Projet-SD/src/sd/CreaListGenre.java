package sd;

import java.util.ArrayList;
import java.util.List;

public class CreaListGenre {

	private static List<Genre> genres = new ArrayList<Genre>();
	
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public static List<Genre> CreaListGenre() {
		Genre action = new Genre("action");
		Genre adventure = new Genre("adventure");
		Genre crime = new Genre("crime");
		Genre drama = new Genre("drama");
		Genre mystery = new Genre("mystery");
		Genre scifi = new Genre("scifi");
		Genre thriller = new Genre("thriller");
		Genre war = new Genre("war");
		Genre history = new Genre("history");
		Genre music = new Genre("music");
		Genre comedy = new Genre("comedy");
		Genre biography = new Genre("biography");
		Genre romance = new Genre("romance");
		Genre animation = new Genre("animation");
		Genre family = new Genre("family");
		
		
		genres.add(action);
		genres.add(adventure);
		genres.add(crime);
		genres.add(drama);
		genres.add(mystery);
		genres.add(scifi);
		genres.add(thriller);
		genres.add(war);
		genres.add(history);
		genres.add(music);
		genres.add(comedy);
		genres.add(biography);
		genres.add(romance);
		genres.add(animation);
		genres.add(family);
		
		return genres;
	
	}






}
