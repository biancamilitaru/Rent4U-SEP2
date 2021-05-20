package Server.DatabaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Rent4UDAO
{
    //We are using singleton for this class because we want to have only one instance in our program
    private static Rent4UDAO instance;
    public static synchronized Rent4UDAO getInstance() throws SQLException
    {
        if(instance == null)
            instance = new Rent4UDAO();
        return instance;
    }

    private Rent4UDAO() throws SQLException
    {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=rent4u","postgres","maria5561");
    }
}
