package com.specomm.adidas.common.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterThread extends Thread {

	String outputcsv;
	String content;
	FileWriter writer;
	
	public FileWriterThread(String outputcsv,String content){
		this.outputcsv=outputcsv;
		this.content=content;
	}
	
	public FileWriterThread(String content){
		this.content=content;
	}
	
	
        public void run() {
            try {
                
            	final String outputcsvF;
            	outputcsvF=outputcsv;
            	writer = new FileWriter(outputcsvF);
            	writer.write(content);
            	writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
   
}
