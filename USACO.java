import java.util.*;
import java.io.*;
public class USACO{
  public static int bronze(String filename){
    int elevation = -1;
    int moves = -1;
    int[][] field = new int[1][1];
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
             //System.out.println(biggest + "\n" + field[cowr][cowc] + "\n");
             //System.out.println(cowr + " "+ cowc);
             if (field[cowr][cowc] > biggest){
               biggest = field[cowr][cowc];
             }
           }
         }
        biggest -= Integer.parseInt(data[2]);
        for(int cowr = Integer.parseInt(data[0]) -1; cowr <Integer.parseInt(data[0])+2; cowr++){
          for(int cowc = Integer.parseInt(data[1]) -1; cowc <Integer.parseInt(data[1])+2; cowc++){
            if (field[cowr][cowc] > biggest){
              field[cowr][cowc] = biggest;
            }
          }
        }
       }
       lines += 1;

      //System.out.println(line);
       }
     }
     catch(FileNotFoundException e){
       System.out.println("errrror");
     }
     int vol =0;
     for (int r =0; r < field.length; r++){
       for (int c =0; c <field[r].length; c++){
         if(elevation -field[r][c] > 0){
           vol += elevation - field[r][c];
         }
       }
     }
     return vol * 5184;
     /*
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
   */
  }
  public static int silver(String filename){
    int[][] grass = new int[1][1];
    int [][] grassmove = new int[1][1];
    int seconds = 0;
    int startx = 0;
    int starty = 0;
    int endx = 0;
    int endy = 0;
    int lines = 1;
    String[] data;
     try{
       File text = new File(filename);
       Scanner stuff = new Scanner(text);
       while(stuff.hasNextLine()){
         String line = stuff.nextLine();
         data = line.split(" ");
         if (lines == 1){
           grass = new int[Integer.parseInt(data[0])][Integer.parseInt(data[1])];
           grassmove= new int[Integer.parseInt(data[0])][Integer.parseInt(data[1])];
           seconds = Integer.parseInt(data[2]);
         }
         if(lines > 1 && lines <= grass.length +1){
           for (int c = 0; c < line.length(); c++){
             grass[lines-2][c] = line.charAt(c);
             if(line.charAt(c) == '.'){
               grass[lines-2][c] = 0;
               grassmove[lines-2][c] = 0;
             }
             if (line.charAt(c) == '*'){
               grass[lines-2][c] = -1;
               grassmove[lines-2][c] = -1;
             }
           }
         }
         if (lines == grass.length +2){
           startx = Integer.parseInt(data[0]);
           starty = Integer.parseInt(data[1]);
           endx = Integer.parseInt(data[2]);
           endy = Integer.parseInt(data[3]);
         }
         lines += 1;
  }
}
catch(FileNotFoundException e){
  System.out.println("errrror");
}
System.out.println("\n");
grass[startx-1][starty-1] = 1;
while (seconds != 0){
  for(int r = 0;r <grass.length-1; r++){
    for(int c = 1; c < grass[r].length-1; c++){
      if (r == 0){
        if (grass[r][c] > 0 && grass[r+1][c]<1 && grass[r][c-1] <1 && grass[r][c+1]<1){
          grassmove[r][c]= 0;
        }
        if(grass[r][c] == 0){
          int plus = 0;
          if (grass[r+1][c] >0){
            plus += grass[r+1][c];
          }
          if (grass[r][c+1] >0){
            plus += grass[r][c+1];
          }
          if (grass[r][c-1] >0){
            plus += grass[r][c+1];
          }
          grassmove[r][c] = plus;
        }
      }
      else{
      if (r == grass.length-1){
        if (grass[r][c] > 0 && grass[r-1][c] <1 && grass[r][c-1] <1 && grass[r][c+1]<1){
          grassmove[r][c]= 0;
        }
        if(grass[r][c] == 0){
          int plus = 0;
          if (grass[r-1][c] >0){
            plus += grass[r-1][c];
          }
          if (grass[r][c-1] >0){
            plus += grass[r][c-1];
          }
          if (grass[r][c+1] >0){
            plus += grass[r][c+1];
          }
          grassmove[r][c] = plus;
        }
      }
      else{
      if(c == 0){
        if (grass[r][c] > 0 && grass[r-1][c] <1 && grass[r+1][c]<1 && grass[r][c+1]<1){
          grassmove[r][c]= 0;
        }
        if(grass[r][c] == 0){
          int plus = 0;
          if (grass[r-1][c] >0){
            plus += grass[r-1][c];
          }
          if (grass[r+1][c] >0){
            plus += grass[r+1][c];
          }
          if (grass[r][c+1] >0){
            plus += grass[r][c+1];
          }
          grassmove[r][c] = plus;
        }
      }
      else{
      if (c == grass.length -1){
        if (grass[r][c] > 0 && grass[r-1][c] <1 && grass[r+1][c]<1 && grass[r][c-1] <1){
          grassmove[r][c]= 0;
        }
        if(grass[r][c] == 0){
          int plus = 0;
          if (grass[r-1][c] >0){
            plus += grass[r-1][c];
          }
          if (grass[r+1][c] >0){
            plus += grass[r+1][c];
          }
          if (grass[r][c-1] >0){
            plus += grass[r][c-1];
          }
          grassmove[r][c] = plus;
        }
      }
      if (grass[r][c] > 0 && grass[r-1][c] <1 && grass[r+1][c]<1 && grass[r][c-1] <1 && grass[r][c+1]<1){
        grassmove[r][c]= 0;
      }
      if(grass[r][c] == 0){
        int plus = 0;
        if (grass[r-1][c] >0){
          plus += grass[r-1][c];
        }
        if (grass[r+1][c] >0){
          plus += grass[r+1][c];
        }
        if (grass[r][c-1] >0){
          plus += grass[r][c-1];
        }
        if (grass[r][c+1] >0){
          plus += grass[r][c+1];
        }
        grassmove[r][c] = plus;
      }
    }
  }
    }
    }
  }
  for(int r = 1;r <grass.length-1; r++){
    for(int c = 1; c < grass[r].length-1; c++){
      grass[r][c] = grassmove[r][c];
    }
  }
  seconds -= 1;

}
System.out.println("\n");
 String ans = "";
 for (int r =0; r < grassmove.length; r++){
   for (int c =0; c <grassmove[r].length; c++){
     if (grass[r][c] > 9 || grass[r][c] < 0 ){
       ans += " " + grass[r][c];
     }
     else{
     ans += "  " + grass[r][c];
   }
 }
   ans += "\n";
 }
 System.out.println(seconds + " " + startx + " " + starty + " " + endx + " " + endy);
 System.out.println(ans);
return  grass[endx-1][endy-1];
}

  public static void main(String[] args) {
    System.out.println(silver("silver.txt"));
  }
}
