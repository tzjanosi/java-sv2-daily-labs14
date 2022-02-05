package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StreetView {
    private List<Street> streetsList=new ArrayList<>();

    public void readFromFIle(Path path){
        //Paths.get("src/test/resources/streets.txt")
        List<String> lines;
        try {
            lines= Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: "+path, ioe);
        }
        process(lines);
    }

    private void process(List<String> lines){
        for(int i=0;i< lines.size();i++){
            processLine(lines.get(i));
        }
    }

    private void processLine(String line) {
        String[] fieldsArray;
        fieldsArray=line.split(" ");
        String name=fieldsArray[0];
        int whichSide=Integer.parseInt(fieldsArray[1]);
        Street street=new Street(name);
        if(!streetsList.contains(street)){
            streetsList.add(street);
        }
        getStreetByName(name).sell(whichSide);

    }

    private Street getStreetByName(String name){
        for(Street street:streetsList){
            if(street.getName().equals(name)){
                return street;
            }
        }
        return null;
    }
    public String report(){
        String output="";
        for(int i=0;i<streetsList.size();i++){
            output+=streetsList.get(i).toString()+"\n";
        }
        return output;
    }

    public static void main(String[] args) {
        StreetView streetView= new StreetView();
        streetView.readFromFIle(Path.of("src/main/resources/streets.txt"));
        System.out.println(streetView.report());
    }

}
