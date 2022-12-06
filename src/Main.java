import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
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
            if (choiceOfAction.equals("a")) {
                System.out.println("How many bagels do you want to buy?");
                String bagelQuant = s.nextLine();
                System.out.println("Please enter your PIN to complete the purchase.");
                String passwordInput = s.nextLine();
                boolean paymentAttempt = bagelShop.payForBagels(card1, Integer.parseInt(bagelQuant), passwordInput);
                if (paymentAttempt) {
                    System.out.println("Payment successful!\nYou bought " + bagelQuant + " bagels");
                    System.out.println();
                    System.out.println(card1);
                } else {
                    System.out.println("Payment failed! PIN is incorrect");
                }
            }
            else if(choiceOfAction.equals("b")){
                System.out.println("How many bagels do you want to return");
                String returnAmt = s.nextLine();
                System.out.println("Please enter your PIN to complete the transaction.");
                String passwordInput = s.nextLine();
                boolean returnAttempt = bagelShop.returnBagels(card1, Integer.parseInt(returnAmt), passwordInput);
                if (returnAttempt) {
                    System.out.println("Refund successful!\nYou returned " + returnAmt + " bagels");
                    System.out.println();
                    System.out.println(card1);
                } else {
                    System.out.println("Refund failed! PIN is incorrect");
                }
            }
            else if(choiceOfAction.equals("c")){
                System.out.println("How much do you want to pay off?");
                String paymentAmt = s.nextLine();
                bank.makePayment(card1, Integer.parseInt(paymentAmt));
                System.out.println();
                System.out.println(card1);
            }
            else if(choiceOfAction.equals("d")){
                System.out.println("What's the name on this new card?");
                System.out.println("What's the PIN for this new card?");
                CreditCard card2 = new CreditCard(name,pin);
                System.out.println();
                System.out.println(card2);
            }
            else if(choiceOfAction.equals("e")){
                
            }
            else if(choiceOfAction.equals("f")){

            }

        }
        System.out.println("Successfully exited");
    }
}

