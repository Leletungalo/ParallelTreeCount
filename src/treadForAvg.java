import java.util.concurrent.RecursiveTask;

public class treadForAvg extends RecursiveTask<Integer> {
    int lo; // arguments
    int hi;
    int[] arr;
    static final int SEQUENTIAL_CUTOFF=500;

    int ans = 0; // result

    treadForAvg(int[] a, int l, int h) {
        lo=l; hi=h; arr=a;
    }


    protected Integer compute(){// return answer - instead of run
        if((hi-lo) < SEQUENTIAL_CUTOFF) {
            int ans = 0;
            for(int i=lo; i < hi; i++)
                ans += arr[i];
            return ans;
        }
        else {
            treadForAvg left = new treadForAvg(arr,lo,(hi+lo)/2);
            treadForAvg right= new treadForAvg(arr,(hi+lo)/2,hi);

            // order of next 4 lines
            // essential – why?
            left.fork();
            int rightAns = right.compute();
            int leftAns  = left.join();
            return leftAns + rightAns;
        }
    }
}
