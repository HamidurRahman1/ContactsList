package contactsList;

import java.util.Objects;

public class Contact
{
    private String firstName;
    private String lastName;
    private String phone;
    private String dob = "";
    private String email = "";
    private boolean favorite;

    public Contact(String firstName, String lastName, String phone)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
    }

    public Contact(String firstName, String lastName, String phone, String dob, String email)
    {
        this(firstName, lastName, phone, dob, email, false);
    }

    public Contact(String firstName, String lastName, String phone, String dob, String email, boolean favorite)
    {
        this(firstName, lastName, phone);
        this.setDob(dob);
        this.setEmail(email);
        this.setFavorite(favorite);
    }

    public boolean isFavorite()
    {
        return (this.favorite == true);
    }

    public void setFavorite(boolean favorite)
    {
        this.favorite = favorite;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (! (o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return isFavorite() == contact.isFavorite() &&
                Objects.equals(getFirstName(), contact.getFirstName()) &&
                Objects.equals(getLastName(), contact.getLastName()) &&
                Objects.equals(getPhone(), contact.getPhone()) &&
                Objects.equals(getDob(), contact.getDob()) &&
                Objects.equals(getEmail(), contact.getEmail());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getFirstName(), getLastName(), getPhone(), getDob(), getEmail(), isFavorite());
    }
}
