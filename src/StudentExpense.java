
import java.util.Scanner;

public class StudentExpense {

    String studentName;
    double dailyBudget;
    double foodExpense;
    double travelExpense;
    double studyExpense;
    double otherExpense;

    double calculateTotalExpense() {
        double total = foodExpense + travelExpense + studyExpense + otherExpense;
        return total;
    }

    double calculateRemainingAmount() {
        double remaining = dailyBudget - calculateTotalExpense();
        return remaining;
    }

    boolean isWithinBudget() {
        if (calculateTotalExpense() <= dailyBudget) {
            return true;
        }
        return false;
    }

    double calculateExceededAmount() {
        double total = calculateTotalExpense();

        if (total > dailyBudget) {
            return total - dailyBudget;
        }
        return 0;
    }

    String getBudgetStatus() {
        double total = calculateTotalExpense();

        if (total < dailyBudget) {
            return "Within Budget";
        }

        if (total == dailyBudget) {
            return "Budget Fully Used";
        }

        return "Budget Exceeded";
    }

    void displayExpenseReport() {

        double total = calculateTotalExpense();

        System.out.println("\n---------- DAILY EXPENSE REPORT ----------");
        System.out.println("Student Name      : " + studentName);
        System.out.println("Daily Budget      : " + dailyBudget);
        System.out.println("Food Expense      : " + foodExpense);
        System.out.println("Travel Expense    : " + travelExpense);
        System.out.println("Study Expense     : " + studyExpense);
        System.out.println("Other Expense     : " + otherExpense);
        System.out.println("Total Expense     : " + total);

        if (isWithinBudget()) {
            System.out.println("Remaining Amount  : " + calculateRemainingAmount());
        } else {
            System.out.println("Exceeded Amount   : " + calculateExceededAmount());
        }
        System.out.println("Budget Status     : " + getBudgetStatus());
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentExpense expense = new StudentExpense();

        System.out.print("Enter student name: ");
        expense.studentName = input.nextLine();

        do {
            System.out.print("Enter daily budget: ");
            expense.dailyBudget = input.nextDouble();

            if (expense.dailyBudget < 0) {
                System.out.println("Budget cannot be negative.");
            }
        } while (expense.dailyBudget < 0);

        do {
            System.out.print("Enter food expense: ");
            expense.foodExpense = input.nextDouble();

            if (expense.foodExpense < 0) {
                System.out.println("Expense cannot be negative.");
            }
        } while (expense.foodExpense < 0);

        do {
            System.out.print("Enter travel expense: ");
            expense.travelExpense = input.nextDouble();

            if (expense.travelExpense < 0) {
                System.out.println("Expense cannot be negative.");
            }
        } while (expense.travelExpense < 0);

        do {
            System.out.print("Enter study expense: ");
            expense.studyExpense = input.nextDouble();

            if (expense.studyExpense < 0) {
                System.out.println("Expense cannot be negative.");
            }
        } while (expense.studyExpense < 0);

        do {
            System.out.print("Enter other expense: ");
            expense.otherExpense = input.nextDouble();

            if (expense.otherExpense < 0) {
                System.out.println("Expense cannot be negative.");
            }
        } while (expense.otherExpense < 0);

        expense.displayExpenseReport();

        input.close();
    }
}
