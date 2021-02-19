package models.prescribed;

import java.util.ArrayList;

import models.DeceasedModel;

public class AncestorPS extends PrescribedHeir {

	public AncestorPS(DeceasedModel dm, String name,int n) {
		super(dm, name, n);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		if(name.equalsIgnoreCase("father's father"))
			return dm.getEffectiveShares()/6;
		else if(name.equalsIgnoreCase("father's mother"))
			return (dm.getEffectiveShares()/12) + (dm.getEffectiveShares()/12) * hasNoMotherOfMother();
		else if (name.equalsIgnoreCase("mother's mother"))
			return (dm.getEffectiveShares()/12) + ((dm.getEffectiveShares()/12) * hasNoFatherAndhasMotherOfFather());
		else 
			return 0;
	}
	public int hasNoMotherOfMother() {
		ArrayList<String> listofHeirs=dm.getListOfHeirs();   
	    if(!listofHeirs.contains("mother's mother"))
	    	return 1;
	    else 
	    	return 0;
	}
	
	public int hasNoFatherAndhasMotherOfFather() {
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		   
	    if(!listofHeirs.contains("father") && listofHeirs.contains("father's mother") )
	    	return 0;
	    else
	    	return 1;	
	}

}
