package Database;
import Systems.Interfaces.DatabaseOperation;
import java.util.ArrayList;

public class Database<T>
{
    private ArrayList<T> data = new ArrayList<>();

    public Database() {}

    public Database(ArrayList<T> data)
    {
        this.data = data;
    }

    public ArrayList<T> getData()
    {
        return data;
    }

    public void insertInformation(T object)
    {
        DatabaseOperation addInformation = () -> {
            data.add(object);
        };
        addInformation.performOperation();
    }
}
