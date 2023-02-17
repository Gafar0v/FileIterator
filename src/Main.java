import java.io.FileNotFoundException;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        try {
            Iterator<String> itr = new FileIterator("12.txt");
            System.out.println(itr.hasNext());
            while (itr.hasNext()){
                System.out.println(itr.next());
            }
            System.out.println(itr.hasNext());
        } catch (FileNotFoundException e) {
            System.out.println("Все фигня!");
        }

    }
}

