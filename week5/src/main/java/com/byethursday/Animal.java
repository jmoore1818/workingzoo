package com.byethursday;

public class Animal {

	private String animalID = null;
	private String species = null;
	private String habitat = null;
	private String diet = null;
	private String activity = null;

	public Animal(String animalID, String species, String habitat, String diet, String activity) {
		super();
		this.animalID = animalID;
		this.species = species;
		this.habitat = habitat;
		this.diet = diet;
		this.activity = activity;
	}

	public Animal() {
		super();
	}

	public String getAnimalID() {
		return animalID;
	}

	public void setAnimalID(String animalID) {
		this.animalID = animalID;
	}

	public String getspecies() {
		return species;
	}

	public void setspecies(String species) {
		this.species = species;
	}

	public String gethabitat() {
		return habitat;
	}

	public void sethabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getdiet() {
		return diet;
	}

	public void setdiet(String diet) {
		this.diet = diet;
	}

	public String getactivity() {
		return activity;
	}

	public void setactivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Animal [animalID=" + animalID + ", species" + species + ", habitat is " + habitat + ", diet is " + diet
				+ ", activity is" + activity + "]";
	}

}
