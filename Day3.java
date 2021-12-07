import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;

class Day3 {
	static int[] count(int binary, int[] temp_freq) {
		for (int i = temp_freq.length - 1; i >= 0; i--) { 
			temp_freq[i] += binary % 2; //modulo returns last bit
			binary = binary >> 1;
			System.out.println(Integer.toBinaryString(binary)); //debug diagnostic but its pretty so it stays
		}
		return temp_freq;
	}

	static int countArrayToBinary(int[] temp_freq, int length) {  //make sure to pass arraylist length when ran
		int bin = 0;

		for (int i = 0; i < temp_freq.length; i++) { 
			bin = bin << 1;
			bin += (temp_freq[i] * 2 > length) ? 1 : 0;
			System.out.println(Integer.toBinaryString(bin)); //debug diagnostic but its pretty so it stays
		}

		return bin;
	}
	static int mostCommon(ArrayList data, int position) {		// 6|5|4|3|2|1
		int count = 0;						// 0|0|0|0|0|0
		int temp = 0;  //might not be necessary but better safe than sorry
		for (int i = 0; i < data.size(); i++) {
			count += ((((int) data.get(i)) >> position) % 2);
		}
		if (count * 2 > data.size()) {
			return 1;
		} else {
			return 0;
		}
	}

	static int getBit(int binary, int position) {
		return binary >> position % 2;
	}

	static int eliminate(ArrayList data, boolean most) {
		int length = 12;  //I'm sure theres a better way to do this but *shrug emoji* 
		for (int i = 0; i < length; i++) {		//iterate through bit position, 
			// int bit = mostCommon(data, length - i);
			int bit = (most) ? (mostCommon(data, length - i) & 0x1) : ~(mostCommon(data, length - i)) & 0x1;
			System.out.println("Position : " + i + " Bit : " + bit);
			for (int x = 0; x < data.size(); x++) {
				if (data.size() == 1) {
					System.out.println(data.get(x));
					return (int) data.get(x);
				}else if ((getBit((int) data.get(x), i) & 0x1)!= bit) {
					data.remove(x);
				}
			}
		}
	
		return 0;

	}
		
	public static void main(String[] args) {
		System.out.print("Part one: ");
		ArrayList<Integer> report = new ArrayList<Integer>();
		int[] frequency = new int[12];
		int gamma, epsilon;

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
		System.out.println(report);

		for (int i = 0; i < report.size(); i++) {
			frequency = count(report.get(i), frequency);
		}
		
		gamma = countArrayToBinary(frequency, report.size());
		System.out.println(gamma);
		System.out.println(Integer.toBinaryString(gamma));
		epsilon = ~(gamma) & 0xfff;
		System.out.println(epsilon);
		System.out.println(Integer.toBinaryString(epsilon));
		System.out.println(gamma*epsilon);

		//Rough sketch: put values into arrays, iterate through Arrays adding each column then check
		//against Arraylist length divided by two, 1 if greater, 0 if lesser, adding this to gamma then
		//left shift bit <<. Chop off to where they should be with & 0xff *shrug emoji*

		System.out.println("Part two: ");
		int oxy = eliminate(report, true);
		System.out.println(oxy);
		int carbon = eliminate(report, false);
		System.out.println(carbon);
		// System.out.println(oxy*carbon);
	}
}
