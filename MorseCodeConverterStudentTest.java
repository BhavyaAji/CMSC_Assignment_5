import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

public class MorseCodeConverterStudentTest {

	@Test
	public void testConvertToEnglishString() {
		assertEquals("sos", MorseCodeConverter.convertToEnglish("... --- ..."));
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		File file = new File("test.txt");
		PrintWriter writer = new PrintWriter(file);
		writer.print("...");
		writer.close();

		assertEquals("s", MorseCodeConverter.convertToEnglish(file));

		file.delete();
	}

	@Test
	public void testPrintTree() {
		String result = MorseCodeConverter.printTree();
		assertNotNull(result);
	}
}