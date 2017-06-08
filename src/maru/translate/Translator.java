package maru.translate;

import java.io.IOException;
import java.net.MalformedURLException;

import maru.network.WebRequest;

public class Translator {
	public static String translate(String src) {
		String result = null;
		try {
			WebRequest request = new WebRequest("https://translate.google.com/translate_a/single");
			result = request.request(WebRequest.GET,"client=t&sl=ko&tl=en&hl=ko&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=t&ie=UTF-8&oe=UTF-8&source=btn&ssel=0&tsel=0&kc=0&tk=838310.692962&q=" + toHex(src));			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static String toHex(String src) {
		StringBuffer buf = new StringBuffer();
		for (char ch : src.toCharArray()) {
			buf.append(String.format("%%%x", (int)ch));
		}
		return buf.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Translator.translate("안녕하세요"));
	}
}
