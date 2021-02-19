package models.prescribed;

import java.util.ArrayList;

import models.DeceasedModel;

public class ParentsPS extends PrescribedHeir {

	public ParentsPS(DeceasedModel dm, String name, int count) {
		super(dm, name, count);
		this.portions=computePortion();
	}

	@Override
	public double computePortion() {
		if(name.equalsIgnoreCase("father"))
			return dm.getEffectiveShares()/6;
		else if(name.equalsIgnoreCase("mother"))
			return (dm.getEffectiveShares()/6)+ (dm.getEffectiveShares()/6) *hasNoChildrenAndNoMultipleSiblings();
		else 
			return 0;
	}
	
	public int hasNoChildrenAndNoMultipleSiblings() {
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		ArrayList<Integer> numberofHeir=dm.getNumberOfHeir();
		int numberofSiblings=0;
		if (listofHeirs.contains("sisters"))
			numberofSiblings = numberofSiblings+ numberofHeir.get(listofHeirs.indexOf("sisters"));
		if (listofHeirs.contains("brothers"))
			numberofSiblings = numberofSiblings + numberofHeir.get(listofHeirs.indexOf("brothers"));
		//System.out.println("number of siblings"+numberofSiblings);
	    if(listofHeirs.contains("sons") || listofHeirs.contains("son's sons") || listofHeirs.contains("son's daughters") || listofHeirs.contains("daughters") || numberofSiblings>1)
	    	return 0;
	    else 
	    	return 1;
	}

}
