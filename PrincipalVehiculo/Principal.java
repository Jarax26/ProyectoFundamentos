import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal
{
    public static void main(String[]args) throws FileNotFoundException {
        Principal.mostrarMenu();
    }

    public static void mostrarMenu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("- Ingrese 0 si desea finalizar la ejecución del programa." + "\n"
                    + "- Ingrese 1 para crear un nuevo vehiculo con su modelo, marca, valor comercial y color." + "\n"
                    + "- Ingrese 2 para mostrar los vehiculos almacenados." + "\n"
                    + "- Ingrese 3 para mostrar la cantidad de vehiculos creados." + "\n"
                    + "- Ingrese 4 para mostrar la informacion de vehiculos verdes." + "\n"
                    + "- Ingrese 5 para buscar un vehículo por su id." + "\n"
                    + "- Ingrese 6 para crear un nuevo sensor con su tipo y su valor a un vehículo." + "\n"
                    + "- Ingrese 7 para mostrar los sensores almacenados de un vehículo." + "\n"
                    + "- Ingrese 8 para mostrar la información de todos los sensores de tipo temperatura." + "\n"
                    + "- Ingrese 9 para mostrar la información del vehículo con más sensores." + "\n"
                    + "- Ingrese 10 para importar los vehículos del archivo Vehículos.txt." + "\n"
                    + "- Ingrese 666 para mostrar los sensores tipo 'temperatura' ordenados por valor.");
            int num = sc.nextInt();
            if(num == 0)
            {
                break;
            }
            switch(num){
                case 1:
                    while(true)
                    {
                        if(Vehiculo.posAnadir == 10)
                        {
                            System.out.println("Error, base de datos llena");
                            break;
                        }
                        System.out.println("Ingrese el modelo del vehiculo: ");
                        int modelo = sc.nextInt();
                        System.out.println("Ingrese la marca del vehiculo: ");
                        String marca = sc.next();
                        System.out.println("Ingrese el valor comercial del vehiculo: ");
                        double valorComercial = sc.nextDouble();
                        System.out.println("¿Desea ingresar el color del vehiculo?"+ "\n"
                                + "- Ingrese 'Si' para ingresar un color."+"\n"
                                + "- Ingrese 'No' y el color por defecto será verde.");
                        String siNo = sc.next();
                        if(siNo.equals("Si"))
                        {
                            System.out.println("Ingrese el color del vehiculo: ");
                            String color = sc.next();
                            Vehiculo vehiculo = new Vehiculo(modelo, marca, valorComercial, color);
                        }else if(siNo.equals("No"))
                        {
                            Vehiculo vehiculo = new Vehiculo(modelo, marca, valorComercial);
                        }
                        Vehiculo.posAnadir++;
                        System.out.println("¿Desea ingresar otro vehiculo?"+ "\n"
                                + "- Ingrese 'Si' para crear un nuevo vehiculo."+"\n"
                                + "- Ingrese 'No' para volver al menú.");
                        String siNo2 = sc.next();
                        if(siNo2.equals("Si"))
                        {
                            continue;
                        }else if(siNo2.equals("No"))
                        {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 3:
                    System.out.println("La cantidad de vehículos creados es: " + Vehiculo.cantidadVehiculos());
                    break;
                case 4:
                    for(int i = 0; i<Vehiculo.posAnadir; i++)
                    {
                        if(Vehiculo.vehiculos.get(i).getColor().equals("verde"))
                        {
                            System.out.println(Vehiculo.vehiculos.get(i).toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ingrese id a buscar. ");
                    int idscan = sc.nextInt();
                    if (Vehiculo.obtenerVehiculoPorId(idscan) == null) {
                        System.out.println("No se ha encontrado un vehículo por ese id");
                        break;
                    }
                    else {
                        System.out.println(Vehiculo.obtenerVehiculoPorId(idscan).toString());
                    }
                    break;
                case 6:
                    System.out.println("Ingrese id a buscar. ");
                    int idscan2 = sc.nextInt();
                    if (Vehiculo.obtenerVehiculoPorId(idscan2) == null) {
                        System.out.println("No se ha encontrado un vehículo por ese id");
                        break;
                    }
                    else {
                        System.out.println("Ingrese tipo de sensor. ");
                        String tipo = sc.next();
                        System.out.println("Ingrese valor del sensor. ");
                        double valor = sc.nextDouble();
                        Sensor sensor = new Sensor(tipo, valor);
                        Vehiculo.obtenerVehiculoPorId(idscan2).anadirSensor(sensor);
                        break;
                    }
                case 7:
                    System.out.println("Ingrese id a buscar");
                    int id7  = sc.nextInt();
                    if (Vehiculo.obtenerVehiculoPorId(id7) == null) {
                        System.out.println("No se ha encontrado ningún vehículo con ese id.");
                    }
                    else {
                        ArrayList<Sensor> arr = Vehiculo.obtenerVehiculoPorId(id7).getSensores();
                        for (Sensor sensor : arr) {
                            System.out.println(sensor.toString());
                        }
                    }
                case 8:
                    System.out.println(Vehiculo.detectorSensoresTemp());
                    break;
                case 9:
                    System.out.println(Vehiculo.mayorSensores());
                    break;
                case 10:
                    Vehiculo.vehiculosTxt();
                    break;
                case 666:
                    System.out.println(Sensor.toStringOrdenarValores());
                    break;
            }
        }
        sc.close();
    }
}
