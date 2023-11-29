import java.util.*;

public class TCAS_Structure<V> implements Map<String, V> {
    ArrayList<TCAS_Entry<V>> storageSystem;

    public TCAS_Structure() {
        this.storageSystem = new ArrayList<>();
    }


    public int size() {
        return storageSystem.size();
    }


    public boolean isEmpty() {

        return this.storageSystem.isEmpty();
    }


    //Todo: Confirm that this checks to see if 2 strings are equal
    public boolean containsKey(Object key) {

        for (int i = 0; i < this.storageSystem.size(); i++) {
            if (this.storageSystem.get(i).getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }


    public boolean containsValue(Object value) {
        String temp = value.toString();
        for (int i = 0; i < this.storageSystem.size(); i++) {
            if (this.storageSystem.get(i).getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }


    public V get(Object key) {

        for (int i = 0; i < this.storageSystem.size(); i++) {
            if (this.storageSystem.get(i).getKey().equals(key)) {
                return this.storageSystem.get(i).getValue();
            }
        }

        return null;

    }


    public V put(String key, V value) {

        if (this.containsKey(key)) {
            return null;
        }

        TCAS_Entry input = new TCAS_Entry<>(key, value);

        this.storageSystem.add(input);
        return value;

    }


    public V remove(Object key) {
        for (int i = 0; i < this.storageSystem.size(); i++) {
            if (this.storageSystem.get(i).getKey().equals(key)) {
                V output = this.storageSystem.get(i).getValue();
                this.storageSystem.remove(i);
                return output;
            }
        }

        return null;

    }


    public void putAll(Map<? extends String, ? extends V> m) {
        System.out.println("Not implemented");
        String[] keys = (String[]) m.keySet().toArray();
        V[] values = (V[]) m.values().toArray();

        for (int i = 0; i < keys.length; i++) {
            this.put(keys[i], values[i]);
        }

    }


    public void clear() {
        while (!this.storageSystem.isEmpty()) {
            this.storageSystem.remove(0);
        }
    }


    public Set<String> keySet() {
        Set<String> output = new HashSet<String>();

        for (int i = 0; i < storageSystem.size(); i++) {
            output.add(this.storageSystem.get(i).getKey());
        }

        return output;
    }


    public Collection<V> values() {
        Set<V> output = new HashSet<V>();

        for (int i = 0; i < storageSystem.size(); i++) {
            output.add(this.storageSystem.get(i).getValue());
        }

        return output;
    }

    //Todo: Probably fix this entire thing, I don't think it works
    public Set<Entry<String, V>> entrySet() {
        Set<Entry<String, V>> output = new HashSet<Entry<String, V>>();

        for (int i = 0; i < storageSystem.size(); i++) {
            output.add(this.storageSystem.get(i));
        }

        return output;
    }


}

class TCAS_Entry<V> implements Map.Entry<String, V> {
    private String key;
    private V value;

    public TCAS_Entry(String key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
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
