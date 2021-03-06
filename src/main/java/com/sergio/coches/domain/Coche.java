package com.sergio.coches.domain;

public class Coche {

	private String matricula;
	private String marca;
	private String modelo;
	private Integer anyoFabricacion;

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

	public void setAnyoFabricacion(Integer anyoFabricacionIn) {
		anyoFabricacion = anyoFabricacionIn;
	}

	public int getAnyoFabricacion() {
		return anyoFabricacion;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
