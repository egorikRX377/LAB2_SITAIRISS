import Database.Database;
import Pojo.Doctor;
import Pojo.Patient;
import Systems.InterfacesRealisations.HospitalSystem;

import java.util.ArrayList;

public class Hospital
{
    public static void main(String[] args)
    {
        Patient patient1 = new Patient("Егор", "+375298859876");
        Patient patient2 = new Patient("Дима", "+375293749801");

        Doctor doctor1 = new Doctor("Алескандр Игоревич", "+37599999999", "Травматолог");
        Doctor doctor2 = new Doctor("Павел Анатольевич", "+37599999999", "Терапевт");

        ArrayList<Patient> patients = new ArrayList<Patient>();
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();

        patients.add(patient1);
        patients.add(patient2);

        doctors.add(doctor1);
        doctors.add(doctor2);

        Database<Patient> patientDatabase = new Database<Patient>(patients);
        Database<Doctor> doctorDatabase = new Database<Doctor>(doctors);

        HospitalSystem system = HospitalSystem.getInstance();

        patientDatabase.getData().getFirst().registration(system);

        patientDatabase.getData().getFirst().signIn(system);

        patientDatabase.getData().getFirst().checkAllDoctors(system, doctorDatabase);

        patientDatabase.getData().getFirst().logOut();

        patientDatabase.getData().getFirst().checkAllDoctors(system, doctorDatabase);
    }
}