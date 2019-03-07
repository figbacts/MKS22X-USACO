import java.util.*;
import java.io.*;
public class USACO{
  private static int[][] field;
  private static int elevation;
  private static int moves;
  public static int bronze(String filename){
    elevation = -1;
    moves = -1;
    int lines = 1;
    String[] data;
     try{
       File text = new File(filename);
       Scanner stuff = new Scanner(text);
       while(stuff.hasNextLine()){
         String line = stuff.nextLine();

         data = line.split(" ");
         if (lines == 1){
         field = new int[Integer.parseInt(data[0])][Integer.parseInt(data[1])];
         elevation = Integer.parseInt(data[2]);
         moves = Integer.parseInt(data[3]);
       }
       if (lines > 1 && lines < field.length +2){
         for (int c = 0; c < data.length; c++){
           field[lines-2][c] = Integer.parseInt(data[c]);
         }
       }
       if (lines >= field.length +2){
         int biggest = 0;
         for(int cowr = Integer.parseInt(data[0]) -1; cowr <Integer.parseInt(data[0]) +2; cowr++){
           for(int cowc = Integer.parseInt(data[1]) -1; cowc <Integer.parseInt(data[1]) +2; cowc++){
             System.out.println(biggest + "\n" + field[cowr][cowc] + "\n");
            System.out.println(cowr + " "+ cowc);
             if (field[cowr][cowc] > biggest){
               biggest = field[cowr][cowc];
             }
           }
         }
        biggest -= Integer.parseInt(data[2]);
        for(int cowr = Integer.parseInt(data[0]) -1; cowr <Integer.parseInt(data[0]+ 2); cowr++){
          for(int cowc = Integer.parseInt(data[1]) -1; cowr <Integer.parseInt(data[1 +2]); cowc++){
            if (field[cowr][cowc] > biggest){
              field[cowr][cowc] = biggest;
            }
          }
        }
       }
       lines += 1;

      System.out.println(line);
       }

     }
     catch(FileNotFoundException e){
       System.out.println("errrror");
     }
    System.out.println("\n");
     String ans = "";
     for (int r =0; r < field.length; r++){
       for (int c =0; c <field[r].length; c++){
         ans += field[r][c] + " ";
       }
       ans += "\n";
     }
     //System.out.println(elevation + " " + moves);
     System.out.println(ans);

   return -1;
  }

  public static void main(String[] args) {
    bronze("bronze.txt");
  }
}
