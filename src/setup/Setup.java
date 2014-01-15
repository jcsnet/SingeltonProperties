package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import domain.Database;

public abstract class Setup {

	public static final String FILE_NAME = "setup.properties";
	private Properties properties;
	private Database database = new Database();
	
	public Database getDatabaseProperties() {
		database.setName(properties.getProperty("db.name"));
		database.setUser(properties.getProperty("db.user"));
		database.setPassword(properties.getProperty("db.password"));
		database.setPort(properties.getProperty("db.port"));
		database.setUrl(properties.getProperty("db.url"));
		database.setDriver(properties.getProperty("db.driver"));
		return database;
	}

	public void setDatabaseProperties(Database database) {
		properties.setProperty("db.name", database.getName());
		properties.setProperty("db.user", database.getUser());
		properties.setProperty("db.password", database.getPassword());
		properties.setProperty("db.port", database.getPort());
		properties.setProperty("db.url", database.getUrl());
		properties.setProperty("db.driver", database.getDriver());
	}

	protected Setup() {
		receiveDatabasePropertiesFromFile();
	}

	private void receiveDatabasePropertiesFromFile() {
		
		File file = new File(FILE_NAME);
		if (file.exists()) {
			
			System.out.println("\n\nFile "+FILE_NAME+" already exist. Read configuration from this file.\n\n");
			properties = new Properties();
			try {
				FileInputStream inputStream = new FileInputStream(file);
				properties.load(inputStream);
				setDatabaseProperties(getDatabaseProperties());
				return;
			}

			catch (FileNotFoundException e) {
				System.out.println("Receive file. File " + FILE_NAME
						+ " was not found. Exception " + e);
			} catch (IOException e) {
				System.out.println("IOException while receive file " + FILE_NAME
						+ ". Exception " + e);
			}

		}
		initProperties();
	}

	private void initProperties() {
		try {
			properties = new Properties();
			database = new Database("baza", "root", "haslo", "localhost",
					"3333", "mysql");
			savePropertiesToFile();
		} catch (IOException e) {
			System.out.println("IOException while init properties file " + FILE_NAME
					+ ". Exception " + e);
		}
	}

	private void savePropertiesToFile() throws IOException {
		System.out.println("\n\nFile "+FILE_NAME+" not exist.\n");
		System.out.println("Saving Database configuration into file : "+FILE_NAME+"\n");
		setDatabaseProperties(database);
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			file.createNewFile();
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			properties.store(outputStream, null);
		} catch (FileNotFoundException e) {
			System.out.println("Save File. File " + FILE_NAME
					+ " was not found. Exception " + e);
		}
	}
	
	@Override
	public String toString() {
		return "Database Configuration "+database;
	}

}
