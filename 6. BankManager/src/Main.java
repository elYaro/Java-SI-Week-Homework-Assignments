// INHERITANCE lesson & POLYMORPHISM

public class Main {
    public static void main(String[] args) {
       CheckingAccount ChAc1 = new CheckingAccount();
        SavingAccount SaAc1 = new SavingAccount();
        COD Cod1 = new COD();

        ChAc1.account = "account no 1";
        ChAc1.balance = 9356;
        ChAc1.limit = 1000;

        SaAc1.account = "account no  2";
        SaAc1.balance = 1534;
        SaAc1.noWithDraw = 5;


        Cod1.account = "account no 3";
        Cod1.balance = 234;
        Cod1.validTill = "april 2020";

        System.out.printf("Account name is %s,\nactual balance is %s,\nlimit is %s\n\n", ChAc1.account, ChAc1.balance, ChAc1.limit);
        System.out.printf("Account name is %s,\nactual balance is %s,\nmax number of withdraw is: limit is %s\n\n", SaAc1.account, SaAc1.balance, SaAc1.noWithDraw);
        System.out.printf("Account name is %s,\nactual balance is %s,\nlimit is %s\n\n", Cod1.account, Cod1.balance, Cod1.validTill);

    }
}



class BankAccount{
    String account;         //account number
    double balance;         //actual balance on the account
   }


class CheckingAccount extends BankAccount {
    int limit;              //debet limit
}


class SavingAccount extends BankAccount {
   int noWithDraw;          //withdraw monthly limit
}

class COD extends BankAccount {
   String validTill;        //deposit valid till date
}
