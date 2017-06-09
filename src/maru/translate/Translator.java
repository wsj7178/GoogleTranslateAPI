package maru.translate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

import maru.network.WebRequest;

public class Translator {
	public static String translate(String src, String tl) {
		String result = null;
		try {
			WebRequest request = new WebRequest("https://translate.google.com/translate_a/single");
			
			//token https://github.com/matheuss/google-translate-token/
			//https://github.com/yjulm/GoogleTranslate-Token-NET/blob/master/GoogleTranslate/GoogleTranslateToken/Token.cs
			//또는 https://translate.google.com 으로 바로 요청
			result = request.request(WebRequest.GET,"client=t&sl=auto&tl=" + tl + "&hl=ko&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=t&ie=UTF-8&oe=UTF-8&source=btn&ssel=3&tsel=0&kc=0&tk=131109.284791&q=" + URLEncoder.encode(src, "utf-8"));			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Translator.translate("my name is we", "ko"));
	}
}
