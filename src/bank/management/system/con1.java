package bank.management.system;

import java.sql.Connection;              //in future if ever gets error {225} it's a connection error remember
import java.sql.DriverManager;           // to fix it u have to remove these 3 imports here and write
import java.sql.Statement;               // import java.sql.*;

public class con {
    Connection  connect; // can be any name, this Connection helps us connect our code with SQL database
    Statement statement; // can be any name, this Statement helps us by providing us ways to manipulate the data update it sends and receives it
    public con(){
        try{                                                // here we will put the username and password we used while making the database (first time in SQL workBench)
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root","asjv34GLA*" );
            statement = connect.createStatement();  // this helps us by providing a way to send and receive SQL queries like INSERT, SELECT
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
