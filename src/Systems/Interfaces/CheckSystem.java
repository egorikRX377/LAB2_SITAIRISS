package Systems.Interfaces;

import Database.Database;

public interface CheckSystem<T>
{
    void check(Database<T> database);
}

