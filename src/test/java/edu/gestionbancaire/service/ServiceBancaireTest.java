package edu.gestionbancaire.service;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.*;


import edu.gestionbancaire.domaine.CompteCourantSal;
import edu.gestionbancaire.domaine.Persphysique;
import edu.gestionbancaire.exceptions.AgioException;
import edu.gestionbancaire.exceptions.CinException;
import edu.gestionbancaire.exceptions.FraisOuvException;
import edu.gestionbancaire.exceptions.SitMatException;

public class ServiceBancaireTest {
	@Mock
	private static ServiceBancaireBeta service;
	private String test;
	@Mock
	static CompteCourantSal cpts;
	@BeforeClass
    public static void BeforeClass() throws CinException, FraisOuvException, SitMatException, AgioException
    {
		Persphysique pers = new Persphysique(2, "772953450", "diopsy@gmail.com", "4567", "Diop", "Sy", "1870198702386",
				3, "marie");
		 cpts = new CompteCourantSal("3", "Dakar Plateau", 200000, 180000, 2000, pers);
		service = Mockito.mock(ServiceBancaireBeta.class);
		Mockito.when(service.operationcli("1870198702386", "marie", 3, 2000)).thenReturn(cpts);
    }
	
	
	
	


	@Test
	public void test() throws CinException, FraisOuvException, AgioException, SitMatException {

		service.operationgrp("187019870238611", "A", 5000);
		Mockito.verify(service).operationgrp("187019870238611", "A", 5000);

	}

	@Test
	@DisplayName("Test for create customer")
	public void testcli() throws CinException, FraisOuvException, SitMatException, AgioException {
		
		Persphysique pers = new Persphysique(2, "772953450", "diopsy@gmail.com", "4567", "Diop", "Sy", "1870198702386",
				3, "marie");
	
		assertEquals(cpts, service.operationcli("1870198702386", "marie", 3, 2000));
		
	}
	
	

}
