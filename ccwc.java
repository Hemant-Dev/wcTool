import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ccwc {
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
            default:
                break;
        }
    }
    private static long getNoOfLines(File file) throws FileNotFoundException{
        long noOfLines = 0;
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            noOfLines++;
            sc.nextLine();
        }
        sc.close();
        return noOfLines;
    }
}