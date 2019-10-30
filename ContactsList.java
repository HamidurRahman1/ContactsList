package contactsList;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

import static java.lang.System.out;

public class ContactsList implements Iterable<Contact>
{
    private List<Contact> contactList = new ArrayList<>();
    private Contact contact;

    public ContactsList() {}

    public ContactsList(Contact contact)
    {
        this(contact, false);
    }

    public ContactsList(Contact contact, boolean favorite)
    {
        this.contact = contact;
        this.contact.setFavorite(favorite);
        contactList.add(this.contact);
    }

    public void addContact(Contact contact)
    {
        contactList.add(contact);
    }

    public void addContact(String firstName, String lastName, String phone)
    {
        this.addContact(firstName, lastName, phone, "", "", false);
    }

    public void addContact(String firstName, String lastName, String phone, String dob, String email)
    {
        this.addContact(firstName, lastName, phone, dob, email, false);
    }

    public void  addContact(String firstName, String lastName, String phone, String dob, String email, boolean favorite)
    {
        this.contact = new Contact(firstName, lastName, phone, dob, email, favorite);
        this.contactList.add(this.contact);
    }

    public void removeContacts(Contact contact)
    {
        if(contactList.remove(contact)) return;
    }

    public int size()
    {
        return contactList.size();
    }

    public boolean exists(Contact contact)
    {
        if(contactList.contains(contact)) return true;
        else return false;
    }

    public void displayFavoriteContacts()
    {
        contactList.stream().filter(contact -> contact.isFavorite()).forEach(out::println);
    }

    public void sortBy(String by)
    {
        final String l = "l";               // sort by last name

        if(by.equalsIgnoreCase(l))
        {
            Collections.sort(contactList, Comparator.comparing(Contact ::getLastName));
        }
        else
        {
            Collections.sort(contactList, Comparator.comparing(Contact ::getFirstName));
        }
    }

    public List<String> getPhoneByFirstName(String firstName)
    {
        return getPhoneBy(firstName);
    }

    public List<String> getPhoneByLastName(String lastName)
    {
        return getPhoneBy(lastName);
    }

    private List<String> getPhoneBy(String firstOrLastName)
    {
        List<String> phoneList = new ArrayList <>();

        for(Contact contact : contactList)
        {
            if(contact.getLastName().equals(firstOrLastName))
            {
                phoneList.add(contact.getPhone());
            }
        }
        return phoneList;
    }

    public List<Contact> getAllContacts()
    {
        List<Contact> tempList = new ArrayList <>();
        contactList.forEach(e -> tempList.add(e));
        return tempList;
    }

    @Override
    public String toString()
    {
        sortBy("f");

        String longString = "";

        for(Contact contact : contactList)
        {
            longString = longString.concat(contact.toString().concat("\n"));
        }

        return longString;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (! (o instanceof ContactsList)) return false;
        ContactsList that = (ContactsList) o;
        return Objects.equals(contactList, that.contactList) &&
                Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(contactList, contact);
    }

    @Override
    public Iterator iterator()
    {
        return new ContactsListIterator();
    }

    private class ContactsListIterator implements Iterator<Contact>
    {
        int counter = 0;

        @Override
        public boolean hasNext()
        {
            return (counter < contactList.size());
        }

        @Override
        public Contact next()
        {
            return contactList.get(counter++);
        }
    }
}
