package com.sergio.coches.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.coches.domain.Coche;
import com.sergio.coches.exception.ObjetoNoEncontradoException;
import com.sergio.coches.repository.CocheRepository;

@Service("cocheService")
public class CocheServiceImpl implements CocheService {

	@Autowired
	private CocheRepository cocheRepository;
	private static final Logger LOGGER = Logger.getLogger(CocheServiceImpl.class.getName());

	@Override
	public boolean crearCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn) {
		boolean cocheCreado = false;
		if (matriculaIn != null && marcaIn != null && modeloIn != null && anyoFabricacionIn != null) {

			try {

				Coche coche = new Coche();
				coche.setMatricula(matriculaIn);
				coche.setMarca(marcaIn);
				coche.setMatricula(matriculaIn);
				coche.setAnyoFabricacion(anyoFabricacionIn);

				existeCoche(coche);

				cocheRepository.add(coche);
				cocheCreado = true;
				LOGGER.info("Coche añadido");

			} catch (ObjetoNoEncontradoException noEncontradoEx) {
				LOGGER.warning(noEncontradoEx.getLocalizedMessage());
			}

		} else {

			LOGGER.warning("Faltan datos del coche");
		}

		return cocheCreado;

	}

	@Override
	public Coche buscarCoche(Coche cocheIn) {
		Coche coche = null;
		if (cocheIn != null) {
			try {
				coche = existeCoche(cocheIn);

				String msg = coche.toString();
				LOGGER.info(msg);

			} catch (ObjetoNoEncontradoException noEncontradoEx) {
				LOGGER.info(noEncontradoEx.getLocalizedMessage());
			}
		} else {
			LOGGER.warning("Matricula no especificada");
		}

		return coche;
	}

	@Override
	public boolean eliminarCoche(Coche cocheIn) {
		boolean eliminado = false;
		if (cocheIn != null) {
			try {
				existeCoche(cocheIn);

				cocheRepository.delete(cocheIn);
				eliminado = true;
				LOGGER.info("Coche eliminado correctamente");

			} catch (ObjetoNoEncontradoException noEncontradoEx) {
				LOGGER.info(noEncontradoEx.getLocalizedMessage());
			}
		} else {
			LOGGER.warning("Matricula no especificada");
		}
		return eliminado;
	}

	@Override
	public boolean modificarCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn) {
		boolean modificado = false;

		if (matriculaIn != null) {
			try {
				Coche coche = new Coche();
				if (marcaIn != null)
					coche.setMarca(marcaIn);

				if (modeloIn != null)
					coche.setModelo(modeloIn);

				if (anyoFabricacionIn != null)
					coche.setAnyoFabricacion(anyoFabricacionIn);

				existeCoche(coche);
				cocheRepository.modify(coche);
				modificado = true;
				LOGGER.info("Coche modificado correctamente");

			} catch (ObjetoNoEncontradoException noEncontradoEx) {
				LOGGER.info(noEncontradoEx.getLocalizedMessage());
			}

		} else {
			LOGGER.warning("Matricula no especificada");
		}
		return modificado;
	}

	/*
	 * Excepciones
	 */

	private Coche existeCoche(Coche cocheIn) throws ObjetoNoEncontradoException {
		if (cocheRepository.find(cocheIn) == null) {
			throw new ObjetoNoEncontradoException("El coche no existe");
		} else {
			return cocheRepository.find(cocheIn);
		}
	}

}
