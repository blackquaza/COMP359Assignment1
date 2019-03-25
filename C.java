package C;

/* C.java */

import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class C {
	
	public static void main (String arg[]) throws FileNotFoundException {
		
		//Open input and output files.
		
       	Scanner fin = new Scanner(new FileReader("input.txt"));
       	PrintWriter writer = new PrintWriter("output.txt");
		
		while (true) {
			
			String input = fin.nextLine();
			if (input.compareTo("0") == 0) break;
			
			boolean[] array = new boolean[input.length()];
			for (int i = 1; i < input.length(); i++) {
				array[i] = (input.substring(i, i+1).compareTo("1") == 0) ? true : false;
			}
			
			Queue<Integer> answer = new LinkedList<Integer>();
			
			for (int i = 1; i < input.length(); i++) {
				
				if (array[i] == false) continue;
				
				answer.add(i);
				
				for (int j = i; j < input.length(); j += i) {
					array[j] = !array[j];
				}
				
			}
			
			while (answer.peek() != null) {
				
				int out = answer.poll();
				System.out.println(out);
				writer.print(out);
				if (answer.peek() != null) writer.print(" ");
				
			}
			
			writer.println();
			
		}
		
		fin.close();
		writer.close();
		
	}
	
	boolean check (boolean[] array) {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] == true) return true;
			
		}
		
		return false;
		
	}

}