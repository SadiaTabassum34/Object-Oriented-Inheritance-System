package businesslogic;

import java.util.ArrayList;

import models.DeceasedModel;
import models.residual.FemaleRS;
import models.residual.MaleRS;
import models.residual.OthersRS;
import models.residual.ResidualHeir;

public class ResidualShares {

	private ArrayList<ResidualHeir> listOfEligibleHeirs;
	private boolean isResidualHeir;
	
	public ResidualShares() {
		this.listOfEligibleHeirs = new ArrayList<ResidualHeir>();
		this.isResidualHeir = false;
	}
	
	
	public ArrayList<ResidualHeir> getListOfEligibleHeirs() {
		return listOfEligibleHeirs;
	}

	public boolean getIsResidualHeir() {
		return isResidualHeir;
	}

	public void computeResidualShares(DeceasedModel dm, double rmainingShares ) {
		
		if (rmainingShares>0) {
			ArrayList<String> listofHeirs=dm.getListOfHeirs();
			if(listofHeirs.contains("sons")) {
				listOfEligibleHeirs.add(new MaleRS(dm,"sons", rmainingShares));
				if(listofHeirs.contains("daughters"))
					listOfEligibleHeirs.add(new FemaleRS(dm,"daughters",rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("son's sons")) {
				listOfEligibleHeirs.add(new MaleRS(dm,"son's sons",rmainingShares));
				if(listofHeirs.contains("son's daughters"))
					listOfEligibleHeirs.add(new FemaleRS(dm,"son's daughters",rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("father")) {
				listOfEligibleHeirs.add(new OthersRS(dm,"father",rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("father's father")) {
				listOfEligibleHeirs.add(new OthersRS(dm,"father's father",rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("brothers")) {
				listOfEligibleHeirs.add(new MaleRS(dm,"brothers",rmainingShares));
				if(listofHeirs.contains("sisters"))
					listOfEligibleHeirs.add(new FemaleRS(dm,"sisters",rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("daughters")) {
				if(listofHeirs.contains("sisters")) {
					listOfEligibleHeirs.add(new FemaleRS(dm,"sisters", rmainingShares));
					this.isResidualHeir=true;
				}
			}
			else if(listofHeirs.contains("son's daughters")) {
				if(listofHeirs.contains("sisters")) {
					listOfEligibleHeirs.add(new FemaleRS(dm,"sisters", rmainingShares));
					this.isResidualHeir=true;
				}
			}
			else if(listofHeirs.contains("brother's sons")) {
				listOfEligibleHeirs.add(new OthersRS(dm, "brother's sons", rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("sons of brother's sons")) {
				listOfEligibleHeirs.add(new OthersRS(dm,"sons of brother's sons", rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("fathers's brothers")) {
				listOfEligibleHeirs.add(new OthersRS(dm,"fathers's brothers", rmainingShares));
				this.isResidualHeir=true;
			}
			else if(listofHeirs.contains("sons of fathers's brothers")) {
				listOfEligibleHeirs.add(new OthersRS(dm, "sons of fathers's brothers", rmainingShares));
				this.isResidualHeir=true;
			}
			else {		
				this.isResidualHeir=false;
			}
		}
		else {
			this.isResidualHeir=false;
		}
	}

	public void view() {
		System.out.println("========Residual Shares=======");
		for (ResidualHeir i: listOfEligibleHeirs) {
			System.out.println(i.getName() + ": "+ i.getPortions());
		}
	}

}
