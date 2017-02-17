import java.util.Scanner;

public class Sequencer {
	public static void main(String[] args) {
		//Sequencer
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input lowercase DNA gragments one line at a time. End with a blank line.");
		String line = "";
		StringBuilder sb = new StringBuilder();
		while(!(line = scanner.nextLine()).isEmpty()) {
			line = line.trim();
			for(int i = 0; i < line.length(); ++i) {
				if(line.charAt(i) != 'a' && line.charAt(i) != 't' && line.charAt(i) != 'c' && line.charAt(i) != 'g') {
					System.out.println("DNA is invalid");
					return;
				}
			}
			if(sb.length() == 0) {
				sb.append(line);
			}else {
				String old = sb.toString();
				int len = line.length();
				String prev = old.substring(old.length() - len >= 0 ? old.length() - len : 0);
				for(int i = 0; i < prev.length(); ++i) {
					String overlap = prev.substring(i);
					if(line.startsWith(overlap)) {
						sb.append(line.substring(overlap.length()));
						break;
					}
				}
				if(old.equals(sb.toString())) {
					System.out.println("DNA is invalid");
					return;
				}
			}
		}
		System.out.println("Input DNA:" + sb.toString());	
		System.out.println();

		//Finding a Gene
		String gene = sb.toString();
		int startIndex = -1;
		for(int i = 0; i <= gene.length() - 3; ++i) {
			if(gene.substring(i, i + 3).equals("atg")) {
				startIndex = i;
				break;
			}
		}
		if(startIndex == -1) {
			System.out.println("DNA does ont contain a gene start codon");
			return;
		}

		int endIndex = startIndex;
		for(int i = startIndex; i <= gene.length() - 3; i += 3) {
			if(gene.substring(i, i + 3).equals("tag") || gene.substring(i, i + 3).equals("taa") || gene.substring(i, i + 3).equals("tga")) {
				endIndex = i;
				break;
			}	
		}
		if(endIndex == startIndex) {
			System.out.println("DNA does not contain a gen end codon");
			return;
		}

		System.out.println("Start codon position: " + startIndex);
		System.out.println("End codon position: " + endIndex);
		System.out.println("Gene: " + gene.substring(startIndex, endIndex));
		System.out.println();

		//Decoding the Gene
		gene = gene.substring(startIndex, endIndex);
		if(gene.length() < 30) {
			System.out.println("The gene is not long enough to continue.");
			return;
		}
		System.out.println("Analysis results");
		System.out.println();

		String eyeColor = "";
		if(gene.charAt(20) == 'a') {
			eyeColor = "blue";
		}else if(gene.charAt(20) == 't') {
			eyeColor = "green";
		}else {
			eyeColor = "brown";
		}

		String hairColor = "";
		if(gene.charAt(18) == 'a') {
			hairColor = "black";
		}else if(gene.charAt(18) == 't') {
			hairColor = "blond";
		}else if(gene.charAt(18) == 'c') {
			hairColor = "brown";
		}else {
			hairColor = "red";
		}

		String canRollTongue = "no";
		if(gene.charAt(8) == 'a') {
			canRollTongue = "yes";
		}

		System.out.println("Eye color: " + eyeColor);
		System.out.println("Hair color: " + hairColor);
		System.out.println("Can roll tongue? " + canRollTongue);
	}
}