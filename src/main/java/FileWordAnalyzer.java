import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        return Arrays.stream(filePartReader.readLines().split(" "))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        return Arrays.stream(filePartReader.readLines().split(" "))
                .filter(n-> n.contains(subString))
                .collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        return Arrays.stream(filePartReader.readLines().split(" "))
                .filter(n-> new StringBuilder(n).reverse().toString().equals(n))
                .collect(Collectors.toList());
    }

}
