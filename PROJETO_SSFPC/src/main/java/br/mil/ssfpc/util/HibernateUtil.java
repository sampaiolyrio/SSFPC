/*
 * Seção de Sistemas da Divisão de Tecnologia da Informação
 *         1ª Região Militar - Exército Brasileiro
 */
package br.mil.ssfpc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author sampaiolyrio
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    static{
        
        try {
            
            System.out.println("Tentando configurar a SessionFactory.");
            
            
            Configuration configuration = new Configuration().configure();
            
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                applySettings(configuration.getProperties()).buildServiceRegistry();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            System.out.println("Session factory criada corretamente");
        } catch (Exception ex) {
            System.out.println("Ocorreu um  erro ao iniciar a SessionFactory. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
