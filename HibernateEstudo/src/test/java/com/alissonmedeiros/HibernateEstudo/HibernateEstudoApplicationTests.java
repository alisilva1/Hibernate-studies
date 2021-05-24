package com.alissonmedeiros.HibernateEstudo;

import model.Editora;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

@SpringBootTest
class HibernateEstudoApplicationTests {

	@Test
	void contextLoads() {
		EntityManagerFactory factory =
		Persistence.createEntityManagerFactory ("Editora");

		EntityManager manager = factory.createEntityManager();

		Editora novaEditora = new Editora();

		Scanner entrada = new Scanner( System.in);

		System.out.println (" Digite o nome da editora : ");
		novaEditora.setNome ( entrada.nextLine());

		System.out.println (" Digite o email da editora : ");
		novaEditora.setEmail ( entrada.nextLine());

		manager.persist(novaEditora);

		manager.getTransaction().begin();
		manager.getTransaction().commit();

		factory.close();
		}

}
