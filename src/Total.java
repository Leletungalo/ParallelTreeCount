import java.util.ArrayList;

public class  Total {

    private ArrayList<Double> newList;
    public  Total(){
        newList = new ArrayList<>();
    }

    public synchronized void setNewList(Double newList) {
        this.newList.add(newList);
    }

    public ArrayList<Double> getNewList() {
        return newList;
    }

    public synchronized void addList(ArrayList<Double> list ,ArrayList<Double> list2){
        newList.addAll(list);
        newList.addAll(list2);
    }
}
