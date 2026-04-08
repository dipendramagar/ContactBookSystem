package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Contact;


public class DBConnection {
		private static String DRIVER="com.mysql.cj.jdbc.Driver";
		private static String HOST="localhost";
		private static int PORT=3306;
		private static String USER="root";
		private static String PASS="DIPENDRA@dipen";
		private static String DB ="contactbook";
		private static String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DB;


//Search contact
	public Contact search(int cid) {//receive value 1
		Connection conn;
		String strSql ="SELECT * FROM contacts where cid=?";
		PreparedStatement pstat;
		ResultSet rs;//Receive result from mysql
		Contact contact=null;
		try {
			Class.forName(DRIVER); //Load driver
			conn = DriverManager.getConnection(URL, USER, PASS);
			pstat=conn.prepareStatement(strSql);
			pstat.setInt(1, cid);
			rs=pstat.executeQuery(); //run sql statement on mysql 
			
			while(rs.next()) {
				contact=new Contact();
				contact.setContactId(cid);
				contact.setName(rs.getString("name"));
				contact.setAddress(rs.getString("address"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
				
			}
			conn.close();
			System.out.println("Search Sucessfully");
		} catch (Exception e) {
			System.out.println("Invalid ID Entered");
			//Display error
		}
		return contact;
	}
	
	
//	SAVE contact
	public boolean save(Contact contact) {
		//Declare
		Connection conn;
		PreparedStatement pstat;
		String strSql="INSERT INTO contacts VALUES(?, ?, ?, ?, ?)";
		boolean result;
		try {
			//Initialize
			//Input, Process, Output
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			pstat = conn.prepareStatement(strSql);
			pstat.setInt(1, contact.getContactId());
			pstat.setString(2, contact.getName());
			pstat.setString(3, contact.getPhone());
			pstat.setString(4, contact.getEmail());
			pstat.setString(5, contact.getAddress());
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			System.out.println("Insert Record Successfully");
			result=true;
		} catch (Exception e) {
			System.out.println("Invalid missing data");
			result=false;
		}
		return result;
	}

	//Update contact
		public boolean update(Contact contact) {
		//Declare
		Connection conn;
		PreparedStatement pstat;
		String strSql = "UPDATE contacts SET name=?, phone=?, email=?, address=? WHERE cid=?";
		boolean result;
		try {
			//Initialize
			//Input, Process, Output
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			pstat = conn.prepareStatement(strSql);
			pstat.setString(1, contact.getName());
			pstat.setString(2, contact.getPhone());
			pstat.setString(3, contact.getEmail());
			pstat.setString(4, contact.getAddress());
			pstat.setInt(5, contact.getContactId());
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			System.out.println("Update Record Successfully");
			result=true;
		} catch (Exception e) {
			System.err.print("Error : "+e.getMessage());
			result=false;
		}
		return result;
	}


	
		//Delete contact
	public boolean Delete(int id) {
		//Declare
		Connection conn;
		PreparedStatement pstat;
		String strSql="DELETE FROM contacts WHERE cid=?";
		boolean result;
		try {
			//Initialize
			//Input, Process, Output
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			pstat = conn.prepareStatement(strSql);
			pstat.setInt(1, id);
			pstat.executeUpdate(); //Delete Record
			pstat.close();
			conn.close();
			System.out.println("Delete Record Successfully");
			result=true;
		} catch (Exception e) {
			System.err.print("Error : "+e.getMessage());
			result=false;
		}
		return result;
	}
	
	
     // all contacts
	public List<Contact> all() {
	    Connection conn;
	    String strSql = "SELECT * FROM contacts";
	    PreparedStatement pstat;
	    ResultSet rs;

	    List<Contact> contacts = new ArrayList<>(); // ✅ correct list

	    try {
	        Class.forName(DRIVER);
	        conn = DriverManager.getConnection(URL, USER, PASS);
	        pstat = conn.prepareStatement(strSql);
	        rs = pstat.executeQuery();

	        while (rs.next()) {
	            Contact contact = new Contact();
	            contact.setContactId(rs.getInt("cid"));
	            contact.setName(rs.getString("name"));
	            contact.setPhone(rs.getString("phone"));
	            contact.setEmail(rs.getString("email"));
	            contact.setAddress(rs.getString("address"));

	            contacts.add(contact); // ✅ correct
	        }

	        conn.close();
	        System.out.println("Data Loaded Successfully");

	    } catch (Exception e) {
	        System.out.println("Error : " + e.getMessage());
	    }

	    return contacts; // ✅ correct
	}

//register new account
	// REGISTER USER
	
	public static Connection getConnection() throws Exception {
	    Class.forName(DRIVER);
	    return DriverManager.getConnection(URL, USER, PASS);
	}


	public Contact search(String name) {
		return null;
	}

}