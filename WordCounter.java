import java.io.BufferedReader; 
import java.io.FileReader; 
import java.util.ArrayList; 
import java.util.Collection;
import java.util.Collections; 
import java.util.HashMap; 
import java.util.HashSet;
import java.util.Map; 
import java.util.Map.Entry;
import java.util.Set;

// ARIEF HAKIM ASKAR
// NATIG KURBANOV
public class WordCounter {
	 public static void main(String[] args) { 
		 int line =1;
	        HashMap<String, ArrayList<Integer>> wordcounter = new HashMap<String, ArrayList<Integer>>();
	        try { 
	            BufferedReader in = new BufferedReader(new FileReader("test.txt"));
	            String str;
	            while ((str = in.readLine()) != null) { 
	                str = str.toLowerCase(); 
	                int idx1 = -1;
	                for (int i = 0; i < str.length(); i++) { 
	                    if ((!Character.isLetter(str.charAt(i))) || (i + 1 == str.length())) {
	                        if (i - idx1 > 1) { 
	                            if (Character.isLetter(str.charAt(i))) 
	                                i++;
	                            String word = str.substring(idx1 + 1, i);
	                            if (wordcounter.containsKey(word)) { 
	                                ArrayList <Integer> existingWordList=(ArrayList<Integer>)wordcounter.get(word);
	                                
	                                existingWordList.add(line);
	                                wordcounter.put(word, existingWordList);
	                            } else { 
	                                ArrayList <Integer> tempList=new ArrayList<Integer>();
	                                tempList.add(line);
	                                wordcounter.put(word, tempList);
	                            } 
	                        }                    
	                        idx1 = i;
	                    } 
	                } 
	                line++;
	            } 
	            in.close();
	        } catch (Exception e) { 
	            e.printStackTrace();
	            System.exit(1);
	        }
	       
	        for (Entry<String, ArrayList<Integer>> entry : wordcounter.entrySet()) {
	        	Set<Integer> lne= new HashSet<Integer>(entry.getValue());
	            System.out.println("Word \"" + entry.getKey() + "\" exists in line " + lne + ", the word occurs "+ entry.getValue().size()+" time(s)");
	        }
	    }
}
