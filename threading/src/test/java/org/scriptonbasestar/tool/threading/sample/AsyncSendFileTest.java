package org.scriptonbasestar.tool.threading.sample;

import org.scriptonbasestar.tool.threading.AsyncTaskManager;

import java.io.File;

/**
 * @author archmagece
 * @with beansugar-sso-parent
 * @since 2014-11-27-19
 */
public class AsyncSendFileTest {

	private static String server = "ftp server address";
	private static int port = 21;
	private static String username = "ftp username";
	private static String password = "ftp password";

	public static void main(String ... p){
		AsyncTaskManager<UploadInfo, Boolean> manager = new AsyncTaskManager<UploadInfo, Boolean>(new AsyncSendFile(server, port, username, password), 1);
		for(int i=0;i<5;i++){
			System.out.println("포"+i);
			File file = new File("/home/busking/aa"+i+".png");
			System.out.println(file.toString());
			System.out.println(file.getName());
			manager.execute(new UploadInfo(file, "/web/"+file.getName()));
		}
	}
}
