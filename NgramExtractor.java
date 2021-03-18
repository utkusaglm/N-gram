import java.io.*;
import java.util.*;

public class NgramExtractor {
    static HashMap<String, Integer> hashMap;
    static HashMap<String, Double> hashMapfr;
    static String stringIns;
    static String pathNamein;
    static String pathNameout;

    static int n;

    public static void main(String[] args) throws IOException {


        pathNamein=args[0];
        pathNameout=args[1];
        n=Integer.parseInt(args[2]);


        readFile readFile = new readFile();
        readFile.openFile();







        readFile.readFile();

        stringIns = readFile.stringIns.replaceAll("null", "");


        ArrayList<String> arr = new ArrayList<>();
        arr = readFile.getFileArray();

        hashMap = new HashMap<>();
        hashMapfr=new HashMap<>();



        findNew(n-1, arr);





        List<Integer>
        sort= new ArrayList<>(hashMap.values());

        Collections.sort(sort);
        StringBuilder sb = new StringBuilder();
        sb.append("ngram");
        sb.append(',');
        sb.append("count");
        sb.append(',');
        sb.append("frequency");
        sb.append('\n');

        for(String a:find){
            String as=a+","+hashMap.get(a)+","+hashMapfr.get(a);


            try (PrintWriter writer = new PrintWriter(new File(pathNameout))) {

                sb.append(a);
                sb.append(',');
                sb.append(hashMap.get(a));
                sb.append(',');
                sb.append(hashMapfr.get(a));
                sb.append('\n');

                writer.write(sb.toString());

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }



        }



        readFile.closeFile();

    }

   static ArrayList<String>find=new ArrayList<>();
    public static void findNew(int n, ArrayList<String> arr) {

        String outer = "";
        String insider = "";


        for (int i=0;i< arr.size();i++){
            int temp=i+n;
            if(temp<arr.size()){
                for(int j=i;j<=temp;j++){

                    insider+=arr.get(j);
                }
            }

            find.add(insider);
            outer+=insider;
            outer+=" ";

            insider="";


        }
        for(String a:find){

            hashMap.put(a,countOccurences(outer,a));

            double ratio=(double) countOccurences(outer,a)/arr.size();
            try{
                hashMapfr.put(a,ratio);
            }catch (Exception e){

            }



        }

    }

    public static int countOccurences(String str, String word) {
        // split the string by spaces in a
        String a[] = str.split(" ");

        // search for pattern in a
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            // if match found increase count
            if (word.equals(a[i]))
                count++;
        }

        return count;
    }




}
