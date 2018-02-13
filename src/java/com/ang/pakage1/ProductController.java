/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ang.pakage1;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Angelis
 */

@ManagedBean(name="productController")
@ApplicationScoped
public class ProductController  extends Product implements Serializable {
    Product p = new Product();
    
    Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
            
            
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void defaultTemplate(){
        Session session = sessionFactory.openSession();
      try{
            session.beginTransaction();

            
            
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
    
    
    /** A  method notification that a product is inserted*/ 
    public String add(){
       
        ProductController pc = new ProductController();
        System.out.println("Product inserted");
        System.out.println(p.getName() +" " + p.getQuantity() +" " + p.getPrice() + " ");
        System.out.println("Why do I get null?");
        // make your database insersion here
        
        if( p.getQuantity() > 60 ){
            return "Fail";
        }
        return "Sucess";
    }
    
    public static void main (String[] args){
    ProductController pc2 = new ProductController ();
    
        //System.out.println(pc2.p.getName());
        pc2.add();
    }
    
//===============================================================================
    double one ;
    double two ;
    double answer;
   
     public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(double two) {
        this.two = two;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }
    
   
    public  double multiply(){
        double answer = (one * two);
        return answer ;
    }
    
    public void clearFields(){
//        one = 0;
//        two = 0;
//        answer = 0;
    }

}
