public class TCAS {
    public static void main(String[] args) {
        TCAS_Structure test1 = new TCAS_Structure<>();
        String str1 = "Hello there!";
        int value1 = 2003;
        test1.put(str1, value1);
        String output = "Value one: " + test1.get(str1);
        System.out.println(output);
    }
}
