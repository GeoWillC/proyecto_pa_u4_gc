package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.funcional.Ciudadano;
import com.example.demo.funcional.Estudiante;
import com.example.demo.repository.IEstudianteRepo;

@Service	
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private ICiudadanoService iCiudadanoService;
	@Autowired
	private IEstudianteRepo iEstudianteRepo;
	
	@Override
	public void procesarEstudiantesParalelo() {
		//
		long inicio=System.currentTimeMillis();
		List<Ciudadano> listaTotal=this.iCiudadanoService.consultarTodos();
		List<Estudiante> estudiantesConvertidos=listaTotal.parallelStream().map((ciudadano)->this.iCiudadanoService.convertir(ciudadano)).collect(Collectors.toList());
		estudiantesConvertidos.forEach(estudiante->this.iEstudianteRepo.insertar(estudiante));
		long fin=System.currentTimeMillis();
		System.out.println("Tiempo en milisegundos: "+(fin-inicio));
	}

}
