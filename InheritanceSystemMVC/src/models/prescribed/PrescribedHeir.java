package models.prescribed;

import models.DeceasedModel;

abstract public class  PrescribedHeir{
	
	protected DeceasedModel dm;
	protected String name;
	protected int count;
	protected double portions;
	
	PrescribedHeir(DeceasedModel dm, String name,int count){
		this.dm=dm;
		this.name=name;
		this.count=count;
	}

	public String getName() {
		return name;
	}

	public double getPortions() {
		return portions;
	}
		
	public int getCount() {
		return count;
	}

	abstract public double computePortion();
}
