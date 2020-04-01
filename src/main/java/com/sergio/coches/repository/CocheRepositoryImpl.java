package com.sergio.coches.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sergio.coches.domain.Coche;

@Repository("cocheRepository")
public class CocheRepositoryImpl implements CocheRepository {

	private List<Coche> coches;

	public CocheRepositoryImpl() {
		coches = new ArrayList<Coche>();
	}

	@Override
	public boolean add(Coche cocheIn) {
		boolean anyadido = false;

		if (cocheIn != null) {
			coches.add(cocheIn);
			anyadido = true;
		}

		return anyadido;
	}

	@Override
	public Coche find(Coche cocheIn) {
		Coche cocheEncontrado = null;

		if (cocheIn != null) {
			for (Coche coche : coches) {
				if (coche.getMatricula().equals(cocheIn.getMatricula())) {
					cocheEncontrado = coche;
					break;
				}
			}
		}
		return cocheEncontrado;
	}

	@Override
	public boolean delete(Coche cocheIn) {
		boolean eliminado = false;

		if (cocheIn != null) {
			for (Coche coche : coches) {
				if (coche.getMatricula().equals(cocheIn.getMatricula())) {
					coches.remove(coche);
					eliminado = true;
					break;
				}
			}
		}

		return eliminado;
	}

	@Override
	public boolean modify(Coche cocheIn) {
		boolean modificado = false;
		Integer contador = 0;
		if (cocheIn != null) {
			for (Coche coche : coches) {
				if (coche.getMatricula().equals(cocheIn.getMatricula())) {
					coches.add(contador, cocheIn);
					modificado = true;
					break;
				}
				contador++;
			}
		}
		return modificado;
	}
}
