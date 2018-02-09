/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ang.pakage1;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Angelis
 */
@Entity
@Table (name="Products")
@ManagedBean (name="p")
@SessionScoped
public class Product  implements Serializable{

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;
    
    public Product(){
    }

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    
    //===================================================================================
    
 
    
     /** A  method notification that a product is inserted*/ 
    public String add(){
        System.out.println("Product inserted");
        System.out.println(name +" " + quantity +" " + price + " ");
        System.out.println("Why do I get null?");
        // make your database insersion here
        
        if( quantity > 50 ){
            return "Fail";
        }
        defaultTemplate();
        return "Sucess";
    }
    
    public void defaultTemplate(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
      try{
            session.beginTransaction();

//            Product product = new Product();
//            product.setName(name);
//            product.setQuantity(quantity);
//            product.setPrice(price);
           // Product product = new Product();
            this.setName(name);
            this.setQuantity(quantity);
            this.setPrice(price);
            session.save(this);
            //session.saveOrUpdate(this);

            session.flush();
            session.getTransaction().commit();
      }catch(HibernateException ex){
          System.err.println(ex);
          if(session.getTransaction() !=null ){
              session.getTransaction().rollback();
          }
      }
       session.close();
       //sessionFactory.close();
    } 
    
    
}
