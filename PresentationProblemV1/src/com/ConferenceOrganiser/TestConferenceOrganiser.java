package com.ConferenceOrganiser;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TestConferenceOrganiser {
	
	ConferenceOrganiser conferenceOrganiser= new ConferenceOrganiser();
	/**
	 * This method will use to test result if N<3 as we will not have 3 sessions
	 */
	@Test
	public void testInvalidConferenceHrs() {
		
		assertTrue("Expected [Invalid Conference Hrs] Actual ["+conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 2)+"]",
				"Invalid Conference Hrs".equalsIgnoreCase(conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 2))) ;
		assertTrue("Expected [Invalid Conference Hrs] Actual ["+conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 1)+"]",
				"Invalid Conference Hrs".equalsIgnoreCase(conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 1))) ;
	
	}
	
	@Test
	public void testNotEnoughPersenters() {
		assertTrue("Expected [Not enough presenters] Actual ["+conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 3)+"]",
				"Not enough presenters".equalsIgnoreCase(conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 3))) ;
		assertTrue("Expected [Not enough presenters] Actual ["+conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithoutOne(), 4)+"]",
				"Not enough presenters".equalsIgnoreCase(conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithoutOne(), 4))) ;
	}
	
	@Test
	public void testMaxNumberOfPresenters() {
		assertTrue("Expected [session 1: P5,session 2: P4,session 3: P10,Total Presenters: 3, cost of sessions: 50" + 
				"] Actual "
				+ "["+conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 5)+"]",
				"session 1: P5,session 2: P4,session 3: P10,Total Presenters: 3, cost of sessions: 50".
				equalsIgnoreCase(conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 5))) ;
		
		assertTrue("Expected [session 1: P5,P1,session 2: P4,session 3: P10,Total Presenters: 4, cost of sessions: 80" + 
				"] Actual "
				+ "["+conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 6)+"]",
				"session 1: P5,P1,session 2: P4,session 3: P10,Total Presenters: 4, cost of sessions: 80".
				equalsIgnoreCase(conferenceOrganiser.getMaximumNumberOfPresenters(getPresentationDataWithOne(), 6))) ;

		
	}
	
	
	private ArrayList<Presenter> getPresentationDataWithOne() {
		ArrayList<Presenter> presenters=new ArrayList<Presenter>();
		Presenter p1= new Presenter("P1", 2, 30);
		presenters.add(p1);
		Presenter p2= new Presenter("P2", 4, 60);
		presenters.add(p2);
		Presenter p3= new Presenter("P3", 2, 70);
		presenters.add(p3);
		Presenter p4= new Presenter("P4", 1, 30);
		presenters.add(p4);
		Presenter p5= new Presenter("P5", 1, 10);
		presenters.add(p5);
		Presenter p6= new Presenter("P6", 4, 90);
		presenters.add(p6);
		Presenter p7= new Presenter("P7", 4, 10);
		presenters.add(p7);
		Presenter p8= new Presenter("P8", 3, 10);
		presenters.add(p8);
		Presenter p9= new Presenter("P9", 3, 20);
		presenters.add(p9);
		Presenter p10= new Presenter("P10", 2, 10);
		presenters.add(p10);
		Presenter p11= new Presenter("P11", 2, 100);
		presenters.add(p11);
		Presenter p12= new Presenter("P12", 3, 15);
		presenters.add(p12);
		Presenter p13= new Presenter("P13", 3, 100);
		presenters.add(p13);
		Presenter p14= new Presenter("P14", 5, 30);
		presenters.add(p14);
		Presenter p15= new Presenter("P15", 4, 80);
		presenters.add(p15);
		
		return presenters;
	}
	
	
	
	private ArrayList<Presenter> getPresentationDataWithoutOne() {
		ArrayList<Presenter> presenters=new ArrayList<Presenter>();
		Presenter p1= new Presenter("P1", 2, 30);
		presenters.add(p1);
		Presenter p2= new Presenter("P2", 4, 60);
		presenters.add(p2);
		Presenter p3= new Presenter("P3", 2, 70);
		presenters.add(p3);
		Presenter p6= new Presenter("P6", 4, 90);
		presenters.add(p6);
		Presenter p7= new Presenter("P7", 4, 10);
		presenters.add(p7);
		Presenter p8= new Presenter("P8", 3, 10);
		presenters.add(p8);
		Presenter p9= new Presenter("P9", 3, 20);
		presenters.add(p9);
		Presenter p10= new Presenter("P10", 2, 10);
		presenters.add(p10);
		Presenter p11= new Presenter("P11", 2, 100);
		presenters.add(p11);
		Presenter p12= new Presenter("P12", 3, 15);
		presenters.add(p12);
		Presenter p13= new Presenter("P13", 3, 100);
		presenters.add(p13);
		Presenter p14= new Presenter("P14", 5, 30);
		presenters.add(p14);
		Presenter p15= new Presenter("P15", 4, 80);
		presenters.add(p15);
		
		return presenters;
	}
	
	

}
