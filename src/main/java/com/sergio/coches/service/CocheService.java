package com.sergio.coches.service;

public interface CocheService {

	public void crearCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn);

	public void buscarCoche(String matriculaIn);

	public void eliminarCoche(String matriculaIn);

	public void modificarCoche(String matriculaIn, String marcaIn, String modeloIn, Integer anyoFabricacionIn);
}
