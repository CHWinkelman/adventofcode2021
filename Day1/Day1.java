import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {
	public static void main (String[] args) {

		ArrayList<Integer> lines = new ArrayList<Integer>();

		try {
			File readings = new File(args[0]);
			Scanner scanner = new Scanner(readings);
				
			while(scanner.hasNextInt()) {
				lines.add(scanner.nextInt());
			}

		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}

		//actual code that does the thing starts here. everything above is annoying filler
		int largerPart1 = 0;
		int largerPart2 = 0;
	
		for (int i = 0; i < lines.size() - 1; i++) {
			if (lines.get(i+1) > lines.get(i)) {
				largerPart1++;
			}
		}

		//System.out.println(largerPart1)

		for (int i = 2; i < lines.size() -1; i++) {
			int previous = lines.get(i) + lines.get(i-1) + lines.get(i-2);
			int next = lines.get(i+1) + lines.get(i) + lines.get(i-1);
			if (next > previous) {
				largerPart2++;
			}
		}
		
		System.out.println(largerPart2);
		
	}
}
