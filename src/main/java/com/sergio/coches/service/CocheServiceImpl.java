package com.sergio.coches.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.coches.domain.Coche;
import com.sergio.coches.exception.ObjetoDuplicadoException;
import com.sergio.coches.exception.ObjetoNoEncontradoException;
import com.sergio.coches.repository.CocheRepository;

@Service("cocheService")
public class CocheServiceImpl implements CocheService {

	@Autowired
	private CocheRepository cocheRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(CocheServiceImpl.class.getName());

	@Override
	public void crearCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn) {
		try {
			if (matriculaIn != null && marcaIn != null && modeloIn != null && anyoFabricacionIn != null) {
				// Se comprueba si existe el coche
				cocheExistente(matriculaIn);

				Coche coche = new Coche();
				coche.setMatricula(matriculaIn);
				coche.setMarca(marcaIn);
				coche.setMatricula(matriculaIn);
				coche.setAnyoFabricacion(anyoFabricacionIn);

				cocheRepository.add(coche);

				LOGGER.info("Coche añadido");

			} else {
				LOGGER.warn("Faltan datos del coche");
			}

		} catch (ObjetoDuplicadoException duplicadoEx) {
			LOGGER.error(duplicadoEx.getLocalizedMessage());
		}
	}

	@Override
	public void buscarCoche(String matriculaIn) {
		if (matriculaIn != null) {
			try {
				encontrarCoche(matriculaIn);

				for (Coche coche : coches) {
					if (coche.getMatricula().equals(matriculaIn)) {
						String msg = coche.toString();
						LOGGER.info(msg);
					}
				}
			} catch (ObjetoNoEncontradoException noEncontradoEx) {
				LOGGER.error(noEncontradoEx.getLocalizedMessage());
			}
		} else {
			LOGGER.warn("Matricula no especificada");
		}

	}

	@Override
	public void eliminarCoche(String matriculaIn) {
		if (matriculaIn != null) {
			try {
				encontrarCoche(matriculaIn);

				for (Coche coche : coches) {
					if (coche.getMatricula().equals(matriculaIn)) {
						coches.remove(coche);
						LOGGER.info("Coche eliminado correctamente");
					}
				}
			} catch (ObjetoNoEncontradoException noEncontradoEx) {
				LOGGER.error(noEncontradoEx.getLocalizedMessage());
			}
		} else {
			LOGGER.warn("Matricula no especificada");
		}

	}

	@Override
	public void modificarCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn) {
		if (matriculaIn != null) {
			try {
				encontrarCoche(matriculaIn);

				for (Coche coche : coches) {
					if (coche.getMatricula().equals(matriculaIn)) {

						if (marcaIn != null)
							coche.setMarca(marcaIn);

						if (modeloIn != null)
							coche.setModelo(modeloIn);

						if (anyoFabricacionIn != null)
							coche.setAnyoFabricacion(anyoFabricacionIn);
					}
				}
			} catch (ObjetoNoEncontradoException noEncontradoEx) {
				LOGGER.error(noEncontradoEx.getLocalizedMessage());
			}

		} else {
			LOGGER.warn("Matricula no especificada");
		}

	}

}
