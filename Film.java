package sd;

import java.util.List;
import java.util.ArrayList;

public class Film {
	private String titre;
	private String année;
	private String type;
	private String synopsis;
	private Directeur directeur;
	private List<Acteur> acteurs = new ArrayList<Acteur>();
	private List<Genre> genres = new ArrayList<Genre>();
	private String duree;
	
	public Film(String titre, String année, String type, String synopsis, Directeur directeur, List<Acteur> acteurs, List<Genre> genres, String duree ) {
		this.titre = titre;
		this.année = année;
		this.type = type;
		this.synopsis = synopsis;
		this.directeur = directeur;
		this.acteurs=acteurs;
		this.genres=genres;
		this.duree=duree;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAnnée() {
		return année;
	}

	public void setAnnée(String année) {
		this.année = année;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Directeur getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public List<Genre> getGenre() {
		return genres;
	}

	public void setGenre(ArrayList<Genre> genre) {
		this.genres = genre;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}
	

}
