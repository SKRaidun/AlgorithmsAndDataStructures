package Table;

import java.nio.ByteBuffer;

public class SecondKeySpace {

    KeySpace2[] KS2;
    int capacity;

    public SecondKeySpace(int size) {
        KS2 = new KeySpace2[size];
    }

    public int hashFunction(int key) {
        int hash = (int) Math.pow(2, 32);

        byte[] bytes = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE).putInt(key).array();

        hash = 37 * key;

        return Math.abs(hash) % KS2.length;
    }

    public SecondKeySpace search2(int sKey) throws RuntimeException {
        if (capacity == 0) {
            System.out.println("Table is null");
            throw new RuntimeException();
        }

        int position = hashFunction(sKey);
        KeySpace2 element;

        try{
            element = KS2[position];
        } catch (NullPointerException _) {
            System.out.println("No such key");
            return null;
        }

        SecondKeySpace newKS = new SecondKeySpace(KS2.length);

        try {
            while (element != null) {
                if (element.key2 == sKey) {
                    Item item = new Item(element.info.info, element.info.key1, element.key2);
                    KeySpace2 newElement = new KeySpace2(element.key2, item);
                    newKS.add2(newElement);
                }
                element = element.next;
            }
        } catch (NullPointerException _) {};

        if (newKS.capacity == 0) {
            System.out.println("No such key");
            return null;
        }


        return newKS;

    }

    public int search(int sKey) throws RuntimeException {
        if (capacity == 0) {
            System.out.println("Table is null");
            return -1;
        }

        int position = hashFunction(sKey);
        KeySpace2 element;

        try{
            element = KS2[position];
        } catch (NullPointerException _) {
            System.out.println("No such key");
            return -1;
        }

        try {
            while (element != null) {
                if (element.key2 == sKey) {
                   return position;
                }
                element = element.next;
            }
        } catch (NullPointerException _) {};


        return -1;
    }

    public void add2(KeySpace2 newElement) {
        int position = hashFunction(newElement.key2);

         if (KS2[position] == null) {
            KS2[position] = newElement;
        } else {
            KeySpace2 element = KS2[position];
            if (element.key2 == newElement.key2) {
                newElement.next = element;
                newElement.release = element.release + 1;
                KS2[position] = newElement;
            } else {
                while (element.next != null) {
                    if (element.next.key2 == newElement.key2) {
                        int release = element.next.release + 1;
                        newElement.next = element.next;
                        element.next = newElement;
                        newElement.release = release;
                        break;
                    }
                    element = element.next;
                }
                if (element.next == null) {
                    element.next = newElement;
                }
            }
        }
    capacity++;
}
//Проверить условия
public void reorganization() {
    if (capacity == 0) {
        throw new RuntimeException();
    }
    for (KeySpace2 keySpace2 : KS2) {
        try {
            KeySpace2 element = keySpace2;
            KeySpace2 temp = keySpace2;
            boolean k = false;
            while (element != null) {
                if (element.next == null && k) {
                    temp.next = null;
                    break;
                }
                if (element.key2 == element.next.key2 && !k) {
                    temp = element;
                    k = true;
                } else if (element.key2 != element.next.key2 && k) {
                    temp.next = element.next;
                    temp = element.next;
                    k = false;
                }
                element = element.next;
            }
        } catch (NullPointerException _) {
        }
    }
}
//Проверить условия
public void delete2(int dKey) {

        int position = hashFunction(dKey);

        KeySpace2 element = KS2[position];
        KeySpace2 prev = null;

        try {
            while (element != null) {
                if (element.key2 != dKey) {
                    prev = element;
                } else if (element.key2 == dKey && element.next != null) {
                    if (prev == null) {
                        KS2[position] = element.next;
                    } else {
                        prev.next = element.next;
                    }
                    capacity--;
                } else if (element.next == null) {
                    if (prev == null) {
                        KS2[position] = null;
                    } else {
                        prev.next = null;
                    }
                    capacity--;
                }
                element = element.next;
            }
        } catch (NullPointerException _) {}
}

public void delete2(int dKey, int release) {

    int position = hashFunction(dKey);
    boolean deleted = false;
    KeySpace2 element;

    try {
        element = KS2[position];
    } catch (NullPointerException _) {
        System.out.println("No such key");
        return;
    }

    try {
        if (element.key2 == dKey && element.release == release) {
            KS2[position] = element.next;
            deleted = true;
            capacity--;
            return;
        }
    } catch (NullPointerException _) {
        KS2[position] = null;
        deleted = true;
        capacity--;
        return;
    }

    try {
        while (element != null) {
            if (element.next.key2 == dKey && element.next.release == release) {
                capacity--;
                if (element.next.next != null) {
                    element.next = element.next.next;
                } else {
                    element.next = null;
                }
                deleted = true;
            }
            element = element.next;
        }
        capacity--;
    } catch (NullPointerException _) {}

    if (!deleted) {
        System.out.println("No such key or release");
    }

}

public void print() {

    if (capacity == 0) {
        System.out.println("Table is null");
        throw new RuntimeException();
    }

    for (KeySpace2 k : KS2) {
        KeySpace2 element = k;
        try {
            while (element.next != null) {
                System.out.println("Key: " + " " + element.key2 + ", " + "release: " + element.release + ", " + element.info.info);
                element = element.next;
            }
            System.out.println("Key: " + " " + element.key2 + ", " + "release: " + element.release + ", " + element.info.info);
        } catch (NullPointerException _) {}
    }
}
}
