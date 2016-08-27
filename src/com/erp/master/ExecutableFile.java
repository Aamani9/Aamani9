package com.erp.master;

import java.io.IOException;

public class ExecutableFile {


	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	
		
		LibFile ef = new LibFile();
		
		 ef.launch();
		 ef.login("admin", "master");
		 ef.suppliers("Aamani", "546876548", "bangalore", "uk", "kutty", "4684548", "kutty@gmail.com", "458765468", "vbcfbgfbjv");
		 ef.stockCatagories("textiles");
		 ef.uom("5697", "kg");
		 ef.stockItems();
	}

}
