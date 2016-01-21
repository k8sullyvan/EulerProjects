import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class p018_MaximumPathSumI {

	int[][] triangularArray;
	int[] path;

	public static void main(String[] args) {
		new p018_MaximumPathSumI();

	}

	public p018_MaximumPathSumI() {
		readFile();

		path = new int[triangularArray.length];
		path[0] = 0;
		maxPath(0, 0);

		for (int i = 0; i < path.length; i++) {
			System.out.print(triangularArray[i][path[i]] + ", ");
		}
	}

	private int sumSubSet(int row, int position) {
		int sum = 0;
		for (int i = 0; i < triangularArray.length - row; i++) {
			for (int j = 0; j <= i; j++) {
				sum += triangularArray[row + i][position + j];
			}
		}
		return sum;
	}

	private void maxPath(int row, int position) {
		row++;
		if (row >= triangularArray.length)
			return;

		int left = position;
		int right = position + 1;

		if (sumSubSet(row, left) > sumSubSet(row, right)) {
			position = left;
		} else {
			position = right;
		}
		path[row] = position;
		maxPath(row, position);
	}
	
	private void readFile() {
		File file = new File(System.getProperty("user.dir"));
		File textFile = new File(file, "//textFiles//mediumTriangle");
		System.out.println("File: " + textFile);
		
		try {
			FileReader fr = new FileReader(textFile);
			BufferedReader br = new BufferedReader(fr);
			
			triangularArray = new int[15][15];
			String currentLine;
			int lineCount = 0;
			while ((currentLine = br.readLine()) != null) {
				String[] line = currentLine.split(" ");
				for (int i = 0; i < line.length; i++) {
					triangularArray[lineCount][i] = Integer.parseInt(line[i].trim());
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
