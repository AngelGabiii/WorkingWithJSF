/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ang.pakage1;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author Angelis
 */

@ManagedBean
@SessionScoped
public class MemberController implements Serializable {

        
//        private  static SessionFactory factory;
//        Transaction tx ;  
//        Session s;
//        
//        
//        public void addMember(){
//            try{     
//                Configuration cfg = new Configuration();
//                 cfg.configure("hibernate.cfg.xml");
//                 SessionFactory sf = cfg.buildSessionFactory();
//                 s = sf.openSession();
//                 factory = sf; // For closing hibernate. N.B the position is important
//                 tx = s.beginTransaction();
//                 Member2 m = new Member2();
//                 m.setId(1);
//                 m.setName("Steve");
//                 s.save(m); 
//                    s.flush();
//                    tx.commit();
//                    }catch(HibernateException ex){
//                    if(tx !=null){
//                        tx.rollback();
//                        System.err.println(ex);
//                        }
//                        }finally{
//                           s.close();
//                            stop();
//                        }
//        
//        }
//        
// //------------------------------------------------------       
//    public void stop(){
//       factory.close();
//    } 
/////---------------------------------------------------------

//    public static void main (String[] arg){
//        MemberController go = new MemberController();
//        go.addMember();
//    }
    

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
  
  public void addMember(){
          Session session = sessionFactory.openSession();
      try{
          System.out.println("What is wrong");
        session.beginTransaction();
        Member2 m2 = new Member2();
        m2.setName("ftfu Happye");
        session.save(m2);
        session.flush();
       
        session.getTransaction().commit();
      }catch(Exception ex){
          if(session.getTransaction() !=null){
              session.getTransaction().rollback();
          }
      }finally{
           session.close();
          //sessionFactory.close();
      }
  }
  
  
  
    
    
}
