import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    FilePartReader(){
        this.filePath = "src/XDXD.xd";
        this.fromLine = -1;
        this.toLine = -2;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine){
        if(toLine<fromLine || fromLine<1)
            throw new IllegalArgumentException();
        this.fromLine = fromLine;
        this.toLine = toLine;
        this.filePath = filePath;
    }

    public String read()throws IOException {
        Scanner scan  = new Scanner(new File(filePath));
        String content = "";
        while(scan.hasNextLine()){
            content +=  scan.nextLine();
        }
        return content;
    }
    public String readLines()throws IOException {
        Scanner scan  = new Scanner(new File(filePath));
        String content = "";
        int currentLine = 1;
        while(scan.hasNext()){
            if(inRangeFromTo(currentLine))
                content += scan.nextLine()+" ";
            else{
                scan.nextLine();
            }
            currentLine++;
        }
        return content.substring(0,content.length()-1);
    }

    private boolean inRangeFromTo(int currentLine) {
        return currentLine>=fromLine && currentLine <=toLine;
    }
}
