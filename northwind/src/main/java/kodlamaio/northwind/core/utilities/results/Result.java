package kodlamaio.northwind.core.utilities.results;

public class Result {

	private boolean success;  //işlem başarılı mı
	private String message;   //işlem sonuç durumu mesajı

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}
	
	//getters for both
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
