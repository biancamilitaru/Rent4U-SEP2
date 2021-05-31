package Server.DatabaseAccess;

import Client.Model.Employee;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ManageEmployees
{
  void createEmployee(Employee employee) throws RemoteException, SQLException;
  void editEmployeeInfo(Employee employee,Employee newEmployee) throws RemoteException, SQLException;
  ArrayList<Employee> getEmployees() throws RemoteException, SQLException;
}
