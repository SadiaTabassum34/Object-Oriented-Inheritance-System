package models.prescribed;

import java.util.ArrayList;

import models.DeceasedModel;

public class SpousePS extends PrescribedHeir {

	public SpousePS(DeceasedModel dm, String name, int count) {
		super(dm, name, count);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		if(name.equalsIgnoreCase("husband"))
			return (dm.getEffectiveShares()/4)+ (dm.getEffectiveShares()/4) *hasNoChildren() ;
		else if(name.equalsIgnoreCase("wives"))
			return ((dm.getEffectiveShares()/8)+ ((dm.getEffectiveShares()/8)*hasNoChildren()))/count;
		else 
			return 0;
	}

	public int hasNoChildren() {
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		boolean b= listofHeirs.contains("sons") || listofHeirs.contains("daughters") || listofHeirs.contains("son's daughters")|| listofHeirs.contains("son's sons");   
	    if(b)
	    	return 0;
	    else 
	    	return 1;
	}
}
