package com.example.demo.funcional;

@FunctionalInterface
//Supplier no recibe argumento pero retorna algun especifico
public interface IPersonaSupplier<T> {
	public T getNombre ();
}
