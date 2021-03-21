package com.ConferenceOrganiser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ImportCSVFile {
	
	/**
	 * by Varun Satija dated today
	 * @return
	 */
	public ArrayList<Presenter> readCsvFile() {
		BufferedReader reader;
		ArrayList<Presenter> presenterList= new ArrayList<Presenter>();
		try {
			reader = new BufferedReader(new FileReader(".\\src\\sample1.csv"));
			String line;
			int index=0;
	        while ((line=reader.readLine()) != null) {
	            String[] fields = line.split(",");
	            // Print the columns in array form
	            index++;
	            if(index==1)
	            	continue;
	            //System.out.println(Arrays.toString(fields));
	            Presenter presenter=getPresenter(fields);
	            if(presenter!=null) {
	            	presenterList.add(presenter);
	            }
	            
	        }
	        reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return presenterList;
        
	}
	
	
	/**
	 * 
	 * @param fields
	 * @return
	 */
	private Presenter getPresenter(String[] fields) {
		if(fields.length==3) {
			try {
				Presenter presenter= new Presenter();
				presenter.setPresentationCost(Integer.parseInt(fields[2]));
				presenter.setPresenterName(fields[0]);
				presenter.setPresentationHours(Integer.parseInt(fields[1]));
				return presenter;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private void test(){
		
	}

}
