package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.funcional.Ciudadano;
import com.example.demo.funcional.Estudiante;
import com.example.demo.repository.ICiudadanoRepo;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepo iCiudadanoRepo;
	
	@Override
	public Estudiante convertir(Ciudadano ciudadano) {
		
		Estudiante convertido=new Estudiante();
		Integer edad=Period.between(ciudadano.getCiudadanoFechaNacimiento().toLocalDate(),LocalDate.now()).getYears();
		convertido.setEdad(edad);
		convertido.setNombreCompleto(ciudadano.getNombre()+" "+ciudadano.getApellido());
		return convertido;
	}

	@Override
	public List<Ciudadano> consultarTodos() {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepo.buscar();
	}
}
