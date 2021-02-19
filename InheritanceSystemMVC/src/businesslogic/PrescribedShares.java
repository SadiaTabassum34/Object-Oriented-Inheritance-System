package businesslogic;

import java.util.ArrayList;
import models.DeceasedModel;
import models.prescribed.AncestorPS;
import models.prescribed.ParentsPS;
import models.prescribed.PrescribedHeir;
import models.prescribed.SistersPS;
import models.prescribed.SpousePS;
import models.prescribed.SuccessorPS;

public class PrescribedShares {
	
	private ArrayList<PrescribedHeir> listOfEligibleHeirs;
	private double sumOfPrescribedShares;
	
	public void computePrescribedShares(DeceasedModel dm){
		ArrayList<String> listofHeirs=dm.getListOfHeirs();
		ArrayList<Integer> numberofHeir=dm.getNumberOfHeir();
		listOfEligibleHeirs=new ArrayList<PrescribedHeir>(); 
		if(listofHeirs.contains("husband"))
			listOfEligibleHeirs.add(new SpousePS(dm,"husband",numberofHeir.get(listofHeirs.indexOf("husband"))));
		if(listofHeirs.contains("wives"))
			listOfEligibleHeirs.add(new SpousePS(dm,"wives",numberofHeir.get(listofHeirs.indexOf("wives"))));
		if(listofHeirs.contains("daughters") && !listofHeirs.contains("sons"))
			listOfEligibleHeirs.add(new SuccessorPS(dm,"daughters",numberofHeir.get(listofHeirs.indexOf("daughters"))));
		if(listofHeirs.contains("father"))
			listOfEligibleHeirs.add(new ParentsPS(dm,"father",numberofHeir.get(listofHeirs.indexOf("father"))));
		if(listofHeirs.contains("mother"))
			listOfEligibleHeirs.add(new ParentsPS(dm, "mother",numberofHeir.get(listofHeirs.indexOf("mother"))));
		if(listofHeirs.contains("father's father") && !listofHeirs.contains("father"))
			listOfEligibleHeirs.add(new AncestorPS(dm,"father's father",numberofHeir.get(listofHeirs.indexOf("father's father"))));
		if(listofHeirs.contains("father's mother") && !listofHeirs.contains("mother") && !listofHeirs.contains("father"))
			listOfEligibleHeirs.add(new AncestorPS(dm,"father's mother",numberofHeir.get(listofHeirs.indexOf("father's mother"))));
		if(listofHeirs.contains("mother's mother") && !listofHeirs.contains("mother"))
			listOfEligibleHeirs.add(new AncestorPS(dm,"mother's mother",numberofHeir.get(listofHeirs.indexOf("mother's mother"))));
		if(listofHeirs.contains("son's daughters") && !listofHeirs.contains("sons") && !listofHeirs.contains("son's sons") && (!listofHeirs.contains("daughters") || (listofHeirs.contains("daughters") && (numberofHeir.get(listofHeirs.indexOf("daughters"))==1))))
			listOfEligibleHeirs.add(new SuccessorPS(dm,"son's daughters",numberofHeir.get(listofHeirs.indexOf("son's daughters"))));
		if(listofHeirs.contains("sisters") && !listofHeirs.contains("daughters") && !listofHeirs.contains("sons") && !listofHeirs.contains("son's sons") && !listofHeirs.contains("son's daughters") && !listofHeirs.contains("father") && !listofHeirs.contains("father's father") && !listofHeirs.contains("brothers"))
			listOfEligibleHeirs.add(new SistersPS(dm,"sisters", numberofHeir.get(listofHeirs.indexOf("sisters"))));
	}
	
	public void sumOfPS() {
		double ps=0;
		for (PrescribedHeir i: listOfEligibleHeirs) {
			ps=ps+ i.getPortions()* i.getCount();
		this.sumOfPrescribedShares=ps;
		}
	}

	public double getSumofPS() {
		return sumOfPrescribedShares;
	}
	
	

	public ArrayList<PrescribedHeir> getListOfEligibleHeirs() {
		return listOfEligibleHeirs;
	}

	public double getSumOfPrescribedShares() {
		return sumOfPrescribedShares;
	}

	public void view() {
		System.out.println("========Prescribed Shares=======");
		for (PrescribedHeir i: listOfEligibleHeirs) {
			System.out.println(i.getName() + ": "+ i.getPortions());
		}
	}
}
