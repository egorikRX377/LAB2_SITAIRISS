package Pojo;

import Pojo.Abstracts.Human;
import Systems.Interfaces.IPrintable;
import Systems.Interfaces.LogSystem;
import Systems.Interfaces.RegSystem;
import Systems.InterfacesRealisations.PrintMechanism;

import java.util.ArrayList;

public class Patient extends Human
{
    private Account account = null;
    private boolean isLogin = false;

    public Patient(String name, String phoneNumber)
    {
        super(name, phoneNumber);
    }

    public void registration(RegSystem regSystem)
    {
        account = regSystem.reg();
    }

    public void signIn(LogSystem logSystem)
    {
        isLogin = logSystem.login();
    }

    public void checkAllDoctors(ArrayList<Doctor> doctors)
    {
        IPrintable<Doctor> printMechanism = new PrintMechanism<>();
        if (isLogin)
        {
            printMechanism.printInfo(doctors);
        }
        else
        {
            System.out.println("Вам необходимо войти в аккаунт!");
        }
    }

    public void logOut()
    {
        if (isLogin)
        {
            account = null;
            isLogin = false;
            System.out.println("Вы вышли из аккаунта!");
        }
    }



    @Override
    public String toString()
    {
        return "ФИО: " + super.getName() + "; " + "Номер телефона: " + super.getPhoneNumber() + "; ";
    }
}
