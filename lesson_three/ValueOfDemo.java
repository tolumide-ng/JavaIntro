public class ValueOfDemo {
    public static void main(String[] args) {
        if(args.length == 2) {
                  // convert string to numbers
            float a = (Float.valueOf(args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue();

            float a_other = Float.parseFloat(args[0]);

            System.out.println("this is a_other using Float.parseFloat()" + a_other);

            System.out.println("a + b = " +
                                ( a + b ));
            System.out.println("a * b = " +
                                ( a * b ));
            System.out.println("a - b = " +
                                ( a - b ));
            System.out.println("a / b = " +
                                ( a / b ));
            System.out.println("a % b = " +
                                ( a % b ));
        } else {
            System.out.println("This program " +
                "requires two command-line arguments.");
        }
    }
}
