package com.example.demo.service;

import java.util.List;

import com.example.demo.funcional.Ciudadano;
import com.example.demo.funcional.Estudiante;

public interface ICiudadanoService {
	public Estudiante convertir(Ciudadano ciudadano);
	public List<Ciudadano> consultarTodos();
}
