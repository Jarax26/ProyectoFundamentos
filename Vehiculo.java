public class Vehiculo
{
    public static Vehiculo [] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    
    public Vehiculo()
    {
        
    }
    
    public Vehiculo(int mo, String ma, double vC)
    {
        this(mo, ma, vC, "verde");
    }
    
    public Vehiculo(int mo, String ma, double vC, String co)
    {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = vC;
        this.color = co;
    }
    
    public void setModelo(int mo)
    {
        this.modelo = mo;
    }
    
    public int getModelo()
    {
        return this.modelo;
    }
    
    public void setMarca(String ma)
    {
        this.marca = ma;
    }
    
    public String getMarca()
    {
        return this.marca;
    }
    
    public void setValorComercial(double vC)
    {
        this.valorComercial = vC;
    }
    
    public double getValorComercial()
    {
        return this.valorComercial;
    }
    
    public void setColor(String co)
    {
        this.color = co;
    }
    
    public String getColor()
    {
        return this.color;
    }
    
    public String toString()
    {
        return "Vehiculo -- Modelo " + this.modelo + ", de marca " +this.marca + ", color " + this.color + " y con valor de " + this.valorComercial;
    }
    
    public static String toStringVehiculos()
    {
        String texto = "";
        String texto1 = "";
        for(int i = 0; i<Vehiculo.posAnadir; i++)
        {
            texto = vehiculos[i].toString().concat("\n");
            texto1 = texto1.concat(texto);
        }
        return texto1;
    }
    
    public static int cantidadVehiculos()
    {
        return posAnadir;
    }
}
