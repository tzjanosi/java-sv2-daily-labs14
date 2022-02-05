package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Street{
    private String name;
    private List<Integer> soldOrder=new ArrayList<>();
    private int nextOdd=1;
    private int nextEven=2;

    public Street(String name) {
        this.name = name;
    }

    public void addOdd(){
        soldOrder.add(nextOdd);
        nextOdd+=2;
    }
    public void addEven(){
        soldOrder.add(nextEven);
        nextEven+=2;
    }
    public void sell(int whichSide) {
        switch(whichSide){
            case 0:
                addEven();
                break;
            case 1:
                addOdd();
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getSoldOrder() {
        return soldOrder;
    }

    @Override
    public String toString() {
        return name + "-{" + soldOrder + '}';
    }
}
