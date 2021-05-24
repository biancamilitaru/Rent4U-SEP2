package Client.Model;

public class Date
{
  private int year;
  private int month;
  private int day;
  private int hour;
  private int minute;

  public Date(int year,int month,int day,int hour,int minute)
  {
    if(year<2021)
      throw new IllegalArgumentException();
    else
      this.year=year;
    if(month<1 || month>12)
      throw new IllegalArgumentException();
    else
      this.month=month;
    if(daysInMonth()<day ||day<1)
      throw new IllegalArgumentException();
    else
      this.day=day;
    if(hour>23 ||hour<0)
      throw new IllegalArgumentException();
    else
      this.hour=hour;
    if(minute>59 || minute<0)
      throw new IllegalArgumentException();
    else
      this.minute=minute;
  }

  public void setYear(int year)
  {
    if(year<2021)
      throw new IllegalArgumentException();
    else
      this.year=year;
  }

  public void setMonth(int month)
  {
    if(month<1 || month>12)
      throw new IllegalArgumentException();
    else
      this.month=month;
  }


  public void setDay(int day)
  {
    if(daysInMonth()<day ||day<1)
      throw new IllegalArgumentException();
    else
      this.day=day;
  }

  public void setHour(int hour)
  {
    if(hour>23 ||hour<0)
      throw new IllegalArgumentException();
    else
      this.hour=hour;
  }

  public void setMinute(int minute)
  {
    if(minute>59 || minute<0)
      throw new IllegalArgumentException();
    else
      this.minute=minute;
  }

  public int getYear()
  {
    return year;
  }

  public int getMonth()
  {
    return month;
  }

  public int getDay()
  {
    return day;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }

  private boolean isLeapYear()
  {
    if ((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0 )
    {
      return true;
    }

    else
    {
      return false;
    }
  }

  private int daysInMonth()
  {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12)
    {
      return 31;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else if (month == 2 && isLeapYear())
    {
      return 28;
    }
    else if (month == 2 && !(isLeapYear()))
    {
      return 29;
    }
    else
    {
      return -1;
    }
  }

  public String toString()
  {
    return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":00";
  }
}
