package com.angoor.securesociety.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.angoor.contacts.model.Address;
import com.angoor.contacts.model.AddressType;
import com.angoor.contacts.model.ContactAddress;
import com.angoor.contacts.model.Country;
import com.angoor.contacts.model.MaritalStatus;
import com.angoor.contacts.model.NamePrefix;
import com.angoor.contacts.model.NameSuffix;
import com.angoor.contacts.model.Person;
import com.angoor.securesociety.model.Dwelling;
import com.angoor.securesociety.model.DwellingType;

/**
 * @author Rakesh Kumar
 * @since Version - 1.0
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));

		registerAnnotatedClasses(sessionFactoryBean);

		return sessionFactoryBean;
	}

	/**
	 * To register annotated entity classes with the given Hibernate SessionFactory
	 * 
	 * @see Configuration#addAnnotatedClass(Class)
	 * @param sessionFactoryBean
	 */
	private void registerAnnotatedClasses(LocalSessionFactoryBean sessionFactoryBean) {
		sessionFactoryBean.setAnnotatedClasses(Address.class, AddressType.class, ContactAddress.class, Country.class,
				Dwelling.class, DwellingType.class, MaritalStatus.class, NamePrefix.class, NameSuffix.class,
				Person.class);
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
