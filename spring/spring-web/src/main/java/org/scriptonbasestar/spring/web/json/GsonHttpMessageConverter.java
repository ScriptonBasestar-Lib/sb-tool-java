package org.scriptonbasestar.spring.web.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.scriptonbasestar.tool.transfer.wrapper.SBListResponseWrapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * @author archmagece
 * @since 2015-06-12-10
 */
public class GsonHttpMessageConverter<RES extends Serializable> extends AbstractHttpMessageConverter<RES> {

	private Gson gson = new Gson();

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public GsonHttpMessageConverter(){
		super(new MediaType("application", "json", DEFAULT_CHARSET));
	}

	@Override
	protected RES readInternal(Class<? extends RES> clazz,
								  HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

		Type listType = new TypeToken<SBListResponseWrapper<RES>>(){}.getType();
//		StringBuilder sb = new StringBuilder();
//		byte[] b = new byte[4096];
//		for (int n; (n = inputMessage.getBody().read(b)) != -1;) {
//			sb.append(new String(b, 0, n));
//		}
//		String sss = sb.toString();
		try{
			RES obj = gson.fromJson(convertStreamToString(inputMessage.getBody()), listType);
			return obj;
		}catch(JsonSyntaxException e){
			throw new HttpMessageNotReadableException("Could not read JSON: " + e.getMessage(), e);
		}

	}

	@Override
	protected boolean supports(Class<?> clazz) {
		if(SBListResponseWrapper.class == clazz){
			return true;
		}
		return false;
	}

	@Override
	protected void writeInternal(RES t, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		String json = gson.toJson(t);

		outputMessage.getBody().write(json.getBytes());
	}

	public String convertStreamToString(InputStream is) throws IOException {
        /*
         * To convert the InputStream to String we use the Reader.read(char[]
         * buffer) method. We iterate until the Reader return -1 which means
         * there's no more data to read. We use the StringWriter class to
         * produce the string.
         */
		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

}