package model;

public class Contact {
	private int contactId;
	 private String name;
	    private String phone;
	    private String email;
	    private String address;
	    public Contact() {
		
			this.contactId = 0;
			this.name = "NA";
			this.phone = "NA";
			this.email = "NA";
			this.address = "NA";
		}
		public Contact(int contactId, String name, String phone, String email, String address) {
			super();
			this.contactId = contactId;
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.address = address;
		}
		public Contact(Contact c) {
			super();
			this.contactId = c.contactId;
			this.name = c.name;
			this.phone = c.phone;
			this.email = c.email;
			this.address = c.address;
		}
		public int getContactId() {
			return contactId;
		}
		public void setContactId(int contactId) {
			this.contactId = contactId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Contact [contactId=" + contactId + ", name=" + name + ", phone=" + phone + ", email=" + email
					+ ", address=" + address + "]";
		}


}
