import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MorseCodeConverter {

	public static MorseCodeTree MorseCode = new MorseCodeTree();
	
	public MorseCodeConverter() {
		
	}
	
	public static String printTree() {
		ArrayList<String> tree = MorseCode.toArrayList();
		String s = " ";
		
		for (String string : tree) {
			s = s + " "+ string;
		}
		
		return s.trim();
		
	}

	public static String convertToEnglish(String code) {
	    String[] letter;
	    String[] word = code.split(" / ");
	    StringBuilder english = new StringBuilder();

	    for (String string : word) 
	    {
	      letter = string.split(" ");
	      
	      for (String temp : letter) 
	      {
	        english.append(MorseCode.fetch(temp));
	      }
	      english.append(" ");
	    }
	    return english.toString().trim();
	}
	
	public static String convertToEnglish(File codeFile)throws FileNotFoundException{
		StringBuilder SB = new StringBuilder();
		InputStream IS = new FileInputStream(codeFile);
		BufferedReader BR = new BufferedReader(new InputStreamReader(IS));
		
		BR.lines().forEach(s -> SB.append(convertToEnglish(s)).append("\n"));
		try {
			BR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SB.toString().trim();
	}


}
