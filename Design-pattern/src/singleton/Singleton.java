package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {

	// 1- way: Eager initialization
	// drawbacks- client may not used this early created object..waste of memory
	/*
	 * private static Singleton singleton = new Singleton(); private Singleton() {}
	 * public static Singleton getInstSingleton() { return singleton; }
	 */

	// ==========================================================================================

	// 2-way: static block initialization
	// drawbacks-same as eager initialization but we can handle exception
	/*
	 * private static Singleton singleton; private Singleton() { } static { try {
	 * singleton = new Singleton(); } catch (RuntimeException e) { throw new
	 * RuntimeException("Exception occured while creating singleton instance of the class"
	 * ); } } public static Singleton getInstSingleton() { return singleton; }
	 */

	// ==========================================================================================

	// 3-way: Lazy initialization:
	// drawbacks-good way but not recommended in multithreading environment, if
	// multiple thread acting on method at same time having possibility of creating
	// multiple classes at same time
	/*
	 * private static Singleton singleton; private Singleton() { } public Singleton
	 * getInstSingleton() { if(singleton==null) { singleton= new Singleton(); }
	 * return singleton; }
	 */

	// =====================================================================================

	// 4-way: Thread safe singleton
	// drawbacks- it works fine but reduce performance
	/*
	 * private static Singleton singleton; private Singleton() { } public
	 * synchronized Singleton getInstSingleton() { if (singleton == null) {
	 * singleton = new Singleton(); } return singleton; }
	 */
	// ===============================================================================================

	// 5-way: Thread safe singleton
	// drawbacks- it works fine but it can be break by reflection API code
	/*
	 * private static Singleton singleton; private Singleton() { } public Singleton
	 * getInstSingleton() { if (singleton == null) { synchronized (Singleton.class)
	 * { if (singleton == null) { singleton = new Singleton(); } } } return
	 * singleton; }
	 */
//================================================================================================================================================	
	// 6-way: Bill Pugh Singleton Implementation(inner class implementation
	// drawbacks- it works fine,this doesn't required synchronized private class
	// load when getInstance method called this is industry standard (but all failed
	// because of reflection API )

	/*
	 * private Singleton() {} private static class SingletonHelper { private static
	 * final Singleton INSTANCE = new Singleton(); } public static Singleton
	 * getInstance(){ return SingletonHelper.INSTANCE; }
	 */
//=========================================================================================================================================	
	// below code destroy all above ways of creating singleton

	/*
	 * private static Singleton singleton = new Singleton();
	 * 
	 * private Singleton() { }
	 * 
	 * public static Singleton getInstance() { return singleton; }
	 * 
	 * public static void main(String[] args) { Singleton singletonone =
	 * Singleton.getInstance(); Singleton singletontwo = null; Constructor
	 * constructor[] = Singleton.class.getDeclaredConstructors(); for (Constructor
	 * construct : constructor) { construct.setAccessible(true); try { singletontwo
	 * = (Singleton) construct.newInstance(); } catch (Exception e) {
	 * e.printStackTrace(); } } System.out.println(singletonone.hashCode());
	 * System.out.println(singletontwo.hashCode());
	 * 
	 * }
	 */
}
