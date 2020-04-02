package com.sergio.coches.repository;

import com.sergio.coches.domain.Coche;

public interface CocheRepository {

	public boolean add(Coche cocheIn);

	public Coche find(Coche cocheIn);

	public boolean delete(Coche cocheIn);

	public boolean modify(Coche cocheModificar, Coche cocheNuevo);
}
