package edu.hm.dako.chat.tcp;

import java.io.IOException;
import java.net.BindException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.chat.connection.Connection;

public class TcpServerSocketAudit {
	private static java.net.ServerSocket serverSocket;
	private static Log log = LogFactory.getLog(TcpServerSocketAudit.class);
	// TEST
		public TcpServerSocketAudit(int port) throws BindException, IOException{
			try {
				serverSocket = new java.net.ServerSocket(port);
			} catch (BindException e) { 
				log.debug(
						"Port " + port + " auf dem Rechner schon in Benutzung, Bind Exception: " + e);
				throw e;
			} catch (IOException e) {
				log.debug("Schwerwiegender Fehler beim Anlegen eines TCP-Sockets mit Portnummer "
						+ port + ": " + e);
				throw e;
			}
		}
		
		public Connection accept() throws IOException {
			return new TcpConnectionAudit(serverSocket.accept());
		}
		public void close() throws IOException {
			log.debug(
					"Serversocket wird geschlossen, lokaler Port: " + serverSocket.getLocalPort());
			serverSocket.close();
		}

		public boolean isClosed() {
			return serverSocket.isClosed();
		}
}