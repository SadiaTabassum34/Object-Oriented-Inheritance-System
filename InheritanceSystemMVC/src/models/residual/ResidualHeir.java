package models.residual;

import models.DeceasedModel;

public abstract class ResidualHeir{
	
	protected DeceasedModel dm;
	protected String name;
	protected double portions;
	protected double remainingShares;
	
	public ResidualHeir(DeceasedModel dm, String name, double remainingShares ) {
		this.dm=dm;
		this.name=name;
		this.remainingShares=remainingShares;
	}

	public String getName() {
		return name;
	}

	public double getPortions() {
		return portions;
	}
	
	abstract public double computePortion();
}
