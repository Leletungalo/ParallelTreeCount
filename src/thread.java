
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class thread extends RecursiveTask<ArrayList<Double>> {
    private int lo; // arguments
    private int hi;
    private int[][] arr;
    private static final int SEQUENTIAL_CUTOFF = 100;
    ArrayList<Double> totalForTree;
    Total total;
    //int ans = 0; // result

    public thread(int[][] a, int l, int h) {
        lo=l; hi=h; arr=a;
       total = new Total();
    }


    protected ArrayList<Double> compute(){// return answer - instead of run
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
                Double totalForOneTree = 0.0;

                for (int z = 0 ; z < lengthOfTree; z++) {
                    try {
                        for (int l = 0; l < lengthOfTree ;l++){
                        float sss = dataaa[xOfTree][yOfTree];
                        totalForOneTree += sss;
                        ans += sss;
                        yOfTree++;}
                    }catch (ArrayIndexOutOfBoundsException e){}

                    yOfTree = yr;
                    xOfTree = xr + 1;
                    xr++;
                }
                total.setNewList(totalForOneTree);
                //totalForTree.add(totalForOneTree);
                //total for tree will here
            }
            totalForTree.add(ans);
            return total.getNewList();
        }
        else {
            thread left = new thread(arr,lo,(hi+lo)/2);
            thread right= new thread(arr,(hi+lo)/2,hi);

            // order of next 4 lines
            // essential – why?
            left.fork();
            ArrayList<Double> rightAns = right.compute();
            ArrayList<Double> leftAns  = left.join();

            //Total.newList.addAll(leftAns);
            //Total.newList.addAll(rightAns);
           //Total.setNewList(leftAns,rightAns);

            /*ArrayList<Double>  newlist = new ArrayList<>();
            //add last element and delete it
           /* double leftAnswer = leftAns.get(leftAns.size() -1);
            double rightAnswer = rightAns.get(rightAns.size()-1);
            leftAns.remove(leftAns.size()-1);
            rightAns.remove(rightAns.size()-1);
            newlist.addAll(leftAns);
            newlist.addAll(rightAns);*/
            //newlist.add(leftAnswer + rightAnswer);*/
            //return leftAns + rightAns;
           return null;
        }
    }
}