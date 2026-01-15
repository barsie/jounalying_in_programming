package Lessons;

public class ConditionalEvaluations {
    public static void main(String[] args) {
        // conditional evaluations

        int a = 1;
        int b = 3;
        System.out.println(a != b);
        System.out.println(a == b);

        int temperature = 12;
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = true;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;
        boolean isElegible1 = hasHighIncome || hasGoodCredit; // || or operator, ! not operator.
        System.out.println(isEligible);
        System.out.println(isElegible1);
    }
}
