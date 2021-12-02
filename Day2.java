import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Day2 {
	public static void main(String[] args) throws FileNotFoundException {
		
		/*------------part one----------------*/
		System.out.print("Part one: ");

		int x = 0;	//up or down
		int y = 0;	//forward direction

		File directions = new File("day2input.txt");
		Scanner scanner = new Scanner(directions);

		while (scanner.hasNextLine()) {
			String direction = scanner.next();
			int movement = scanner.nextInt();
			scanner.nextLine();

			switch (direction) {
				case "forward": y += movement;
						break;
				case "up": x -= movement;
						break;
				case "down": x += movement;
						break;
				default: System.out.println("Oops");
						break;
			}
		}

		System.out.println(x*y);
	}
}
