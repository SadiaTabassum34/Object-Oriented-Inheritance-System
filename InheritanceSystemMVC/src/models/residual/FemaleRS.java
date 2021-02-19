package models.residual;

import java.util.ArrayList;

import models.DeceasedModel;

public class FemaleRS extends ResidualHeir {

	public FemaleRS(DeceasedModel dm, String name, double remainingShares) {
		super(dm, name, remainingShares);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		ArrayList<Integer> numberofHeir=dm.getNumberOfHeir();
		int nm=0; 
		int nf=numberofHeir.get(listofHeirs.indexOf(name));
		if(name=="daughters") {
			if(listofHeirs.contains("sons"))
				nm=numberofHeir.get(listofHeirs.indexOf("sons"));
		}
			
		if(name=="son's daughters") {
			if(listofHeirs.contains("son's sons"))
				nm=numberofHeir.get(listofHeirs.indexOf("son's sons"));
		}
			
		if(name=="sisters") {
			if(listofHeirs.contains("brothers"))
				nm=numberofHeir.get(listofHeirs.indexOf("brothers"));
		}
			
		return (remainingShares/(2*nm+nf));
	}

}
