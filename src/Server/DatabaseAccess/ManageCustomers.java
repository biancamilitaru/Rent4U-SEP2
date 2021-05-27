package Server.DatabaseAccess;

import Client.Model.Customer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageCustomers
{
    void addCustomer(Customer customer) throws RemoteException, SQLException;
    ArrayList<Customer> viewAllCustomers() throws RemoteException, SQLException;
}
