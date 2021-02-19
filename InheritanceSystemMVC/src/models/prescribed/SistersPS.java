package models.prescribed;

import models.DeceasedModel;

public class SistersPS extends PrescribedHeir {

	public SistersPS(DeceasedModel dm, String name,int n) {
		super(dm, name, n);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		return ((dm.getEffectiveShares()/2) + (dm.getEffectiveShares()/6) * hasMultipleSisters())/count;
	}
	
	public int hasMultipleSisters() {
	    if(count>1)
	    	return 1;
	    else 
	    	return 0;
	}

}
