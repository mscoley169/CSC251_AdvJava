package edu.nashcc.testdb;

import java.sql.*;

public class SimpleJDBC extends ConnectionJDBC {
    public static void main(String args[]) {
	if (args.length != 1) {
	    System.out.println("Usage: java SimpleJDBC custid");
	    System.exit(1);
	}
	
	String query = "Select Title, Type " +
	    "from Orders O, Titles T, Tapes V " +
	    "where V.TapeId=O.TapeId and T.TitleId=V.TitleId and " + 
	    "Status = 'O' and " + 
	    "O.CustomerID= " + args[0];

	SimpleJDBC J = new SimpleJDBC();
	Connection dbConnect = null;
	Statement dbStatement = null;
	ResultSet dbRS = null;
	try {
	    dbConnect = J.makeConnection(); //from ConnectionJDBC
	    dbStatement = dbConnect.createStatement();
	    dbRS = dbStatement.executeQuery(query);
	    J.presentResultSet(dbRS);
	} catch (SQLException sqlex) {
	    System.out.println(sqlex.getMessage());
	}   finally {
	    J.closeConnection(dbConnect,dbStatement); //from ConnectionJDBC
	}
    }

    public void presentResultSet(ResultSet rs) 
	throws SQLException {
	if (!rs.next()) System.out.println("No records for customer");
	else {
	    do {
		System.out.println(rs.getString("Title") + ": " + 
				   rs.getString("Type"));
	    } while (rs.next());
	}
    }
}
