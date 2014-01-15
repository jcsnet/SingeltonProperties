import setup.Setup;
import setup.SetupEagerSingleton;
import setup.SetupLazySingleton;

public class Booter {

	public static void main(String[] args) {
		Setup setup;
//		setup = SetupEagerSingleton.getInstance();
		setup = SetupLazySingleton.getInstance();
		System.out.println(setup);
	}
}
