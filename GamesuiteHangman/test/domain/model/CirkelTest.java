package domain.model;

import static org.junit.Assert.*;

import domain.exceptions.*;
import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	private Punt middelPunt;
	private int radius;
	private Cirkel cirkel;
	
	@Before
	public void setUp() {
		middelPunt = new Punt (200, 200);
		radius = 20;
		cirkel = new Cirkel(middelPunt, radius);
	}
	
	@Test
	public void Cirkel_moet_cirkel_aanmaken_met_gegeven_middelpunt_en_radius() {
		Cirkel cirkel = new Cirkel(middelPunt, radius);
		assertEquals(middelPunt, cirkel.getMiddelPunt());
		assertEquals(radius, cirkel.getRadius());
	}
	
	@Test (expected = DomainException.class)
	public void Cirkel_moet_exception_gooien_als_middelpunt_null() {
		new Cirkel(null, radius);
	}
	
	@Test (expected = DomainException.class)
	public void Cirkel_moet_exception_gooien_als_radius_gelijk_aan_0() {
		new Cirkel(middelPunt, 0);
	}
	
	@Test (expected = DomainException.class)
	public void Cirkel_moet_exception_gooien_als_radius_negatief() {
		new Cirkel(middelPunt, -1);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_middelpunt_radius_gelijk_zijn() {
		Cirkel zelfdeCirkel = new Cirkel(middelPunt, radius);
		assertTrue(cirkel.equals(zelfdeCirkel));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_middelpunt_verschilt() {
		Punt andereMiddelPunt = new Punt(100, 100);
		Cirkel verschillendeCirkel = new Cirkel(andereMiddelPunt, radius);
		assertFalse(cirkel.equals(verschillendeCirkel));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_radius_verschilt(){
		Cirkel verschillendeCirkel = new Cirkel(middelPunt, radius + 10);
		assertFalse(cirkel.equals(verschillendeCirkel));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(cirkel.equals(null));
	}
}
