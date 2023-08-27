class ArithmeticDemo {
    public static void main(String[] args) {
        int result = 1 + 2;
        // result is now 3
        System.out.println("1 + 2 = " + result);
        int original_result = result;

        result = result - 1;
        System.out.println(original_result + " - 1 = " + result);
        original_result = result;
    }
}