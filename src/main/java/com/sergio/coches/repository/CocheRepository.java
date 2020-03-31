package com.sergio.coches.repository;

import com.sergio.coches.domain.Coche;

public interface CocheRepository {

	public void add(Coche coche);

	public Coche find(String matriculaIn);

	public void delete(String matriculaIn);

	public void modify(String matriculaIn);
}
