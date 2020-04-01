package com.sergio.coches.service;

import com.sergio.coches.domain.Coche;

public interface CocheService {

	public boolean crearCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn);

	public Coche buscarCoche(Coche cocheIn);

	public boolean eliminarCoche(Coche cocheIn);

	public boolean modificarCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn);
}
