package a3package;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.*;


/**
 * This class contains some basic test cases for system 1 and can be used as a template for future test cases.
 *
 * @author Landon Navarre
 * @version 1.0
 */
public class Tests {

    /**
     * This test goes over basic functionality and is used as a template for the other test cases.
     */
    @Test
    public void Test1() {
        TCAS_Structure test = new TCAS_Structure<>();
        String[] keys = {"First", "Second", "Third"};
        Integer[] values = {1, 2, 3};
        for (int i = 0; i < keys.length; i++) {
            test.put(keys[i], values[i]);
        }

        //Testing values of key-value pairs in system.
        Collection<Integer> valuesCollection1 = test.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        //Testing keys of key-value pairs in system.
        Set<String> keysSet1 = test.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(test.containsKey(keysArray1[i]));
        }

        //Testing complete key-value pairs in system.
        Set<TCAS_Entry> entrySet1 = test.entrySet();
        TCAS_Entry[] entryArray1 = new TCAS_Entry[entrySet1.size()];
        entrySet1.toArray(entryArray1);
        for (int i = 0; i < entryArray1.length; i++) {
            String tempKey = entryArray1[i].getKey().toString();
            Assert.assertEquals(test.get(tempKey), entryArray1[i].getValue());
        }

    }

    /**
     * This test cases goes over a relatively large data set of 100 elements.
     */
    @Test
    public void Test2() {
        TCAS_Structure test = new TCAS_Structure<>();
        String[] keys = new String[100];
        Integer[] values = new Integer[100];

        //Adding entries to system
        for (int i = 0; i < keys.length; i++) {
            keys[i] = "" + i;
            values[i] = (i + 7) % 4;
            test.put(keys[i], values[i]);
        }

        //Testing values in key-value pairs in system
        Collection<Integer> valuesCollection1 = test.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        //Testing keys in key-value pairs in system
        Set<String> keysSet1 = test.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(test.containsKey(keysArray1[i]));
        }

        //Testing key-value pairs in system
        Set<TCAS_Entry> entrySet1 = test.entrySet();
        TCAS_Entry[] entryArray1 = new TCAS_Entry[entrySet1.size()];
        entrySet1.toArray(entryArray1);
        for (int i = 0; i < entryArray1.length; i++) {
            String tempKey = entryArray1[i].getKey().toString();
            Assert.assertEquals(test.get(tempKey), entryArray1[i].getValue());
        }

    }

    /**
     * This test includes testing for all remaining methods of the TCAS_Structure class.
     */
    @Test
    public void Test3() {
        //Declaration and adding key-value pairs
        TCAS_Structure test = new TCAS_Structure<>();
        String[] keys = {"This is a really long key",
                "This is also a key", "This is another key", "Yet another key"};
        Integer[] values = {27, 16, 49, 216};
        for (int i = 0; i < keys.length; i++) {
            test.put(keys[i], values[i]);
        }

        //Testing for values of key-value pairs in system
        Collection<Integer> valuesCollection1 = test.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertTrue(test.containsValue(valuesArray1[i]));
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        //Testing for keys of key-value pairs in system
        Set<String> keysSet1 = test.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(test.containsKey(keysArray1[i]));
        }

        //Testing for key-value pairs in system
        Set<TCAS_Entry> entrySet1 = test.entrySet();
        TCAS_Entry[] entryArray1 = new TCAS_Entry[entrySet1.size()];
        entrySet1.toArray(entryArray1);
        for (int i = 0; i < entryArray1.length; i++) {
            String tempKey = entryArray1[i].getKey().toString();
            Assert.assertEquals(test.get(tempKey), entryArray1[i].getValue());
        }

        //Testing isEmpty() functionality
        Assert.assertFalse(test.isEmpty());
        for (int i = 0; i < keys.length; i++) {
            test.remove(keys[i]);
        }
        Assert.assertTrue(test.isEmpty());

        //Re-Filling System with entries
        Map<String, Integer> toPutAll = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            toPutAll.put(keys[i], values[i]);
        }

        test.putAll(toPutAll);

        //Re-Testing key-value pairs
        entrySet1 = test.entrySet();
        entrySet1.toArray(entryArray1);
        for (int i = 0; i < entryArray1.length; i++) {
            String tempKey = entryArray1[i].getKey().toString();
            Assert.assertEquals(test.get(tempKey), entryArray1[i].getValue());
        }

        test.clear();
        Assert.assertTrue(test.isEmpty());
    }

    /**
     * From here we shift to testing TCAS_Structure2, starting with a test of basic functionality
     * as we did for our first structure.
     */
    @Test
    public void Test4() {
        //Declaration and adding key-value pairs
        TCAS_Structure_2 toTest = new TCAS_Structure_2();
        String[] keys = {"First", "Second", "Third"};
        Integer[] values = {1, 2, 3};
        for (int i = 0; i < keys.length; i++) {
            toTest.put(keys[i], values[i]);
        }

        //Testing values of key-value pairs in system.
        Collection<Integer> valuesCollection1 = toTest.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        //Testing keys of key-value pairs in system
        Collection<String> keysSet1 = toTest.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(toTest.containsKey(keysArray1[i]));
        }

        //Testing key-value pairs in system
        Set<TCAS_Structure_2.TCAS_Node> entrySet1 = toTest.entrySet();
        for (TCAS_Structure_2.TCAS_Node entry : entrySet1) {
            String tempKey = entry.getKey().toString();
            Assert.assertEquals(toTest.get(tempKey), entry.getValue());
        }
    }

    /**
     * Testing system 2 over a large collection of entries.
     */
    @Test
    public void Test5() {
        TCAS_Structure_2 toTest = new TCAS_Structure_2();
        String[] keys = new String[100];
        Integer[] values = new Integer[100];

        //Inserting 100 entries into our system.
        for (int i = 0; i < keys.length; i++) {
            keys[i] = "" + i;
            values[i] = (i + 7) % 4;
            toTest.put(keys[i], values[i]);
            //The above is error-free, the values[] array is as expected.
        }

        //Testing values of key-value pairs in our system.
        Collection<Integer> valuesCollection1 = toTest.values();

        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);

        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        //Testing keys of key-value pairs in our system.
        Collection<String> keysSet1 = toTest.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(toTest.containsKey(keysArray1[i]));
        }

        //Testing key-value pairs in our system.
        Set<TCAS_Structure_2.TCAS_Node> entrySet1 = toTest.entrySet();
        for (TCAS_Structure_2.TCAS_Node entry : entrySet1) {
            String tempKey = entry.getKey().toString();
            Assert.assertEquals(toTest.get(tempKey), entry.getValue());
        }
    }

    /**
     * Testing the remaining functionality of system #2.
     */
    @Test
    public void Test6() {
        //Testing isEmpty() functionality.
        TCAS_Structure_2 toTest = new TCAS_Structure_2<>();
        Assert.assertTrue(toTest.isEmpty());

        //Adding key-value pairs.
        String[] keys = {"This is a really long key",
                "This is also a key", "This is another key", "Yet another key"};
        Integer[] values = {27, 16, 49, 216};
        for (int i = 0; i < keys.length; i++) {
            toTest.put(keys[i], values[i]);
        }

        //Testing values in key-value pairs
        Collection<Integer> valuesCollection1 = toTest.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertTrue(toTest.containsValue(valuesArray1[i]));
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        //Testing keys in key-value pairs
        Collection<String> keysSet1 = toTest.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(toTest.containsKey(keysArray1[i]));
        }

        //Testing key-value pairs in system
        Set<TCAS_Structure_2.TCAS_Node> entrySet1 = toTest.entrySet();
        for (TCAS_Structure_2.TCAS_Node entry : entrySet1) {
            String tempKey = entry.getKey().toString();
            Assert.assertEquals(toTest.get(tempKey), entry.getValue());
        }

        //Testing removal via isEmpty
        Assert.assertFalse(toTest.isEmpty());

        for (int i = 0; i < keys.length; i++) {
            toTest.remove(keys[i]);
        }
        Assert.assertTrue(toTest.isEmpty());

        //Re-adding key-value pairs
        Map<String, Integer> toPutAll = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            toPutAll.put(keys[i], values[i]);
            toTest.put(keys[i], values[i]);
        }

        //Re-testing key-value pairs
        entrySet1 = toTest.entrySet();
        for (TCAS_Structure_2.TCAS_Node entry : entrySet1) {
            String tempKey = entry.getKey().toString();
            Assert.assertEquals(toTest.get(tempKey), entry.getValue());
        }
    }

}