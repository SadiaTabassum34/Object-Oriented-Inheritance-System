package models.prescribed;

import java.util.ArrayList;

import models.DeceasedModel;

public class SuccessorPS extends PrescribedHeir {

	public SuccessorPS(DeceasedModel dm, String name, int count) {
		super(dm, name, count);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		if(name.equalsIgnoreCase("daughters"))
			return ((dm.getEffectiveShares()/2) + (dm.getEffectiveShares()/6) * hasMultipleDaughters())/count;
		else if(name.equalsIgnoreCase("son's daughters"))
			return ((dm.getEffectiveShares()/6)*hasSingleDaughter() + (1-hasSingleDaughter())*(dm.getEffectiveShares()/2 + ((dm.getEffectiveShares()/6)*hasMultipleGrandDaughters()))/count);
		else 
			return 0;
	}
	
	public int hasMultipleDaughters() {
	    if(this.count>1)
	    	return 1;
	    else 
	    	return 0;
	}
	
	public int hasMultipleGrandDaughters() {
	    if(this.count>1)
	    	return 1;
	    else 
	    	return 0;
	}
	
	public int hasSingleDaughter() {
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		if (listofHeirs.contains("daughters"))
	    	return 1;
	    else 
	    	return 0;
	}

}
