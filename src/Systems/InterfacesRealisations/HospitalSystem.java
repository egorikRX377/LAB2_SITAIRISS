package Systems.InterfacesRealisations;

import Pojo.Doctor;
import Systems.Interfaces.CheckSystem;
import Systems.Interfaces.PrintSystem;
import Systems.Interfaces.RegSystem;
import Systems.Interfaces.LogSystem;

import java.util.Scanner;

import Pojo.Account;
import Database.Database;

public class HospitalSystem implements RegSystem, LogSystem, CheckSystem<Doctor>
{
    private Database<Account> database;

    private HospitalSystem() { database = new Database<Account>(); }

    private static HospitalSystem system;

    public static HospitalSystem getInstance()
    {
        if (system == null)
        {
            system = new HospitalSystem();
        }
        return system;
    }

    @Override
    public Account reg()
    {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------РЕГИСТРАЦИЯ--------------");
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        Account account = new Account(login, password);
        database.insertInformation(account);

        System.out.println("Регистрация прошла успешно!");
        return account;
    }

    @Override
    public boolean login()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------АВТОРИЗАЦИЯ--------------");
        while(true)
        {
            System.out.print("Введите логин: ");
            String login = scanner.nextLine();

            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            for (Account account : database.getData())
            {
                if (account.getLogin().equals(login) && account.getPassword().equals(password))
                {
                    System.out.println("Вы успешно вошли в аккаунт!");
                    return true;
                }
            }

            System.out.println("Неверный логин или пароль! Попробуйте ещё раз!");
        }
    }

    @Override
    public void check(Database<Doctor> database)
    {
        PrintSystem<Doctor> printMechanism = new PrintMechanism<>();
        printMechanism.printInfo(database.getData());
    }
}
