package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	// Buena practica de impresiones
	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	// static final con mayuscula
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Java tiene sus propias librerias que ya tienen creadas sus interfaces funcionale por lo que
//		solo necesitamos implementar los lambdas
		//Stream collecion orientada a programacion funcional
		//Cuando un metodo recibe una interfaz funcional, ese metodo se denomina metodos Hight order 
		// 1.Java Supplier 
		LOG.info("1.Java Supplier ");
		//Permite usar una implementacion de supplier
		Stream<String> lista=Stream.generate(()-> "Willian").limit(10);
		lista.forEach((cadena)-> LOG.info("Cadena : "+cadena));
		
		// 2.Java Consumer 
		LOG.info("2.Java Consumer");
		List<Integer> listaNumero=Arrays.asList(1,2,3,4,5,6);
		listaNumero.forEach((numero)->LOG.info("Valor consumer: "+numero ));
		for(Integer val:listaNumero ) {
			LOG.info("Foreach valor: "+val);
		}
		// 3.Java Predicate
		LOG.info("3.Java Predicate");
		//Filter recibe una condiicion
		Stream <Integer> listaFiltrada=listaNumero.stream().filter((numero)->numero>=3);
		//foreach(CONSUMER)
		listaFiltrada.forEach(numero ->LOG.info("Valor predicate "+numero));
		
		// 4.Java Function
		LOG.info("4.Java Function");
		Stream<String> listaCadena=listaNumero.stream().map(numeroLista->{
			Integer valorFinal=numeroLista+1;
			String cadena="num: "+valorFinal.toString();
			return cadena;
		});
		listaCadena.forEach(cadena->LOG.info("Cadena function: "+cadena));	
		Stream<Integer> listaCadena2=listaNumero.stream().map(numeroLista->{
			Integer valorFinal=numeroLista+1;
			return valorFinal;
		});
		listaCadena2.forEach(numero->LOG.info("Integer function: "+numero));

	}
}
