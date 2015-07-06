package hr.fer.zemris.ooup.labos_3.kompozit;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExpressionFactory {
	
	private static ExpressionFactory factory;
	
	private URLClassLoader newClassLoader;
	

	public static ExpressionFactory getFactory() {
		if (factory == null) {
			factory = new ExpressionFactory(); 
		}
		return factory;
	}
	
	private ExpressionFactory() {
		newClassLoader = null;
		try {
			ClassLoader parent = ExpressionFactory.class.getClassLoader();
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
	public AritmetickiIzraz newInstance(String operator, AritmetickiIzraz lijevi, AritmetickiIzraz desni) {

		AritmetickiIzraz izraz = null;
		
		Class<AritmetickiIzraz> clazz = null;
		String imeRazreda = null;
		try {
			imeRazreda = operator.toLowerCase();
			imeRazreda = Character.toUpperCase((imeRazreda.charAt(0))) +  imeRazreda.substring(1);
			
			clazz = (Class<AritmetickiIzraz>)newClassLoader.loadClass("hr.fer.zemris.ooup.labos_3.kompozit." + imeRazreda);
		} catch (ClassNotFoundException e) {
			System.out.println("Class " + imeRazreda + " not found");
			e.printStackTrace();
			System.out.println();
		}

		Constructor<?> ctr = null;
		try {
			ctr = clazz.getConstructor(AritmetickiIzraz.class, AritmetickiIzraz.class);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("Requested constructor does not exist");
			e.printStackTrace();
			System.out.println();
		}
		try {
			izraz = (AritmetickiIzraz) ctr.newInstance(lijevi, desni);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Instance of class " + operator.toLowerCase()
					+ "could not be created");
			e.printStackTrace();
		}

		return izraz;
	}
}

