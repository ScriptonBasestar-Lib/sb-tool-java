package org.scriptonbasestar.tool.core.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author archmagece
 * @date 2015-12-09
 */
public class FileMergeUtil {

	public static final String fileSeparator = File.separator;
	public static final String lineSeparator = System.lineSeparator();

	public static String path(String... paths) {
		List<String> pathList = new LinkedList<>();
		for (String path1 : paths) {
			for (String path2 : path1.split(fileSeparator)) {
				pathList.add(path2);
			}
			pathList.add(path1);
		}
		StringBuilder sb = new StringBuilder(fileSeparator);
		for (String path0 : pathList) {
			sb.append(path0).append(fileSeparator);
		}
		return sb.toString();
	}

}
