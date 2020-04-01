package com.sergio.coches.repository;

import com.sergio.coches.domain.Coche;
import com.sergio.coches.exception.ObjetoDuplicadoException;
import com.sergio.coches.exception.ObjetoNoEncontradoException;

public interface CocheRepository {

	public void add(Coche coche);

	public Coche find(String matriculaIn);

	public void delete(String matriculaIn);

	public void modify(String matriculaIn, Coche coche);

	public void cocheExistente(String matriculaIn) throws ObjetoDuplicadoException;

	public void encontrarCoche(String matriculaIn) throws ObjetoNoEncontradoException;
}
