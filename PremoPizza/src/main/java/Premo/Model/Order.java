package Premo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    @Column(name = "zip")
    private String zip;
    
    @Column(name = "employeeid")
    private long employeeid;
    
    @Column(name = "phonenumber")
    private String phonenumber;
    
    @Column(name = "timestamp")
    private Date timestamp;
    
    @Column(name = "orderitems")
    private String orderitems;

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(String orderitems) {
		this.orderitems = orderitems;
	}
        

    
}
