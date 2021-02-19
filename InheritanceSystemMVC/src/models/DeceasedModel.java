package models;

import java.util.ArrayList;

public class DeceasedModel {
	
	private ArrayList<String> listOfHeirs;
	private ArrayList<Integer> numberOfHeir;
	private double effectiveShares;
	
	public void createDeceasedModel(ArrayList<String> list,ArrayList<Integer> number, double shares) {
		this.listOfHeirs=list;
		this.numberOfHeir=number;
		this.effectiveShares=shares;
	}


	public ArrayList<String> getListOfHeirs() {
		return listOfHeirs;
	}

	public ArrayList<Integer> getNumberOfHeir() {
		return numberOfHeir;
	}

	public double getEffectiveShares() {
		return effectiveShares;
	}

	
	@Override
	public String toString() {
		return "DeceasedModel [listofHeirs=" + listOfHeirs + ", numberofHeir=" + numberOfHeir + ", effectiveShares="
				+ effectiveShares + "]";
	}
	
}
