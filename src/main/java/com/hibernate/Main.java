package com.hibernate;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("sdsds");


            Product product = new Product("safsdgdgsdgs", BigDecimal.valueOf(2.22), "Olanda");
            Customers customer = new Customers("vlad", "mihalea", Gender.M, 34567);
            session.beginTransaction();
            session.save(customer);
            session.save(product);
            System.out.println(session.get(Product.class, 1));




            //HQL

            List<Product> listOfProducts = session.createQuery("from Product").list();

            //System.out.println(listOfProducts);
//            listOfProducts.forEach(product1-> System.out.println(product1.getCoffeeOrigin()));

//            InstructorDetail instructorDetail= new InstructorDetail("sfajsfasfkg");
//            Instructor instructor=new Instructor("nameer","email@email.com",instructorDetail);
//            InstructorDetail instructorDetail2= new InstructorDetail("213123sfajsfasfkg");
//            Instructor instructor2=new Instructor("namee213r","ema123il@email.com",instructorDetail2);
//            session.save(instructorDetail);
//            session.save(instructor);
//            session.save(instructorDetail2);
//            session.save(instructor2);
            User user1=new User("mark");
            User user2=new User("alloy");
            session.save(user1);
            session.save(user2);

            Set<ChatMessage> messages= new HashSet<ChatMessage>();
            Chatroom chatroom= new Chatroom("discutii",messages);
            session.save(chatroom);
            for(int i=0;i<10;i++){
                ChatMessage chatmessage= new ChatMessage("content"+i,user1,user2,i,chatroom);
                session.save(chatmessage);
                chatroom.getMessages().add(chatmessage);
            }
            session.save(chatroom);


            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
