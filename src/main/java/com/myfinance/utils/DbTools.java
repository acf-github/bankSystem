package com.myfinance.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbTools {

	public static class createDatabase {

		public static void main(String[] args) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("myFinance");
			factory.createEntityManager();
		}
	}

}
