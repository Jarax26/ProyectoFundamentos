public class BichoNormal extends Bicho{
    public BichoNormal() {
        setSalud(10);
        setId("BN - ");
        setNombre(this.getId() + this.getSalud());
    }

}
