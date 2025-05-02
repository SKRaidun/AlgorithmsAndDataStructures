package Table;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        FirstKeySpace ks = new FirstKeySpace(3);

        Item it1 = new Item("POPA1", "key1", 1);
        KeySpace1 ks1 = new KeySpace1(it1.key1, it1);
        ks.add1(ks1);

        Item it2 = new Item("POPA2", "key2", 2);
        KeySpace1 ks2 = new KeySpace1(it2.key1, it2);

        Item it3 = new Item("POPA3", "key3", 3);
        KeySpace1 ks3 = new KeySpace1(it3.key1, it3);

        ks.add1(ks2);
        ks.add1(ks3);
        ks.print();

        System.out.println("-----------------------------");

//        ks.delete1("key2");
//        ks.print();

        System.out.println("-----------------------------");
        ks.compressTable();
        ks.print();

        System.out.println("-----------------------------");
        ks.removeInRange(0, 1);
        ks.print();
        System.out.println("-----------------------------");
        Item it5 = new Item("PISKA", "key1", 5);
        KeySpace1 ks5 = new KeySpace1(it5.key1, it5);
        ks.add1(ks5);
        ks.print();

        System.out.println("-----------------------------");
        System.out.println("Второе пространство ключей");

        SecondKeySpace keys2 = new SecondKeySpace(3);

        KeySpace2 newk1 = new KeySpace2(1, it1);
        KeySpace2 newk2 = new KeySpace2(2, it2);
        KeySpace2 newk3 = new KeySpace2(1, it2);
        KeySpace2 newk4 = new KeySpace2(10, it3);
        KeySpace2 newk5 = new KeySpace2(2, it5);
        KeySpace2 newk6 = new KeySpace2(2, it3);

        keys2.add2(newk1);
        keys2.add2(newk2);
        keys2.add2(newk3);
        keys2.add2(newk4);
        keys2.add2(newk5);
        keys2.add2(newk6);

        keys2.print();

        System.out.println("--------------------");

        //keys2.reorganization();

        keys2.print();

        System.out.println("--------------------");

        keys2.delete2(2, 1);
        keys2.print();

        System.out.println("--------------------");

        //keys2.delete2(1);
        keys2.print();

        System.out.println("--------------------");

        SecondKeySpace searchTable = keys2.search2(1);
        try {
            searchTable.print();
        } catch (NullPointerException _) {
        }
        ;

        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("Testing table");

        Item item1 = new Item("info 1", "key1", 1);
        Item item2 = new Item("info 2", "key2", 1);
        Item item3 = new Item("info 3", "key3", 3);

        Table table = new Table(3, 3);

        table.add(item1);
        table.add(item2);
        table.add(item3);

        table.print();

        System.out.println("--------------------");

        table.delete("key3", 3);

        table.print();

        System.out.println("--------------------");
        table.search("key3", 3);

        System.out.println("--------------------");
        table.search("key2", 1);
    }
}
