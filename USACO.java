import java.util.*;
import java.io.*;
public class USACO{
  public static int bronze(String filename){
    int elevation;
    int moves;
    int lines = 1;
    String[] data;
    int[][] field = new int [0][0];
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
        System.out.println(field);
       }
       lines += 1;
       }
     }
     catch(FileNotFoundException e){
       System.out.println("errrror");
     }
    // System.out.println(field);
     return -1;
  }
  public String toString(){
    String ans = "";
    for (int r =0; r < field.length; r++){
      for (int c =0; c <field[r].length; c++){
        ans += field[r][c];
      }
      ans += "\n";
    }
    return ans;
  }
  public static void main(String[] args) {
    bronze("bronze.txt");
  }
}
