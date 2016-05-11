package eulerproblems.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
	private String filePath;	
	
	public void setFilePath(String path) {
		this.filePath = path;
	}
	public String getFilePath() {
		return this.filePath;
	}	
	
	public List<String> readFileByLine() {
		BufferedReader br = null;
		List<String> list = new ArrayList<>();
		
		try {
			String currentLine;			
			br = new BufferedReader(new FileReader(filePath));
			while((currentLine = br.readLine()) != null) {
				list.add(currentLine);
				//System.out.println(currentLine);
			}
		} catch(IOException e) {
			System.out.println("Error trying to read to file");
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				System.out.println("Error trying to close the file");
				e.printStackTrace();
			}
		}
		return list;
	}

}
