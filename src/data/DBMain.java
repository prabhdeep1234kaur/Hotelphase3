package data;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import business.CustomerInfo;
import business.DBUserData;
public class DBMain {
	protected Connection conn=null;
	protected ResultSet rs=null;
	protected Statement stm=null;
	
	public DBMain() throws SQLException,ClassNotFoundException{
		this.connect();
	}
	
	protected void connect() throws SQLException,ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url ="jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
		String username = "N01349068";
		String password = "oracle";
		conn = DriverManager.getConnection(url,username,password);
		String sql = "Select * From hotel_users";
		stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(sql);
	}
	
	public void disconnect() throws SQLException{
		if (!rs.isClosed()) {
			rs.close();
			conn.close();
		}
	}
	
	
	public ResultSet getLoginDetains(int userType,String username, String password){
		
		try {
			stm = conn.createStatement();
            String query = "select * from hotel_users where username = '"+username+"' and password = '"+password+"' and user_type="+userType;
            
            rs = stm.executeQuery(query);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
	}
	
	
	//admin show users
	public ResultSet getAllUsers(){
		
		try {
			stm = conn.createStatement();
            String query = "select * from hotel_users where user_type = 2 order by user_id";
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
	}
	
	
	//add new user

	public int addUser(DBUserData userss) throws SQLException {
		int count = 0;
		//get value
		stm = conn.createStatement();
        String querymain = "select MAX(user_id) as user_id from hotel_users";
        
        rs = stm.executeQuery(querymain);
		
    	while(rs.next()) {
    		int ss = rs.getInt("user_id");
    		String query = "Insert into hotel_users values (?,?, ?, ?)"; 
    		PreparedStatement preparedStmt = conn.prepareStatement(query);

    	     preparedStmt.setInt(1,ss+1);
    	     preparedStmt.setInt(2,2);
    	     preparedStmt.setString(3, userss.getUserName());
    	     preparedStmt.setString(4, userss.getUserPassword());
    	     preparedStmt.execute();
    	     this.refresh();
    	}
	    return count;
	}
	
	
	//update user
	public void updateUser(String userName, int user_id) throws Exception{
		try {
			 String query = "update hotel_users set username='"+userName+"' and user_id="+user_id;
		     PreparedStatement preparedStmt = conn.prepareStatement(query);
		     preparedStmt.execute();
		     this.refresh();
		     JOptionPane.showMessageDialog(null, "User Updated Successfully ");
		} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
	}
	
	//search users
	public ResultSet SeachUser(String userName) throws Exception{
		
		try {
			stm = conn.createStatement();
            String query = "select * from hotel_users where username = '"+userName+"'";
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
	}
	
	
	//delete user
	public void deleteUser(String userName, int user_id) throws Exception{
		try {
			 String query = "delete from hotel_users where username='"+userName+"' and user_id="+user_id;
		     PreparedStatement preparedStmt = conn.prepareStatement(query);
		     preparedStmt.execute();
		     this.refresh();
		     JOptionPane.showMessageDialog(null, "User Deleted Successfully ");
		} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
	}
	
	
	public void refresh() throws SQLException{
		String sql = "Select * From hotel_users";
		stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = stm.executeQuery(sql);
		rs.first();
	}
	
	//manage rooms : add room type
	public int addRoomType(String newRoomType) throws SQLException {
		int count = 0;
		//get value
		stm = conn.createStatement();
        String querymain = "select MAX(ROOM_TYPE_ID) as ROOM_TYPE_ID from hotel_room_types";
        
        rs = stm.executeQuery(querymain);
		
    	while(rs.next()) {
    		int ss = rs.getInt("ROOM_TYPE_ID");
    		String query = "Insert into hotel_room_types values (?,?)"; 
    		PreparedStatement preparedStmt = conn.prepareStatement(query);

    	     preparedStmt.setInt(1,ss+1);
    	     preparedStmt.setString(2,newRoomType);
    	     preparedStmt.execute();
    	     this.refresh();
    	}
	    return count;
		
	}
	
	//get all room types
	public ResultSet getAllRoomType(){
		
		try {
			stm = conn.createStatement();
            String query = "select * from hotel_room_types order by room_type_id asc";
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
	}
	
	//delete the room
	public void deleteRoomType(String rtype) throws Exception{
		
		//check if the type exists or not
		stm = conn.createStatement();
		String query_chk = "select * from hotel_room_types where room_type = '"+rtype+"'";
		rs = stm.executeQuery(query_chk);
		
		if(!rs.next()) {
			JOptionPane.showMessageDialog(null, "Room Type not found ");
		}
		try {
			 String query = "delete from hotel_room_types where room_type='"+rtype+"' and room_type_id ="+rs.getInt("room_type_id");
		     PreparedStatement preparedStmt = conn.prepareStatement(query);
		     preparedStmt.execute();
		     this.refresh();
		     JOptionPane.showMessageDialog(null, "Type Deleted Successfully ");
		} catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
       }
	}
	
}
