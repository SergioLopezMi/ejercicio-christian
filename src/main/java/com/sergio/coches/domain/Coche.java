package com.sergio.coches.domain;

public class Coche {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int anyoFabricacion;
	
	public void setMatricula(String matriculaIn) {
		matricula = matriculaIn;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMarca(String marcaIn) {
		marca = marcaIn;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setModelo(String modeloIn) {
		modelo = modeloIn;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setAnyoFabricacion(int anyo) {
		anyoFabricacion = anyo;
	}
	
	public int getAnyoFabricacion() {
		return anyoFabricacion;
	}
	
	public String toString() {
		return "El " + marca + " " + modelo +" con matrícula " + matricula + ", se contruyó el año: " + anyoFabricacion; 
	}
}
