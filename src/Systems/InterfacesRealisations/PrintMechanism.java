package Systems.InterfacesRealisations;

import Systems.Interfaces.IPrintable;

import java.util.ArrayList;

public class PrintMechanism<T> implements IPrintable<T>
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
