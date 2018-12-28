package auditLog;

import java.io.Serializable;
import java.util.Vector;

import edu.hm.dako.chat.common.ChatPDU;
import edu.hm.dako.chat.common.ClientConversationStatus;
import edu.hm.dako.chat.common.PduType;

public class AuditLogPDU implements Serializable {


/**
	 * 
	 */
	private static final long serialVersionUID = -3521467652246622773L;

/* Nachrichtenaufbau f�r das Server-Client Protokoll zwischen
 * AuditlogServer (Server) und den ChatServer(Client)
 * 
 */
	//Aufrufen der ProtocollDatei
	public static void main(String[] args) {
		DateiProtocoll test = new DateiProtocoll();
		test.schreiben();
	}
	
	// Kommandos bzw. PDU-Typen
		private PduType pduType;

		// Login-Name des Clients
		private String userName;

		// Name des Clients, von dem ein Event initiiert wurde
		private String eventUserName;
		
		// Nutzdaten (eigentliche Chat-Nachricht in Textform)
		private String message;
		
		// Name des Client-Threads, der den Request absendet
		private String clientThreadName;

		// Name des Threads, der den Request im Server
		private String serverThreadName;
		
		// Fehlercode, derzeit nur 1 Fehlercode definiert
		private int errorCode;
		public final static int NO_ERROR = 0;
		public final static int LOGIN_ERROR = 1;

	public AuditLogPDU() {
		pduType = PduType.UNDEFINED;
		userName = null;
		eventUserName = null;
		message = null;
		clientThreadName = null;
		serverThreadName = null; 
		errorCode = NO_ERROR;
	}

	public PduType getPduType() {
		return pduType;
	}

	public void setPduType(PduType pduType) {
		this.pduType = pduType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEventUserName() {
		return eventUserName;
	}

	public void setEventUserName(String eventUserName) {
		this.eventUserName = eventUserName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getNoError() {
		return NO_ERROR;
	}

	public static int getLoginError() {
		return LOGIN_ERROR;
	}

	public String getClientThreadName() {
		return clientThreadName;
	}

	public void setClientThreadName(String clientThreadName) {
		this.clientThreadName = clientThreadName;
	}

	public String getServerThreadName() {
		return serverThreadName;
	}

	public void setServerThreadName(String serverThreadName) {
		this.serverThreadName = serverThreadName;
	}
	
	public AuditLogPDU(PduType cmd) {
		this.pduType = cmd;
	}

	public AuditLogPDU(PduType cmd, String message) {
		this.pduType = cmd;
		this.message = message;
	}
	
	public String toString() {

		return "\n"
				+ "ChatPdu ****************************************************************************************************"
				+ "\n" + "PduType: " + this.pduType + ", " + "\n" + "userName: " + this.userName
				+ ", " + "\n" + "eventUserName: " + this.eventUserName + ", " + "\n"
				+ "clientThreadName: " + this.clientThreadName + ", " + "\n"
				+ "serverThreadName: " + this.serverThreadName + ", " + "\n" + "errrorCode: "
				+ this.errorCode + "\n"
				+ "**************************************************************************************************** ChatPdu"
				+ "\n";
	}
	
	/*Erzeugen von Event-PDU's??
	*welche Events werden gebraucht?
	*
	*/
	
	
}