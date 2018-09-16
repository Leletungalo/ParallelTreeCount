import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class parallelThreeCount {
    private static long startTime = 0;

    private static void tick(){
        startTime = System.currentTimeMillis();
    }
    private static float tock(){
        return (System.currentTimeMillis() - startTime) / 1000.0f;
    }
    private static final ForkJoinPool fjPool = new ForkJoinPool();
    private static ArrayList<Double> sum(int[][] arr){
        return fjPool.invoke(new thread(arr,0,arr.length));
    }
     private static Double sum2(ArrayList<Double> list){
        return fjPool.invoke(new treadForAvg(list,0,list.size()));
     }

    public static void main(String [] agrs){
     //  if (agrs.length > 0) {
        tick();
            readData data = new readData("sample_input.txt");
            ArrayList<Double> treeTotals = sum(data.getTreesLocation());
            float time1 = tock();

            tick();
            double totalForAll = sum2(treeTotals);
            float time2 = tock();

            tick();
            File file = new File("sample_out.txt");


            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                int treenum = readData.numberOfTrees;
                out.write(String.valueOf(totalForAll/treenum));
                out.newLine();
                out.write(String.valueOf(treenum));
                out.newLine();
                for (Double treeTotal : treeTotals) {
                    double oneTotal = treeTotal;
                   // System.out.println(oneTotal);
                    out.write(String.valueOf(oneTotal));
                    out.newLine();
                }
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            float time3 = tock();
            System.out.println("Time 1 is: "+time1);

            System.out.println("Time 2 is: " + time2);

            System.out.println("Time 3 is: " + time3);

      /*  }else {
            System.out.println("No file Entered");
        }*/
    }
}
