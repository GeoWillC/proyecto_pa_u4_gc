package com.example.demo.funcional;

@FunctionalInterface
//El unico requisito es que tenga un solo metodo,buena practica es tener la anotacion
public interface IPersona {
	public String comer();
}
