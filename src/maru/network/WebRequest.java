package maru.network;

public class WebRequest {
	public static final int GET = 0;
	public static final int POST = 1;
	
	private String url;
	
	public WebRequest(String url) {
		this.url = url;
	}
	
	public String request(int type, String data) {
		return null;
	}
}
