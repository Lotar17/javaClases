import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;


public class ProductDAO {
	
	public LinkedList getAll() {
		Connection conn = null;
		LinkedList<Product> productos = new LinkedList();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root" , "java2022");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT pro.id, pro.name, pro.price FROM product pro");
			
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				productos.add(p);
			}
			if (rs != null) {rs.close();}
			if (stmt!=null) {stmt.close();}
			conn.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " +ex.getMessage());
			System.out.println("SQL State: " +ex.getSQLState());
			System.out.println("SQL Vendor Error: " +ex.getErrorCode());
		}
		return productos;
		
	}
	
	public Product getOne(int id) {
		
		Connection conn = null;
		Product p = new Product();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root" , "java2022");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setDescription(rs.getString("description"));
			p.setPrice(rs.getDouble("price"));
			p.setStock(rs.getInt("stock"));
			if (rs.getInt("shippingIncluded") == 1) {
				p.setShippingIncluded(true);
			} else {
				p.setShippingIncluded(false);
			}
			if (rs!= null) {rs.close();}
			if (stmt!=null) {stmt.close();}
			conn.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " +ex.getMessage());
			System.out.println("SQL State: " +ex.getSQLState());
			System.out.println("SQL Vendor Error: " +ex.getErrorCode());
		}
		return p;			
	}
	
	public void cargarProduct(String name, String description, double price, int stock, int shippingIncluded) {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root" , "java2022");
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO `javamarket`.`product`(`name`, `description`, `price`, `stock`, `shippingIncluded`) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setString(2, description);
			stmt.setDouble(3,price);
			stmt.setInt(4, stock);
			stmt.setInt(5, shippingIncluded);
			stmt.executeUpdate();
			if (stmt!=null) {stmt.close();}
			conn.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " +ex.getMessage());
			System.out.println("SQL State: " +ex.getSQLState());
			System.out.println("SQL Vendor Error: " +ex.getErrorCode());
		}
	}
	
	public void deleteOne(int id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root" , "java2022");
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM `javamarket`.`product` WHERE (`id` = ?)");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			if (stmt!=null) {stmt.close();}
			conn.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " +ex.getMessage());
			System.out.println("SQL State: " +ex.getSQLState());
			System.out.println("SQL Vendor Error: " +ex.getErrorCode());
		}
		
	}
	
	public void changeOne(String name, String description, double price, int stock, int shippingIncluded, int id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket", "root" , "java2022");
			PreparedStatement stmt = conn.prepareStatement("UPDATE `javamarket`.`product` SET `name` = ?, `description` = ?, `price` = ?, `stock` = ?, `shippingIncluded` = ? WHERE (`id` = ?)");
			stmt.setString(1, name);
			stmt.setString(2, description);
			stmt.setDouble(3,price);
			stmt.setInt(4, stock);
			stmt.setInt(5, shippingIncluded);
			stmt.setInt(6, id);
			stmt.executeUpdate();
			if (stmt!=null) {stmt.close();}
			conn.close();
			
		} catch (SQLException ex) {
			System.out.println("SQL Exception: " +ex.getMessage());
			System.out.println("SQL State: " +ex.getSQLState());
			System.out.println("SQL Vendor Error: " +ex.getErrorCode());
		}
		
		
	}
	
	
	
	
	
	
}
