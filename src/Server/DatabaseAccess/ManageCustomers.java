package Server.DatabaseAccess;

import Client.Model.Customer;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface ManageCustomers
{
    void addCustomer(Customer customer) throws RemoteException, SQLException;
    ArrayList<Customer> viewAllCustomers() throws RemoteException, SQLException;
    void editCustomerInfo(String firstName, String lastName, GregorianCalendar dateOfBirth, String email, String password, String phoneNumber,
                          String drivingLicenseNumber, String cpr_number) throws RemoteException, SQLException;
}
