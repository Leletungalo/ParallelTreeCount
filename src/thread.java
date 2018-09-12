
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class thread extends RecursiveTask<Double> {
    private int lo; // arguments
    private int hi;
    private int[][] arr;
    private static final int SEQUENTIAL_CUTOFF = 500;
    ArrayList<Double> totalForTree;
    //static ArrayList<Double> newList;
    //int ans = 0; // result

    public thread(int[][] a, int l, int h) {
        lo=l; hi=h; arr=a;
    }


    protected Double compute(){// return answer - instead of run
        if((hi-lo) < SEQUENTIAL_CUTOFF) {
            float[][] dataaa = readData.data;
            Double ans = 0.0;
            totalForTree = new ArrayList<>();
            for(int i=lo; i < hi; i++){
                int xOfTree = arr[i][0];
                int yOfTree = arr[i][1];
                int lengthOfTree = arr[i][2];

                int xr = xOfTree;
                int yr = yOfTree;

                for (int z = 0 ; z < lengthOfTree; z++) {
                    try {
                        for (int l = 0; l < lengthOfTree ;l++){
                        float sss = dataaa[xOfTree][yOfTree];
                        ans += sss;
                        yOfTree++;}
                    }catch (ArrayIndexOutOfBoundsException e){}

                    yOfTree = yr;
                    xOfTree = xr + 1;
                    xr++;
                }
                totalForTree.add(ans);
                //total for tree will here
            }
            return ans;
        }
        else {
            thread left = new thread(arr,lo,(hi+lo)/2);
            thread right= new thread(arr,(hi+lo)/2,hi);

            // order of next 4 lines
            // essential – why?
            left.fork();
            Double rightAns = right.compute();
            Double leftAns  = left.join();
         /*   newlist = new ArrayList<Double>();
            newlist.addAll(left.totalForTree);
            newlist.addAll(right.totalForTree);*/
            return leftAns + rightAns;
        }
    }
}