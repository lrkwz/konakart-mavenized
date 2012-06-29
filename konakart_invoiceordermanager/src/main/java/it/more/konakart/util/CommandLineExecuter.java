/**
 * 
 */
package it.more.konakart.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author lorenzo
 */
public class CommandLineExecuter {
	protected static Log	log	= LogFactory.getLog(CommandLineExecuter.class);

	public static int execute(String command)
	{
		Process process; // Process
		Runtime runtime; // Local runtime object
		java.io.InputStream input; // Output from process
		byte buffer[]; // Buffer for output data
		int bytes; // Number of bytes

		// First tell the client that we will be sending PDF...
		//System.out.print("Content-type: application/pdf\n\n");

		// Construct the command string
		/*
		command = "/usr/bin/htmldoc --quiet --jpeg --webpage -t pdf --left 36 --outfile " + filename
				+ ".pdf --header .t. --footer .1. " + filename;
				*/
		log.debug("Executing:" + command);

		// Run the process and wait for it to complete...
		runtime = Runtime.getRuntime();

		try {
			// Create a new process...
			process = runtime.exec(command);

			// Get stdout from the process and a buffer for the data...
			input = process.getInputStream();
			buffer = new byte[8192];

			// Read output from process until we have it all...
			StringBuffer strBuff = new StringBuffer();
			while ((bytes = input.read(buffer)) > 0) {
				strBuff.append(new String(buffer, 0, bytes));
			}
			log.info("Output of " + command + " is: " + strBuff.toString());

			// Return the exit status from process...
			return (process.waitFor());
		} catch (Exception e) {
			log.error(e.toString() + " caught while running:" + command);
			return (1);
		}
	}
}
