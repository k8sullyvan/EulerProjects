import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class p011_LargestProductInGrid {

	private int[][] grid;

	public static void main(String[] args) {
		new p011_LargestProductInGrid();
	}

	public p011_LargestProductInGrid(){
		readFile();
		
		int maxProduct = 0;

		// Checks everything vertically
		for (int column = 0; column < grid.length; column++) {
			for (int item = 0; item < grid[column].length - 4; item++) {
				maxProduct = Math.max(maxProduct,
						grid[column][item] * grid[column][item + 1] * grid[column][item + 2] * grid[column][item + 3]);
			}
		}

		// Checks everything horizontally
		for (int column = 0; column < grid.length - 4; column++) {
			for (int item = 0; item < grid[column].length; item++) {
				maxProduct = Math.max(maxProduct,
						grid[column][item] * grid[column + 1][item] * grid[column + 2][item] * grid[column + 3][item]);
			}
		}

		// Checks everything diagonally right (South-East)
		for (int column = 0; column < grid.length - 4; column++) {
			for (int item = 0; item < grid[column].length - 4; item++) {
				maxProduct = Math.max(maxProduct, grid[column][item] * grid[column + 1][item + 1]
						* grid[column + 2][item + 2] * grid[column + 3][item + 3]);
			}
		}

		// Checks everything diagonally left (South-West)
		for (int column = 3; column < grid.length; column++) {
			for (int item = 0; item < grid[column].length - 4; item++) {
				maxProduct = Math.max(maxProduct, grid[column][item] * grid[column - 1][item + 1]
						* grid[column - 2][item + 2] * grid[column - 3][item + 3]);
			}
		}

		System.out.println(maxProduct);
	}

	
	private void readFile() {
		File file = new File(System.getProperty("user.dir"));
		File textFile = new File(file, "//textFiles//20x20grid");
		System.out.println("File: " + textFile);
		
		try {
			FileReader fr = new FileReader(textFile);
			BufferedReader br = new BufferedReader(fr);
			
			grid = new int[20][20];
			String currentLine;
			int lineCount = 0;
			while ((currentLine = br.readLine()) != null) {
				String[] line = currentLine.split(" ");
				for (int i = 0; i < line.length; i++) {
					grid[lineCount][i] = Integer.parseInt(line[i].trim());
				}
				lineCount++;
			}

//			Files.lines(textFile.toPath())
//			  .map(s -> s.trim())
//			 .filter(s -> !s.isEmpty())
//			 .forEach(System.out::println); 
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found :(");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
