package Table;

public class Item {
    String info;
    String key1;
    int key2;
    KeySpace1 KS1;
    KeySpace2 KS2;

    public Item(String info, String key1, int key2) {
        this.info = info;
        this.key1 = key1;
        this.key2 = key2;
    }

    public void setKS(KeySpace1 KS1, KeySpace2 KS2) {
        this.KS1 = KS1;
        this.KS2 = KS2;
    }

}
