import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculate(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculate(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculate(double value, int places) {

        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateDeposit() {
        int period;
        int amount;
        int action;
        double result = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом," + " 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }


}
