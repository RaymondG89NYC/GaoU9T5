import java.util.*;
public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name){
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName(){
        return name;
    }
    public ArrayList<Performer> getPerformers(){
        return performers;
    }
    public boolean addPerformer(Performer person){
        if(!performers.contains(person)){
            performers.add(person);
            return true;
        }
        else{
            return false;
        }
    }
    public boolean removePerformer(Performer person){
        if(performers.indexOf(person) != -1){
            performers.remove(performers.indexOf(person));
            return true;
        }
        else{
            return false;
        }
    }
    public double averagePerformerAge(){
        double total = 0;
        for(Performer p : performers){
            total += (p.getAge());
        }
        return total/performers.size();
    }
    public ArrayList<Performer> performersOverAge(int age){
        ArrayList<Performer> newArr = new ArrayList<Performer>();
        for(Performer p : performers){
            if(p.getAge() >= age){
                newArr.add(p);
            }
        }
        return newArr;
    }
    public void groupRehearsal(){
        for(Performer p : performers){
            System.out.println("REHEARSAL CALL! " + p.getName());
            if(p instanceof Comedian) {
                Comedian temp = (Comedian) p;
                temp.rehearse(false);
            }
            else{
                p.rehearse();
            }
        }
    }
    public void cabaretShow(){
        for(Performer p : performers){
            System.out.println("Welcome to the cabaret! Next act up... " + p.getName());
            if(p instanceof Dancer) {
                ((Dancer) p).pirouette(2);
            }
            p.perform();
        }
    }
}
