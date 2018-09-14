import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readData {
    public static float[][] data;
    private int[][] treesLocation;

    public readData(String fileName){
        File file = new File(fileName);
        Scanner scan;

        try {
            scan = new Scanner(file);
            int x = scan.nextInt();
            int y = scan.nextInt();
            data = new float[x][y];
            scan.nextLine();
            for (int row =0 ; row < x ; row++ ){
                for (int cal = 0; cal < y ; cal++){
                    data [row][cal] = Float.parseFloat(scan.next());
                }
            }
            scan.nextLine();

            int numberOfTrees = scan.nextInt();
            treesLocation = new int[numberOfTrees][3];
            scan.nextLine();

            int xOfTree;
            int yOfTree;
            int lengthOfTree;

            for (int i = 0; i < numberOfTrees; i++){
                xOfTree = scan.nextInt();
                yOfTree = scan.nextInt();
                lengthOfTree = scan.nextInt();

                int[] arr = {xOfTree,yOfTree,lengthOfTree};

                treesLocation[i] = arr;
                scan.nextLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
            e.getStackTrace();
        }
    }

    public int[][] getTreesLocation() {
        return treesLocation;
    }
}
