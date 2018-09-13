import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class parallelThreeCount {

    parallelThreeCount(){}
    private static long startTime = 0;

    private static void tick(){
        startTime = System.currentTimeMillis();
    }
    private static float tock(){
        return (System.currentTimeMillis() - startTime) / 1000.0f;
    }
    static final ForkJoinPool fjPool = new ForkJoinPool();
    static ArrayList<Double> sum(int[][] arr){
        return fjPool.invoke(new thread(arr,0,arr.length));
    }

    public static void main(String [] agrs){

        tick();
        readData data = new readData("sample_input.txt");
        ArrayList<Double> fofof = sum(data.getTreesLocation());
        float huhu = tock();


        System.out.println("Time is: " + huhu);
        for (int i = 0; i < 1000;i++){
            System.out.println(fofof.get(i));
        }
        //System.out.println("Answer is: "  /*fofof/1000000*/);
        System.out.println();

        /*tick();
        readData data1 = new readData("sample_input.txt");
        double gga = sum(data1.getTreesLocation());
        float huhu1 = tock();

        System.out.println("Time is 1 : " + huhu1);
        System.out.println("Answer is: "+ gga/1000000);
        System.out.println();


        tick();
        readData data2 = new readData("sample_input.txt");
        double ueue = sum(data2.getTreesLocation());
        float huhu2 = tock();

        System.out.println("Time is 2 : " + huhu2);
        System.out.println("Answer is: " + ueue/1000000);
        System.out.println();

        tick();
        readData data3 = new readData("sample_input.txt");
        double oaoa = sum(data3.getTreesLocation());
        float huhu3 = tock();

        System.out.println("Time is 3 : " + huhu3);
        System.out.println("Answer is: " + oaoa/1000000);
        System.out.println();


        tick();
        readData data4 = new readData("sample_input.txt");
        double uua = sum(data4.getTreesLocation());
        float huhu4 = tock();

        System.out.println("Time is 4 : " + huhu);
        System.out.println("Answer is: " + uua/1000000);
        System.out.println();

        tick();
        readData data5 = new readData("sample_input.txt");
        double nun = sum(data5.getTreesLocation());
        float huhu5 = tock();

        System.out.println("Time is 5 : " + huhu5 );
        System.out.println("Answer is: " + nun/1000000);
        System.out.println();

     /*   for (int i = 0; i < 1000;i++){
           System.out.println(thread.newlist.get(i));
        }*/

    }
}
