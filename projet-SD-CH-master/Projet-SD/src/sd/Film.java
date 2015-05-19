package sd;

import java.util.List;
import java.util.ArrayList;

public class Film {
	
	private String titre;
	private int annee;
	private String type;
	private String synopsis;
	private Directeur directeur;
	private List<Acteur> acteurs = new ArrayList<Acteur>();
	private List<Genre> genres = new ArrayList<Genre>();
	private String duree;
	private int point;
	
	public Film(String titre,int annee,String type,String synopsis,Directeur directeur,List<Acteur> acteurs,List<Genre> genres,String duree) {
		this.titre = titre;
		this.annee = annee;
		this.type = type;
		this.synopsis = synopsis;
		this.directeur =directeur;
		this.acteurs=acteurs;
		this.genres=genres;
		this.duree=duree;
		this.point=0;
	}
	
	public String getTitre() {
		return this.titre;
	}	
	public int getAnnee() {
		return this.annee;
	}
	public String getType() {
		if(this.type==null){
			return "";
		}else{
			return " "+this.type;
		}
	}
	public String getSynopsis(){
		return this.synopsis;
	}
	public String getDirecteur() {
		String s="";
		s+=this.directeur.getPrenom();
		s+=" ";
		s+=this.directeur.getNom();
		return s;
	}
	public String getActeurs() {
		String s="";
		for(int i=0;i<this.acteurs.size();i++){
			if(i!=0){
				s+=", ";
			}
			s+=this.acteurs.get(i).getPrenom();
			s+=" ";
			s+=this.acteurs.get(i).getNom();
		}
		return s;
	}
	public String getGenres() {
		String s="";
		for(int i=0;i<this.genres.size();i++){
			if(i!=0){
				s+=" | ";
			}
			s+=this.genres.get(i).getType();
		}
		return s;
	}
	public String getDuree() {
		if(this.duree==null){
			return "";
		}else{
			return " "+this.duree;
		}
	}
	public int getPoint(){
		return this.point;
	}	

	public void augmentePoint(){
		this.directeur.augmentePoint();
		for(int i=0;i<acteurs.size();i++){
			this.acteurs.get(i).augmentePoint();
		}			
		for(int i=0;i<genres.size();i++){
			this.genres.get(i).augmentePoint();
		}
	}
	
	public void calculPoint(){
		this.point=0;
		this.point+=this.directeur.getPoint();
		for(int i=0;i<acteurs.size();i++){
			this.point+=this.acteurs.get(i).getPoint();
		}			
		for(int i=0;i<genres.size();i++){
			this.point+=this.genres.get(i).getPoint();
		}
	}
}
