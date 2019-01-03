package auditLog;

import java.io.*;
import java.util.*;

import edu.hm.dako.chat.common.PduType;

import java.text.*;

public class DateiProtocoll {

	public void schreiben(AuditLogPDU pdu) {
		
		FileWriter writer;
		File file;
		
		//File anlegen
		file = new File("FileTest.txt");
		try {
			// falls die Datei bereits existiert werden die Bytes an das Ende der Datei geschrieben
			writer = new FileWriter(file, true);
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			
			//Zeitstemple
			writer.write(dateTimeInstance.format(Calendar.getInstance().getTime())+ "\t");
			
			//text wird in den Stream geschrieben
			writer.write(AuditLogPDU.getPduType()+ "\t");
			//writer.write(System.getProperty("line.separator"));
			
			writer.write(AuditLogPDU.getUserName()+ "\t");
			
			//if bedingungen: wenn das Event eine Message ist, dann auch die Message ausgeben
			if(AuditLogPDU.getPduType().equals(PduType.CHAT_MESSAGE_EVENT)) {
//			if(AuditLogPDU.getPduType() == PduType.CHAT_MESSAGE_REQUEST) {	
				writer.write(pdu.getMessage()+ "\t");
			}
			else {
				writer.write(" "+ "\t");
			}
			
			writer.write("WorkerThreadsID\t");
			
			writer.write("ThreadID\t");
			
			
			//springt in die n�chste Zeile (unabh�ngig vom System)
			//writer.write(System.getProperty("line.separator"));
			
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			
			//schlie�t FileWriter Stream
			writer.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
