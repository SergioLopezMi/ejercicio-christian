package com.sergio.coches.service;

import com.sergio.coches.domain.Coche;
import com.sergio.coches.exception.ObjetoDuplicadoException;
import com.sergio.coches.exception.ObjetoNoEncontradoException;

public interface CocheService {

	public Coche crearCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn)
			throws ObjetoDuplicadoException;

	public Coche buscarCoche(Coche cocheIn) throws ObjetoNoEncontradoException;

	public boolean eliminarCoche(Coche cocheIn) throws ObjetoNoEncontradoException;

	public boolean modificarCoche(Coche cocheModificar, String matriculaIn, String marcaIn, String modeloIn,
			Integer anyoFabricacionIn) throws ObjetoNoEncontradoException;
}
