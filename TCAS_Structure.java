import java.util.*;

public class TCAS_Structure<K,V> implements Map<K,V> {
    ArrayList storageSystem;

    public TCAS_Structure () {
        
    }

}

class TCAS_Entry<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;

    public TCAS_Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V output = this.value;
        this.value = value;
        return output;
    }

}
