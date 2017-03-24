//Gretchen Wilson

//Project1.java
//Reads data input 
//Organizes input into two data arrays: Data and Query
//Query holds the search items, Data holds the array to be searched
//Searched Data for Query items by a sequential and binary sort
//Prints whether or not Query item was found and the time it took.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CompareSearch {

	/**
	 * Task:Main method for Project1
	 * 		Reads input, calls search methods, 
	 * 		and Prints results.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Variables
		ArrayList<Integer> dataList = new ArrayList<Integer>();
		ArrayList<Integer> queryList = new ArrayList<Integer>();
		int query = 0;
		int data = 0;
		
		try{
			//Read File/Data Input
			Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			String [] sizes = in.nextLine().split(" ");
			data = Integer.parseInt(sizes[0]);
			query = Integer.parseInt(sizes[1]);
			//Fill data array
			for (int i=0; i<data; i++){
				int input = in.nextInt();
				dataList.add(input);
			}
			//Fill query array
			for (int e=0; e<query; e++) {
				int input = in.nextInt();
				queryList.add(input);
				
			}
			in.close();
		}
		catch(Exception e){
			System.out.println("Input Error: " + e.getMessage());
			System.exit(0);
		}
		
		//Search dataList for each query item in queryList
		//Print results
		for (int i=0; i<query; i++){
			int value = queryList.get(i);
			long startBin = System.currentTimeMillis();
			boolean binary = binarySearch(value, 0, dataList.size()-1, dataList);
			long endBin = System.currentTimeMillis();
			long timeBin = endBin - startBin;
			
			long startSeq = System.currentTimeMillis();
			boolean sequential = sequentialSearch(value, dataList);
			long endSeq = System.currentTimeMillis();
			long timeSeq = endSeq - startSeq;
			
			System.out.println(sequential + ":" + timeSeq + "ms:" + binary + ":" + timeBin + "ms:" + value);
		}
	}
	
	//Method for binary searching
	public static boolean binarySearch(int value, int start, int end, ArrayList<Integer> array ) {
		int midPoint = ((start+end)/2);
		
		if ( start>end) return false;
		int middle = array.get(midPoint);
		
		if (value == middle) return true;
		if (value<middle) return binarySearch(value, start, midPoint-1, array );
		if (value>middle) return binarySearch(value,midPoint+1, end, array );
		else return false;
	}
	//Method for sequential searching
	public static boolean sequentialSearch(int value, ArrayList<Integer> array) {
		boolean found = false;
		for (int i=0; !found&&i<array.size(); i++){
			if (value==array.get(i)) return true;
		}
		return found;
	}
	
}
