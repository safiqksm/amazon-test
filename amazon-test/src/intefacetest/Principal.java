package intefacetest;

public class Principal {
	public static void main(String[] args) {
		AcaoAnimal acaoAnimal = new AcaoAnimal();
		
		acaoAnimal.usaVelocidade(new Cachorro());
		acaoAnimal.usaVelocidade(new Leopardo());
		acaoAnimal.usaVelocidade(new Gato());
	} 
}
