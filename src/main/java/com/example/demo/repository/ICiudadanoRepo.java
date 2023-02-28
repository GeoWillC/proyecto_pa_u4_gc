package com.example.demo.repository;

import java.util.List;

import com.example.demo.funcional.Ciudadano;

public interface ICiudadanoRepo {
	
	public void insertar(Ciudadano ciudadano);
	public List<Ciudadano> buscar();
}
