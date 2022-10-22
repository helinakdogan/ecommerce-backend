package kodlamaio.northwind.core.utilities.results;

public class DataResult<T> extends Result{

	private T data;
	public DataResult(T data, boolean success, String message) {
		super(success, message); //super() -> base'in constructor'ını çalıştırabilir, tekrar set etmeye gerek yok
		this.data = data;
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
	
	//data bilgisi için getter
	public T getData() {
		return this.data;
	}

}
