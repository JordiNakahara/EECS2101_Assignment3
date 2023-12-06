package a3package;

import java.util.*;

/**
 * This class is the data structure that will be used by the TCAS system.
 * It is based on a binary tree.
 *
 * @param <V> This is the data type of the values of the structure.
 * @author Farzin Aliverdi Mamaghani
 * @version 1.0
 */
public class TCAS_Structure_2<V> {
    //=====VARIABLES=====

    private TCAS_Node<V> header;
    private int count;

    private boolean getSwitch = false;
    private V get = null;
    private TCAS_Node getNode = null;
    private TCAS_Node prevGetNode = null;

    private boolean putSwitch = false;

    private boolean removeSwich = false;
    private V removeValue = null;

    //=====CONSTRUCTORS=====

    /**
     * This is the default constructor.
     */
    public TCAS_Structure_2() {
        this.header = null;
        this.count = 0;
    }

    /**
     * This constructor takes in a key and a value and adds them to the newly initialized structure.
     *
     * @param key   The initial key to be added.
     * @param value The initial value to be added.
     */
    public TCAS_Structure_2(String key, V value) {
        this.header = new TCAS_Node<>(key, value);
        this.count = 1;
    }

    //=====FUNCTIONS=====

    /**
     * This method gives the current size of the structure.
     *
     * @return The current size of the structure as an int.
     */
    public int size() {
        return this.count;
    }

    /**
     * This method states whether the structure is currently empty.
     *
     * @return A boolean that is true if the structure has 0 elements and false otherwise.
     */
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /**
     * This method searches the structure for a key and returns the associated value.
     *
     * @param key The key to search the stucture for.
     * @return The value associated with the key and null if the key is not in the structure.
     */
    public V get(String key) {
        if (count == 0) {
            return null;
        }
        getSwitch = false;
        get = null;
        preOrderGet(header, key);
        return get;
    }

    /**
     * This method adds a given key-value pair to the structure if it doesn't already exist in it.
     * If it does exist the old value is swapped for the new one.
     *
     * @param key   The key to add to the structure or to have its value replaced.
     * @param value The value to add or replace with.
     * @return The old value or null if there was none.
     */
    public V put(String key, V value) {
        if (count == 0) {
            header = new TCAS_Node<>(key, value);
            count++;
            return null;
        }

        getSwitch = false;
        get = null;
        preOrderGet(header, key);
        if (get == null) { //===ADD NEW===
            putSwitch = false;
            preOrderPut(header, key, value);
            count++;
            return null;
        } else { //===UPDATE OLD===
            putSwitch = false;
            preOrderPut(header, key, value);
            return get;
        }
    }

    /**
     * This method removes a given key-value pair from the structure and returns it.
     *
     * @param key The key to be removed from the structure.
     * @return The value that was removed or null if none was.
     */
    public V remove(String key) {
        if (size() == 1) {
            if (header.getKey().equals(key)) {
                V value = header.getValue();
                header = null;
                count = 0;
                return value;
            }
        }

        get = null;
        getSwitch = false;
        preOrderGetAndPrevious(header, header, key);
        if (get == null) {
            return null;
        } else {
            removeSwich = false;
            removeValue = null;
            preOrderRemove(getNode);
            return removeValue;
        }
    }

    /**
     * This method checks to see if a given key is within the structure.
     *
     * @param key The key to be checked for.
     * @return A boolean that is true if the key is in the structure and false otherwise.
     */
    public boolean containsKey(Object key) {
        for (String toCheck : this.keySet()) {
            if (toCheck.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks to see if a given value is contained within the structure.
     * @param value The value to be checked for.
     * @return A boolean that is true if the value was found in the structure and false otherwise.
     */
    public boolean containsValue(Object value) {
        for (V toCheck : this.values()) {
            if (toCheck.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method gives the set of all keys contained within the structure.
     * @return A set with all the keys contained within the structure.
     */
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        preOrderKeySet(header, keys);
        return keys;
    }

    /**
     * This method gives a collection with all the values contained within the structure.
     * @return A collection containing all the values of the structure.
     */
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        preOrderValues(header, values);
        return values;
    }

    /**
     * This method gives a set containing all the key-value pairs of the structure.
     * @return A set with type Map.Entry containing all the key-value entries in the structure.
     */
    public Set<Map.Entry<String, V>> entrySet() {
        Set<Map.Entry<String, V>> entrySet = new HashSet<>();
        preOrderEntrySet(header, entrySet);
        return entrySet;
    }

    //=====PRIVATE FUNCTIONS=====

    /**
     * 
     * @param node
     * @param key
     */
    private void preOrderGet(TCAS_Node<V> node, String key) {
        if (node == null || getSwitch) { //===NULL CASE===
            //PASS
        } else if (node.getKey().equals(key)) { //===FUNCTION===
            get = node.getValue();
            getNode = node;
            getSwitch = true;
        } else { //===PREORDER===
            preOrderGet(node.getLeftNode(), key);
            preOrderGet(node.getRightNode(), key);
        }
    }

    private void preOrderGetAndPrevious(TCAS_Node<V> preNode, TCAS_Node<V> node, String key) {
        if (node != null) {
            if ((!getSwitch) && !(node.getKey().equals(key))) {
                prevGetNode = node;
            }
        }


        if (node == null || getSwitch) { //===NULL CASE===
            //PASS
        } else if (node.getKey().equals(key)) { //===FUNCTION===
            get = node.getValue();
            getNode = node;
            getSwitch = true;
        } else { //===PREORDER===
            preOrderGetAndPrevious(prevGetNode, node.getLeftNode(), key);
            preOrderGetAndPrevious(prevGetNode, node.getRightNode(), key);
        }
    }

    private void preOrderPut(TCAS_Node<V> node, String key, V value) {
//        System.out.println("CURRENT ADD:");
//        System.out.println("  CURRENT NODE: " + node.getKey());
//        System.out.println("  NODE TO ADD: " + key);
        if (node == null || putSwitch) { //===NULL CASE===
            //PASS
        } else if (node.getKey().equals(key)) { //===REPEAT===
            //System.out.println("REPLace");
            node.setValue(value);
            putSwitch = true;
        } else if (node.getKey().compareTo(key) >= 0 && node.getLeftNode() == null) { //===ADD LEFT===
            //System.out.println("LEFT ADD" + node.getKey() + "-then-" + key);
            TCAS_Node<V> newNode = new TCAS_Node<>(key, value);
            node.setLeftNode(newNode);
            putSwitch = true;
        } else if (node.getKey().compareTo(key) < 0 && node.getRightNode() == null) { //===ADD RIGHT===
            //System.out.println("RIGHT ADD" + node.getKey() + "-then-" + key);
            TCAS_Node<V> newNode = new TCAS_Node<>(key, value);
            node.setRightNode(newNode);
            putSwitch = true;
        } else if (node.getKey().compareTo(key) >= 0) { //===PREORDER===
            preOrderPut(node.getLeftNode(), key, value);
        } else { //===PREORDER===
            preOrderPut(node.getRightNode(), key, value);
        }
    }

    private void preOrderRemove(TCAS_Node<V> node) {
        removeValue = node.getValue();
        ArrayList<TCAS_Node<V>> redoNodes = new ArrayList<>();
        getRestNodes(node.getLeftNode(), redoNodes);
        getRestNodes(node.getRightNode(), redoNodes);
        count -= (redoNodes.size() + 1);
        if (prevGetNode != null) {
            prevGetNode.setLeftNode(null);
            prevGetNode.setRightNode(null);
        }
        addNodes(redoNodes);
    }

    private void preOrderKeySet(TCAS_Node<V> node, Set<String> keys) {
        if (node != null) {
            keys.add(node.getKey());
            preOrderKeySet(node.getLeftNode(), keys);
            preOrderKeySet(node.getRightNode(), keys);
        }
    }

    private void preOrderValues(TCAS_Node<V> node, Collection<V> values) {
        if (node != null) {
            values.add(node.getValue());
            //Error stems from line below:
            preOrderValues(node.getRightNode(), values);
            preOrderValues(node.getLeftNode(), values);
        }
    }

    private void preOrderEntrySet(TCAS_Node<V> node, Set<Map.Entry<String, V>> entrySet) {
        if (node != null) {
            entrySet.add(node);
            preOrderEntrySet(node.getLeftNode(), entrySet);
            preOrderEntrySet(node.getRightNode(), entrySet);
        }
    }

    private void getRestNodes(TCAS_Node<V> node, ArrayList<TCAS_Node<V>> list) {
        if (node == null) {
            return;
        } else {
//            System.out.println("TO BE ADDED: " + node.getKey());
            list.add(node);
        }

        if (node.getRightNode() != null) { //===HAS RIGHT===
            getRestNodes(node.getRightNode(), list);
        }
        if (node.getLeftNode() != null) { //===HAS LEFT===
            getRestNodes(node.getLeftNode(), list);
        }
    }

    private void addNodes(ArrayList<TCAS_Node<V>> list) {
        for (int i = 0; i < list.size(); i++) {
            put(list.get(i).getKey(), list.get(i).getValue());
        }
    }

    //=====INNER CLASS=====
    class TCAS_Node<V> implements Map.Entry<String, V> {
        //=====VARIABLES=====
        private final String key;
        private V value;
        private TCAS_Node<V> leftNode;
        private TCAS_Node<V> rightNode;

        //=====CONSTRUCTORS=====
        TCAS_Node(String key, V value) {
            this.key = key;
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }

        TCAS_Node(String key, V value, TCAS_Node<V> leftNode, TCAS_Node<V> rightNode) {
            this.key = key;
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        //=====FUNCTIONS=====

        //=====GETTERS/SETTERS=====
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        public void setLeftNode(TCAS_Node<V> leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(TCAS_Node<V> rightNode) {
            this.rightNode = rightNode;
        }

        public String getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public TCAS_Node<V> getLeftNode() {
            return leftNode;
        }

        public TCAS_Node<V> getRightNode() {
            return rightNode;
        }
    }
}
