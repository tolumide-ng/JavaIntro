package classes;

public class Loan {
    private String name;

    public Loan() {}

    public double computePayment(
        double loanAmount, double rate, double futureValue, int numPeriods
    ) {
        double interest = rate / 100.0;
        double partial1 = Math.pow((1 + interest), -numPeriods);
        double denominator = (1 - partial1) / interest;
        double answer = (-loanAmount / denominator) - ((futureValue * partial1) / denominator);
        
        return answer;
    }
}
