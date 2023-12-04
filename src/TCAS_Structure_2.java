import java.util.*;

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

    public TCAS_Structure_2(){
        this.header = null;
        this.count = 0;
    }

    public TCAS_Structure_2(String key, V value){
        this.header = new TCAS_Node<>(key, value);
        this.count = 1;
    }

    //=====FUNCTIONS=====

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return (this.count == 0);
    }

    public V get(String key){
        if (count == 0) {
            return null;
        }
        getSwitch = false;
        get = null;
        preOrderGet(header, key);
        return get;
    }

    public V put(String key, V value){
        if (count == 0) {
            header = new TCAS_Node<>(key, value);
            count++;
            return null;
        }

        getSwitch = false;
        get = null;
        preOrderGet(header, key);
        if (get == null){ //===ADD NEW===
            putSwitch = false;
            preOrderPut(header, key, value);
            count++;
            return null;
        }else { //===UPDATE OLD===
            putSwitch = false;
            preOrderPut(header, key, value);
            return get;
        }
    }

    public V remove(String key){
        if (size() == 1){
            if (header.getKey().equals(key)){
                V value = header.getValue();
                header = null;
                count = 0;
                return value;
            }
        }

        get = null;
        getSwitch = false;
        preOrderGetAndPrevious(header, header, key);
        if (get == null){
            return null;
        }else {
            removeSwich = false;
            removeValue = null;
            preOrderRemove(getNode);
            return removeValue;
        }
    }

    public Collection<String> keySet(){
        Collection<String> keys = new ArrayList<>();
        preOrderKeySet(header, keys);
        return keys;
    }

    public Collection<V> values(){
        Collection<V> values = new ArrayList<>();
        preOrderValues(header, values);
        return values;
    }

    //TODO
    public Map<String, V> entrySet(){
        Map<String, V> entrySet = new HashMap<>();
        preOrderEntrySet(header, entrySet);
        return entrySet;
    }

    //=====PRIVATE FUNCTIONS=====

    private void preOrderGet(TCAS_Node<V> node, String key){
        if (node == null || getSwitch){ //===NULL CASE===
            //PASS
        }else if (node.getKey().equals(key)){ //===FUNCTION===
            get = node.getValue();
            getNode = node;
            getSwitch = true;
        }else { //===PREORDER===
            preOrderGet(node.getLeftNode(), key);
            preOrderGet(node.getRightNode(), key);
        }
    }

    private void preOrderGetAndPrevious(TCAS_Node<V> preNode, TCAS_Node<V> node, String key){
        if (node != null){
            if ((!getSwitch) && !(node.getKey().equals(key))){
                prevGetNode = node;
            }
        }


        if (node == null || getSwitch){ //===NULL CASE===
            //PASS
        }else if (node.getKey().equals(key)){ //===FUNCTION===
            get = node.getValue();
            getNode = node;
            getSwitch = true;
        }else { //===PREORDER===
            preOrderGetAndPrevious(prevGetNode, node.getLeftNode(), key);
            preOrderGetAndPrevious(prevGetNode, node.getRightNode(), key);
        }
    }

    private void preOrderPut(TCAS_Node<V> node, String key, V value){
//        System.out.println("CURRENT ADD:");
//        System.out.println("  CURRENT NODE: " + node.getKey());
//        System.out.println("  NODE TO ADD: " + key);
        if (node == null || putSwitch){ //===NULL CASE===
            //PASS
        }else if (node.getKey().equals(key)){ //===REPEAT===
            //System.out.println("REPLace");
            node.setValue(value);
            putSwitch = true;
        }else if(node.getKey().compareTo(key) >= 0 && node.getLeftNode() == null){ //===ADD LEFT===
            //System.out.println("LEFT ADD" + node.getKey() + "-then-" + key);
            TCAS_Node<V> newNode = new TCAS_Node<>(key, value);
            node.setLeftNode(newNode);
            putSwitch = true;
        }else if(node.getKey().compareTo(key) < 0 && node.getRightNode() == null){ //===ADD RIGHT===
            //System.out.println("RIGHT ADD" + node.getKey() + "-then-" + key);
            TCAS_Node<V> newNode = new TCAS_Node<>(key, value);
            node.setRightNode(newNode);
            putSwitch = true;
        }else if (node.getKey().compareTo(key) >= 0){ //===PREORDER===
            preOrderPut(node.getLeftNode(), key, value);
        }else { //===PREORDER===
            preOrderPut(node.getRightNode(), key, value);
        }
    }

    private void preOrderRemove(TCAS_Node<V> node){
        removeValue = node.getValue();
        ArrayList<TCAS_Node<V>> redoNodes = new ArrayList<>();
        getRestNodes(node.getLeftNode(), redoNodes);
        getRestNodes(node.getRightNode(), redoNodes);
        count -= (redoNodes.size() + 1);
        if (prevGetNode != null){
            prevGetNode.setLeftNode(null);
            prevGetNode.setRightNode(null);
        }
        addNodes(redoNodes);
    }

    private void preOrderKeySet(TCAS_Node<V> node, Collection<String> keys){
        if (node != null){
            keys.add(node.getKey());
            preOrderKeySet(node.getLeftNode(), keys);
            preOrderKeySet(node.getRightNode(), keys);
        }
    }

    private void preOrderValues(TCAS_Node<V> node, Collection<V> values){
        if (node != null){
            values.add(node.getValue());
            preOrderValues(node.getLeftNode(), values);
            preOrderValues(node.getRightNode(), values);
        }
    }

    private void preOrderEntrySet(TCAS_Node<V> node, Map<String, V> entrySet){
        if (node != null){
            entrySet.put(node.getKey(), node.getValue());
            preOrderEntrySet(node.getLeftNode(), entrySet);
            preOrderEntrySet(node.getRightNode(), entrySet);
        }
    }

    private void getRestNodes(TCAS_Node<V> node, ArrayList<TCAS_Node<V>> list){
        if (node == null){
            return;
        }else {
//            System.out.println("TO BE ADDED: " + node.getKey());
            list.add(node);
        }

        if (node.getRightNode() != null){ //===HAS RIGHT===
            getRestNodes(node.getRightNode(), list);
        }
        if (node.getLeftNode() != null){ //===HAS LEFT===
            getRestNodes(node.getLeftNode(), list);
        }
    }

    private void addNodes(ArrayList<TCAS_Node<V>> list){
        for (int i = 0; i < list.size(); i++) {
            put(list.get(i).getKey(), list.get(i).getValue());
        }
    }

    //=====INNER CLASS=====
    private class TCAS_Node<V>{
        //=====VARIABLES=====
        private final String key;
        private V value;
        private TCAS_Node<V> leftNode;
        private TCAS_Node<V> rightNode;

        //=====CONSTRUCTORS=====
        TCAS_Node(String key, V value){
            this.key = key;
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
        }

        TCAS_Node(String key, V value, TCAS_Node<V> leftNode, TCAS_Node<V> rightNode){
            this.key = key;
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        //=====FUNCTIONS=====

        //=====GETTERS/SETTERS=====
        public void setValue(V value) {
            this.value = value;
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
