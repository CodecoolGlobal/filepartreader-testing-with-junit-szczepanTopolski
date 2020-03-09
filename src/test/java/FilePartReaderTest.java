import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;

public class FilePartReaderTest {
    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void setupInvalidLinesInitializationThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class,()->{filePartReader.setup(" ", 0, -1);});
    }

    @Test
    public void readInvalidFilePathThrowsException() {
        Assertions.assertThrows(IOException.class, filePartReader::read);
    }
    @Test
    public void readLinesInvalidFilePathThrowsException() {
        Assertions.assertThrows(IOException.class, filePartReader::readLines);
    }
    @Test
    public void readReturnsPropertyValue() throws IOException {
        filePartReader.setup("src/main/resources/oneLineOfWords.txt",1,1);
        String expected = "xd xd xd";
        String actual = filePartReader.read();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void readLineReturnsPropertyValueFromOneLine() throws IOException {
        filePartReader.setup("src/main/resources/words.txt",3,3);
        String expected = "xd fiki miki ciamciaramciam giligili cyk cyk";
        String actual = filePartReader.readLines();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void readLineReturnsPropertyValueFromManyLines() throws IOException {
        filePartReader.setup("src/main/resources/words.txt",2,3);
        String expected = "Okeeey boomer ola ma kota kot ma ale itd itd xd fiki miki ciamciaramciam giligili cyk cyk";
        String actual = filePartReader.readLines();
        Assertions.assertEquals(expected, actual);
    }
}