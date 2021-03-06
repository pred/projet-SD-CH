package sd;

import java.util.ArrayList;
import java.util.List;

public class ListeFilm {
	
	private List<Film> Liste ;
	
	public ListeFilm(List<Film> Liste){
		this.Liste=Liste;
	}
	public ListeFilm(ListeFilm Liste){
		this.Liste=Liste.getListe();
	}
	public ListeFilm(){
		this.Liste =new ArrayList<Film>();
	}
	
	public void add(Film f){
		this.Liste.add(f);
	}
	public void remove(Film f){
		this.Liste.remove(f);
	}
	public Film get(int i){
		return Liste.get(i);
	}
	public int size(){
		return Liste.size();
	}
	public List<Film> getListe(){
		return this.Liste;
	}
	
	public String affiche(){
		String a="";
		for (int i=0;i<Liste.size();i++){
			a+=i+": "+Liste.get(i).getTitre()+"\n";
		}
		return a;
	}
	
	public void augmentePoint(){ 
		for(int i=0;i<this.Liste.size();i++){
			this.Liste.get(i).augmentePoint();
		}
	}
	public void calculPoint(){
		for(int i=0;i<this.Liste.size();i++){
			this.Liste.get(i).calculPoint();
		}
		//for(int i=0;i<this.Liste.size();i++){
		//	System.out.println(this.Liste.get(i).getTitre()+": "+this.Liste.get(i).getPoint());
		//}
	}
	public void classeFilm(){
		List<Film> ListeFilmebis=new ArrayList<Film>();
		int n=this.Liste.size();
		for(int h=0;h<n;h++){
			int max=0;
			for(int i=0;i<this.Liste.size();i++){
				if(this.Liste.get(i).getPoint()>this.Liste.get(max).getPoint()){
					max=i;
				}
			}
			ListeFilmebis.add(this.Liste.get(max));
			this.Liste.remove(max);
		}
		this.Liste=ListeFilmebis;
	}
	
}
