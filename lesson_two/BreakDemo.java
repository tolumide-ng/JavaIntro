public class BreakDemo {
    public static void main(String[] args) {
        int[] arrayOfThings = {32, 87, 3, 590, 12, 622, 127};
        int searchfor = 12;

        int i;
        boolean foundIt = false;

        for(i=0; i<arrayOfThings.length; i++) {
            if (arrayOfThings[i] == searchfor) {
                foundIt = true;
                break;
            }
        }

        if(foundIt) {
            System.out.println("Found " + searchfor + " at index " + i);
        } else {
            System.out.println(searchfor + " not in the array");
        }
    }
}
