package com.mini.ejb;

import com.mini.entity.Sembako;

import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class SembakoEJB implements Serializable {
	static final long serialVersionUID = 14231299l;
	static EntityManagerFactory factory = null;
	static EntityManager entityManager = null;

	Sembako sembako;
	List<Sembako> sembakoList;
	int i = 0;
	int harga, stok;
	String jenis;
	
	Sembako updateSembako;

	@PostConstruct
	public void init() {
		try {
			sembako = new Sembako();
			factory = Persistence.createEntityManagerFactory("TrainingUnit");
			entityManager = factory.createEntityManager();
			readNews();
		} catch (Exception e) {

		}
	}

	public void insertNews(String jenisSembako, int hargaSembako, int stokSembako) {
//		EntityTransaction transaction = entityManager.getTransaction();
//		try {
//			transaction.begin();
//			sembako.setJenis(jenis);
//			sembako.setHarga(harga);
//			sembako.setStok(stok);
//			entityManager.persist(sembako);
//			transaction.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			if (transaction.isActive()) {
//				System.out.println("running .... persistCourse transaction.isActive()");
//				transaction.rollback();
//			}
//		}
		try
	    {
	      // create our mysql database connection
		  sembakoList = new ArrayList<Sembako>();
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/magang";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	   // create a Statement from the connection
	      Statement statement = conn.createStatement();

	      // the mysql insert statement
	      String query = "insert into sembako (jenis, harga, stok) values (?, ?, ?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, jenisSembako);
	      preparedStmt.setInt(2, hargaSembako);
	      preparedStmt.setInt(3, stokSembako);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      statement.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	}

	public void delNews(int sembakoId) {
//		try {
//			entityManager.getTransaction().begin();
//
//			// do something ...
//
//			// add this if you fetched the Book entity in this session
//			entityManager.flush();
//			entityManager.clear();
//
//			Query query = entityManager.createQuery("DELETE Sembako s WHERE id = :sembako_id", Sembako.class);
//			query.setParameter("sembako_id", sembakoId);
//			query.executeUpdate();
//
//			entityManager.getTransaction().commit();
//			init();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		 try
		    {
		      // create the mysql database connection
			  String myDriver = "com.mysql.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost/magang";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      
		      // create the mysql delete statement.
		      String query = "delete from sembako where id = ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setInt(1, sembakoId);

		      // execute the preparedstatement
		      preparedStmt.execute();
		      
		      conn.close();
		      init();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
	}

	public void updateNews(int idSembako, String jenisSembako, int hargaSembako, int stokSembako) {
		
//		try {
//			Sembako newsUpdate = new Sembako();
//			newsUpdate =  entityManager.find(Sembako.class, id);
//
//			entityManager.getTransaction().begin();
//
//			newsUpdate.setJenis(jenisSembako);
//			newsUpdate.setHarga(hargaSembako);
//			newsUpdate.setStok(stokSembako);
//
//			entityManager.getTransaction().commit();
//			init();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		try
	    {
	      // create our mysql database connection
		  sembakoList = new ArrayList<Sembako>();
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/magang";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	   // create a Statement from the connection
	      Statement statement = conn.createStatement();

	      // the mysql insert statement
	      String query = " update sembako set jenis = ?, harga = ?, stok = ? where id = ?";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, jenisSembako);
	      preparedStmt.setInt(2, hargaSembako);
	      preparedStmt.setInt(3, stokSembako);
	      preparedStmt.setInt(4, idSembako);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      statement.close();
	      init();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	}

	public void readNews() {
//		try {
//			sembakoList = new ArrayList<Sembako>();
//			Query query = entityManager.createQuery("SELECT s FROM Sembako s", Sembako.class);
//			sembakoList = query.getResultList();
//			System.out.println("Iki news ----------------------------- : " + sembakoList);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("Bosokkkk " + e);
//		}
		try
	    {
	      // create our mysql database connection
		  sembakoList = new ArrayList<Sembako>();
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/magang";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM sembako";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	    	sembako = new Sembako();
	        int id = rs.getInt("id");
	        sembako.setId(id);
	        String jenis = rs.getString("jenis");
	        sembako.setJenis(jenis);
	        int harga = rs.getInt("harga");
	        sembako.setHarga(harga);
	        int stok = rs.getInt("stok");
	        sembako.setStok(stok);
	        // print the results
	        System.out.format("%s, %s, %s, %s\n", id, jenis, harga, stok);
	        sembakoList.add(sembako);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	}
	
	public void bantuUpdate(int idSembako) {

//		TypedQuery<Sembako> query = entityManager.createQuery("SELECT s FROM Sembako s where id = :sembakoku",Sembako.class);
//		query.setParameter("sembakoku", id);
//		updateSembako = new Sembako();
//		updateSembako = query.getSingleResult();
		try
	    {
	      // create our mysql database connection
		  sembakoList = new ArrayList<Sembako>();
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://localhost/magang";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM sembako where id = " + idSembako;

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	    	updateSembako = new Sembako();
	        int id = rs.getInt("id");
	        updateSembako.setId(id);
	        String jenis = rs.getString("jenis");
	        updateSembako.setJenis(jenis);
	        int harga = rs.getInt("harga");
	        updateSembako.setHarga(harga);
	        int stok = rs.getInt("stok");
	        updateSembako.setStok(stok);
	        // print the results
	        System.out.format("%s, %s, %s, %s\n", id, jenis, harga, stok);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		init();
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlg4').show();");

	}

	public Sembako getSembako() {
		return sembako;
	}

	public void setSembako(Sembako sembako) {
		this.sembako = sembako;
	}

	public List<Sembako> getSembakoList() {
		return sembakoList;
	}

	public void setSembakoList(List<Sembako> sembakoList) {
		this.sembakoList = sembakoList;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public Sembako getUpdateSembako() {
		return updateSembako;
	}

	public void setUpdateSembako(Sembako updateSembako) {
		this.updateSembako = updateSembako;
	}
}
