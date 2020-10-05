package games;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class CampaignGenerator {
	public static void main(String[] args) {
		boolean cont = true;
		Scanner s = new Scanner(System.in);
		int[] fileLengths = checkFiles();
		
		while(cont) {
			System.out.println("Would you like to generate a:\na - Continent\nb - Country\nc - Nothing");
			char gen = s.next().charAt(0);
			
			//continent generator
			if (gen == 'a') {
				//name and size of continent
				//size is the number of biomes in the continent
				System.out.println("Name of continent: " + getName("continent", fileLengths[0]));
				System.out.println();
				int size = (int)(Math.random()*6+4);
				System.out.println(size + " total biomes:");
				
				//establishes available biomes
				int[] biomes = new int[11];
				boolean forest = false, desert = false, swamp = false, plains = false, mountains = false;
				boolean hills = false, volcanic = false, taiga = false, arctic = false, sahara = false;
				boolean tropical = false;
				
				//decide which biomes to use, and how many
				for (int i = 0; i < size; i++) {
					int biome = (int)(Math.random()*112);
					
					if (biome < 12) {
						forest = true;
						biomes[0]++;
					} else if (biome < 22) {
						desert = true;
						biomes[1]++;
					} else if (biome < 33) {
						swamp = true;
						biomes[2]++;
					} else if (biome < 48) {
						plains = true;
						biomes[3]++;
					} else if (biome < 59) {
						mountains = true;
						biomes[4]++;
					} else if (biome < 72) {
						hills = true;
						biomes[5]++;
					} else if (biome < 78) {
						volcanic = true;
						biomes[6]++;
					} else if (biome < 87) {
						taiga = true;
						biomes[7]++;
					} else if (biome < 91) {
						arctic = true;
						biomes[8]++;
					} else if (biome < 100) {
						sahara = true;
						biomes[9]++;
					} else if (biome < 112) {
						tropical = true;
						biomes[10]++;
					}
				}
				
				if (forest) System.out.println("-Forests: " + biomes[0]);
				if (desert) System.out.println("-Deserts: " + biomes[1]);
				if (swamp) System.out.println("-Swamps: " + biomes[2]);
				if (plains) System.out.println("-Plains: " + biomes[3]);
				if (mountains) System.out.println("-Mountainous regions: " + biomes[4]);
				if (hills) System.out.println("-Hilly regions: " + biomes[5]);
				if (volcanic) System.out.println("-Volcanic regions: " + biomes[6]);
				if (taiga) System.out.println("-Taigas: " + biomes[7]);
				if (arctic) System.out.println("-Arctic regions: " + biomes[8]);
				if (sahara) System.out.println("-Saharas: " + biomes[9]);
				if (tropical) System.out.println("-Tropical regions: " + biomes[10]);
			}
			
			//country generator
			else if (gen == 'b') {
				System.out.println("Country name: " + getName("country", fileLengths[1]));
				System.out.println("Government type: " + getName("government", fileLengths[4]));
				System.out.println("Economy type: " + getName("economy", fileLengths[5]));
			}
			
			//ends the generator
			else if (gen == 'c') cont = false;
			
			else System.out.println("Improper input. Please choose a, b, or c\n");
		}
		
		s.close();
	}
	
	//grabs random element from the files with the list of names
	public static String getName(String type, int fileLength) {
		String name = "";
		String user = System.getProperty("user.name");
		int line = (int)(Math.random()*fileLength);
		
		try {
			if (type == "continent") {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\continentNames.txt");
				BufferedReader read = new BufferedReader(fw);
				for(int i = 0; i < line; i++) name = read.readLine();
				read.close();
			}
			if (type == "country") {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\countryNames.txt");
				BufferedReader read = new BufferedReader(fw);
				for(int i = 0; i < line; i++) name = read.readLine();
				read.close();
			}
			if (type == "city") {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\cityNames.txt");
				BufferedReader read = new BufferedReader(fw);
				for(int i = 0; i < line; i++) name = read.readLine();
				read.close();
			}
			if (type == "town") {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\townNames.txt");
				BufferedReader read = new BufferedReader(fw);
				for(int i = 0; i < line; i++) name = read.readLine();
				read.close();
			}
			if (type == "government") {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\governmentTypes.txt");
				BufferedReader read = new BufferedReader(fw);
				for(int i = 0; i < line; i++) name = read.readLine();
				read.close();
			}
			if (type == "economy") {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\economyTypes.txt");
				BufferedReader read = new BufferedReader(fw);
				for(int i = 0; i < line; i++) name = read.readLine();
				read.close();
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return name;
	}
	
	public static int[] checkFiles() {
		//returns an array where the values are the number of possible continent, country, city, and town names, in that order
		int[] fileLengths = new int[6];
		
		String user = System.getProperty("user.name");
		try {
			File continents = new File("C:\\Users\\" + user + "\\continentNames.txt");
			File countries = new File("C:\\Users\\" + user + "\\countryNames.txt");
			File cities = new File("C:\\Users\\" + user + "\\cityNames.txt");
			File towns = new File("C:\\Users\\" + user + "\\townNames.txt");
			File govTypes = new File("C:\\Users\\" + user + "\\governmentTypes.txt");
			File econTypes = new File("C:\\Users\\" + user + "\\economyTypes.txt");
			
			if (!continents.exists()) {
				FileWriter fw = new FileWriter("C:\\Users\\" + user + "\\continentNames.txt");
				BufferedWriter writeFile = new BufferedWriter(fw);
				
				writeFile.write("Aerenal");
				writeFile.newLine();
				writeFile.write("Aman");
				writeFile.newLine();
				writeFile.write("Anchrome");
				writeFile.newLine();
				writeFile.write("Argonnessen");
				writeFile.newLine();
				writeFile.write("Arnesse");
				writeFile.newLine();
				writeFile.write("Cantor");
				writeFile.newLine();
				writeFile.write("Dragaera");
				writeFile.newLine();
				writeFile.write("Erest");
				writeFile.newLine();
				writeFile.write("Essos");
				writeFile.newLine();
				writeFile.write("Everice");
				writeFile.newLine();
				writeFile.write("Flanaess");
				writeFile.newLine();
				writeFile.write("Gamroth");
				writeFile.newLine();
				writeFile.write("Genertela");
				writeFile.newLine();
				writeFile.write("Goethel");
				writeFile.newLine();
				writeFile.write("Hansyl");
				writeFile.newLine();
				writeFile.write("Helet");
				writeFile.newLine();
				writeFile.write("Hyboria");
				writeFile.newLine();
				writeFile.write("Ironia");
				writeFile.newLine();
				writeFile.write("Jalat");
				writeFile.newLine();
				writeFile.write("Kandan");
				writeFile.newLine();
				writeFile.write("Karatur");
				writeFile.newLine();
				writeFile.write("Karain");
				writeFile.newLine();
				writeFile.write("Lemyria");
				writeFile.newLine();
				writeFile.write("Maldahar");
				writeFile.newLine();
				writeFile.write("Merapis");
				writeFile.newLine();
				writeFile.write("Midcyru");
				writeFile.newLine();
				writeFile.write("Nalfagar");
				writeFile.newLine();
				writeFile.write("Nonestica");
				writeFile.newLine();
				writeFile.write("Onterat");
				writeFile.newLine();
				writeFile.write("Ophiucha");
				writeFile.newLine();
				writeFile.write("Ryeka");
				writeFile.newLine();
				writeFile.write("Sarlona");
				writeFile.newLine();
				writeFile.write("Tibar");
				writeFile.newLine();
				writeFile.write("Valinar");
				writeFile.newLine();
				writeFile.write("Zothique");
				writeFile.newLine();
				
				writeFile.close();
				
				fileLengths[0] = 35;
			} else {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\continentNames.txt");
				BufferedReader read = new BufferedReader(fw);
				int lines = 0;
				while (read.readLine() != null) lines++;
				fileLengths[0] = lines;
				
				read.close();
			}
			
			if (!countries.exists()) {
				FileWriter fw = new FileWriter("C:\\Users\\" + user + "\\countryNames.txt");
				BufferedWriter writeFile = new BufferedWriter(fw);
				
				writeFile.write("Amasia");
				writeFile.newLine();
				writeFile.write("Alvarado");
				writeFile.newLine();
				writeFile.write("Alterra");
				writeFile.newLine();
				writeFile.write("Avalonia");
				writeFile.newLine();
				writeFile.write("Bersu");
				writeFile.newLine();
				writeFile.write("Cakiur");
				writeFile.newLine();
				writeFile.write("Cimmeria");
				writeFile.newLine();
				writeFile.write("Dione");
				writeFile.newLine();
				writeFile.write("Goldcoast");
				writeFile.newLine();
				writeFile.write("Idorta");
				writeFile.newLine();
				writeFile.write("Kolania");
				writeFile.newLine();
				writeFile.write("Kumari");
				writeFile.newLine();
				writeFile.write("L'Guardia");
				writeFile.newLine();
				writeFile.write("Metis");
				writeFile.newLine();
				writeFile.write("Nidvalir");
				writeFile.newLine();
				writeFile.write("Poracia");
				writeFile.newLine();
				writeFile.write("Quatora");
				writeFile.newLine();
				writeFile.write("Schiphol");
				writeFile.newLine();
				writeFile.write("Thessia");
				writeFile.newLine();
				writeFile.write("Thetis");
				writeFile.newLine();
				writeFile.write("Thropen");
				writeFile.newLine();
				writeFile.write("Thuria");
				writeFile.newLine();
				writeFile.write("Tyrancia");
				writeFile.newLine();
				writeFile.write("Valancia");
				writeFile.newLine();
				writeFile.write("Zion");
				writeFile.newLine();
				
				writeFile.close();
				
				fileLengths[1] = 25;
			} else {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\countryNames.txt");
				BufferedReader read = new BufferedReader(fw);
				int lines = 0;
				while (read.readLine() != null) lines++;
				fileLengths[1] = lines;
				
				read.close();
			}
			
			if (!cities.exists()) {
				FileWriter fw = new FileWriter("C:\\Users\\" + user + "\\cityNames.txt");
				BufferedWriter writeFile = new BufferedWriter(fw);
				
				writeFile.write("Anahorst");
				writeFile.newLine();
				writeFile.write("Alryne");
				writeFile.newLine();
				writeFile.write("Guggenheim");
				writeFile.newLine();
				writeFile.write("Ghoulcrest");
				writeFile.newLine();
				writeFile.write("Haneda");
				writeFile.newLine();
				writeFile.write("Maitreya");
				writeFile.newLine();
				writeFile.write("Meili");
				writeFile.newLine();
				writeFile.write("Mokosh");
				writeFile.newLine();
				writeFile.write("Nishder");
				writeFile.newLine();
				writeFile.write("Parktra");
				writeFile.newLine();
				writeFile.write("Perun");
				writeFile.newLine();
				writeFile.write("Rosenwalk");
				writeFile.newLine();
				writeFile.write("Tashigh");
				writeFile.newLine();
				writeFile.write("Vaeasa");
				writeFile.newLine();
				writeFile.write("Veles");
				writeFile.newLine();
				writeFile.write("Vydar");
				writeFile.newLine();
				writeFile.write("Xanholt");
				writeFile.newLine();
				
				writeFile.close();
				
				fileLengths[2] = 17;
			} else {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\cityNames.txt");
				BufferedReader read = new BufferedReader(fw);
				int lines = 0;
				while (read.readLine() != null) lines++;
				fileLengths[2] = lines;
				
				read.close();
			}
			
			if (!towns.exists()) {
				FileWriter fw = new FileWriter("C:\\Users\\" + user + "\\townNames.txt");
				BufferedWriter writeFile = new BufferedWriter(fw);
				
				writeFile.write("Attpa");
				writeFile.newLine();
				writeFile.write("Blackvale");
				writeFile.newLine();
				writeFile.write("Dazbog");
				writeFile.newLine();
				writeFile.write("Fletching");
				writeFile.newLine();
				writeFile.write("Frostford");
				writeFile.newLine();
				writeFile.write("Garud");
				writeFile.newLine();
				writeFile.write("Gerpe");
				writeFile.newLine();
				writeFile.write("Ghullstone");
				writeFile.newLine();
				writeFile.write("Lackvil");
				writeFile.newLine();
				writeFile.write("Lemat");
				writeFile.newLine();
				writeFile.write("Lockheed");
				writeFile.newLine();
				writeFile.write("Pointybridge");
				writeFile.newLine();
				writeFile.write("Mou");
				writeFile.newLine();
				writeFile.write("Scrabben");
				writeFile.newLine();
				writeFile.write("Sharpstone");
				writeFile.newLine();
				writeFile.write("Surt");
				writeFile.newLine();
				writeFile.write("Throd");
				writeFile.newLine();
				
				writeFile.close();
				
				fileLengths[3] = 17;
			} else {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\townNames.txt");
				BufferedReader read = new BufferedReader(fw);
				int lines = 0;
				while (read.readLine() != null) lines++;
				fileLengths[3] = lines;
				
				read.close();
			}
			
			if (!govTypes.exists()) {
				FileWriter fw = new FileWriter("C:\\Users\\" + user + "\\governmentTypes.txt");
				BufferedWriter writeFile = new BufferedWriter(fw);
				
				writeFile.write("Stratocracy");
				writeFile.newLine();
				writeFile.write("Demarchy");
				writeFile.newLine();
				writeFile.write("Geniocracy");
				writeFile.newLine();
				writeFile.write("Direct Democracy");
				writeFile.newLine();
				writeFile.write("Constitutional Monarchy");
				writeFile.newLine();
				writeFile.write("Kleptocracy");
				writeFile.newLine();
				writeFile.write("Kraterocracy");
				writeFile.newLine();
				writeFile.write("Oligarchy");
				writeFile.newLine();
				writeFile.write("Theocracy");
				writeFile.newLine();
				writeFile.write("Meritocracy");
				writeFile.newLine();
				writeFile.write("Tribalism");
				writeFile.newLine();
				writeFile.write("Military Dictatorship");
				writeFile.newLine();
				writeFile.write("Anarchy");
				writeFile.newLine();
				writeFile.write("Absolute Monarchy");
				writeFile.newLine();
				writeFile.write("Banana Republic");
				writeFile.newLine();
				writeFile.write("Timocracy");
				writeFile.newLine();
				writeFile.write("Totalitarianism");
				writeFile.newLine();
				writeFile.write("Despotism");
				writeFile.newLine();
				writeFile.write("Feudalism");
				writeFile.newLine();
				writeFile.write("Democratic Republic");
				writeFile.newLine();
				
				writeFile.close();
				
				fileLengths[4] = 20;
			} else {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\governmentTypes.txt");
				BufferedReader read = new BufferedReader(fw);
				int lines = 0;
				while (read.readLine() != null) lines++;
				fileLengths[4] = lines;
				
				read.close();
			}
			
			if (!econTypes.exists()) {
				FileWriter fw = new FileWriter("C:\\Users\\" + user + "\\economyTypes.txt");
				BufferedWriter writeFile = new BufferedWriter(fw);
				
				writeFile.write("Complex Bartering System");
				writeFile.newLine();
				writeFile.write("Communism");
				writeFile.newLine();
				writeFile.write("Minarchism");
				writeFile.newLine();
				writeFile.write("Capitalism");
				writeFile.newLine();
				writeFile.write("Distributism");
				writeFile.newLine();
				writeFile.write("Liberal Capitalism");
				writeFile.newLine();
				writeFile.write("Socialism");
				writeFile.newLine();
				writeFile.write("Free-Market Capitalism");
				writeFile.newLine();
				writeFile.write("Free-Market Socialism");
				writeFile.newLine();
				writeFile.write("Laissez-Faire Capitalism");
				writeFile.newLine();
				
				writeFile.close();
				
				fileLengths[5] = 10;
			} else {
				FileReader fw = new FileReader("C:\\Users\\" + user + "\\economyTypes.txt");
				BufferedReader read = new BufferedReader(fw);
				int lines = 0;
				while (read.readLine() != null) lines++;
				fileLengths[5] = lines;
				
				read.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return fileLengths;
	}
}