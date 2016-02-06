package Kek;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dimbo on 02-Feb-16.
 */
public class ATM {

    Random rnd = new Random();

    int hundreds;
    int fiveHundreds;
    int grand;
    int fiveGrand;
    int totalMoney;
    int n100 = 0, n500 = 0, n1000 = 0, n5000 = 0;

    ATM(int randMultiplier) {
        hundreds = (int) (rnd.nextDouble() * randMultiplier);
        fiveHundreds = (int) (rnd.nextDouble() * randMultiplier);
        grand = (int) (rnd.nextDouble() * randMultiplier);
        fiveGrand = (int) (rnd.nextDouble() * randMultiplier);

        totalMoney = hundreds * 100 +
                fiveHundreds * 500 +
                grand * 1000 +
                fiveGrand * 5000;
    }

    void showAll() {
        totalMoney = hundreds * 100 +
                fiveHundreds * 500 +
                grand * 1000 +
                fiveGrand * 5000;

        System.out.println("hun: " + hundreds +
                "\nfiveHun: " + fiveHundreds +
                "\ngrand: " + grand +
                "\nfiveGrand: " + fiveGrand +
                "\nTotal: " + totalMoney +
                "\n");
    }

    String returnResult(int moneysRequested) {
        String resultState = "Выдача ";
        int startMoneys = moneysRequested;
        if (moneysRequested % 100 != 0) resultState += "невозможна: Сумма не кратна 100";
        else if (moneysRequested > totalMoney) resultState += "невозможна: Недостаточно средств в банкомате";
        else if (moneysRequested <= 0) resultState += "невозможна: Запрашиваемая сумма не может быть меньше 0 или 0";
        else {
            while (moneysRequested >= 5000) {
                if (fiveGrand == 0) break;
                moneysRequested -= 5000;
                n5000++;
                fiveGrand--;
            }
            while (moneysRequested >= 1000) {
                if (grand == 0) break;
                moneysRequested -= 1000;
                n1000++;
                grand--;
            }
            while (moneysRequested >= 500) {
                if (fiveHundreds == 0) break;
                moneysRequested -= 500;
                n500++;
                fiveHundreds--;
            }
            while (moneysRequested >= 100) {
                if (hundreds == 0) break;
                moneysRequested -= 100;
                n100++;
                hundreds--;
            }
            if (moneysRequested > 0) {
                resultState += "невозможна: для выдачи запрошенной суммы в банкомате недостаточно купюр";
            } else {
                resultState += "возможна, число купюр: \n" +
                        (n5000 > 0 ? (n5000 + "x5000") : "") +
                        (n1000 > 0 ? (n1000 + "x1000") : "") +
                        (n500 > 0 ? (n500 + "x500") : "") +
                        (n100 > 0 ? (n100 + "x100") : "") +"\n";
            }
        }

        return "Сумма: " + startMoneys + "\n" +
                resultState;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(60);
        atm.showAll();

        Scanner scn = new Scanner(System.in);
        int input = 0;
        while (true) {
            System.out.println("Enter value needed> ");
            if (!scn.hasNextInt()) {
                System.out.println("WRONG INPUT! Please, input whole number");
                scn.nextLine();
                continue;
            }
            input = scn.nextInt();
            System.out.println(atm.returnResult(input));
            atm.showAll();
        }
    }
}
