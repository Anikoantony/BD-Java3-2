import java.sql.*;

public class Main {

    //отвечает за соедиенение с БД


    static Connection postgresConnection;

    public static void main(String[] args) {
   //     DBconnect dBconnect = new DBConnect();

        System.out.println("Стоп");

        try {
           if (!Class.forName("org.postgresql.Driver").equals(null))
           {System.out.println("driver ON");}
    /*

                CREATE TABLE IF NOT EXISTS public.students
            (
                studid integer NOT NULL DEFAULT nextval('id_auto'::regclass),
                studname character varying(255) COLLATE pg_catalog."default" NOT NULL,
                groupname character varying(255) COLLATE pg_catalog."default" NOT NULL,
                averegescore double precision NOT NULL,
                CONSTRAINT students_pkey PRIMARY KEY (studid)
            )

            TABLESPACE pg_default;

            ALTER TABLE IF EXISTS public.students
                OWNER to postgres;
     */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("нет драйвера");
        }


        try {
            //DriverManager - устанавливает связь с JDBC Driver

        //    postgresConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GB", "postgres", "123")


            postgresConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
            if (!postgresConnection.equals(null))
            {System.out.println("Connet ON - 1");}
            else {
                System.out.println("Connect OFF");
            };
            //Statement - позволяет выполнять SQL запросы
            Statement statement = postgresConnection.createStatement();
            ResultSet studentsResultSet = statement.executeQuery("select * from students");
            while (studentsResultSet.next())
            {
                System.out.print(studentsResultSet.getString(1));
                System.out.print(" ");
                System.out.print(studentsResultSet.getString("studname"));
                System.out.print(" \n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String str;
    }
}
