package scp.java9.HibernateCaching.SecondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

public class TestSecondLevelCache {

	public static void main(String[] args) {
		Laptop l1= new Laptop(10, "Dell", 50000);
		Laptop l2= new Laptop(11, "Dell", 50000);
		Laptop l3= new Laptop(12, "Dell", 50000);
		Configuration cfg = new Configuration();
		SessionFactory sf= cfg.configure().buildSessionFactory();
		Session session1 =sf.openSession();
		Transaction tr1 = session1.beginTransaction();
		session1.save(l1);
		session1.save(l2);
		session1.save(l3);
		session1.flush();
		tr1.commit();
		session1.close();
		Session session2 = sf.openSession();
		Laptop l4=session2.get(Laptop.class, 10);
		System.out.println(l4);
		Laptop db2 = session2.get(Laptop.class, 10);
		System.out.println(db2);
		Statistics stats = sf.getStatistics();
		stats.setStatisticsEnabled(true);
		long fetchcount =stats.getEntityFetchCount();
		System.out.println(fetchcount);
	}

}
