import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Horse1",3,0));
        horses.add(new Horse("Horse2",3,0));
        horses.add(new Horse("Horse3",3,0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            move();
            print();
        }
    }
    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
    }

    public Horse getWinner() {
        return horses.stream().
                max(Comparator.comparingDouble(Horse::getDistance)).get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
