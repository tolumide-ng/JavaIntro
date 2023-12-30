package lesson_four.streams;

import java.util.List;

public class Optionals {
    
    Optionals() {
    }
    
    public static void main(String[] args) {
        new Optionals().getUser(1);
    }
    
    public void getUser(int id) {
        List<Customer> customers = List.of(new Customer(1, "tolu"), new Customer(2, "mide"));
    
        String result = customers.stream().filter(customer -> customer.getId() == id).findFirst().map(Customer::getName)
                .orElse("UNKNOWN");

        System.out.println("the name is" + result);
    }
}
