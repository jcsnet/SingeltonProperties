package setup;


public class SetupEagerSingleton extends Setup{

	private static SetupEagerSingleton classInstance = new SetupEagerSingleton();

	private SetupEagerSingleton() {
		super();
		System.out.println("SetupEagerSingleton Instance\n");
	}

	public static SetupEagerSingleton getInstance() {
		return classInstance;
	}
}
