import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class TCAS {
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

                } else if (command.equals("keySet")) {

                } else if (command.equals("values")) {

                } else if (command.equals("entrySet")) {

                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
