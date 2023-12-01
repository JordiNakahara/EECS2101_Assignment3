public class Main {
    public static void main(String[] args){
        TCAS_Structure_2<Integer> tcas = new TCAS_Structure_2<>("3", 3);

        tcas.put("2", 2);
        tcas.put("1", 1);
        tcas.put("4", 4);
        tcas.put("2", 5);
        tcas.put("0", 0);
        /*
        TREE SHOULD LOOK LIKE SUCH:
                        ("3", 3)
                       |        |
                    ("2",5)  ("4", 4)
                   |
                ("1", 1)
               |
            ("0", 0)
         */

        System.out.println(tcas.get("2")); // Should be 5

        tcas.remove("3");
        /*
        TREE SHOULD LOOK NOW LIKE SUCH:
                        ("2", 5)
                       |        |
                    ("1",1)  ("4", 4)
                   |
                ("0", 0)
         */

        System.out.println(tcas.get("0")); // Should be 0
        System.out.println("Size: " + tcas.size()); // Should be 4
        System.out.println(tcas.keySet()); // Should be [2, 1, 0, 4]
        System.out.println(tcas.values()); // Should be [5, 1, 0, 4]
        System.out.println(tcas.entrySet()); // Should be {0=0, 1=1, 2=5, 4=4}, it is in this order only because
        //                                                                      HashMap orders it on its own
    }
}
