package setup;

public class SetupLazySingleton extends Setup {

	private static SetupLazySingleton classInstance = null;

	private SetupLazySingleton() {
		super();
		System.out.println("SetupLazySingleton Instance\n");
	}

	public static SetupLazySingleton getInstance() {
		if (classInstance == null) {
			System.out.println("\nAt the beginning SetupLazySingleton is Null Instance");

			synchronized (SetupLazySingleton.class) {
				if (classInstance == null) {
					classInstance = new SetupLazySingleton();
				}
			}
		}
		return classInstance;
	}
}
