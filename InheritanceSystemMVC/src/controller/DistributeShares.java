package controller;

import java.util.ArrayList;

import businesslogic.PrescribedShares;
import businesslogic.ResidualShares;
import businesslogic.TotalDistributedShares;
import models.DeceasedModel;
import views.OutputScreen;
import views.Screen;

public class DistributeShares {
	private DeceasedModel deceasedModel;
	private PrescribedShares prescribedShares;
	private ResidualShares residualShares;
	private TotalDistributedShares totalDistributedShares;
	public void allotShares(ArrayList<String> list,ArrayList<Integer> number, double shares){
		deceasedModel=new DeceasedModel(); 
		deceasedModel.createDeceasedModel(list,number,shares);
		prescribedShares=new PrescribedShares();
		//System.out.println(dm);
		prescribedShares.computePrescribedShares(deceasedModel);
		prescribedShares.view();
		prescribedShares.sumOfPS();
		residualShares=new ResidualShares();
		residualShares.computeResidualShares(deceasedModel,(shares-prescribedShares.getSumofPS()));
			 //System.out.println("Eligible Heirs for Residual Shares: "+ rs);
		residualShares.view();
		totalDistributedShares=new TotalDistributedShares(); 
		totalDistributedShares.computeFinalShares(shares,prescribedShares,residualShares);
		residualShares.view();
		Screen os=new OutputScreen(); 
		os.view(totalDistributedShares);
	}
}
