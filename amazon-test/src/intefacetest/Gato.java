package intefacetest;

public class Gato implements Veloz {

	@Override
	public void correRapido() {
		System.out.println("O gato usa sua velocidade");
	}
	
	public void mia() {
		System.out.println("miau");
	}
	
}
