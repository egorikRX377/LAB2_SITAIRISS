package Pojo;

import Pojo.Abstracts.Human;

public class Doctor extends Human
{
    private String speciality;

    public Doctor(String name, String phoneNumber, String speciality)
    {
        super(name, phoneNumber);
        this.speciality = speciality;
    }

    @Override
    public String toString()
    {
        return "ФИО: " + super.getName() + "; " + "Номер телефона: " + super.getPhoneNumber() + "; " + this.speciality + "; ";
    }
}
