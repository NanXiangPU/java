import Objects.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class to manage the execution of different components.
 *
 */
public class Driver {
	/**
	 * Method to start a new crawler with a given number of threads.
	 */

	public Crawler crawl() throws ParseException, IOException {
		long start = System.currentTimeMillis();

		Crawler c = new Crawler("https://cs.purdue.edu", 250);
		c.crawl();

    	long end = System.currentTimeMillis();
    	System.out.println("Stats: ");
    	System.out.println("Number of parsed pages: " + c.getParsed().size());
    	System.out.println("Number of words: " + c.getWords().size());
    	
    	System.out.println("Total time: " + (end - start) + "ms.");

    	return c;
	}
	/**
	 * Save the word and page table from Crawler to memory
	 * by calling the required FileUtils methods. 
	 */

	public void save(Crawler c) throws IOException, ClassNotFoundException {
		// Save Info 
    	FileUtils f = new FileUtils();
    			
		// Save the Word Table 
		f.saveWordTable(c.getWords(), "words.txt");
		
		// Save Parsed List 
		f.savePageTable(c.getParsed(), "parsed.txt");

	}



	public void search(String query) throws IOException, ClassNotFoundException, InterruptedException {
		// Prepare Search 
		Search s = new Search("words.txt", "parsed.txt");
		
		long start = System.currentTimeMillis();
		List<Result> result = s.executeQuery(query);
		long end = System.currentTimeMillis();
		
		System.out.println("Query: " + query);
		System.out.println(result.size() + " results found in " + (end - start) + "ms:\n");
		for(int i = 0; i < 10 && i < result.size(); i++)
		{
			Result r = result.get(i);
			System.out.println((i + 1) + ") " + r.getURL() + ", score: " + r.getScore());
		}
	}

	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException, InterruptedException {
    	Driver d = new Driver();
    	Crawler c = d.crawl();
    	d.save(c);

    	Scanner sc = new Scanner(System.in);
    	while(true)
		{
			System.out.println("Enter query:");
			String query = sc.nextLine();

			d.search(query);

			System.out.println("\nContinue? (Yes / No)");

			while(true) {
				String decision = sc.nextLine();

				if (decision.equalsIgnoreCase("yes"))
					break;
				else if (decision.equalsIgnoreCase(("no")))
					System.exit(0);
				else
					System.out.println("Invalid response, try again:");
			}
		}

    }
}
