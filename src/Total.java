import java.util.ArrayList;

public class  Total {

    public  ArrayList<Double> newList;
    public  Total(){
        newList = new ArrayList<>();
    }

    public synchronized void setNewList(Double newList) {
        this.newList.add(newList);
    }

    public ArrayList<Double> getNewList() {
        return newList;
    }
}
