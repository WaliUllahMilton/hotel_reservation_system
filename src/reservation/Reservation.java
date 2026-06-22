package reservation;

import DB.DbConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public  class Reservation {
    public static void createReservation(Connection con , Scanner sc){
        System.out.print("Guest name :");
        String guestName = sc.nextLine();
        System.out.print("Room number :");
        int roomNumber = sc.nextInt();
        System.out.print("Contact numbers :");
        sc.next();
        String contactNumbers = sc.nextLine();
        System.out.println();


        String query = "INSERT INTO reservations (guest_name, room_number, contact_numbers) VALUES ('" + guestName + "', " + roomNumber + ", '" + contactNumbers + "')";
        try{
            Statement st =con.createStatement();
            int rowsAffected =st.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Reservation create successfully");
            }
            st.close();
            DbConfig.dbConnection().close();
        } catch (SQLException e) {
            System.out.println("Reservation creation failed");
            System.out.println(e.getMessage());
        }

    }
    public static void  getAllReservation(Connection con){
        String query = "SELECT * FROM reservations";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                System.out.println("reservation_id : "+rs.getInt("reservation_id")+" guest_name : "+rs.getString("guest_name")+" room_number : " + rs.getInt("room_number")+" contact_numbers : "+rs.getString("contact_numbers")+" reservation date : " +rs.getString("reservation_date"));
            }
            con.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Retrieving data failed");
            System.out.println(e.getMessage());
        }
    }
    public static void updateReservation(Connection con,Scanner sc){
        System.out.print("Reservation Id :");
        int reservation_id = sc.nextInt();
        System.out.print("Guest name :");
        sc.nextLine();
        String guest_name = sc.nextLine();
        System.out.print("Room number :");
        int room_number = sc.nextInt();
        System.out.print("Contact numbers :");
        sc.nextLine();
        String contact_numbers = sc.nextLine();

        String query = "UPDATE reservations SET " +
                "guest_name = '" + guest_name + "', " +
                "room_number = " + room_number + ", " +
                "contact_numbers = '" + contact_numbers + "' " +
                "WHERE reservation_id = " + reservation_id;
        try {
            Statement st = con.createStatement();
            int rowsAffected =  st.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Data updated successfully");
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void deleteReservation(Connection con, Scanner sc){
        System.out.print("Enter Id :");
        int reservation_id = sc.nextInt();
        String query = "DELETE FROM reservations WHERE reservation_id =" + reservation_id;
        try {
            Statement st = con.createStatement();
            int rowsAffected = st.executeUpdate(query);
            if(rowsAffected >0){
                System.out.println("Reservation deleted");
            }
        } catch (SQLException e) {
            System.out.println("Failed to reservation delete");
            System.out.println(e.getMessage());
        }
    }
    public static void exit()  {
        System.out.print("System exiting");
        for (int i = 0; i<5; i++){
            System.out.print(".");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
