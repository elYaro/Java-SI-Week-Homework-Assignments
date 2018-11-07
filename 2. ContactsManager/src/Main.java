public class Main {

    public static void main(String[] args) {
        ContactsManager myContactsManager = new ContactsManager();
        Contact friend1 = new Contact();
        friend1.name = "Ala";
        friend1.phone = "111.222.333";
        friend1.email = "ala@gmail.com";
        myContactsManager.addContact(friend1);

        Contact friend2 = new Contact();
        friend2.name = "Bala";
        friend2.phone = "444.555.666";
        friend2.email = "bala@gmail.com";
        myContactsManager.addContact(friend2);

        Contact friend3 = new Contact();
        friend3.name = "Cala";
        friend3.phone = "777.888.999";
        friend3.email = "cala@gmail.com";
        myContactsManager.addContact(friend3);

        // in line below please choose the name to search for
        Contact result = myContactsManager.searchContact("Cala");
        System.out.printf("Name: %s ,\nphone : %s,\nemail : %s\n", result.name, result.phone, result.email);
    }
}
