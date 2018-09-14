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
        //if (agrs.length > 0) {
            tick();
            readData data = new readData("sample_input.txt");
            ArrayList<Double> fofof = sum(data.getTreesLocation());
            float huhu = tock();

            File file = new File("sample_out.txt");
            tick();
            double drdr = sum2(fofof);
            float time2 = tock();
            try {
                BufferedWriter out = new  BufferedWriter( new FileWriter(file));
                for (Double aFofof : fofof) {
                    double gg = aFofof;
                    System.out.println(gg);
                    out.write(String.valueOf(gg));
                    out.newLine();
                    out.flush();
                }


                out.close();
            }catch (IOException e) {
                e.printStackTrace();
            }



            System.out.println("Time is: " + huhu);

            System.out.println("Time 2 is"+drdr/1000000 +"\n" + time2);
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
        System.out.println();*/

    }
}
