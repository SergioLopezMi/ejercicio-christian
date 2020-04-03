package com.sergio.coches.service;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sergio.coches.configuration.JavaConfig;
import com.sergio.coches.domain.Coche;
import com.sergio.coches.exception.ObjetoDuplicadoException;
import com.sergio.coches.exception.ObjetoNoEncontradoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JavaConfig.class })
public class CocheServiceImplTest {

	@Autowired
	private CocheServiceImpl service;

	@Test
	public void crearCocheTest() throws ObjetoDuplicadoException {

		Coche cochePrueba = cochePrueba();
		String matricula = cochePrueba.getMatricula();

		Coche cocheCreado = service.crearCoche(matricula, "Renault", "Megane", 2018);

		Assert.assertEquals(cochePrueba, cocheCreado);
	}

	@Test(expected = ObjetoDuplicadoException.class)
	public void crearCocheFailTest() throws ObjetoDuplicadoException {

		service.crearCoche("2345FFF", "Ford", "Fiesta", 2019);

		service.crearCoche("2345FFF", "Ford", "Fiesta", 2019);
	}

	@Test
	public void buscarCocheTest() throws ObjetoNoEncontradoException, ObjetoDuplicadoException {
		Coche cocheEnviado = cochePrueba();
		Coche cocheRecivido = null;
		String matricula = cocheEnviado.getMatricula();

		service.crearCoche(matricula, "Renault", "Megane", 2018);

		cocheRecivido = service.buscarCoche(cocheEnviado);

		Assert.assertEquals(cocheEnviado, cocheRecivido);
	}

	@Test(expected = ObjetoNoEncontradoException.class)
	public void buscarCocheFailTest() throws ObjetoNoEncontradoException {
		Coche cochePrueba = cochePrueba();

		service.buscarCoche(cochePrueba);
	}

	@Test
	public void eliminarCocheTest() throws ObjetoDuplicadoException, ObjetoNoEncontradoException {
		boolean eliminado;
		Coche cochePrueba = cochePrueba();

		service.crearCoche(cochePrueba.getMatricula(), cochePrueba.getMarca(), cochePrueba.getModelo(),
				cochePrueba.getAnyoFabricacion());

		eliminado = service.eliminarCoche(cochePrueba);

		Assert.assertEquals(true, eliminado);
	}

	@Test(expected = ObjetoNoEncontradoException.class)
	public void eliminarCocheFailTest() throws ObjetoNoEncontradoException {
		Coche cochePrueba = cochePrueba();

		service.eliminarCoche(cochePrueba);
	}

	@Test
	public void modificarCochePrueba() throws ObjetoNoEncontradoException, ObjetoDuplicadoException {
		Coche cochePrueba = cochePrueba();

		String matricula = "2178PRU";
		String marca = cochePrueba.getMarca();
		String modelo = cochePrueba.getModelo();
		Integer anyo = cochePrueba.getAnyoFabricacion();

		service.crearCoche(cochePrueba.getMatricula(), marca, modelo, anyo);
		service.modificarCoche(cochePrueba, matricula, marca, modelo, anyo);
	}

	@Test(expected = ObjetoNoEncontradoException.class)
	public void modificarCocheFailPrueba() throws ObjetoNoEncontradoException {
		Coche cochePrueba = cochePrueba();

		String matricula = "2178PRU";
		String marca = cochePrueba.getMarca();
		String modelo = cochePrueba.getModelo();
		Integer anyo = cochePrueba.getAnyoFabricacion();

		service.modificarCoche(cochePrueba, matricula, marca, modelo, anyo);

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
