package annotations;

public class BuiltIns {
    // Java doc comment below 
    /*
    * @deprecated
    * this is no longer in use
    * 
    */
    @Deprecated
    void oldMethod() {};
}



class LocalBuiltIn extends BuiltIns {
    // @SuppressWarnings("deprecation")
    void usingDeprecatedMethod() {
        BuiltIns objectA = new BuiltIns();

        objectA.oldMethod();
    };
}




// Type annotations were creation to support improved analysis of Java programs way of ensuring strongger type checking. The Java SE 8 release does not provide a type checking framework, but it allows you 