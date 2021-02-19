package models.residual;

import java.util.ArrayList;

import models.DeceasedModel;

public class MaleRS extends ResidualHeir {

	
	public MaleRS(DeceasedModel dm, String name, double remainingShares) {
		super(dm, name, remainingShares);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		ArrayList<Integer> numberofHeir=dm.getNumberOfHeir();
		int nm = numberofHeir.get(listofHeirs.indexOf(name));
		int nf=0;
		if(name=="sons" && listofHeirs.contains("daughters") )
			nf=numberofHeir.get(listofHeirs.indexOf("daughters"));
		if(name=="son's sons" && listofHeirs.contains("son's daughters"))
			nf=numberofHeir.get(listofHeirs.indexOf("son's daughters"));
		if(name=="brothers" && listofHeirs.contains("sisters"))
			nf=numberofHeir.get(listofHeirs.indexOf("sisters"));
		return (2*(remainingShares/(2*nm+nf)));
	}

}
