package sd;

import java.util.List;
import java.util.ArrayList;

public class Film {
	private String Titre;
	private int Année;
	private String Type;
	private String Synopsis;
	private Directeur Directeur;
	private List<Acteur> Acteurs = new ArrayList<Acteur>();
	private List<Genre> Genre = new ArrayList<Genre>();
	private String Duree;
	
	public Film() {
		Titre = "inconnu";
		Année = 0;
		Type = "inconnu";
		Synopsis = "inconnu";
		Directeur =null;
		Acteurs=null;
		Genre=null;
		Duree="inconnue";
	}

}
