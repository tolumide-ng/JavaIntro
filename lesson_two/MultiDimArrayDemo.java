public class MultiDimArrayDemo {
    public static void main(String[] args) {
        String[][] names = {
            {"Mr. ", "Mrs. ", "Ms. "},
            {"Smith", "Jones"}
        };

        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        System.out.println(names.length);
    }
}