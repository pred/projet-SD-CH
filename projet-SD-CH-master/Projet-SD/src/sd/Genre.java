package sd;

public class Genre {
	
	private String type;
	private int point;
	
	public Genre(String type){
		this.type=type;
		this.point=0;
	}
	
	public String getType(){
		return this.type;
	}
	public int getPoint(){
		return this.point;
	}
	
	public void augmentePoint(){
		this.point++;
	}

}
