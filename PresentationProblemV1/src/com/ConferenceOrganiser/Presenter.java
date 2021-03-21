package com.ConferenceOrganiser;
import java.util.Comparator;

/**
*  added by VS185110
*  changes p1  
*  changes p3
*  changes p2
*
**/
public class Presenter implements Comparator<Presenter>{
	
	private String PresenterName;
	private int PresentationHours;
	private int PresentationCost;
	
	
	
	/**
	 * added by Varun Satija
	 * @param presenterName
	 * @param presentationHours
	 * @param presentationCost
	 */
	public Presenter(String presenterName, int presentationHours, int presentationCost) {
		super();
		PresenterName = presenterName;
		PresentationHours = presentationHours;
		PresentationCost = presentationCost;
	}
	
	/**
	 * 
	 */
	public Presenter() {
		
	}
	

   /**
    * 
    * @return
    */
	public String getPresenterName() {
		return PresenterName;
	}

    /**
     * 
     * @param presenterName
     */
	public void setPresenterName(String presenterName) {
		PresenterName = presenterName;
	}


	public int getPresentationHours() {
		return PresentationHours;
	}

    /**
     * 
     * @param presentationHours
     */
	public void setPresentationHours(int presentationHours) {
		PresentationHours = presentationHours;
	}

    /**
     * 
     * @return
     */
	public int getPresentationCost() {
		return PresentationCost;
	}

    /**
     * 
     * @param presentationCost
     */
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
	
	public void t1(){
	}
	
	
	

}
