package sd;

import java.util.List;
import java.util.ArrayList;

public class Film {
	String Titre;
	int Année;
	String Type;
	String Synopsis;
	String Directeur;
	List<String> Acteurs = new ArrayList<String>();
	List<String> Genre = new ArrayList<String>();
	
	public Film() {
		Titre = "inconnu";
		Année = 0;
		Type = "inconnu";
		Synopsis = "inconnu";
		Directeur = "inconnu";		
	}
}
bonjour
