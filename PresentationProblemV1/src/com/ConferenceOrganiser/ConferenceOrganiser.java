package com.ConferenceOrganiser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ConferenceOrganiser {
	
	 /**
	  * As per requirement, we should have 3 sessions for any input
	  *  N hence three separate list objects. 
	  */
	
	 ArrayList<Presenter> firstSession= new ArrayList<Presenter>();
	 ArrayList<Presenter> secondSession= new ArrayList<Presenter>();
	 ArrayList<Presenter> thirdSession= new ArrayList<Presenter>();
	 
	 // a convenient list to store data of all sessions
	 ArrayList<Presenter> allSession= new ArrayList<Presenter>();
   
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  confenenceHrs = getConferenceHrs(args);
	   ImportCSVFile importCSVFile = new ImportCSVFile();
	   ArrayList<Presenter> presenterList=importCSVFile.readCsvFile();
	   ConferenceOrganiser conferenceOrganiser = new ConferenceOrganiser();
	   System.out.println(conferenceOrganiser.getMaximumNumberOfPresenters(presenterList,confenenceHrs));
	}
	
	
	/**
	 * This methods contains the core logic. This methods sorts the presenters in the ascender order of presentation hours
	 * and presentation cost in case of a conflict for presentation hours. This method then divides the presenters in 3
	 * sessions based on least presentation hours. This method also check the minimum cost for the sessions.
	 * 
	 * @param presenterList
	 * @param confenenceHrs
	 * @return
	 */
	public  String getMaximumNumberOfPresenters(ArrayList<Presenter> presenterList, int confenenceHrs) {
    clearList();
	if(confenenceHrs>=3) {
		Collections.sort(presenterList, new Presenter());
		/*
		 * System.out.println(" After Sorting \n");
		 * presenterList.forEach(System.out::println);
		 */
		int index=1;
		boolean status=false;
		int sessionIndex=0;
		for(Presenter p: presenterList) {
			if(index>3) {
				index=1;
			}
			if(index==1) {
				status=alignSession(allSession,firstSession,p,confenenceHrs);
				if(status)
					sessionIndex=1;
			} else if(index==2) {
				status=alignSession(allSession,secondSession,p,confenenceHrs);
				if(status)
					sessionIndex=2;
			} else if(index==3) {
				status=alignSession(allSession,thirdSession,p,confenenceHrs);
				if(status)
					sessionIndex=3;
			}
			if(!status)
				break;
			index++;
		 }
	   if(isEmpty(firstSession)||isEmpty(secondSession)||isEmpty(thirdSession)) {
		   return "Not enough presenters";
	   }
	   int totalSum = isEmpty(allSession)?0:getSum(allSession);

	   if(totalSum<confenenceHrs) {
		   replacePresenterWithMinCost(confenenceHrs,presenterList,sessionIndex);
		   return printResult();
	   } else {
		   return printResult();
	   }
	} else {
		return "Invalid Conference Hrs";
	}
	   
		
	}
	
	
	/**
	 * 
	 * @param allSession
	 * @param sessionList
	 * @param currentPresenter
	 * @param confenenceHrs
	 */
	private static boolean alignSession(ArrayList<Presenter> allSession,ArrayList<Presenter> 
	sessionList, Presenter currentPresenter, int confenenceHrs ) {
		int totalSum = isEmpty(allSession)?0:getSum(allSession);
		totalSum=totalSum+currentPresenter.getPresentationHours();
		if(totalSum<=confenenceHrs) {
			int sessionSum=isEmpty(sessionList)?0:getSum(sessionList);
			sessionSum=sessionSum+currentPresenter.getPresentationHours();
				if(sessionSum<=(confenenceHrs/2)) {
					sessionList.add(currentPresenter);
					allSession.add(currentPresenter);
					return true;
				}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param presenters
	 * @return
	 */
	private static int getSum(ArrayList<Presenter> presenters) {
		return presenters.stream().mapToInt((Presenter p)->p.getPresentationHours()).sum();
	}
	
	
	/**
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isEmpty(Collection val) {
        return (val == null || (val.size() == 0));
    }
	
	
	/**
	 * 
	 */
	private  String printResult() {
		   StringBuffer sb = new StringBuffer();
		   sb.append("session 1: ");
		   this.firstSession.forEach(li->sb.append(li.getPresenterName()+","));
		   sb.append("session 2: ");
		   this.secondSession.forEach(li->sb.append(li.getPresenterName()+","));
		   sb.append("session 3: ");
		   this.thirdSession.forEach(li->sb.append(li.getPresenterName()+","));
		   sb.append("Total Presenters: "+allSession.size());
		   sb.append(", cost of sessions: ");
		   sb.append(allSession.stream().mapToInt((Presenter p)->p.getPresentationCost()).sum());
		   return sb.toString();
		   
	}
	
	/**
	 * 
	 * @param confenenceHrs
	 * @param presenterList
	 * @param index
	 */
   private  void replacePresenterWithMinCost(int confenenceHrs, ArrayList<Presenter> presenterList, int index) {
	   Presenter oldPresenter=this.allSession.get(this.allSession.size()-1);
	   this.allSession.remove(this.allSession.size()-1);
	   int newSum=getSum(this.allSession);
	   int diff= getDifference((confenenceHrs-newSum), confenenceHrs);
	   int initialValue=oldPresenter.getPresentationHours();
	   List<Presenter> filteredList=presenterList.stream().filter(li->li.getPresentationHours()>initialValue 
			   && li.getPresentationHours()<=diff).collect(Collectors.toList());
	  int minRate =filteredList.stream().mapToInt((Presenter p)->p.getPresentationCost()).min().orElse(-1);
	  Presenter newPresenter=null;
	  if(minRate>-1) {
		  Optional<Presenter> presenterWithLowestCost =filteredList.stream().filter(li->li.getPresentationCost()==minRate).findFirst();
		  if(presenterWithLowestCost.isPresent()){
			  newPresenter=presenterWithLowestCost.get();
		  } else {
			  newPresenter=oldPresenter;
		  }
	  } else
		  newPresenter=oldPresenter;
	  allSession.add(newPresenter);
	 if(index==1) {
		firstSession.remove(firstSession.size()-1);
		firstSession.add(newPresenter);
	 }
	 else if(index==2) {
		secondSession.remove(secondSession.size()-1); 
		secondSession.add(newPresenter);
	 }
	 else if(index==3) {
		thirdSession.remove(thirdSession.size()-1); 
		thirdSession.add(newPresenter);
	 }
   }
   
   /**
    * 
    * @param diff
    * @param confenenceHrs
    * @return
    */
   private static int getDifference(int diff, int confenenceHrs ) {
	   if(diff<=confenenceHrs/2)
		   return diff;
	   else
		  return getDifference(diff-1,confenenceHrs);
   }
   
   /**
	 * This methods parses the input - N (Conference Hours)
	 * @param args
	 * @return
	 */
	private static int getConferenceHrs(String[] args) {
		int  confenenceHrs=0;
		try {
			confenenceHrs=Integer.parseInt(args[0]);
		}catch (Exception ex) {
			
		}
		return confenenceHrs;
	}
	
	
	/**
	 * Method to clear List objects
	 */
	private void clearList() {
		allSession.clear();
		firstSession.clear();
		secondSession.clear();
		thirdSession.clear();
	}
}
