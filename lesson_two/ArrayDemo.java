public class ArrayDemo {
    public static void main(String[] args) {
        // declares an array of integers
        int[] anArray;
        
        // allocates memory for 10 integers
        anArray = new int[10];

        anArray[0] = 100;
        anArray[1] = 200;
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1_000;

        System.out.println("Element at index 0 is: " + anArray[0]);
        System.out.println("Element at index 4 is: " + anArray[4]);
        System.out.println("Element at index 9 is: " + anArray[9]);

        int[] anArrayWithShortCutSyntax = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1_000};
        System.out.println("the arrywithShortSyntax: " + anArrayWithShortCutSyntax[4]);
    }
}