package businesslogic;

import java.util.ArrayList;

import models.prescribed.PrescribedHeir;
import models.residual.ResidualHeir;

public class TotalDistributedShares {

	ArrayList<PrescribedHeir> listPH;
	ArrayList<ResidualHeir> listRH;
	private ArrayList<String> eligibleHeirs;
	private ArrayList<Double> earnedTotalShares;
	
	
	public TotalDistributedShares() {
		eligibleHeirs = new ArrayList<String>();
		earnedTotalShares = new ArrayList<Double>(); 
	}
	

	public ArrayList<String> getEffectiveHeirs() {
		return eligibleHeirs;
	}


	public ArrayList<Double> getEffectiveShares() {
		return earnedTotalShares;
	}


	public void computeFinalShares(double shares, PrescribedShares ps, ResidualShares rs) {
		
		listPH=ps.getListOfEligibleHeirs();
		listRH=rs.getListOfEligibleHeirs();
		
		if(ps.getSumofPS()>shares || (ps.getSumofPS()<shares && rs.getIsResidualHeir()==false)) {
			double factor=shares/ps.getSumofPS();
			for (PrescribedHeir l: listPH) {
				eligibleHeirs.add(l.getName());
				earnedTotalShares.add(l.getPortions()*factor);
				}
			
		}
		else {
			
			for (PrescribedHeir l: listPH) {
				eligibleHeirs.add(l.getName());
				earnedTotalShares.add(l.getPortions());
				} 
			for (ResidualHeir l: listRH) {
				if(eligibleHeirs.contains(l.getName())) {
					int i=eligibleHeirs.indexOf(l.getName());
					earnedTotalShares.set(i, earnedTotalShares.get(i)+l.getPortions());
					}
				else {
					eligibleHeirs.add(l.getName());
					earnedTotalShares.add(l.getPortions());
					}
				} 
		}
		
	}
	
	public ArrayList<PrescribedHeir> getListofheirsofps() {
		return listPH;
	}

	public ArrayList<ResidualHeir> getListofheirsofrs() {
		return listRH;
	}


	public void view() {
		System.out.println("========Total Distributed Shares==========");
		for(String name: eligibleHeirs) {
			System.out.println(name+": "+ earnedTotalShares.get(eligibleHeirs.indexOf(name)));
		}
	}

}
