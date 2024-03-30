package connectionjavaarduino;

import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ConnectionJavaArduino {

    public static void main(String[] args) throws IOException, InterruptedException {
        SerialPort sp = SerialPort.getCommPort("COM4");
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        
        if(!sp.openPort()){
            System.out.println("\nPuerto COM no disponible\n");
            return;
        }//Fin if
        
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("\nIngrese un numero(Ingrese 0 para salir)");
            Integer blinks = input.nextInt();
            if (blinks == 0) break;
            Thread.sleep(1500);
            sp.getOutputStream().write(blinks.byteValue());
        }//Fin while
        
    }//Fin main
    
}//Fin class ConnectionJavaArduino
