package SmallPrograms;

public class incomeValidation {

    public static void main(String[] args) {
        int income = 120_000;
        // boolean hasHighIncome = (income > 100_000);

        /* Ternary Operators: it's compose by 3 pieces; the condition, firts evaluation and second evaluation*/ 
        String classType = income > 100_000 ? "Economy" : "First";
        System.out.println(classType);
    }
}