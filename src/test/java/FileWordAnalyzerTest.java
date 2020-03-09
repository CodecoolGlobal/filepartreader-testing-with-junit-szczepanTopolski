import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzerTest {
    FilePartReader mockPartReader = Mockito.mock(FilePartReader.class);
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(mockPartReader);

    @Test
    public void getWordsOrderedAlphabeticallyReturnsProperValue() throws IOException {
        String init = "c d b a";
        Mockito.when(mockPartReader.readLines()).thenReturn(init);
        List<String> expected = Arrays.asList("a","b","c","d");
        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getWordsOrderedAlphabeticallyInitializedWithEmptyStringReturnsEmptyList() throws IOException {
        String init = "";
        Mockito.when(mockPartReader.readLines()).thenReturn(init);
        List<String> expected = Arrays.asList("");
        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getWordsContainingSubstingReturnsProperValue() throws IOException {
        String init = "cyk dupaxd xddupa bum bum";
        Mockito.when(mockPartReader.readLines()).thenReturn(init);
        List<String> expected = Arrays.asList("dupaxd","xddupa");
        List<String> actual = fileWordAnalyzer.getWordsContainingSubstring("dupa");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getWordsContainingSubstingInitializedWithEmptyStringReturnsEmptyList() throws IOException {
        String init = "";
        Mockito.when(mockPartReader.readLines()).thenReturn(init);
        List<String> expected =  new ArrayList<>();
        List<String> actual = fileWordAnalyzer.getWordsContainingSubstring("dupa");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getStringsWhichArePalindromesReturnsProperValue() throws IOException {
        String init = "ala ma kota kot ma ele kajak x";
        Mockito.when(mockPartReader.readLines()).thenReturn(init);
        List<String> expected = Arrays.asList("ala","ele","kajak","x");
        List<String> actual = fileWordAnalyzer.getStringsWhichPalindromes();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getStringsWhichArePalindromesInitializedWithoutPalindromesReturnsEmptyList() throws IOException {
        String init = "xd ma kota kot ela ela eee! umbrealla ela dx";
        Mockito.when(mockPartReader.readLines()).thenReturn(init);
        List<String> expected = new ArrayList<>();
        List<String> actual = fileWordAnalyzer.getStringsWhichPalindromes();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getStringsWhichArePalindromesInitializedWithEmptyStringReturnsEmptyList() throws IOException {
        String init = "";
        Mockito.when(mockPartReader.readLines()).thenReturn(init);
        List<String> expected = Arrays.asList("");
        List<String> actual = fileWordAnalyzer.getStringsWhichPalindromes();
        Assertions.assertEquals(expected, actual);
    }
}