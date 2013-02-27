/**
 * Create an app that will be executed in terminal or from the command line. 
 * The app should accept a hashtag as an argument and should only print out unique urls found in the 100 most recent tweets that matched the hashtag.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class tweet {
	public static void main(String[] args) throws IOException{
		System.out.println("Welcome! Please input the hashtag you want to search. (Input example:#valentine#)");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String sentence;
		sentence = input.readLine().trim();
		//input error 
		if(sentence.length() < 3){
			System.out.println("Error: input error. Input example:#valentine#");
			return;
		}
		else if (sentence.charAt(0) != '#' || sentence.charAt(sentence.length() - 1) != '#') {
			System.out.println("Please add # to the word you want to search.");
			return;
		}
		//delect "##"		
		String querykey = sentence.substring(1, sentence.length() - 1);

		
		//initiate query
		String query="http://search.twitter.com/search.json?q=%23"+ querykey +"&rpp=100&include_entities=true&result_type=recent%22";
		URL tweeter;
		BufferedReader in;
		System.out.println("The 100 most recent tweets that matched the hashtag #" + querykey + "# are:");
		try {
			tweeter = new URL(query);
			URLConnection connect=tweeter.openConnection();
			in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
		}catch (Exception e) {
			System.out.println("Not able to setup connection");
			e.printStackTrace();
			return;
		}
		try {
			String eachline;
			while ((eachline = in.readLine()) != null) {
			   parser(eachline);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}	
	}

	//parse the string received.
	public static void parser(String str){
		 int i = str.indexOf("\"url\"");
		    while (i >= 0) {
		    	str = str.substring(i+7);
		        int j = str.indexOf("\"");
		        System.out.println(str.substring(0, j).replaceAll("\\\\", ""));
		        str = str.substring(j);
		        i = str.indexOf("\"url\"");
		    }
	}
}
