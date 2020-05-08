package id.d3ti.oopl.ketujuh.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.*;

public class DBBiodata {
Connection con;
Statement st;
ResultSet rs;
	public DBBiodata() {
		try 
		{
			/*Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)
			DriverManager.getConnection("jdbc:mysql://127.0.0.1/biodata?user=root&password=");**/
			String url ="jdbc:mysql://localhost:3306/biodata";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(url,user,pass);
            st = (Statement) con.createStatement();
            System.out.println("koneksi berhasil;");
				Class.forName("com.mysql.jdbc.Driver");
				 con =(Connection) DriverManager.getConnection(url,user,pass);
				 st = (Statement) con.createStatement();
				 System.out.println("koneksi berhasil;");
			}catch (SQLException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
				System.err.println("koneksi gagal" +e.getMessage());
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	public Vector data() {
		try {
			st = (Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery ("SELECT * FROM mahasiswa");
		} catch (SQLException e){
			e.printStackTrace();
		}
		Vector dBdata = new Vector(1);
		try {
			while(rs.next()) {
				Vector rows = new Vector();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				rows.add(rs.getString(5));
				rows.add(rs.getString(6));
				dBdata.addElement(rows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dBdata;
	}
	public void insertBiodata (String nim, String nama, String jk, String tmp_lahir, String tgl_lahir, String alamat)
	{
		try {
			st = (Statement) con.createStatement();
			st.executeUpdate("INSERT INTO mahasiswa VALUES"+"("
														   +"'"+nim+","
														   +"'"+nama+","
														   +"'"+jk+","
														   +"'"+tmp_lahir+","
														   +"'"+tgl_lahir+","
														   +"'"+alamat+"'"
														   +")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
