package a3package;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TCAS2 {
    public static void main(String[] args) {
        //TCAS_Structure_2<Integer> tcas = new TCAS_Structure_2<>("3", 3);
        /*
        tcas.put("2", 2);
        tcas.put("1", 1);
        tcas.put("4", 4);
        tcas.put("2", 5);
        tcas.put("0", 0);

//        TREE SHOULD LOOK LIKE SUCH:
//                        ("3", 3)
//                       |        |
//                    ("2",5)  ("4", 4)
//                   |
//                ("1", 1)
//               |
//            ("0", 0)


        System.out.println(tcas.get("2")); // Should be 5

        tcas.remove("3");

//        TREE SHOULD LOOK NOW LIKE SUCH:
//                        ("2", 5)
//                       |        |
//                    ("1",1)  ("4", 4)
//                   |
//                ("0", 0)


        System.out.println(tcas.get("0")); // Should be 0
        System.out.println("Size: " + tcas.size()); // Should be 4
        System.out.println(tcas.keySet()); // Should be [2, 1, 0, 4]
        System.out.println(tcas.values()); // Should be [5, 1, 0, 4]
        System.out.println(tcas.entrySet()); // Should be {0=0, 1=1, 2=5, 4=4}, it is in this order only because
        //                                                                      HashMap orders it on its own
        */

        TCAS_Structure_2<Integer> tcas = new TCAS_Structure_2<>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            try {
                String input = sc.nextLine();
                if(input.toLowerCase().equals("quit")) {
                    return;
                }
                int index = input.indexOf('(');
                String command = "";
                if (index != -1) {
                    command = input.substring(0, index);
                } else {
                    System.out.println("Invalid command name!");
                    continue;
                }

                if (command.equals("size")) {
                    if (input.indexOf(')') == 5) {
                        System.out.println(tcas.size());
                    } else {
                        System.out.println("Invalid command name!");
                    }
                } else if (command.equals("isEmpty")) {
                    if (input.indexOf(')') == 8) {
                        System.out.println(tcas.isEmpty());
                    } else {
                        System.out.println("Invalid command name!");
                    }
                } else if (command.equals("get")) {
                    if (input.endsWith(")")) {
                        int index2 = input.indexOf('"');
                        int index3 = input.indexOf('"', 5);
                        String arg = input.substring(index2 + 1, index3);
                        System.out.println(tcas.get(arg));
                    } else {
                        System.out.println("Invalid command name!");
                    }
                } else if (command.equals("put")) {
                    int index2 = input.indexOf('"') + 1;
                    int index3 = input.indexOf('"', 5);
                    String inputKey = input.substring(index2, index3);
                    index2 = input.indexOf(',') + 1;
                    index3 = input.indexOf(')');
                    Integer inputValue = Integer.valueOf((input.substring(index2, index3)).trim());
                    System.out.println(tcas.put(inputKey, inputValue));
                } else if (command.equals("remove")) {
                    int index2 = input.indexOf('"') + 1;
                    int index3 = input.indexOf('"', 8);
                    String inputKey = input.substring(index2, index3);
                    System.out.println(tcas.remove(inputKey));
                } else if (command.equals("keySet")) {
//                    System.out.println("Keyset result with each element of the set being printed on a new line: ");
                    if (input.indexOf(')') == 7) {
                        System.out.println(tcas.keySet());
                    } else {
                        System.out.println("Invalid command name!");
                    }
                } else if (command.equals("values")) {
//                    System.out.println("Values result with each element of the collection being printed on a new line: ");
                    System.out.println(tcas.values());
                    if (input.indexOf(')') == 7) {
                        System.out.println(tcas.values());
                    } else {
                        System.out.println("Invalid command name!");
                    }
                } else if (command.equals("entrySet")) {
//                    System.out.println("Entryset result with each pair of elements being printed on a new line: ");
                    if (input.indexOf(')') == 9) {
                        Set<Map.Entry<String, Integer>> entrySet1 = tcas.entrySet();
                        Map.Entry[] entryArray1 = new Map.Entry[entrySet1.size()];
                        entrySet1.toArray(entryArray1);
                        System.out.print("[");
                        for (int i = 0; i < entryArray1.length; i++) {
                            Object tempKey = entryArray1[i].getKey();
                            Object tempValue = entryArray1[i].getValue();
                            System.out.print("('" + tempKey + "', " + tempValue + ")");
                            if (i != entryArray1.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                    } else {
                        System.out.println("Invalid command name!");
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Invalid input!");
            }
        }
    }
}
