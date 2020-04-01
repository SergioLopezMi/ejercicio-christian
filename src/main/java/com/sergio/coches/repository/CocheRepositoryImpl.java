package com.sergio.coches.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sergio.coches.domain.Coche;
import com.sergio.coches.exception.ObjetoDuplicadoException;
import com.sergio.coches.exception.ObjetoNoEncontradoException;

@Repository("cocheRepository")
public class CocheRepositoryImpl implements CocheRepository {

	private List<Coche> coches;

	public CocheRepositoryImpl() {
		coches = new ArrayList<Coche>();
	}

	@Override
	public void add(Coche coche) {
		if (coche != null) {
			coches.add(coche);
		}
	}

	@Override
	public Coche find(String matriculaIn) {
		Coche cocheEncontrado = new Coche();
		if (matriculaIn != null) {
			for (Coche coche : coches) {
				if (coche.getMatricula().equals(matriculaIn))
					cocheEncontrado = coche;
			}
		}
		return cocheEncontrado;
	}

	@Override
	public void delete(String matriculaIn) {
		if (matriculaIn != null) {
			for (Coche coche : coches) {
				if (coche.getMatricula().equals(matriculaIn)) {
					coches.remove(coche);
				}
			}
		}
	}

	@Override
	public void modify(String matriculaIn, Coche cocheIn) {
		if (matriculaIn != null) {
			for (Coche coche : coches) {
				if (coche.getMatricula().equals(matriculaIn)) {
					coche = cocheIn;
				}
			}
		}
	}

	/*
	 * Excepciones
	 */
	@Override
	public void cocheExistente(String matriculaIn) throws ObjetoDuplicadoException {
		for (Coche coche : coches) {
			if (coche.getMatricula().equals(matriculaIn)) {
				throw new ObjetoDuplicadoException("El coche ya existe");
			}
		}
	}

	@Override
	public void encontrarCoche(String matriculaIn) throws ObjetoNoEncontradoException {
		for (Coche coche : coches) {
			if (coche.getMatricula().equals(matriculaIn)) {
				throw new ObjetoNoEncontradoException("El coche no existe");
			}
		}
	}

}
