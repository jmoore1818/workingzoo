package com.byethursday;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	
	public static final ArrayList<Animal> ourZoo = new ArrayList<>();

	public static void connToDB() {

		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Trying to connect to the DB...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to DB.");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}

	}

	public static void readFromDB() {

		connToDB();

		try {

			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM our_schema.zoo;");

			while (RES_SET.next()) {

				Animal animalInDB = new Animal();

				animalInDB.setAnimalID((RES_SET.getString("animal_id")));
				animalInDB.setspecies(RES_SET.getString("species"));
				animalInDB.sethabitat(RES_SET.getString("habitat"));
				animalInDB.setdiet(RES_SET.getString("diet"));
				animalInDB.setactivity(RES_SET.getString("activity"));

				ourZoo.add(animalInDB);

			}

			for (Animal animal : ourZoo) {
				System.out.println(animal);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // read

	public static void writeToDatabase(Animal animal) {

		Animal animalToAdd = new Animal();

		animalToAdd = animal;

		try {

			connToDB();

			PREP_STMT = CONN.prepareStatement(insertIntoTable);

			PREP_STMT.setString(1, animalToAdd.getspecies());
			PREP_STMT.setString(2, animalToAdd.gethabitat());
			PREP_STMT.setString(3, animalToAdd.getdiet());
			PREP_STMT.setString(4, animalToAdd.getactivity());

			System.out.println(PREP_STMT);

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // write

	public static void deleteFromDB() {

		Scanner sc = new Scanner(System.in);

		readFromDB();

		System.out.println("\nWhich Animal would you like to delete?"
				+ "\nPlease select an ID");
		int id = sc.nextInt();

		try {
			PREP_STMT = CONN.prepareStatement(delFromTable(id));
			
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // delete

	private static String insertIntoTable = "INSERT INTO `our_schema`.`zoo`" + "(species, habitat, diet, activity)"
			+ " VALUES " + "(?, ?, ?, ?)";

	private static String delFromTable(int id) {
		return "DELETE FROM `our_schema`.`zoo` WHERE animal_id = " + id + ";";
	}

	private static Animal aboutTheStudent() {

		Scanner sc = new Scanner(System.in);

		Animal animalToAdd = new Animal();

		System.out.println("What is the animal's name?");

		animalToAdd.setspecies(sc.nextLine());

		System.out.println("What is the animal's species?");

		animalToAdd.sethabitat(sc.nextLine());

		System.out.println("What kind of enclosure does the animal live in?");

		animalToAdd.setdiet(sc.nextLine());

		System.out.println("What kind of food does the animal eat?");

		animalToAdd.setactivity(sc.nextLine());

		sc.close();
		return animalToAdd;
	}

} // class