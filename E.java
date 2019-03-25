package E;

/* E.java */

import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class E {
	
	public static void main (String arg[]) throws FileNotFoundException {
		
       	Scanner fin = new Scanner(new FileReader("input.txt"));
       	Queue<Integer> q = new LinkedList<Integer>();
       	int highest = 0;
		
		while (true) {
			
			int input = fin.nextInt();
			if (input == 0) break;
			
			q.add(input);
			if (input > highest) highest = input;
			
		}
		
		fin.close();
		
		int[] array = new int[highest+1];
		array[0] = 0;
		
		for (int i = 1; i <= highest; i++) {
			
			array[i] = array[i-1] + i + 1;
			
		}
		
		PrintWriter writer = new PrintWriter("output.txt");
		
		while (q.peek() != null) {
			
			int out = q.poll();
			int count = 0, pos = 0, i = 0;
			// count is the number of steps through the deck
			// pos is the card we are on
			// i is the iterator
			int[] cardpos = new int[out];
			for (int j = 0; j < out; j++) {
				cardpos[j] = 0;
			}
			
			while (pos < out) {
				
				if (cardpos[i] == 0) {
					
					count++;
					
					if (count == array[pos+1]) {
						
						cardpos[i] = pos+1;
						pos++;
						
					}
					
				}
				
				i++;
				if (i >= out) i -= out;
				
			}
			
			for (int j = 0; j < out; j++) {
				
				writer.print(cardpos[j]);
				
				if (j < out - 1) writer.print(" ");
				
			}
			
			writer.println();
			
		}
		
		writer.close();
		
	}

}