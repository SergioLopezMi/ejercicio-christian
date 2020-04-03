package com.sergio.coches.service;

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

	private static final String COCHE_NO_ENCONTRADO = "El coche no existe";
	private static final String COCHE_DUPLICADO = "El coche ya existe";

	@Override
	public Coche crearCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn)
			throws ObjetoDuplicadoException {
		Coche cocheCreado = null;

		if (matriculaIn != null && marcaIn != null && modeloIn != null && anyoFabricacionIn != null) {

			Coche coche = new Coche();
			coche.setMatricula(matriculaIn);
			coche.setMarca(marcaIn);
			coche.setModelo(modeloIn);
			coche.setAnyoFabricacion(anyoFabricacionIn);

			if (cocheRepository.find(coche) == null) {
				cocheCreado = cocheRepository.add(coche);
			} else {
				throw new ObjetoDuplicadoException(COCHE_DUPLICADO);
			}
		}

		return cocheCreado;

	}

	@Override
	public Coche buscarCoche(Coche cocheIn) throws ObjetoNoEncontradoException {
		Coche coche = null;

		if (cocheIn != null) {

			coche = cocheRepository.find(cocheIn);

			if (coche == null) {
				throw new ObjetoNoEncontradoException(COCHE_NO_ENCONTRADO);
			}

		}

		return coche;
	}

	@Override
	public boolean eliminarCoche(Coche cocheIn) throws ObjetoNoEncontradoException {
		boolean eliminado = false;

		if (cocheIn != null) {
			if (cocheRepository.find(cocheIn) != null) {
				eliminado = cocheRepository.delete(cocheIn);
			} else {
				throw new ObjetoNoEncontradoException(COCHE_NO_ENCONTRADO);
			}
		}

		return eliminado;
	}

	@Override
	public boolean modificarCoche(Coche cocheModificar, String matriculaIn, String marcaIn, String modeloIn,
			Integer anyoFabricacionIn) throws ObjetoNoEncontradoException {

		boolean modificado = false;

		if (cocheRepository.find(cocheModificar) != null) {

			if (matriculaIn != null) {
				Coche cocheNuevo = new Coche();
				if (marcaIn != null) {
					cocheNuevo.setMarca(marcaIn);
				}

				if (modeloIn != null) {
					cocheNuevo.setModelo(modeloIn);
				}

				if (anyoFabricacionIn != null) {
					cocheNuevo.setAnyoFabricacion(anyoFabricacionIn);
				}

				modificado = cocheRepository.modify(cocheModificar, cocheNuevo);
			}
		} else {
			throw new ObjetoNoEncontradoException(COCHE_NO_ENCONTRADO);

		}
		return modificado;
	}
}
