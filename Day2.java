import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Day2 {
	public static void main(String[] args) throws FileNotFoundException {
		
		int x = 0;	//up or down
		int y = 0;	//forward direction

		int x2 = 0;     //part two variables
		int y2 = 0;
		int aim = 0;

		File directions = new File("day2input.txt");
		Scanner scanner = new Scanner(directions);

		while (scanner.hasNextLine()) {
			String direction = scanner.next();
			int movement = scanner.nextInt();
			scanner.nextLine();

			switch (direction) {
				case "forward": y += movement;
						y2 += movement;
						x2 += movement * aim;			
						break;
				case "up": x -= movement;
					   aim -= movement;
						break;
				case "down": x += movement;
					     aim += movement;
						break;
				default: System.out.println("Oops");
						break;
			}
		}

		System.out.println("Part 1: " + (x*y));
		System.out.println("Part 2: " + (x2*y2));
	}
}
