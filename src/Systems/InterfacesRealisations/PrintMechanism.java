package Systems.InterfacesRealisations;

import Systems.Interfaces.PrintSystem;

import java.util.ArrayList;

public class PrintMechanism<T> implements PrintSystem<T>
{
    @Override
    public void printInfo(ArrayList<T> data)
    {
        System.out.println("Вывод информации: ");
        for (T item : data)
        {
            System.out.println(item);
        }
    }
}
