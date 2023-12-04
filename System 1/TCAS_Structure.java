import java.util.*;

/**
 * This class is the data structure that will be used by the TCAS system. It is based on an unsorted map that uses an array list implementation.
 *
 * @param <V> This is the data type of the values of the structure.
 * @author Jordi Nakahara
 * @version 1.0
 */
public class TCAS_Structure<V> implements Map<String, V> {
    ArrayList<TCAS_Entry<V>> storageSystem;

    /**
     * This method creates an empty TCAS_Structure.
     */
    public TCAS_Structure() {
        this.storageSystem = new ArrayList<>();
    }


    /**
     * This method states the size of a structure by reading the size of the array list.
     *
     * @return The size of the structure.
     */
    public int size() {
        return storageSystem.size();
    }


    /**
     * This method states whether the structure is empty.
     *
     * @return A boolean that is true when the structure has 0 elements and false otherwise.
     */
    public boolean isEmpty() {

        return this.storageSystem.isEmpty();
    }


    /**
     * This method states whether a given key is within the structure.
     *
     * @param key key whose presence in this map is to be tested.
     * @return A boolean that is true if the key exists and false otherwise.
     */
    public boolean containsKey(Object key) {

        for (int i = 0; i < this.storageSystem.size(); i++) {
            if (this.storageSystem.get(i).getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }


    /**
     * This method states whether a given value is within the structure.
     *
     * @param value value whose presence in this map is to be tested.
     * @return A boolean that is true if the value exists and false otherwise.
     */
    public boolean containsValue(Object value) {
        String temp = value.toString();
        for (int i = 0; i < this.storageSystem.size(); i++) {
            if (this.storageSystem.get(i).getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method returns the value of a given key.
     *
     * @param key the key whose associated value is to be returned.
     * @return The value associated with the key if it exists and null otherwise.
     */
    public V get(Object key) {

        for (int i = 0; i < this.storageSystem.size(); i++) {
            if (this.storageSystem.get(i).getKey().equals(key)) {
                return this.storageSystem.get(i).getValue();
            }
        }

        return null;

    }


    /**
     * This method adds a given key-value pair into the system.
     *
     * @param key   key with which the specified value is to be associated.
     * @param value value to be associated with the specified key.
     * @return The value that was put into the structure and null if the key already exists within the structure.
     */
    public V put(String key, V value) {

        if (this.containsKey(key)) {
            int index = -1;
            for (int i = 0; i < storageSystem.size(); i++) {
                if(this.storageSystem.get(i).getKey().equals(key)) {
                    index = i;
                }
            }
            this.storageSystem.get(index).setValue(value);
            return value;
        }

        TCAS_Entry input = new TCAS_Entry<>(key, value);

        this.storageSystem.add(input);
        return null;

    }

    /**
     * This method removes a given key and its associated value from the structure.
     *
     * @param key key whose mapping is to be removed from the map.
     * @return The value associated with the structure and null if the key-value pair was not removed.
     */
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

    /**
     * This method puts a given map into the structure.
     *
     * @param m mappings to be stored in this map.
     */
    public void putAll(Map<? extends String, ? extends V> m) {
        Object[] keys = m.keySet().toArray();
        V[] values = (V[]) m.values().toArray();

        for (int i = 0; i < keys.length; i++) {
            this.put(keys[i].toString(), values[i]);
        }

    }


    /**
     * This method removes all key-value pairs within the system, leaving an empty system.
     */
    public void clear() {
        while (!this.storageSystem.isEmpty()) {
            this.storageSystem.remove(0);
        }
    }


    /**
     * This method gives a set containing all the keys of the system.
     *
     * @return A set containing all the keys in the system.
     */
    public Set<String> keySet() {
        Set<String> output = new HashSet<String>();

        for (int i = 0; i < storageSystem.size(); i++) {
            output.add(this.storageSystem.get(i).getKey());
        }

        return output;
    }


    /**
     * This method gives the collection of the values contained in the structure.
     *
     * @return A collection containing the values of the structure.
     */
    public Collection<V> values() {
        Collection<V> output = new ArrayList<>();

        for (int i = 0; i < storageSystem.size(); i++) {
            output.add(this.storageSystem.get(i).getValue());
        }

        return output;
    }

    /**
     * This method gives the set of the keys contained within the structure
     *
     * @return A set containing the keys of the structure.
     */
    public Set<Entry<String, V>> entrySet() {
        Set<Entry<String, V>> output = new HashSet<Entry<String, V>>();

        for (int i = 0; i < storageSystem.size(); i++) {
            output.add(this.storageSystem.get(i));
        }

        return output;
    }


}

/**
 * This class is the data type of the entries of the TCAS_Structure.
 * The keys are of the string data type and the data type of the values is determined by "V".
 *
 * @param <V> The type of the value.
 */
class TCAS_Entry<V> implements Map.Entry<String, V> {
    private String key;
    private V value;

    /**
     * This method is the constructor for new entries.
     *
     * @param key   The key with data type string.
     * @param value The value with data type determined by "V".
     */
    public TCAS_Entry(String key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * This method gives the key of the entry.
     *
     * @return The string representing the key of the entry.
     */
    public String getKey() {
        return key;
    }

    /**
     * This method gives the value of the entry.
     *
     * @return The value of the entry with data type determined by "V".
     */
    public V getValue() {
        return value;
    }

    /**
     * This method changes the value of the entry.
     *
     * @param value new value to be stored in this entry.
     * @return The old value of the entry.
     */
    public V setValue(V value) {
        V output = this.value;
        this.value = value;
        return output;
    }

}
