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

		anyadido = coches.add(cocheIn);

		return anyadido;
	}

	@Override
	public Coche find(Coche cocheIn) {
		Coche cocheEncontrado = null;

		for (Coche coche : coches) {
			if (coche.equals(cocheIn)) {
				cocheEncontrado = coche;
				break;
			}
		}
		return cocheEncontrado;
	}

	@Override
	public boolean delete(Coche cocheIn) {
		boolean eliminado = false;

		for (Coche coche : coches) {
			if (coche.equals(cocheIn)) {
				eliminado = coches.remove(coche);
				break;
			}
		}

		return eliminado;
	}

	@Override
	public boolean modify(Coche cocheModificar, Coche cocheNuevo) {
		boolean modificado = false;

		int posCocheAModificar = coches.indexOf(cocheModificar);

		if (coches.set(posCocheAModificar, cocheNuevo) != null) {
			modificado = true;
		}
		return modificado;
	}
}
