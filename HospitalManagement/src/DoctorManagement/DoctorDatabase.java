package DoctorManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DoctorDatabase {
	public static void doctor() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Doctor doctor = new Doctor();
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms", "root", "sakshi@2004");
		while (true) {
			System.out.println("What would you like to do Today ?");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Update");
			System.out.println("4. Search");
			System.out.println("5. View");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:

				System.out.println("\nEnter the product details: ");

				System.out.println("Enter the Doctor ID: ");
				doctor.id = scanner.nextInt();

				System.out.println("\nEnter the Doctor name: ");
				doctor.name = scanner.next();

				System.out.println("Enter the doctor qualification: ");
				doctor.department = scanner.next();

				System.out.println("\nEnter thedoctor opdtime : ");
				doctor.opdtime = scanner.next();

				String query = "SELECT * FROM hms.doctor;";

				String insertQuery = "INSERT INTO doctor (ID, Name, department, OPDTime) VALUES (" + doctor.id + ", '"
						+ doctor.name + "','" + doctor.department + "','" + doctor.opdtime + "')";

				Statement statement = connection.createStatement();

				statement.execute(insertQuery);

				System.out.println("Record inserted successfully.");

				break;
			case 2:
				System.out.print("Enter ID to delete: ");
				doctor.id = scanner.nextInt();

				String deleteQuery = "DELETE FROM doctor WHERE id = " + doctor.id;
				Statement statement1 = connection.createStatement();

				statement1.execute(deleteQuery);

				System.out.println("Record deleted successfully.");
				break;
			case 3:
				System.out.print("Enter ID to update: ");
				doctor.id = scanner.nextInt();

				System.out.print("Enter new name: ");
				String newName = scanner.next();

				System.out.print("Enter new department: ");
				String newdepartment= scanner.next();

				System.out.print("Enter new OPDTime: ");
				String newOPDTime = scanner.next();

				String updateQuery = "UPDATE doctor SET Name = '" + newName + "', department = '" + newdepartment
						+ "',OPDTime='" + newOPDTime + "' WHERE ID = " +doctor.id;

				Statement statement2 = connection.createStatement();

				statement2.execute(updateQuery);

				System.out.println("Record updated successfully.");
				break;
			case 4:
				System.out.print("Enter ID to search: ");
				doctor.id = scanner.nextInt();
				String searchQuery = "SELECT * FROM doctor WHERE id = " + doctor.id;
				Statement statement3 = connection.createStatement();

				statement3.execute(searchQuery);
				ResultSet rs = statement3.executeQuery(searchQuery);
				if (rs.next()) {
					System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("Name") + ", department: "
							+ rs.getString("Department") + ", OPDTime: " + rs.getString("OPDTime"));
				} else {
					System.out.println("Record not found.");
				}
				break;
			case 5:
				 String viewAllQuery = "SELECT * FROM doctor";
                 Statement statement5 = connection.createStatement();

 				statement5.execute(viewAllQuery);
 				
                 ResultSet rsAll = statement5.executeQuery(viewAllQuery);
                 while (rsAll.next()) {
                	 System.out.println("ID: " + rsAll.getInt("id") + ", Name: " + rsAll.getString("Name") + ", department: "
 							+ rsAll.getString("Department") + ", OPDTime: " + rsAll.getString("OPDTime"));
                 }
				break;
			case 6:
				System.out.println("Exiting...");

				scanner.close();
				return;
				
			default:
				System.out.println("Invalid choice. Please try again.");

			}

		}

	}


}
