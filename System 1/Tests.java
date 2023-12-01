import java.util.*;
import org.junit.Test;
import org.junit.Assert;

public class Tests {

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


//Old main method below, remove in final version


//    public static void main(String[] args) {
//
//        //Test for basic functionality
//        TCAS_Structure test1 = new TCAS_Structure<>();
//        String str1 = "Hello there!";
//        int value1 = 2003;
//        test1.put(str1, value1);
//        String output = "Value one: " + test1.get(str1);
//        System.out.println(output);
//        System.out.println("--------------------------------------------------------------------------");
//
//        //Test for the other methods----------------------
//
//        //Initialization
//        TCAS_Structure test2 = new TCAS_Structure<>();
//        String str2 = "This is a key";
//        String str3 = "This is also a key";
//        String str4 = "Is this a key?";
//        String str5 = "Ran out of funny things";
//        int value2 = 1;
//        int value3 = 44;
//        int value4 = 23234234;
//        int value5 = -1;
//        test2.put(str2, value2);
//        test2.put(str3, value3);
//        test2.put(str4, value4);
//        test2.put(str5, value5);
//
//        //Testing the methods
//        System.out.println("2nd test initial size: " + test2.size());
//
//        System.out.println("Is the 2nd test currently empty?: " + test2.isEmpty());
//        String getTest = "This is a key";
//        System.out.println("Get result when using \"" + getTest + "\": " + test2.get(getTest));
//        getTest = "This is also a key";
//        System.out.println("Get result when using \"" + getTest + "\": " + test2.get(getTest));
//        getTest = "Is this a key?";
//        System.out.println("Get result when using \"" + getTest + "\": " + test2.get(getTest));
//        getTest = "Ran out of funny things";
//        System.out.println("Get result when using \"" + getTest + "\": " + test2.get(getTest));
//        getTest = "This should return null";
//        System.out.println("Get result when using \"" + getTest + "\": " + test2.get(getTest));
//
//
//        System.out.println("Put result when using \"Ran out of funny things\" and \"72\": "
//                + test2.put("Ran out of funny things", 72));
//        System.out.println("Put result when using \"New key\" and \"72\": "
//                + test2.put("New key", 72));
//
//        System.out.println("Remove result when using \"New key\": "
//                + test2.remove("New key"));
//        System.out.println("Put result when using \"Key new\": "
//                + test2.remove("Key new"));
//
//        System.out.println("Keyset result with each element of the set being printed on a new line: ");
//        Set<String> keySet1 = test2.keySet();
//        Object[] keyArray1 = keySet1.toArray();
//        for (int i = 0; i < keyArray1.length; i++) {
//            System.out.println(keyArray1[i]);
//        }
//
//        System.out.println("Values result with each element of the collection being printed on a new line: ");
//        Collection valueSet1 = test2.values();
//        Object[] valueArray1 = valueSet1.toArray();
//        for (int i = 0; i < valueArray1.length; i++) {
//            System.out.println(valueArray1[i]);
//        }
//
//        System.out.println("Entryset result with each pair of elements being printed on a new line: ");
//        Set<Map.Entry> entrySet1 = test2.entrySet();
//        Map.Entry[] entryArray1 = new Map.Entry[entrySet1.size()];
//        entrySet1.toArray(entryArray1);
//        for (int i = 0; i < entryArray1.length; i++) {
//            Object tempKey = entryArray1[i].getKey();
//            Object tempValue = entryArray1[i].getValue();
//            System.out.println(tempKey + " " + tempValue);
//        }
//    }
}
