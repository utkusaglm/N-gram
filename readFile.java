import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {


    Scanner scanner;
    private int height;
    private int width;
    private int numberOfObstacles;
    //public static String inputStr="";
    private ArrayList<String> fileArray = new ArrayList<>();
    public static String stringIns;
    private int count =0;



    public void openFile() {
        try {
            scanner = new Scanner(new File(NgramExtractor.pathNamein));

        } catch (Exception e) {

        }
    }

    public void readFile() {


        while (scanner.hasNext()) {

            String as = scanner.next().trim().toLowerCase();
            as = as.replaceAll("\\p{Punct}", "");


            String as1 = as + " ";
            stringIns += as1;

            fileArray.add(as);
            count++;

        }


    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public void setNumberOfObstacles(int numberOfObstacles) {
        this.numberOfObstacles = numberOfObstacles;
    }

    public void closeFile() {

        scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<String> getFileArray() {
        return fileArray;
    }

    public void setFileArray(ArrayList<String> fileArray) {
        this.fileArray = fileArray;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
