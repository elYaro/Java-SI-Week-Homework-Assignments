public class ContactsManager {
    //Fields
    private Contact [] myContactsArray;
    private int myContactsCount;

    //Constructor
    ContactsManager(){
        this.myContactsCount = 0;
        this.myContactsArray = new Contact [500];
    }

    //Methods start here
    public void addContact(Contact contact){
        myContactsArray[myContactsCount] = contact;
        myContactsCount ++;
    }

    public Contact searchContact(String name) {
        for (int i = 0; i < myContactsCount; i++) {
            if (myContactsArray[i].name.equals(name)) {
                return myContactsArray[i];
            }
        }
        return null;
    }



}
