import java.util.*;

import org.junit.Test;
import org.junit.Assert;


/**
 * This class contains some basic test cases for system 1 and can be used as a template for future test cases.
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

        Collection<Integer> valuesCollection1 = test.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        Set<String> keysSet1 = test.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(test.containsKey(keysArray1[i]));
        }

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


        for (int i = 0; i < keys.length; i++) {
            keys[i] = "" + i;
            values[i] = (i + 7) % 4;
            test.put(keys[i], values[i]);
        }

        Collection<Integer> valuesCollection1 = test.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        Set<String> keysSet1 = test.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(test.containsKey(keysArray1[i]));
        }

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
        TCAS_Structure test = new TCAS_Structure<>();
        String[] keys = {"This is a really long key",
                "This is also a key", "This is another key", "Yet another key"};
        Integer[] values = {27, 16, 49, 216};
        for (int i = 0; i < keys.length; i++) {
            test.put(keys[i], values[i]);
        }

        Collection<Integer> valuesCollection1 = test.values();
        Integer[] valuesArray1 = new Integer[valuesCollection1.size()];
        valuesCollection1.toArray(valuesArray1);
        for (int i = 0; i < valuesArray1.length; i++) {
            Assert.assertTrue(test.containsValue(valuesArray1[i]));
            Assert.assertEquals(values[i], valuesArray1[i]);
        }

        Set<String> keysSet1 = test.keySet();
        String[] keysArray1 = new String[keysSet1.size()];
        keysSet1.toArray(keysArray1);
        for (int i = 0; i < keysArray1.length; i++) {
            Assert.assertTrue(test.containsKey(keysArray1[i]));
        }

        Set<TCAS_Entry> entrySet1 = test.entrySet();
        TCAS_Entry[] entryArray1 = new TCAS_Entry[entrySet1.size()];
        entrySet1.toArray(entryArray1);
        for (int i = 0; i < entryArray1.length; i++) {
            String tempKey = entryArray1[i].getKey().toString();
            Assert.assertEquals(test.get(tempKey), entryArray1[i].getValue());
        }

        Assert.assertFalse(test.isEmpty());

        for (int i = 0; i < keys.length; i++) {
            test.remove(keys[i]);
        }

        Assert.assertTrue(test.isEmpty());

        Map<String, Integer> toPutAll = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            toPutAll.put(keys[i], values[i]);
        }

        test.putAll(toPutAll);

        entrySet1 = test.entrySet();
        entrySet1.toArray(entryArray1);
        for (int i = 0; i < entryArray1.length; i++) {
            String tempKey = entryArray1[i].getKey().toString();
            Assert.assertEquals(test.get(tempKey), entryArray1[i].getValue());
        }

        test.clear();
        Assert.assertTrue(test.isEmpty());
    }
}