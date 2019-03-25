package A;

/* A.java */

import java.io.*;
import java.util.Scanner;

class A {
	
	public static void main (String arg[]) throws FileNotFoundException {
		
       	Scanner fin = new Scanner(new FileReader("input.txt"));
       	PrintWriter writer = new PrintWriter("output.txt");
		
		while (true) {
			
			int m, n;
			
			m = fin.nextInt();
			n = fin.nextInt();
			
			if (m == 0 && n == 0) break;
			fin.nextLine();
			
			String[][] array = new String[m+n][n];
			String[] list = new String[m+n];
			int[] count = new int[m+n];
			
			for (int i = 0; i < m+n; i++) {
				list[i] = "";
				for (int j = 0; j < n; j++) {
					array[i][j] = "";
				}
			}
			
			for (int i = 0; i < m; i++) {
				
				for (int j = 0; j < n; j++) {
					array[i][j] = "";
				}
				
				count[i] = 0;
				list[i] = fin.nextLine();
				
				
			}
			
			for (int i = 0; i < n; i++) {
				
				String input = fin.nextLine();

				int space = input.indexOf(' ');
				String name = input.substring(0, space);
				String support = input.substring(space + 1, input.length());
				
				int position = findPos(support, list, m);
				
				if (position > -1) {
					array[position][count[position]++] = name;
				} else {
					array[m][count[m]++] = name;
					list[m++] = support;
				}
				
			}
			
			for (int i = 0; i < m; i++) {
				
				for (int j = 0; j < n; j++) {
					
					if (array[i][j].compareTo("") == 0) continue;

					writer.println(array[i][j]);
					
				}
				
			}
			
		}
		
		fin.close();
		writer.close();
		
	}
	
	static int findPos(String candidate, String[] list, int length) {
		
		for (int i = 0; i < length; i++) {
			
			if (candidate.compareTo(list[i]) == 0) {
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}

}