package intefacetest;

public class Cachorro implements Veloz {

	@Override
	public void correRapido() {
		System.out.println("O cachorro usa sua velocidade.");
	}
	
	public void late() {
		System.out.println("Au au");
	}

}
