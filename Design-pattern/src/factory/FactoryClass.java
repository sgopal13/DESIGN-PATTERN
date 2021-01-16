package factory;

/*Note: 
 * Base on input we can return the object of that class
 * 
 * Factory design pattern provides approach to code for interface rather than implementation.
   Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our code more robust, less coupled and easy to extend. For example, we can easily change PC class implementation because client program is unaware of this.
   Factory pattern provides abstraction between implementation and client classes through inheritance.
*/
public class FactoryClass {
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu){
		
		if("PC".equalsIgnoreCase(type)) 
				return new PC(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type))
				return new Server(ram, hdd, cpu);
		
		return null;
	}

}
