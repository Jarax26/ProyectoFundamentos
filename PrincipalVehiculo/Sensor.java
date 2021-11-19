import java.util.ArrayList;

public class Sensor
{
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


    public static String toStringOrdenarValores()
    {
        ArrayList<Sensor> ord = new ArrayList<>();

        for (int i = 0; i < Vehiculo.vehiculos.size(); i++) {
            for (int j = 0; j < Vehiculo.vehiculos.get(i).getSensores().size(); j++) {
                if (Vehiculo.vehiculos.get(i).getSensores().get(j).getTipo().equals("temperatura")) {
                    ord.add(Vehiculo.vehiculos.get(i).getSensores().get(j));
                }
            }
        }
        int x = -1;
        double temp;
        for (int i = 0; i < ord.size()-1; i++)
        {
            for (int j = i + 1; j < ord.size(); j++)
            {
                if (ord.get(j).getValor() < ord.get(i).getValor())
                {
                    temp = ord.get(i).getValor();
                    ord.get(i).setValor(ord.get(j).getValor());
                    ord.get(j).setValor(temp);
                }
            }
        }
        String texto = "";
        String texto1 = "";
        for(int i = 0; i<ord.size(); i++)
        {
            if(i == ord.size()-1){
                texto = ord.get(i).toString();
                texto1 = texto1.concat(texto);
            }else{
                texto = ord.get(i).toString().concat("\n");
                texto1 = texto1.concat(texto);
            }
        }
        return texto1;
    }
}
