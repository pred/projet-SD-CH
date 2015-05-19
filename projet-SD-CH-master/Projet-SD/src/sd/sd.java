package sd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sd {

	public static void main(String[] args) {
		ListeFilm Liste_Film=new ListeFilm();
		
		Directeur d1=new Directeur("Sam","Mendes");//1
		Directeur d2=new Directeur("m","Medes");//0
		Acteur aa1=new Acteur("Daniel","Craig");//1
		Acteur aa2=new Acteur("Ralph","Fiennes");//1
		Acteur aa3=new Acteur("Dl","Crdg");//0	
		Acteur aa4=new Acteur("hjel","Crehe");//0		
		Genre gg1=new Genre("Action");;//1	
		Genre gg2=new Genre("Azon");//0
		Genre gg3=new Genre("rgt");//0	
		
		String s1="A cryptic message from Bond's past sends him on a trail to uncover a sinister organization. While M battles political forces to keep the secret service alive, Bond peels back the layers of deceit to reveal the terrible truth behind SPECTRE.";
		String s2="A SPECTRE.";	
		String s3="E.";	
		
		List<Acteur> a1 = new ArrayList<Acteur>();
		a1.add(aa1);
		a1.add(aa2);
		List<Acteur> a2 = new ArrayList<Acteur>();
		a2.add(aa1);
		a2.add(aa3);
		List<Acteur> a3 = new ArrayList<Acteur>();
		a3.add(aa4);
		a3.add(aa2);	
		
		List<Genre> g1 = new ArrayList<Genre>();
		g1.add(gg1);		
		List<Genre> g2 = new ArrayList<Genre>();
		g2.add(gg2);
		g2.add(gg1);
		List<Genre> g3 = new ArrayList<Genre>();
		g3.add(gg3);
		g3.add(gg1);

		Film f1=new Film("Spectre",2015,"TV",s1,d1,a1,g1,"2h55");//4	
		Film f2=new Film("aerobis",2014,null,s2,d2,a2,g2,null);//2		
		Film f3=new Film("aevrebis",2014,null,s3,d1,a3,g3,null);//3		
		Liste_Film.add(f1);
		Liste_Film.add(f2);
		Liste_Film.add(f3);
		
		//affichage des films
		System.out.println(Liste_Film.affiche());
		
		System.out.println("Quels films avez-vous vus :");
		System.out.println("Notez les numéro des films que vous avez vu separer d'un seul espace :");
		//interaction utilisateur
		Scanner sc =new Scanner(System.in);
		String s="";
		s=sc.nextLine();
		
		//traitement du string utilisateur
		
		//Scanner scc=new Scanner(s);
		//scc.useDelimiter("\\s* \\s*");
		//int i;
		//List<int> L=new ArrayList<int>();
		//while(scc.hasNextInt()){
		//	i=scc.nextInt();
		//	System.out.println(i);
		//}
		//scc.close();
		
		String[] tab=s.split(" ");
		List<Integer> vu=new ArrayList<Integer>();
		for(int i=0;i<tab.length;i++){
			if(!isIn(vu,Integer.parseInt(tab[i]))){ 
				vu.add(Integer.parseInt(tab[i]));
			}
		}
		
		//création Liste_vu
		ListeFilm Liste_vu=new ListeFilm();
		for(int i=0;i<vu.size();i++){
			Liste_vu.add(Liste_Film.get(vu.get(i)));
		}
		//for(int i=0;i<Liste_vu.size();i++){
		//	System.out.println(Liste_vu.get(i).getTitre());
		//}
		//point de chaque film
		Liste_vu.augmentePoint();
		//creation liste pasvu
		ListeFilm Liste_pasvu=new ListeFilm(Liste_Film);
		for(int i=0;i<Liste_pasvu.size();i++){
			for(int j=0;j<Liste_vu.size();j++){
				if(Liste_pasvu.get(i).getTitre()==Liste_vu.get(j).getTitre()){
					Liste_pasvu.remove(Liste_pasvu.get(i));
				}
			}
		}
		//for(int i=0;i<Liste_pasvu.size();i++){
		//	System.out.println(Liste_pasvu.get(i).getTitre());
		//}
		Liste_pasvu.calculPoint();
		Liste_pasvu.classeFilm();
		//for(int i=0;i<Liste_pasvu.size();i++){
		//	System.out.println(Liste_pasvu.get(i).getTitre()+": "+Liste_pasvu.get(i).getPoint());
		//}
		
		int l=0;
		while(!s.equals("o")){
			System.out.println(Liste_pasvu.get(l).getTitre()+": "+Liste_pasvu.get(l).getSynopsis());
			//validation utilisateur
			System.out.println("accepter o/n");
			s="";
			s=sc.nextLine();
		
		
			if(s.equals("o")){
				System.out.println(Liste_pasvu.get(l).getTitre()+": ("+Liste_pasvu.get(l).getAnnee()+Liste_pasvu.get(l).getType()+"). \n"
							   	+Liste_pasvu.get(l).getSynopsis()+"\nDirecteur : "+Liste_pasvu.get(l).getDirecteur()+"\nWith : "
							   	+Liste_pasvu.get(l).getActeurs()+"\nGenre : "+Liste_pasvu.get(l).getGenres()+" "+Liste_pasvu.get(l).getDuree());
				sc.close();
			}else if(s.equals("n")){
				if(l<Liste_pasvu.size()-1){
					l++;
				}else{
					System.out.println("plus de film a proposer, retour au premier");
					l=0;
				}
			}else{
				System.out.println("commande non valide recommencer");
			}
		}
		System.out.println("fin");
	}
	
	public static boolean isIn (List<Integer> t,int a){
		boolean b=false;
		for(int i=0;i<t.size();i++){
			if(a==t.get(i)){
				b=true;
			}
		}
		return b;
	}
}
