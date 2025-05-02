package Table;

public class FirstKeySpace {

    KeySpace1[] KS;
    int capacity = 0;

    public FirstKeySpace(int size) {
        KS = new KeySpace1[size];
    }


    public int search(String sKey) {

        if (capacity == 0) {
            return -1;
        }
        try {
            for (int i = 0; i < KS.length; i++) {
                if (KS[i].key.equals(sKey)) {
                    if (KS[i].busy) {
                        return i;
                    }
                }
            }
        } catch (NullPointerException _) {}

        return -1;
    }

    public void reorganize() {
        KeySpace1[] newKS = new KeySpace1[KS.length];
        int j = 0;
        int newCapacity = 0;
        try {
            for (int i = 0; i < KS.length; i++) {
                if (KS[i].busy) {
                    newKS[j] = KS[i];
                    newCapacity++;
                    j++;
                }
            }
        } catch (NullPointerException _) {}
        KS = newKS;
        capacity = newCapacity;
    }

    public void add1(KeySpace1 element) {
        if (search(element.key) != -1) {
            System.out.println("Duplicate keys are not allowed");
            throw new RuntimeException();
        }
        if (capacity >= 0.6 * KS.length) {
            reorganize();
        }
        if (capacity == KS.length) {
            System.out.println("There is no more free space in the key space 1");
            throw new RuntimeException();
        }

        KS[capacity] = element;
        capacity++;
        element.busy = true;
    }

    public void delete1(String dKey) {
        if (search(dKey) == -1) {
            System.out.println("Table is empty or no such element");
            throw new RuntimeException();
        }
        try {
            for (KeySpace1 k : KS) {
                if (k.key.equals(dKey)) {
                    if (k.busy) {
                        k.busy = false;
                        capacity--;
                    }
                }
            }
        } catch (NullPointerException _) {}
    }

    public void compressTable() {
        KeySpace1[] newKS = new KeySpace1[capacity];
        int j = 0;
        int newCapacity = 0;
        try {
            for (int i = 0; i < KS.length; i++) {
                if (KS[i].busy) {
                    newKS[j] = KS[i];
                    newCapacity++;
                    j++;
                }
            }
        } catch (NullPointerException _) {}
        KS = newKS;
        capacity = newCapacity;
    }

    public void removeInRange(int a, int b) {

        try {
            if (a < 0 || b >= KS.length) {
                System.out.println("Incorrect bounds");
            }
        } catch (ArrayIndexOutOfBoundsException _) {}
        try {
            for (int i = a; i <= b; i++) {
                if (KS[i].busy) {
                    delete1(KS[i].key);
                }
            }
        } catch (NullPointerException _) {}
    }

    public void print() {
        for (int i = 0; i < KS.length; i++) {
            try {
                if (KS[i].busy) {
                    System.out.println("Key: " + KS[i].key + ". " + "Info: " + KS[i].info.info);
                }
            } catch (NullPointerException _) {
            }
        }
    }
}
