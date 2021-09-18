package controle;


public class Main {

	private Main(){
		ControladorPrincipal.getInstance();
		
	}

	public static void main(String[] args) {
		
		new Main();

	}

}
