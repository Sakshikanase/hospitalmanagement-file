package PatientManagement;

public class Patient {
	String name;
	String address;
	int contactno;
	int age;
	String sex;
	String bloodgroup;
	String earlierdisease;
	int patientid;

	public void printPatient() {
		System.out.println("Patient Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Contact No. : " + contactno);
		System.out.println("Age : " + age);
		System.out.println("Sex: " + sex);
		System.out.println("Blood Group : " + bloodgroup);
		System.out.println("Any Major disease suffered earlier:  " + earlierdisease);
		System.out.println("Patient ID: " + patientid);

	}

}
