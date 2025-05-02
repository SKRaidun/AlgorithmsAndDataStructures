package Table;

import java.util.Objects;

public class KeySpace2 {
    int key2;
    int release = 0;
    Item info;
    KeySpace2 next = null;

    public KeySpace2(int key2, Item info) {
        this.key2 = key2;
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeySpace2 keySpace2 = (KeySpace2) o;
        return key2 == keySpace2.key2 && release == keySpace2.release && Objects.equals(info, keySpace2.info) && Objects.equals(next, keySpace2.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key2, release, info, next);
    }
}