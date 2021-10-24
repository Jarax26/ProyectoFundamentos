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
            cantSensorTemp+=1;
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
    
    public static String toStringOrdenarValores()
    {    
        Sensor[]ord = new Sensor[cantSensorTemp];
        for(int i = 0; i<Sensor.posAnadir; i++){
            for(int j = 0; j<ord.length;j++)
            {
                if(sensores[i].getTipo().equals("temperatura"))
                {
                    ord[j] = new Sensor(sensores[i].getTipo(),sensores[i].getValor());
                }
            }
        }
        double temp;
        for (int i = 0; i < ord.length-1; i++)
        {
            for (int j = i + 1; j < ord.length; j++)
            {
                if (ord[j].getValor() < ord[i].getValor())
                {
                    temp = ord[i].getValor();
                    ord[i].setValor(ord[j].getValor());
                    ord[j].setValor(temp);
                }
            }
        }
        String texto = "";
        String texto1 = "";
        for(int i = 0; i<ord.length; i++)
        {
            if(i == ord.length-1){
                texto = ord[i].toString();
                texto1 = texto1.concat(texto);
            }else{
                texto = ord[i].toString().concat("\n");
                texto1 = texto1.concat(texto);
            }
        }
        return texto1;
    }
}
