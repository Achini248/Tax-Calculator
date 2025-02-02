import java.util.Scanner;

public class TaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            clearConsole();
            System.out.println("=== TAX CALCULATOR ===");
            System.out.println("1. Withholding Tax");
            System.out.println("2. Payable Tax");
            System.out.println("3. Income Tax");
            System.out.println("4. Social Security Contribution Levy (SSCL)");
            System.out.println("5. Leasing Payment");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = validateIntegerInput(scanner);

            switch (choice) {
                case 1:
                    calculateWithholdingTax(scanner);
                    break;
                case 2:
                    calculatePayableTax(scanner);
                    break;
                case 3:
                    calculateIncomeTax(scanner);
                    break;
                case 4:
                    calculateSSCLTax(scanner);
                    break;
                case 5:
                    calculateLeasingPayment(scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void calculateWithholdingTax(Scanner scanner) {
        boolean backToMenu = false;
        while (!backToMenu) {
            clearConsole();
            System.out.println("=== WITHHOLDING TAX ===");
            System.out.println("1. Rent Tax");
            System.out.println("2. Bank Interest Tax");
            System.out.println("3. Dividend Tax");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = validateIntegerInput(scanner);

            switch (choice) {
                case 1:
                    calculateRentTax(scanner);
                    break;
                case 2:
                    calculateBankInterestTax(scanner);
                    break;
                case 3:
                    calculateDividendTax(scanner);
                    break;
                case 4:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void calculateRentTax(Scanner scanner) {
        while (true) {
            System.out.print("Enter the service charge amount: ");
            double amount = validateDoubleInput(scanner);

            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else if (amount <= 100000) {
                System.out.println("You don’t have to pay Rent Tax.");
            } else {
                double tax = amount * 0.10;
                System.out.println("Rent Tax to be paid: Rs. " + tax);
            }

            System.out.print("Do you want to calculate Rent Tax again? (Y/N): ");
            if (!scanner.next().equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private static void calculateBankInterestTax(Scanner scanner) {
        while (true) {
            System.out.print("Enter the annual bank interest amount: ");
            double amount = validateDoubleInput(scanner);

            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else {
                double tax = amount * 0.05;
                System.out.println("Bank Interest Tax to be paid: Rs. " + tax);
            }

            System.out.print("Do you want to calculate Bank Interest Tax again? (Y/N): ");
            if (!scanner.next().equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private static void calculateDividendTax(Scanner scanner) {
        while (true) {
            System.out.print("Enter the dividend amount: ");
            double amount = validateDoubleInput(scanner);

            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else if (amount <= 100000) {
                System.out.println("You don’t have to pay Dividend Tax.");
            } else {
                double tax = amount * 0.14;
                System.out.println("Dividend Tax to be paid: Rs. " + tax);
            }

            System.out.print("Do you want to calculate Dividend Tax again? (Y/N): ");
            if (!scanner.next().equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private static void calculatePayableTax(Scanner scanner) {
        while (true) {
            System.out.print("Enter the monthly salary: ");
            double salary = validateDoubleInput(scanner);

            if (salary < 0) {
                System.out.println("Invalid salary. Please enter a positive value.");
            } else if (salary <= 100000) {
                System.out.println("You don’t have to pay Payable Tax.");
            } else {
                double tax = calculatePayableTaxAmount(salary);
                System.out.println("Payable Tax to be paid: Rs. " + tax);
            }

            System.out.print("Do you want to calculate Payable Tax again? (Y/N): ");
            if (!scanner.next().equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    private static double calculatePayableTaxAmount(double salary) {
        double tax = 0;
        double[] limits = {100000, 141667, 183333, 225000, 266667, 308333};
        double[] rates = {0.06, 0.12, 0.18, 0.24, 0.30, 0.36};

        for (int i = 0; i < limits.length; i++) {
            if (salary > limits[i]) {
                double taxable = Math.min(salary - limits[i], 41667);
                tax += taxable * rates[i];
            }
        }
        return tax;
    }

    private static void calculateIncomeTax(Scanner scanner) {
        // Implement Income Tax calculation logic here
    }

    private static void calculateSSCLTax(Scanner scanner) {
        // Implement SSCL Tax calculation logic here
    }

    private static void calculateLeasingPayment(Scanner scanner) {

    }

    private static int validateIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double validateDoubleInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

