/**
 * 
 */
package it.more.konakart.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author lrkwz
 * see {@link http://www.easysw.com/htmldoc/docfiles/5-cgi.html}
 */
public class Html2doc {
	protected static Log	log	= LogFactory.getLog(Html2doc.class);

	// Convert named file to PDF on stdout...
	public static int topdf(String command)// I - Name of file to convert
	{
		Process process; // Process for HTMLDOC
		Runtime runtime; // Local runtime object
		java.io.InputStream input; // Output from HTMLDOC
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
			// Create a new HTMLDOC process...
			process = runtime.exec(command);

			// Get stdout from the process and a buffer for the data...
			input = process.getInputStream();
			buffer = new byte[8192];

			// Read output from HTMLDOC until we have it all...
			StringBuffer strBuff = new StringBuffer();
			while ((bytes = input.read(buffer)) > 0) {
				strBuff.append(new String(buffer, 0, bytes));
			}
			log.info("Output of " + command + " is: " + strBuff.toString());

			// Return the exit status from HTMLDOC...
			return (process.waitFor());
		} catch (Exception e) {
			log.error(e.toString() + " caught while running:" + command);
			return (1);
		}
	}

	// Main entry for htmldoc class
	public static void main(String[] args)// I - Command-line args
	{
		String server_name, // SERVER_NAME env var
		server_port, // SERVER_PORT env var
		path_info, // PATH_INFO env var
		query_string, // QUERY_STRING env var
		filename; // File to convert

		if ((server_name = System.getProperty("SERVER_NAME")) != null && (server_port = System.getProperty("SERVER_PORT")) != null
				&& (path_info = System.getProperty("PATH_INFO")) != null) {
			// Construct a URL for the resource specified...
			filename = "http://" + server_name + ":" + server_port + path_info;

			if ((query_string = System.getProperty("QUERY_STRING")) != null) {
				filename = filename + "?" + query_string;
			}
		} else if (args.length == 1) {
			// Pull the filename from the command-line...
			filename = args[0];
		} else {
			// Error - no args or env variables!
			System.err.print("Usage: htmldoc.class filename\n");
			return;
		}
		// First tell the client that we will be sending PDF...
		System.out.print("Content-type: application/pdf\n\n");

		// Convert the file to PDF and send to the web client...
		topdf(filename);
	}
}
