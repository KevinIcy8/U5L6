

public class BankApp {
    private String name;
    private String pin;
    private CreditCard card;
    private BagelShop bagelShop;
    private Bank bank;

    public BankApp(String name, String pin, CreditCard card, BagelShop bagelshop, Bank bank){
        this.name = name;
        this.pin = pin;
        this.card = card;
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
        if(userChoice.equals("a")){
            return "How many bagels do you want to buy?\n";
        }
        else if (userChoice.equals("b")){

        }
        return "sup";
    }
}
