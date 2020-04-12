package data;
import java.sql.*;

import javax.swing.JOptionPane;

import business.CustomerInfo;
public class DBCustomer {
    protected Connection conn=null;
    protected ResultSet rs=null;
    protected Statement stm=null;
    public DBCustomer() throws SQLException,ClassNotFoundException{
      this.connect();
    }
      
    protected void connect() throws SQLException,ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
      String url ="jdbc:oracle:thin:@CALVIN.HUMBER.CA:1521:GROK";
      String username = "N01349068";
      String password = "oracle";
      conn = DriverManager.getConnection(url,username,password);
      String sql = "Select * From hotel_customer";
      stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs = stm.executeQuery(sql);
    }
    public void disconnect() throws SQLException{
      if (!rs.isClosed()) {
        rs.close();
        conn.close();
      }
    }
    
//    public void refreshCustomer() throws SQLException{
//      String sql = "Select * From hotel_customer";
//      stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//      rs = stm.executeQuery(sql);
//      rs.first();
//    }
      
      //insert into table
    public void insertCustomer(CustomerInfo customerss) throws SQLException{
    	int count=0;
    	stm = conn.createStatement();
        String querymain = "select MAX(customer_id) as customer_id from hotel_customer";
        
        rs = stm.executeQuery(querymain);
        while(rs.next()) {
        	int ss = rs.getInt("customer_id");
        	ss = ss+1;
    	try {
    		String insertQuery = "insert into hotel_customer"
                    + "(customer_id,first_name,last_name,phone_num,address,city,province,code,country)"
                    + " values("
                    + ss
                    + ",'" + customerss.getfirstName() + "'"
                    + ",'" + customerss.getlastName() + "'"
                    + ",'" + customerss.getPhoneNumber() + "'"
                    + ",'" + customerss.getAddress() + "'"
                    + ",'" + customerss.getCity() + "'"
                    + ",'" + customerss.getProvince() + "'"
                    + ",'" + customerss.getZip() + "'"
                    + ",'" + customerss.getCountry() + "'"
                    + " )";
            PreparedStatement statement = conn.prepareStatement(insertQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Customer info saved");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() +ex.getCause() + "\n" + "InsertQuery  booking Failed");
        }
    	
        }
		//return count;
    }
    
    
    //search customer
    public ResultSet SeachCustomer(String targetName) throws Exception{
		
		try {
			stm = conn.createStatement();
            String query = "select * from hotel_customer where last_name='"+targetName+"'";
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
	}
    
    //get all customers
    public ResultSet getAllCustomer(){
		
		try {
			stm = conn.createStatement();
            String query = "select * from hotel_customer";
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
	}
    
    //delete user
    public ResultSet deleteCustomer(String targetName) throws Exception{
		
		try {
			stm = conn.createStatement();
            String query = "delete from hotel_customer where last_name='"+targetName+"'";
            rs = stm.executeQuery(query);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
	}
    
    /*****************booking **********************/
    
    
    //getroom types
    public ResultSet getAllRoomTypes() {
    	try {
			stm = conn.createStatement();
            String query = "select * from hotel_room_types";
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning DB Operation");
        }
		return rs;
    }
    
    
}
