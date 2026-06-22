import DB.DbConfig;
import reservation.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConfig.loadDBDriver();
        Connection con = DbConfig.dbConnection();
        Scanner sc = new Scanner(System.in);
//
//        Reservation.getAllReservation();
        System.out.println("1. Create reservation");
        System.out.println("2. See all reservation");
        System.out.println("3. Update reservation");
        System.out.println("4. Delete reservation");
        System.out.println("0. Exit");

        System.out.print("Chose an option :");
        int option = sc.nextInt();
        switch (option){
            case 1:
                Reservation.createReservation(con,sc);
                break;
            case 2:
                Reservation.getAllReservation(con);
                break;
            case 3:
                Reservation.updateReservation(con,sc);
                break;
            case 4:
                Reservation.deleteReservation(con,sc);
                break;
            case 0:
                Reservation.exit();
                break;
            default:
                System.out.println("You choose wrong option");
                break;
        }
        con.close();
        sc.close();
    }
}
