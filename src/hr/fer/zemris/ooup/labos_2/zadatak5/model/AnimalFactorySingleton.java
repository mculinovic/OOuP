package hr.fer.zemris.ooup.labos_2.zadatak5.model;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class AnimalFactorySingleton {
	
	private static AnimalFactorySingleton factory;
	
	private URLClassLoader newClassLoader;
	

	public static AnimalFactorySingleton getFactory() {
		if (factory == null) {
			factory = new AnimalFactorySingleton(); 
		}
		return factory;
	}
	
	private AnimalFactorySingleton() {
		newClassLoader = null;
		try {
			ClassLoader parent = AnimalFactory.class.getClassLoader();
			newClassLoader = new URLClassLoader(
					new URL[] {
							new File("/home/mculinovic/workspace/OOuP/").toURI().toURL(),
							new File("/home/mculinovic/workspace/OOUP/lib").toURI().toURL()
					}, parent);
		} catch (MalformedURLException e) {
			System.out.println(".jar file not found");
			e.printStackTrace();
			System.out.println();
		}
	}
	
	

	@SuppressWarnings("unchecked")
	public Animal newInstance(String animalKind, String name) {

		Animal animal = null;
		
		Class<Animal> clazz = null;
		try {
//			clazz = (Class<Animal>) Class
//					.forName("hr.fer.zemris.ooup.labos_2.zadatak5.plugins."
//							+ animalKind);
			clazz = (Class<Animal>)newClassLoader.loadClass("hr.fer.zemris.ooup.labos_2.zadatak5.plugins." + animalKind);
		} catch (ClassNotFoundException e) {
			System.out.println("Class " + animalKind + " not found");
			e.printStackTrace();
			System.out.println();
		}

		Constructor<?> ctr = null;
		try {
			ctr = clazz.getConstructor(String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("Requested constructor does not exist");
			e.printStackTrace();
			System.out.println();
		}
		try {
			animal = (Animal) ctr.newInstance(name);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Instance of class " + animalKind
					+ "could not be created");
			e.printStackTrace();
		}

		return animal;
	}
}
