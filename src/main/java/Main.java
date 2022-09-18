import java.sql.*;

public class Main {

    //отвечает за соедиенение с БД


    static Connection postgresConnection;

    public static void main(String[] args) {
   //     DBconnect dBconnect = new DBConnect();

        System.out.println("Стоп");
       /*
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        */
        try {
            //DriverManager - устанавливает связь с JDBC Driver
            //
        //    postgresConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GB", "postgres", "123")


            postgresConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GB", "postgres", "123");
            if (!postgresConnection.equals(null))
            {System.out.println("Connet ON - 1");}
            else {
                System.out.println("Connect OFF");
            };
            //Statement - позволяет выполнять SQL запросы
            Statement statement = postgresConnection.createStatement();
            ResultSet studentsResultSet = statement.executeQuery("select * from postgres.students");
            while (studentsResultSet.next())
            {
                System.out.print(studentsResultSet.getString(1));
                System.out.print(" ");
                System.out.print(studentsResultSet.getString("name"));
                System.out.print(" \n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String str;
    }
}
