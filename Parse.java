package sd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Parse {
	static List<String> genreGene = StringListGenre.ListGenre();
	
	public int countFile(File fin) throws IOException { // inutile, je garde au cas où
		FileInputStream fis = new FileInputStream(fin);
		 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		int i = 0;
		while ((br.readLine()) != null) {
			i++;		
		}
	 
		br.close();
		return i; 
	}
	
	private static String[] titre (String line) { // méthode pour récupérer titre date type
		String delims = "[()\\.]";  // délimiteur
		String[] tokens = line.split(delims); // on parse la ligne et on stocke dans tokens[]
		String titre = tokens[1].trim().replaceAll(" +", " "); // pour supprimer le double espace
		System.out.println(titre); // juste pour check
		tokens = tokens[2].split(" "); // on split la partie ()
		String type;
		if (tokens.length>0) { //si y'a qu'une seule case dans le tableau, c'est que c'est un film
			type = "TV Series"; // sinon c'est une série
		} else { type = "Film"; }
		String date = tokens[0]; //on récupère la date 
		
		String[] res = { titre, type, date }; // on range dans un tableau
		
		return res;
	}
	
	private static Directeur director(String line) { // méthod pour récup directeur
		
		String delims = "[:]"; //délimiteur
		String[] tokens = line.split(delims); // parse pour retirer le "Director : "
		String director = tokens[1].trim().replaceAll(" +", " "); // double espace
		//System.out.println(director);
		tokens=director.split(" "); // on parse à nouveau pour prénom et nom
		Directeur direc = new Directeur(tokens[0],tokens[1]); // on crée un nouvel obj directeur
		return direc;
	}
	
	private static List<Acteur> actors(String line) { // méthod pour récup la liste des acteurs
		String delims = ":"; // délimiteur
		String[] tokens = line.split(delims); // on parse pour éliminer le "with :"
		String actor = tokens[1].trim().replaceAll(" +", " "); // on ne récupère que la seconde partie +double espace
		//System.out.println(actor);
		tokens = actor.split(","); // maintenant on veut récupérer chaque acteur
		Acteur tempo; // var temporaire
		List<Acteur> acteurs = new ArrayList<Acteur>(); //liste qu'on va renvoyer
		for (int i=0; i<tokens.length;i++) { // tant qu'il y a qlq chose dans le tableau
			String[] tokens2 = tokens[i].split(" "); // nouveau tableau pour parser prénom et nom
			tempo = new Acteur(tokens2[0].trim().replaceAll(" +", " "), tokens2[1]); // on range l'acteur
		
			acteurs.add(tempo); // on ajoute chaque acteur à la liste
		}
		
		return acteurs;
	}
	
	private static List<Genre> genreFilm(String line) { // méthode pour récupérer le genre
		List<Genre> genres = new ArrayList<Genre>();; // création de la liste que l'on va renvoyer
		String[] tokens = line.split(" "); // on split sur les espaces => la | n'est pas pris en compte par split
		for (int i = 0; i < tokens.length;i++) {
			if (genreGene.contains(tokens[i])) { // on test si chaque élement est un genre
				Genre tempo = new Genre(tokens[i]); // si oui, on créé un objet genre
				genres.add(tempo); // et on le range dans la liste à renvoyer
				//System.out.println(tokens[i]);
			}
			//System.out.println(tokens[i]);
			
		}
		return genres;
	}
	
	public static void readFile1(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin); // initialisation du flux
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis)); // initialisation buffer
	 
		String line = null; // initialisation de la variable dans laquelle on va ranger chaque ligne
	//	int i = countFile(fin);
		
		int boucle = 0; // initialisation condition sortie de boucle
		List<Film> listFilms = new ArrayList<Film>(); // création de la liste finale
		while (boucle <1) {
		line=br.readLine(); // on se place sur la ligne du titre

		String[] res = titre(line); // on appelle la fonction titre qui va renvoyer un tableau de string
		String titre = res[0]; // dans lequel on trouve le titre, la date et le type
		String date = res[1]; // on les récupère pour pouvoir créer un obj film à la fin
		String type = res[2];
		
		//System.out.println(titre);
		//System.out.println(type);
		
		line=br.readLine(); // ligne vide
		//System.out.println(line);
		line=br.readLine(); // on arrive sur la deuxième ligne de texte, synopsis dans la plupart des cas
		
		
		//System.out.println(line); //print synop
		String tempo = line; // var tempo qu'on va substring
		String dirPoints = tempo.substring(0,10); // pour "Director :"
		String withPoints = tempo.substring(0,6); // pour "With :"
		String synopsis = null; // on initialise la variable syno au cas ou on ne peut pas rentrer dans le if
		if (withPoints == "with :" || dirPoints == "Director :") { // Si pas de synopsis, on ne fait rien et on traite après
			System.out.println(line);
			System.out.println("on stop ici");
		} else { // sinon on renvoie le synopsis
			
			synopsis = line;
			line=br.readLine(); // et on passe à la ligne suivante, directeur dans la plupart des cas
		}
		
		Directeur direc = null; // on initialise la variable directeur au cas ou on ne puisse pas rentrer dans le if
		 tempo = line; // on réinitialise tempo avec notre nouvelle ligne
		 dirPoints = tempo.substring(0,10); // pour "Director :"
		 withPoints = tempo.substring(0,6); // pour "With :"
		if (dirPoints.equals("Director :")) {
			 direc = director(line);  // si on a un director, on appelle la method adéquate
			 line=br.readLine(); // et on passe à la ligne suivante, acteurs pour la plupart des cas
		}
		 tempo = line;
		 dirPoints = tempo.substring(0,10);
		 withPoints = tempo.substring(0,6); // idem que précédemment
		 List<Acteur> acteurs = null; // ini la list d'acteurs
		 if (withPoints.equals("With :")) { // si on a le with :
				//String delims = "[()\\.]";
				//String[] tokens = line.split(delims);
				//String actor = tokens[0].trim().replaceAll(" +", " "); reste de test, à virer quand ça marchera
				//System.out.println(actor);
				//System.out.println(line);   
				acteurs = actors( line); // on appelle actor
				line = br.readLine(); // on passe à la ligne suivnate, genre normalement
			}	
		 List<Genre> genres = null; //ini la liste de genre
		/*if (line == null) {
			line = br.readLine(); // le test ici est foireux si pas de genre
		}
		else {*/
			genres = genreFilm(line);
			
		//}
		System.out.println(line); // check on est bien sur la ligne genre
		for (int i = 0; i<2; i++) { // il en faut 2 pour aller au titre suivant, vu qu'on a un readline en tête
			if ((line = br.readLine()) == null) {
				boucle = 1; // si la ligne est null aka qu'on est à la fin, on sort de la boucle
			}
			
		}
		Film un = new Film (titre, date, type, synopsis, direc, acteurs, genres, null);
		listFilms.add(un);
		//System.out.println(un.getGenre());
		//boucle++;
		}
		System.out.println(listFilms);
		
			
		br.close(); // on ferme et on rentre à la maison
	}

}
