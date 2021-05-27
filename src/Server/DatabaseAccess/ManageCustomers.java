package Server.DatabaseAccess;

import java.util.GregorianCalendar;

public interface ManageCustomers
{
  void createCustomerAccount(String firstName, String lastName, GregorianCalendar dateOfBirth, String email, String password,
      String phoneNumber, String drivingLicenseNumber, String cpr_number);
}
