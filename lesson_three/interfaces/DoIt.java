package interfaces;

public interface DoIt {
    void doSomething(int i, double x);
    
    int doSomethingElse(String s);

    boolean didItWork(int i, double x, String s);

    default boolean didItWorkExtended(int i, double x, String s) {
        return true;
    }
}
