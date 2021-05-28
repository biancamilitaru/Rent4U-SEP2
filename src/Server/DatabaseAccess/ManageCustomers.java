package Server.DatabaseAccess;

import Client.Model.Customer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageCustomers
{
    void addCustomer(Customer customer) throws RemoteException, SQLException;
    ArrayList<Customer> viewAllCustomers() throws RemoteException, SQLException;
    void editCustomerInfo(Customer customer,Customer newCustomer) throws RemoteException, SQLException;
    void deleteCustomer(Customer customer) throws RemoteException, SQLException;
    void createPersonalAccount(Customer customer) throws RemoteException, SQLException;
    Customer checkForPassword(String emailAddress, String password) throws RemoteException, SQLException;
    void editPersonalInfo(Customer customer,Customer newCustomer)throws RemoteException, SQLException;
}
