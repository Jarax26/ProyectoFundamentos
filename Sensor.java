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
            Sensor.cantSensorTemp+=1;
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
                texto = Sensor.sensores[i].toString();
                texto1 = texto1.concat(texto);
            }else{
                texto = Sensor.sensores[i].toString().concat("\n");
                texto1 = texto1.concat(texto);
            }
        }
        return texto1;
    }

    public static int cantidadSensores()
    {
        return Sensor.posAnadir;
    }

    public static String toStringOrdenarValores()
    {
        Sensor[]ord = new Sensor[cantSensorTemp];
        int x = -1;
        for(int i = 0; i<ord.length; i++){
            while(x<Sensor.posAnadir){
                x++;
                if(sensores[x].getTipo().equals("temperatura"))
                {
                    ord[i]  = new Sensor(sensores[x].getTipo(), sensores[x].getValor());
                    break;
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
