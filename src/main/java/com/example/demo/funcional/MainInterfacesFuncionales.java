package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	// Buena practica de impresiones
	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	// static final con mayuscula
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.Supplier
		LOG.info("1.Supplier");
		// Clases
		IPersonaSupplier<String> supp1ier1 = new PersonaSupplierImpl();
		LOG.info("Supplier Clase:" + supp1ier1.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "Willian 2";
		LOG.info("Supplier Clase:" + supplier2.getNombre());

		// ->new Integer() deprecated , existe una mejor forma
		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Clase:" + supplier3.getNombre());

		// Cuando solo hay una linea de codigo el return esta
		// Implicito
		// Cuando hay mas expresiones debe declararse el return
		IPersonaSupplier<Persona> supplier4 = () -> {
			Persona per = new Persona();
			per.setApellido("Conlago");
			per.setNombre("George");
			return per;
		};
		LOG.info("Supplier Clase:" + supplier4.getNombre());
		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier Clase:" + supplier5.getNombre());

		// 2.Consumer recibe un argumento, lo procesa y no retorna nada
		LOG.info("2.Consumer");
		// Clase
		IPersonaConsumer<String, Integer> consumer1 = new PersonaConsumerImpl();
		consumer1.accept("Procesa este dato", Integer.valueOf(10));

		IPersonaConsumer<String, Integer> consumer2 = (cadena, numero) -> {
			LOG.info("mesaje a: " + cadena);
			LOG.info("mesaje b: " + cadena);
			LOG.info("mesaje c: " + numero);
		};
		consumer2.accept("procesa este dato 2", Integer.valueOf(15));
		IPersonaConsumer<Integer, Integer> consumer3 = (valor1, valor2) -> {
			Integer valor3 = valor1 + valor2;
			LOG.info("Valor 3= " + valor3);
		};
		consumer3.accept(Integer.valueOf(5), Integer.valueOf(10));
		// 3.Predicate
		LOG.info("3.Predicate");
		// Lambdas
		IPersonaPredicate<String> predicate1 = (cadena) -> cadena.contains("Z");
		LOG.info("Predicate : " + predicate1.evaluar("Willian"));

		IPersonaPredicate<Integer> predicate2 = (numero) -> {
			if (numero.intValue() > 10) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate : " + predicate2.evaluar(Integer.valueOf(11)));
		// 4.Function
		// R: retorno
		// T recibe
		LOG.info("4.Function");
		IPersonaFunction<String, Integer> function1 = (numero) -> "Valor a transformar: " + numero.toString();
		LOG.info("Function : " + function1.aplicar(Integer.valueOf(11)));
	
		IPersonaFunction<Ciudadano, Persona> function2= per-> {
			Ciudadano ciu=new Ciudadano();
			ciu.setNombreCompleto(per.getNombre()+" "+per.getApellido() );
			ciu.setCiudad("Quito");
			return ciu;
		};
		Persona per=new Persona();
		per.setApellido("Conlago");
		per.setNombre("Willian");
		Ciudadano convertido=function2.aplicar(per);
		LOG.info("Ciudadano : " + convertido);
		// 5.Unary Operator
		//Lambdas
		IPersonaUnaryOperator<String> unaryOperator1= cadena -> {
			String cadenaFinal=cadena.concat("-sufijo");
			return cadenaFinal;
		};
		LOG.info("Cadenas : " + unaryOperator1.aplicar("Prefijo"));
				
	}
	
}