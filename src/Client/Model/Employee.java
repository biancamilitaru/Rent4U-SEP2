package Client.Model;

import java.util.Date;

  public class Employee
{
  private String cpr;
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private String phoneNumber;
  private String email;
  private int salary;
  private String position;

  public Employee(String cpr, String firstName, String lastName, Date dateOfBirth,String phoneNumber,
                  String email, int salary,String position){
    this.cpr = cpr;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.salary = salary;
    this.position = position;
  }

  public void setCpr(String cpr)
  {
    this.cpr = cpr;
  }

  public String getCpr()
  {
    return cpr;
  }

  public void setDateOfBirth(Date dateOfBirth)
  {
    this.dateOfBirth = dateOfBirth;
  }

  public Date getDateOfBirth()
  {
    return dateOfBirth;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getEmail()
  {
    return email;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPosition(String position)
  {
    this.position = position;
  }

  public String getPosition()
  {
    return position;
  }

  public void setSalary(int salary)
  {
    this.salary = salary;
  }

  public int getSalary()
  {
    return salary;
  }
}
