package B;

/* B.java */

import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class B {
	
	public static void main (String arg[]) throws FileNotFoundException {
		
       	Scanner fin = new Scanner(new FileReader("input.txt"));
       	
       	int highest = 0;
       	Queue<Integer> q = new LinkedList<Integer>();
		
		while (true) {
			
			int get = fin.nextInt();
			
			if (get == 0) break;
			
			q.add(get);
			if (get > highest) highest = get;
			
		}
		
		fin.close();
		
		int daily;
		int[] total = new int[highest+1];
		daily = 0;
		total[0] = 0;
		
		for (int i = 1; i <= highest; i++) {
			
			daily += i;
			total[i] = total[i-1] + daily;
			
		}
		
		PrintWriter writer = new PrintWriter("output.txt");
		
		while (q.peek() != null) {
			
			int out = q.poll();
			System.out.println(total[out]);
			writer.println(total[out]);
			
		}
		
		writer.close();
		
	}

}