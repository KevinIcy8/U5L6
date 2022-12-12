import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your name?\n");
        String name = s.nextLine();
        Bank bank = new Bank();
        BagelShop bagelShop = new BagelShop(name + "'s Bagel Shop", 200, 2, bank);
        System.out.print("Please create your pin for your credit card: ");
        String pin = s.nextLine();
        CreditCard card1 = new CreditCard(name, pin);
        BankApp app = new BankApp(name, pin, card1, bagelShop, bank);
        String choiceOfAction = "";
        while (!choiceOfAction.equals("q")) {
            System.out.println(app.getMenu());
            choiceOfAction = s.nextLine();
            System.out.println(app.action(choiceOfAction));
            Thread.sleep(1000);
        }
    }
}

