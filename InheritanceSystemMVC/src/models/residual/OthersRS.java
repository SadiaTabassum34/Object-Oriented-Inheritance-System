package models.residual;

import java.util.ArrayList;

import models.DeceasedModel;

public class OthersRS extends ResidualHeir {

	public OthersRS(DeceasedModel dm, String name, double remainingShares) {
		super(dm, name, remainingShares);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		ArrayList<Integer> numberofHeir=dm.getNumberOfHeir();
		int nr = numberofHeir.get(listofHeirs.indexOf(name));
		return (remainingShares/nr);
	}

}
