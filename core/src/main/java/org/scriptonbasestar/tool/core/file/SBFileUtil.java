package org.scriptonbasestar.tool.core.file;

import org.scriptonbasestar.tool.core.reflection.SuperSafeCaller;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2014-09-15-16
 */
public class SBFileUtil {

	public static boolean copyFile(String sourcePath, String destinationPath) {
		boolean result = false;
		try {
			result = copyFile(new FileInputStream(sourcePath), new FileOutputStream(destinationPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean copyFile(FileInputStream inputStream, FileOutputStream outputStream) {
		boolean result = false;

		FileChannel inputChannel = inputStream.getChannel();
		FileChannel outputChannel = outputStream.getChannel();

		long size = 0;
		try {
			size = inputChannel.size();
			inputChannel.transferTo(0, size, outputChannel);

//			outputChannel.close();
//			inputChannel.close();
//			outputStream.close();
//			inputStream.close();

			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		} finally {
			SuperSafeCaller.callNoParams(outputChannel, "close");
			SuperSafeCaller.callNoParams(inputChannel, "close");
			SuperSafeCaller.callNoParams(outputStream, "close");
			SuperSafeCaller.callNoParams(inputStream, "close");
		}
		return result;
	}

	public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {
		boolean result = false;

		try {
			long nread = 0L;
			byte buffer[] = new byte[1024];
			int read;
			while ((read = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, read);
				nread += read;
			}
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		} finally {
			SuperSafeCaller.callNoParams(outputStream, "close");
			SuperSafeCaller.callNoParams(inputStream, "close");
		}
		return result;
	}

}
