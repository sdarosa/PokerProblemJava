package eulerproblems.helper;

public class TestFileReader {

	public static void main(String[] args) {
		MyFileReader fr = new MyFileReader();
		fr.setFilePath("C:\\testing.txt");
		fr.readFileByLine();
	}

}
