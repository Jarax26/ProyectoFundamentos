public class BichoAlien extends Bicho{
    public BichoAlien() {
        setSalud(20);
        setId("BA - ");
        setNombre(this.getId() + this.getSalud());
    }
    
}
