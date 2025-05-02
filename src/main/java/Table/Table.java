package Table;

import java.io.IOException;
import java.security.Key;

public class Table {

    private FirstKeySpace firstKS;
    private SecondKeySpace secondKS;

    int fullCapacity;

    public Table(int fSize, int sSize) {
        firstKS = new FirstKeySpace(fSize);
        secondKS = new SecondKeySpace(sSize);
    }


    public void add(Item item) {

        if (firstKS.search(item.key1) > 0) {
            System.out.println("No duplicates in table");
            throw new RuntimeException();
        }


        KeySpace1 ks1 = new KeySpace1(item.key1, item);
        KeySpace2 ks2 = new KeySpace2(item.key2, item);
        item.setKS(ks1, ks2);

        firstKS.add1(ks1);
        secondKS.add2(ks2);
    }



    public void print() {

        KeySpace2[] secondKeySpace = secondKS.KS2;
        KeySpace1[] firstKeySpace = firstKS.KS;

        try {
            for (int i = 0; i < firstKeySpace.length; i++) {
                KeySpace1 element = firstKeySpace[i];
                if (element.busy) {
                    Item element2 = element.info;
                    KeySpace2 el = element2.KS2;
                    System.out.println("Key1: " + element.key + ". " + "Key2 :" + el.key2 + ", release: " + el.release + ". Info: " + el.info.info);
                }
            }
        } catch (NullPointerException _) {}
    }


    public void delete(String key1, int key2) {

        KeySpace1 element = null;
        try {
            for (int i = 0; i < firstKS.KS.length; i++) {
                element = firstKS.KS[i];
                if (element.key.equals(key1)) {
                    break;
                }
            }


        Item element2 = element.info;
        KeySpace2 el = element2.KS2;

        if (el.key2 != key2) {
            System.out.println("No such element");
            return;
        }

        secondKS.delete2(el.key2, el.release);
        firstKS.delete1(element.key);
        } catch (NullPointerException _) {}
    }

    public void search(String key1, int key2) {

        KeySpace1 element = null;
        try {
            for (int i = 0; i < firstKS.KS.length; i++) {
                element = firstKS.KS[i];
                if (element.key.equals(key1)) {
                    break;
                }
            }
            if (element.busy) {
                Item element2 = element.info;
                KeySpace2 el = element2.KS2;
                if (el.key2 != key2) {
                    System.out.println("No such element");
                    return;
                } else {
                    System.out.println("Key1: " + element.key + ". " + "Key2 :" + el.key2 + ", release: " + el.release + ". Info: " + el.info.info);
                }
            } else {
                System.out.println("No such element");
            }
        } catch (NullPointerException _) {}

    }

}
