import java.util.ArrayList;

public class Vehiculo
{
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();

    public ArrayList<Sensor> getSensores() {
        return this.sensores;
    }

    public void setSensores(ArrayList<Sensor> sensores) {
        this.sensores = sensores;
    }

    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual = 1;
    private int id;
    public static int tamano = 10;
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo()
    {
        this.id = idActual;
        idActual++;
        Vehiculo.vehiculos.add(this);
    }

    public Vehiculo(int mo, String ma, double vC)
    {
        new Vehiculo(mo, ma, vC, "verde");
    }

    public Vehiculo(int mo, String ma, double vC, String co)
    {
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = vC;
        this.color = co;
        this.id = idActual;
        idActual++;
        Vehiculo.vehiculos.add(this);
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
        StringBuilder text = new StringBuilder();
        for (Sensor sensor: this.getSensores()) {
            text.append(sensor.toString() + " ");
        }
        return "Vehiculo -- Modelo " + this.modelo + ", de marca " +this.marca + ", color " + this.color + ", con valor de "
                + this.valorComercial + " id de: " + id  + " Sensores: " + text;

    }

    public static String toStringVehiculos()
    {
        String texto = "";
        String texto1 = "";
        for (Vehiculo vehiculo : Vehiculo.vehiculos) {
            texto = vehiculo.toString().concat("\n");
            texto1 = texto1.concat(texto);
        }
        return texto1;
    }

    public static int cantidadVehiculos()
    {
        return vehiculos.size();
    }

    public void anadirSensor(Sensor s) {
        this.sensores.add(s);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Vehiculo obtenerVehiculoPorId(int id) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId() == id) {
                return vehiculos.get(i);
            }
        }
        return null;
    }

    public static String detectorSensoresTemp() {
        String ans = "";
        for (int i = 0; i < vehiculos.size(); i++) {
            for (int j = 0; j < vehiculos.get(i).getSensores().size(); j++) {
                if (vehiculos.get(i).getSensores().get(j).getTipo().equals("temperatura")) {
                    ans += vehiculos.get(i).getSensores().get(j).toString() + "\n";
                }
            }
        }
        return ans;
    }

    public static String mayorSensores() {
        int mayor = vehiculos.get(0).getSensores().size();
        String infmayor = vehiculos.get(0).toString();
        for (int x = 0; x < vehiculos.size(); x++) {
            if(vehiculos.get(x).getSensores().size() > mayor) {
                    infmayor = vehiculos.get(x).toString();
            }
        }
        return infmayor;
    }
}
