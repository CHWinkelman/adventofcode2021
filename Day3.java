import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

class Day3 {
	static int bitmask(int position){
		return Math.pow(2, position);
	}
	
	static int flip(int bit) {
		if (bit == 0){
			return 1;
		} else {
			return 1;
		}
	}
	
	static int getBit(int binary, int position) {   //position starts at 0, being least significant bit
	if (binary & bitmask(position) != 0) {
		return 1;
	} else {
		return 0;
	}
}
	
	static int[] count(int binary, int[] temp_freq) {
		for (int i = 0; i < temp_freq.length; i++) { 
			temp_freq[i] += getBit(binary, i)
		}
		return temp_freq;
	}

	static int countArrayToBinary(int[] temp_freq) {
		int bin = 0;
		for (int i = 0; i < temp_freq.length; i++) { 
			bin = bin << 1;
			bin += (temp_freq[i] * 2 > length) ? 1 : 0;
		}
		return bin;
	}
	
	static int mostCommon(ArrayList data, int position) {
		int count = 0;
		for (int i = 0; i < data.size(); i++) {
			count += getBit(data.get(i), position);
		}
		if (count * 2 > data.size()) {
			return 1;
		} else {
			return 0;
		}
	}

	static int eliminate(ArrayList data, boolean most, int length) {
		for (int i = 1; i <= length; i++) {		//iterate through bit position, 
			int bit = (most) ? mostCommon(data, length - i) : flip(mostCommon(data, length - i));
			System.out.println("Most : " + most + "Position : " + i + " Bit : " + bit);
			
			for (int x = data.size() - 1; x >= 0; x--) {  //iterating backward through the list stops it from skipping through haphazardly after deleting
				if (data.size() == 1) {
					System.out.println("Winner : " + Integer.toBinaryString(data.get(x))) + " " + data.get(x);
					return (int) data.get(x);
				}else if ((getBit((int) data.get(x), i))!= bit) {
					data.remove(x);
			
				}
			}
		}
	
		return 0;

	}
		
	public static void main(String[] args) {
		System.out.print("Part one: ");
		
		ArrayList<Integer> report = new ArrayList<Integer>();
		int gamma, epsilon;
		int bitLength = 12;
		int[] frequency = new int[bitLength];
		try {
			// File file = new File("day3testinput.txt");
			File file = new File("day3input.txt");
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				report.add(Integer.parseInt(scanner.nextLine(), 2));	
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}

		for (int i = 0; i < report.size(); i++) {
			frequency = count(report.get(i), frequency);
		}
		
		gamma = countArrayToBinary(frequency, report);
		epsilon = ~(gamma) & bitmask(12);
		System.out.println(gamma*epsilon);


		System.out.println("Part two: ");
		int oxy = eliminate(report, true);
		System.out.println(oxy);
		int carbon = eliminate(report, false);
		System.out.println(carbon);
		System.out.println(oxy*carbon);
	}
}
