package D;

/* D.java */

import java.io.*;
import java.util.Scanner;

class D {
	
	public static void main (String arg[]) throws FileNotFoundException {
		
       	Scanner fin = new Scanner(new FileReader("input.txt"));
       	PrintWriter writer = new PrintWriter("output.txt");
		
		while (true) {
			
			String input = fin.nextLine();
			if (input.compareTo("0") == 0) break;
			
			int count = 0;
			
			for (int i = 0; i < input.length(); i++) {
				
				for (int j = i+1; j <= (input.length() + i) / 2; j++) {
					
					String comp1 = input.substring(i, j);
					String comp2 = input.substring(j, 2*j-i);
					
					if (comp1.compareTo(comp2) == 0) count++;
					
				}
				
			}
			
			writer.println(count);
			
		}
		
		fin.close();
		writer.close();
		
	}

}