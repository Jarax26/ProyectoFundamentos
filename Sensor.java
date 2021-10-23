public class Sensor
{
    public static Sensor [] sensores = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;
    public static int cantSensorTemp = 0;
    private String tipo;
    private double valor;
    
    public Sensor()
    {
    
    }
    
    public Sensor(String t, double v)
    {
        this.tipo = t;
        this.valor = v;
        if(t.equals("temperatura"))
        {
            cantSensorTemp++;
        }
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
            if(i == Sensor.posAnadir-1){
                texto = sensores[i].toString();
                texto1 = texto1.concat(texto);
            }else{
                texto = sensores[i].toString().concat("\n");
                texto1 = texto1.concat(texto);
            }
        }
        return texto1;
    }
    
    public static int cantidadSensores()
    {
        return posAnadir;
    }
    
    public static Sensor [] ordenarValores(Sensor[]desord)
    {    
        Sensor[]ord = new Sensor[Sensor.cantSensorTemp];
        for(int i = 0; i<ord.length; i++)
        {
            for(int j = 0; j<desord.length;j++)
            {
                if(desord[j].getTipo().equals("temperatura"))
                {
                    ord[i].setTipo(desord[j].getTipo());
                    ord[i].setValor(desord[j].getValor());
                }else{
                    continue;
                }
            }
        }
        for (int i = 0; i < ord.length; i++)
        {
            for (int j = 0; j < ord.length-1; j++)
            {
                if (ord[j].getValor() > ord[j + 1].getValor())
                {
                    double temp = ord[j + 1].getValor();
                    ord[j + 1].setValor(ord[j].getValor());
                    ord[j].setValor(temp);
                }
            }
        }
        return ord;
    }
}
