//package com.rentCar.rentCar.utils;
//
//import com.rentCar.rentCar.model.*;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class SessionManager extends AbstractSessionManager {
//    private static final SessionManager SESSION_MANAGER = new SessionManager();
//
//    @Override
//    protected void setAnnotatedClasses(Configuration configuration) {
//        configuration.addAnnotatedClass(Branch.class);
//        configuration.addAnnotatedClass(Car.class);
//        configuration.addAnnotatedClass(Customer.class);
//        configuration.addAnnotatedClass(Employee.class);
//        configuration.addAnnotatedClass(Loan.class);
//        configuration.addAnnotatedClass(Refund.class);
//        configuration.addAnnotatedClass(Rental.class);
//        configuration.addAnnotatedClass(Reservation.class);
//
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return SESSION_MANAGER.getSessionFactory("test");
//    }
//
//    public static void shutDown() {
//        SESSION_MANAGER.shutdownSessionManager();
//    }
//
//}
//
