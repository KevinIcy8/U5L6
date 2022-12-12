import java.util.Scanner;

public class BankApp {
    Scanner s = new Scanner(System.in);
    private String name;
    private String pin;
    private CreditCard card;
    private CreditCard card2;
    private BagelShop bagelShop;
    private Bank bank;

    public BankApp(String name, String pin, CreditCard card, BagelShop bagelshop, Bank bank){
        this.name = name;
        this.pin = pin;
        this.card = card;
        card2 = null;
        this.bagelShop = bagelshop;
        this.bank = bank;
    }

    public String getMenu(){
        return "\nWhat would you like to do?\n" +
                "Press a to make a purchase at the bagel shop.\n" +
                "Press b to return bagels at the bagel shop\n" +
                "Press c to make a payment on the credit card.\n" +
                "Press d to open a second credit card\n" +
                "Press e to compare credit card balances.\n" +
                "Press f to deposit profits into the bank.\n" +
                "Press g to check inventory\n" +
                "Press q to quit the program\n";
    }

    public String action(String userChoice){
        userChoice = userChoice.toLowerCase();
        String cardChoice = "";
        CreditCard cardOfChoice = card;
        if (userChoice.equals("a")) {
            System.out.println("How many bagels do you want to buy?");
            String bagelQuant = s.nextLine();
            if(CreditCard.getNumberOfCards()>=2){
                System.out.println("Which card do you want to use? Enter 1 for card 1; Enter 2 for card 2");
                cardChoice = s.nextLine();
                if(cardChoice == "1"){
                    cardOfChoice = card;
                }
                else{
                    cardOfChoice = card2;
                }
            }
            System.out.println("Please enter your PIN to complete the purchase.");
            String passwordInput = s.nextLine();
            boolean paymentAttempt = bagelShop.payForBagels(cardOfChoice, Integer.parseInt(bagelQuant), passwordInput);
            if (paymentAttempt) {
                System.out.println("Payment successful!\nYou bought " + bagelQuant + " bagels");
                System.out.println();
                System.out.println(cardOfChoice);
            } else {
                System.out.println("Payment failed! PIN is incorrect");
            }
        }
        else if(userChoice.equals("b")){
            System.out.println("How many bagels do you want to return");
            String returnAmt = s.nextLine();
            if(CreditCard.getNumberOfCards()>=2){
                System.out.println("Which card do you want to use? Enter 1 for card 1; Enter 2 for card 2");
                cardChoice = s.nextLine();
                if(cardChoice == "1"){
                    cardOfChoice = card;
                }
                else{
                    cardOfChoice = card2;
                }
            }
            System.out.println("Please enter your PIN to complete the transaction.");
            String passwordInput = s.nextLine();
            boolean returnAttempt = bagelShop.returnBagels(cardOfChoice, Integer.parseInt(returnAmt), passwordInput);
            if (returnAttempt) {
                System.out.println("Refund successful!\nYou returned " + returnAmt + " bagels");
                System.out.println();
                System.out.println(cardOfChoice);
            } else {
                System.out.println("Refund failed! PIN is incorrect");
            }
        }
        else if(userChoice.equals("c")){
            System.out.println("How much do you want to pay off?");
            if(CreditCard.getNumberOfCards()>=2){
                System.out.println("Which card do you want to use? Enter 1 for card 1; Enter 2 for card 2");
                cardChoice = s.nextLine();
                if(cardChoice == "1"){
                    cardOfChoice = card;
                }
                else{
                    cardOfChoice = card2;
                }
            }
            String paymentAmt = s.nextLine();
            bank.makePayment(cardOfChoice, Integer.parseInt(paymentAmt));
            System.out.println();
            System.out.println(cardOfChoice);
        }
        else if(userChoice.equals("d")){
            if(CreditCard.getNumberOfCards()>=2){
                System.out.println("You already opened a second card!");
            }
            else{
                System.out.println("What's the name on this new card?");
                String newName = s.nextLine();
                System.out.println("What's the PIN for this new card?");
                String newPin = s.nextLine();
                CreditCard card2 = new CreditCard(newName,newPin);
                this.card2 = card2;
                System.out.println();
                System.out.println(card2);
            }
        }
        else if(userChoice.equals("e")){
            if(CreditCard.getNumberOfCards()<2){
                System.out.println("Sorry, you do not have a second card to compare with");
            }
            else{
                CreditCard lowestCard = bank.lowerBalance(card,card2);
                    if(lowestCard!=null){
                        System.out.println(lowestCard.getAccountHolder() + "with a $" + lowestCard.getBalanceOwed() + "balance\n");
                    }
                    else{
                        System.out.println("They have the same balance");
                    }
            }
        }
        else if(userChoice.equals("f")){
            bagelShop.depositProfits();
            System.out.println("You successfully deposited!\n");
            System.out.println(bagelShop + "\n");
            System.out.println(bank + "\n");
        }
        else if(userChoice.equals("g")){
            System.out.println(bagelShop + "\n");
        }
        else{
            return "Successfully exited!";
        }
        return "";
    }
}
