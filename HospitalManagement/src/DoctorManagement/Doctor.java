package DoctorManagement;

public class Doctor {
	int id;
	String name;
	String qualification;
	String specialization;
	String opdtime;
	String department;

	public void printPatient() {
		
		System.out.println("Doctor ID: " + id);
		System.out.println("Doctor Name: " + name);
		System.out.println("Doctor Qualification: " + qualification);
		System.out.println("Doctor Specialization: " +specialization);
		System.out.println("Doctor OPD Time: " + opdtime);
		System.out.println("Doctor department: " + department);

	}



}
