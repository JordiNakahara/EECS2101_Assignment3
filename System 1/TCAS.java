import java.util.*;

/**
 * This class contains the main method that is used as the main interface for system 1.
 */
public class TCAS {

    /**
     * This method is run via the command line and interfaces with TCAS_Structure.java
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        TCAS_Structure system = new TCAS_Structure<>();


        while (flag) {
            try {
                String input = sc.nextLine();
                int index = input.indexOf('(');
                String command = "";
                if (index != -1) {
                    command = input.substring(0, index);
                } else {
                    System.out.println("Invalid command name!");
                    continue;
                }

                if (command.equals("size")) {
                    System.out.println("The size of the system is: " + system.size());
                } else if (command.equals("isEmpty")) {
                    if (system.isEmpty()) {
                        System.out.printf("The system is empty");
                    } else {
                        System.out.println("The system is not empty");
                    }
                } else if (command.equals("get")) {
                    int index2 = input.indexOf('"');
                    int index3 = input.indexOf('"', 5);
                    String arg = input.substring(index2 + 1, index3);
                    String output = system.get(arg).toString();
                    System.out.println(output);
                } else if (command.equals("put")) {
                    int index2 = input.indexOf('"') + 1;
                    int index3 = input.indexOf('"', 5);
                    String inputKey = input.substring(index2, index3);
                    index2 = input.indexOf(',') + 1;
                    index3 = input.indexOf(')');
                    String inputValue = input.substring(index2, index3);
                    String output = system.put(inputKey, inputValue).toString();
                    System.out.println("Put value of: " + output + " to the system");
                } else if (command.equals("remove")) {
                    int index2 = input.indexOf('"') + 1;
                    int index3 = input.indexOf('"', 8);
                    String inputKey = input.substring(index2, index3);
                    System.out.println(inputKey);
                    String output = system.remove(inputKey).toString();
                    System.out.println("Remove value of: " + output + " from the system");
                } else if (command.equals("keySet")) {
                    System.out.println("Keyset result with each element of the set being printed on a new line: ");
                    Set<String> keySet1 = system.keySet();
                    Object[] keyArray1 = keySet1.toArray();
                    for (int i = 0; i < keyArray1.length; i++) {
                        System.out.println(keyArray1[i]);
                    }
                } else if (command.equals("values")) {
                    System.out.println("Values result with each element of the collection being printed on a new line: ");
                    Collection valueSet1 = system.values();
                    Object[] valueArray1 = valueSet1.toArray();
                    for (int i = 0; i < valueArray1.length; i++) {
                        System.out.println(valueArray1[i]);
                    }
                } else if (command.equals("entrySet")) {
                    System.out.println("Entryset result with each pair of elements being printed on a new line: ");
                    Set<Map.Entry> entrySet1 = system.entrySet();
                    Map.Entry[] entryArray1 = new Map.Entry[entrySet1.size()];
                    entrySet1.toArray(entryArray1);
                    for (int i = 0; i < entryArray1.length; i++) {
                        Object tempKey = entryArray1[i].getKey();
                        Object tempValue = entryArray1[i].getValue();
                        System.out.println(tempKey + ", " + tempValue);
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
