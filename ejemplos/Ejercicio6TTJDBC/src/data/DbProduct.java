package data;

import java.sql.*;
import java.time.*;
import java.util.LinkedList;

import entities.Product;

public class DbProduct {
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String host="127.0.0.1";
	private String port="3306";
	private String user="java";
	private String password="himitsu";
	private String db="javaMarket";
	//private String options="?useLegacyDatetimeCode=false&serverTimezone=Asia/Hong_Kong";
	private String options="";
	private Connection conn=null;
	
	public DbProduct() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
	
		try {
			if (this.conn==null || this.conn.isClosed()) {
				this.conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+options, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.conn;
	}
	
	private void releaseConnection() {
		try {
			if(this.conn!=null && !this.conn.isClosed()) {
				this.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public LinkedList<Product> list(){
		
		
		ResultSet rs=null;
		Statement stmt=null;
		Connection conn=null;
		
		try {
			LinkedList<Product> prods = new LinkedList<Product>();
			
			conn = this.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product");
			
			if(rs!=null) {
				while(rs.next()) {
					Product p = new Product();
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setDescription(rs.getString("description"));
					p.setPrice(rs.getDouble("price"));
					p.setStock(rs.getInt("stock"));
					p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
					p.setDisabledOn(rs.getObject("disabledOn",LocalDateTime.class));
					p.setDisabledDate(rs.getObject("disabledDate",LocalDate.class));
					p.setDisabledTime(rs.getObject("disabledTime",LocalTime.class));
					p.setDisabledOnZoned(rs.getObject("disabledOnZoned",ZonedDateTime.class));
					prods.add(p);
				}
			}
			return prods;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				this.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Product search(Product searchPrd) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Connection conn=null;
		
		try {
			Product prod = null;
			
			conn = this.getConnection();
			
			stmt = conn.prepareStatement("select * from product where id = ?;");
			stmt.setInt(1, searchPrd.getId());
			
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setDescription(rs.getString("description"));
				prod.setPrice(rs.getDouble("price"));
				prod.setStock(rs.getInt("stock"));
				prod.setShippingIncluded(rs.getBoolean("shippingIncluded"));
				prod.setDisabledOn(rs.getObject("disabledOn",LocalDateTime.class));
				prod.setDisabledDate(rs.getObject("disabledDate",LocalDate.class));
				prod.setDisabledTime(rs.getObject("disabledTime",LocalTime.class));
				prod.setDisabledOnZoned(rs.getObject("disabledOnZoned",ZonedDateTime.class));
			}
			
			return prod;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				this.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void newProduct(Product newPrd) {
		ResultSet keyRS=null;
		PreparedStatement stmt=null;
		Connection conn=null;
		
		try {			
			conn = this.getConnection();
			
			stmt = conn.prepareStatement(
					"insert into product(name, description, price, stock, shippingIncluded, disabledOn, disabledDate, disabledTime, disabledOnZoned)  "+
					"values (?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, newPrd.getName());
			stmt.setString(2, newPrd.getDescription());
			stmt.setDouble(3, newPrd.getPrice());
			stmt.setInt(4, newPrd.getStock());
			stmt.setBoolean(5, newPrd.isShippingIncluded());
			stmt.setObject(6, newPrd.getDisabledOn());
			stmt.setObject(7, newPrd.getDisabledDate());
			stmt.setObject(8, newPrd.getDisabledTime());
			stmt.setObject(9, newPrd.getDisabledOnZoned());
			
			stmt.executeUpdate();
			
			keyRS= stmt.getGeneratedKeys();
			
			if(keyRS != null && keyRS.next()) {
				newPrd.setId(keyRS.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(keyRS!=null)keyRS.close();
				if(stmt!=null)stmt.close();
				this.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		
	}

	public void delete(Product delPrd) {
		PreparedStatement stmt=null;
		Connection conn=null;
		
		try {
			
			conn = this.getConnection();
			
			stmt = conn.prepareStatement(
					"delete from product where id = ?");
			
			stmt.setInt(1, delPrd.getId());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				this.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Product updPrd) {
		PreparedStatement stmt=null;
		Connection conn=null;
		
		try {
			
			conn = this.getConnection();
			
			stmt = conn.prepareStatement(
					"update product "+
					"set name = ?, description = ?, price = ?, stock = ?, shippingIncluded=? "+
					", disabledOn=?, disabledDate=?, disabledTime=?, disabledOnZoned=? "+
					"where id = ?");

			stmt.setString(1, updPrd.getName());
			stmt.setString(2, updPrd.getDescription());
			stmt.setDouble(3, updPrd.getPrice());
			stmt.setInt(4, updPrd.getStock());
			stmt.setBoolean(5, updPrd.isShippingIncluded());
			stmt.setObject(6, updPrd.getDisabledOn());
			stmt.setObject(7, updPrd.getDisabledDate());
			stmt.setObject(8, updPrd.getDisabledTime());
			stmt.setObject(9, updPrd.getDisabledOnZoned());
			stmt.setInt(10, updPrd.getId());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null)stmt.close();
				this.releaseConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
