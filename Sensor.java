public class Sensor
{
    public static Sensor [] sensores = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;
    private String tipo;
    private double valor;
    
    public Sensor()
    {
    
    }
    
    public Sensor(String t, double v)
    {
        this.tipo = t;
        this.valor = v;
    }
    
    public void setTipo(String t)
    {
        this.tipo = t;
    }
    
    public String getTipo()
    {
        return this.tipo;
    }
    
    public void setValor(double v)
    {
        this.valor = v;
    }
    
    public double getValor()
    {
        return this.valor;
    }
    
    public String toString()
    {
        return "Sensor -- Tipo " + this.tipo + " y valor de " + this.valor;
    }
    
    public static String toStringSensores()
    {
        String texto = "";
        String texto1 = "";
        for(int i = 0; i<Sensor.posAnadir; i++)
        {
            texto = sensores[i].toString().concat("\n");
            texto1 = texto1.concat(texto);
        }
        return texto;
    }
    
    public static int cantidadSensores()
    {
        return posAnadir;
    }
    
    /*public static Sensor [] ordenarValores(Sensor[]desordenado)
    {
        Sensor [] ordenado = new Sensor[desordenado.length];
        for(int i = 0; i<desordenado.length; i++)
        {
            
        }
    }*/
}
