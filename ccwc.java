import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ccwc {
    private static Scanner sc;
    public static void main(String[] args) throws FileNotFoundException{
        String command = args[0];
        String fileName = args[1];
        String filePath = "E:/github/Hemant-Dev/wcTool/" + fileName;
    
        File file = new File(filePath);
        

        switch (command) {
            case "-c":
                System.out.println("Size: " + file.length());
                break;
            case "-l":
                System.out.println("Lines: " + getNoOfLines(file));
                break;
            case "-w":
                System.out.println("Words: " + getNoOfWords(file));
            default:
                break;
        }
    }
    private static long getNoOfLines(File file) throws FileNotFoundException{
        long noOfLines = 0;
        sc = new Scanner(file);
        while(sc.hasNextLine()){
            noOfLines++;
            sc.nextLine();
        }
        sc.close();
        return noOfLines;
    }
    private static long getNoOfWords(File file) throws FileNotFoundException{
        long words = 0;
        sc = new Scanner(new FileInputStream(file));
        try {
            FileWriter outFile = new FileWriter("output.txt");
            while(sc.hasNext()){
                outFile.write(sc.next() + " || ");
                words++;
            }
            outFile.close();
        }
        catch(Exception e){
            System.out.println("Exception Occurs");
        }
        return words;
    }
}