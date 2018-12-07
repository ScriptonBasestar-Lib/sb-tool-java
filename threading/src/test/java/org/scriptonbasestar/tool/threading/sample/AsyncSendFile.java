package org.scriptonbasestar.tool.threading.sample;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.scriptonbasestar.tool.threading.IAsyncExecuteMethod;

import java.io.*;

/**
 * @author archmagece
 * @with beansugar-sso-parent
 * @since 2014-11-27-11
 * FIXME thread safe하지 않아서 수정필요.
 */
@Slf4j
public class AsyncSendFile
	implements IAsyncExecuteMethod<UploadInfo, Boolean> {

	private final FTPClient ftp;

	private final String hostname;
	private final int port;
	private final String username;
	private final String password;

	public AsyncSendFile(String hostname, int port, String username, String password) {
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password = password;
		this.ftp = new FTPClient();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		connect();
	}

	@Override
	public void beforeCall(UploadInfo uploadInfo) {

	}

	long keepAliveTimeout = -1;
	int controlKeepAliveReplyTimeout = -1;
	boolean printHash = false;
	boolean hidden = false;

	@Override
	public Boolean call(UploadInfo uploadInfo) {
		while (true) {
			if (!connect()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				continue;
			}

			if (printHash) {
				ftp.setCopyStreamListener(createListener());
			}
			if (keepAliveTimeout >= 0) {
				ftp.setControlKeepAliveTimeout(keepAliveTimeout);
			}
			if (controlKeepAliveReplyTimeout >= 0) {
				ftp.setControlKeepAliveReplyTimeout(controlKeepAliveReplyTimeout);
			}
			ftp.setListHiddenFiles(hidden);

			InputStream input;
			try {
				input = new FileInputStream(uploadInfo.getLocalFile());
				ftp.storeFile(uploadInfo.getRemotePath(), input);
				input.close();

//				for (FTPFile f : ftp.listFiles(uploadInfo.getRemotePath())) {
//					System.out.println(f.getRawListing());
//					System.out.println(f.toFormattedString());
//				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		return false;
	}

	@Override
	public void afterCall(Boolean s) {
	}

	private boolean connect() {
		try {
			if (ftp.isConnected()) {
				return true;
			}

			int reply;
			ftp.connect(hostname, port);
			log.debug("Connected to " + hostname + " on " + (port > 0 ? port : ftp.getDefaultPort()));

			// After connection attempt, you should check the reply code to verify
			// success.
			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				log.error("FTP server refused connection.");
				return false;
			}
			if (!ftp.login(username, password)) {
				ftp.logout();
			}
			// 명령어 보여주는 리스너
			ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
		} catch (IOException e) {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException f) {
					// do nothing
				}
			}
			log.error("Could not connect to server.", e);
//			e.printStackTrace();
			return false;
		}

		return true;
	}

	private static CopyStreamListener createListener() {
		return new CopyStreamListener() {
			private long megsTotal = 0;

			@Override
			public void bytesTransferred(CopyStreamEvent event) {
				bytesTransferred(event.getTotalBytesTransferred(), event.getBytesTransferred(), event.getStreamSize());
			}

			@Override
			public void bytesTransferred(long totalBytesTransferred,
										 int bytesTransferred, long streamSize) {
				long megs = totalBytesTransferred / 1000000;
				for (long l = megsTotal; l < megs; l++) {
					System.err.print("#");
				}
				megsTotal = megs;
			}
		};
	}
}
