package com.sergio.coches.repository;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sergio.coches.configuration.JavaConfig;
import com.sergio.coches.domain.Coche;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JavaConfig.class })
public class CocheRepositoryImplTest {

	@Autowired
	private CocheRepositoryImpl repository;

	@Test
	public void addPrueba() {
		Coche cochePrueba = cochePrueba();
		Coche cocheAnyadido;

		cocheAnyadido = repository.add(cochePrueba);

		Assert.assertEquals(cochePrueba, cocheAnyadido);
	}

	@Test
	public void addFailPrueba() {
		Coche cochePrueba = null;
		Coche cocheAnyadido;

		cocheAnyadido = repository.add(cochePrueba);

		Assert.assertNull(cocheAnyadido);
	}

	@Test
	public void findTest() {
		Coche cochePrueba = cochePrueba();
		Coche cocheEncontrado;

		repository.add(cochePrueba);

		cocheEncontrado = repository.find(cochePrueba);

		Assert.assertEquals(cochePrueba, cocheEncontrado);
	}

	@Test
	public void findFailTest() {
		Coche cochePrueba = cochePrueba();
		Coche cocheEncontrado = null;

		cocheEncontrado = repository.find(cochePrueba);

		Assert.assertNull(cocheEncontrado);
	}

	@Test
	public void deleteTest() {
		Coche cochePrueba = cochePrueba();
		boolean eliminado;

		repository.add(cochePrueba);
		eliminado = repository.delete(cochePrueba);

		Assert.assertTrue(eliminado);
	}

	@Test
	public void deleteFailTest() {
		Coche cochePrueba = cochePrueba();
		boolean eliminado;

		eliminado = repository.delete(cochePrueba);

		Assert.assertFalse(eliminado);
	}

	@Test
	public void modifyTest() {
		Coche cochePrueba = cochePrueba();
		Coche cocheModificado = new Coche();
		boolean modificado;

		cocheModificado.setMatricula("1234MOD");
		cocheModificado.setMarca(cochePrueba.getMarca());
		cocheModificado.setModelo(cochePrueba.getModelo());
		cocheModificado.setAnyoFabricacion(cochePrueba.getAnyoFabricacion());

		repository.add(cochePrueba);
		modificado = repository.modify(cochePrueba, cocheModificado);

		Assert.assertTrue(modificado);
	}

	@Test
	public void modifyFailTest() {
		Coche cochePrueba = cochePrueba();
		Coche cocheModificado = new Coche();
		boolean modificado;

		cocheModificado.setMatricula("1234MOD");
		cocheModificado.setMarca(cochePrueba.getMarca());
		cocheModificado.setModelo(cochePrueba.getModelo());
		cocheModificado.setAnyoFabricacion(cochePrueba.getAnyoFabricacion());

		modificado = repository.modify(cochePrueba, cocheModificado);

		Assert.assertFalse(modificado);
	}

	private Coche cochePrueba() {
		Random random = new Random();
		int numMatricula;

		do {
			numMatricula = random.nextInt();
		} while (numMatricula < 1000 && numMatricula > 9999);

		String matricula = numMatricula + "MAT";

		Coche cochePrueba = new Coche();
		cochePrueba.setMatricula(matricula);
		cochePrueba.setMarca("Renault");
		cochePrueba.setModelo("Megane");
		cochePrueba.setAnyoFabricacion(2018);

		return cochePrueba;
	}
}
