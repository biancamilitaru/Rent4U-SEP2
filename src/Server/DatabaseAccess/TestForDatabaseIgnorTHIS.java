package Server.DatabaseAccess;

import Client.Model.Vehicle;
import Server.Model.Date;
import Server.Model.Status;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalField;


public class TestForDatabaseIgnorTHIS {
    public static void main(String[] args) throws SQLException {
        ManageVehicles manageVehicles = new Rent4UDAO();
        Vehicle vehicle = new Vehicle("A78", 7, "type", "make",
                "model", 2009, "automatic", "electric", 9, 100);
        //manageVehicles.addNewVehicle(vehicle);
        Date date1 = new Date(2021,7,25,12,30);
        Date date2 = new Date(2021,7,25,13,30);
        Status status = new Status(date1, date2, "In service");
        //manageVehicles.setStatus(vehicle, status);
        LocalDate startDate = LocalDate.of(2021,7,9);
        LocalTime startTime = LocalTime.of(20,30);
        LocalDateTime start = LocalDateTime.of(startDate, startTime);
        System.out.println(start);
        System.out.println(startDate);
        System.out.println(startTime);
    }
}
