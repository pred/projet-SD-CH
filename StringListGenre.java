package sd;
import java.util.ArrayList;
import java.util.List;

public class StringListGenre {
	
	private static List<String> genres = new ArrayList<String>();
	
	public static List<String> ListGenre () {
		/*
		String adventure ;
		String crime ;
		String drama ;
		String mystery ;
		String scifi ;
		String thriller;
		String war ;
		String history;
		String music;
		String comedy;
		String biography;
		String romance;
		String animation;
		String family;*/
		
		genres.add("Action");
		genres.add("Adventure") ;
		genres.add ("Crime") ;
		genres.add ("Drama" );
		genres.add ("Mystery") ;
		genres.add ("Scifi") ;
		genres.add ("Thriller");
		genres.add("War") ;
		genres.add ("History");
		genres.add ("Music");
		genres.add ("Comedy");
		genres.add ("Biography");
		genres.add("Romance");
		genres.add ("Animation");
		genres.add ("Family");
		
		return genres;
		
		
	}
	

}
