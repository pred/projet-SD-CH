package sd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class FileTest {
	
	private static void titre(String line) {
		String delims = "[()\\.]";
		String[] tokens = line.split(delims);
		String titre = tokens[1].trim().replaceAll(" +", " ");
		System.out.println(titre);
	}
	
	private static void readFile1(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);
	 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
	//	int i = countFile(fin);
		String delims = "[()\\.]";
		while ((line=br.readLine()) != null) {
			
		/*	String[] tokens = line.split(delims);
			for (int k = 0; k < tokens.length; k++) {
			System.out.println(tokens[k]);
			}*/
		//System.out.println(line);
		
			titre(line);
			
		}
	 
		br.close();
	}
	
	public static void main(String[] args) {
		File f = new File("Film.txt");
		try {
		Parse.readFile1(f);
		}
		catch (IOException e)
		{
			e.printStackTrace();	
		}
	}
}
	
