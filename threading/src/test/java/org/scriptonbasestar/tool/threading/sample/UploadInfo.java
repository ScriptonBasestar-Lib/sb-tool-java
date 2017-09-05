package org.scriptonbasestar.tool.threading.sample;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;

@Data
@AllArgsConstructor
public class UploadInfo {
	private File localFile;
	private String remotePath;
}