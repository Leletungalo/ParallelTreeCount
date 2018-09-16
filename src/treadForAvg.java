import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class treadForAvg extends RecursiveTask<Double> {
    private int lo;
    private int hi;
    private ArrayList<Double> arr;
    private static final int SEQUENTIAL_CUTOFF = 1000;

    treadForAvg(ArrayList<Double> a, int l, int h) {
        lo=l; hi=h; arr=a;
    }


    protected Double compute(){
        if((hi-lo) < SEQUENTIAL_CUTOFF) {
            double ans = 0;
            for(int i=lo; i < hi; i++)
                ans += arr.get(i);
            return ans;
        }
        else {
            treadForAvg left = new treadForAvg(arr,lo,(hi+lo)/2);
            treadForAvg right= new treadForAvg(arr,(hi+lo)/2,hi);

            left.fork();
            double rightAns = right.compute();
            double leftAns  = left.join();
            return leftAns + rightAns;
        }
    }
}
