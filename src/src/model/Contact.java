package model;

// Contact class represents a single contact's information
public class Contact {

    // Private variables (Encapsulation - data hiding)
    private int contactId;
    private String name;
    private String phone;
    private String email;
    private String address;

    // Default constructor (initializes with default values)
    public Contact() {
        this.contactId = 0;
        this.name = "NA";
        this.phone = "NA";
        this.email = "NA";
        this.address = "NA";
    }

    // Parameterized constructor (used to create object with values)
    public Contact(int contactId, String name, String phone, String email, String address) {
        super();
        this.contactId = contactId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Copy constructor (creates a new object by copying another Contact object)
    public Contact(Contact c) {
        super();
        this.contactId = c.contactId;
        this.name = c.name;
        this.phone = c.phone;
        this.email = c.email;
        this.address = c.address;
    }

    // Getter method for contactId
    public int getContactId() {
        return contactId;
    }

    // Setter method for contactId
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for phone
    public String getPhone() {
        return phone;
    }

    // Setter method for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter method for email
    public String getEmail() {
        return email;
    }

    // Setter method for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method for address
    public String getAddress() {
        return address;
    }

    // Setter method for address
    public void setAddress(String address) {
        this.address = address;
    }

    // toString method (used to display contact details)
    @Override
    public String toString() {
        return "Contact [contactId=" + contactId + ", name=" + name + ", phone=" + phone + ", email=" + email
                + ", address=" + address + "]";
    }
}