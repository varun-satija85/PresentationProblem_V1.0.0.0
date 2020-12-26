package com.ConferenceOrganiser;
import java.util.Comparator;

public class Presenter implements Comparator<Presenter>{
	
	private String PresenterName;
	private int PresentationHours;
	private int PresentationCost;
	
	
	
	
	public Presenter(String presenterName, int presentationHours, int presentationCost) {
		super();
		PresenterName = presenterName;
		PresentationHours = presentationHours;
		PresentationCost = presentationCost;
	}
	
	public Presenter() {
		
	}
	


	public String getPresenterName() {
		return PresenterName;
	}


	public void setPresenterName(String presenterName) {
		PresenterName = presenterName;
	}


	public int getPresentationHours() {
		return PresentationHours;
	}


	public void setPresentationHours(int presentationHours) {
		PresentationHours = presentationHours;
	}


	public int getPresentationCost() {
		return PresentationCost;
	}


	public void setPresentationCost(int presentationCost) {
		PresentationCost = presentationCost;
	}


	@Override
	public int compare(Presenter o1, Presenter o2) {
		// TODO Auto-generated method stub
		if(o1.getPresentationHours()<o2.getPresentationHours())
			return -1;
		else if(o1.getPresentationHours()>o2.getPresentationHours())
			return 1;
		else if(o1.getPresentationHours()==o2.getPresentationHours()) {
			if(o1.getPresentationCost()<=o2.getPresentationCost()) {
				return -1;
			} else {
				return 1;
			}
		}
		return 0;
	}


	@Override
	public String toString() {
		return "Presenter [PresenterName=" + PresenterName + ", PresentationHours=" + PresentationHours
				+ ", PresentationCost=" + PresentationCost + "]";
	}
	
	
	

}
