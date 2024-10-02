package Pojo;

import Database.Database;
import Pojo.Abstracts.Human;
import Systems.Interfaces.CheckSystem;
import Systems.Interfaces.LogSystem;
import Systems.Interfaces.RegSystem;

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

    public void signIn(LogSystem logSystem) { isLogin = logSystem.login(); isLogin = true;}

    public void checkAllDoctors(CheckSystem<Doctor> checkSystem, Database<Doctor> database)
    {
        if (isLogin)
        {
            checkSystem.check(database);
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
