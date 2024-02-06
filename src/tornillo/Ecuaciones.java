/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tornillo;

import javax.swing.JOptionPane;

/**
 *
 * @author yeiso
 */
public class Ecuaciones {
    
    String ND1,M1;
      
    
    public static String[] engranaje(double ND,double M){ 
       
        double  DP,DE,H,H1=2.167;
        
        DP=(ND*M);
        DE=(DP+(2*M));
        H=(H1*M);
        //se reduce el numero de decimales de la variable h y se convierten a cadenas de texto las variables 
        String HFormateado = Utilidades.formatearNumero(H),
               DP1 = String.valueOf(DP),
               DE1 = String.valueOf(DE);
        return new String[]{HFormateado, DP1, DE1};
    }
    
    public static  String[] HELICOIDALES(Double MR3,Double Z3, Double A3){
    
         double A4,MA,Dp,De,ZI,PH,H1=2.167,H;        
     // se convierten las variables para su verificacion

            // se conviernten los grados a radianes
             A4 = Math.toRadians(A3);
            //operacion para encontrar el modulo aparente 
             MA = MR3/Math.cos(A4);
            //operacion de diametro primitivo
             Dp = MA* Z3;
            //operacion diametro exterior 
            De = Dp + (2*MR3);
            //operacion de altura 
            H = H1 * MR3; 
            //operacion de numero de dientes imaginarios 
            ZI = Z3 / Math.pow(Math.cos(A4),3);
            //operacion paso de helice 
            PH = Math.PI * Dp / Math.tan(A4);
            // se pasan las variables a cadenas de texto 
          String HMA1 = Utilidades.formatearNumero(MA),
                 HDP1 = Utilidades.formatearNumero(Dp),
                 HDE1 = Utilidades.formatearNumero(De),
                 HH1 = Utilidades.formatearNumero(H),
                 HZI1 = Utilidades.formatearNumero(ZI),
                 HPH1 = Utilidades.formatearNumero(PH);
          
          return new String[]{HMA1, HDP1, HDE1, HH1, HZI1, HPH1};
  
    }
    
    public static String[] Conicos(Double MC,Double LC,Double AC,Double ZC ){
     
        double Dpc,Demc,A1,Dimc,G,B,B2,AIDD,H,de,ZI;
        int inclinacionGrados2 = 0;
        A1 = Math.toRadians(AC);
       int A2 = (int) Math.toDegrees(A1);
        
        Dpc = MC*ZC;
        
        Demc = Dpc +(2*MC*(Math.cos(A1)));
        
        Dimc = Dpc - (1.157*2*MC*(Math.cos(A1)));
        
        G = Dpc/(2*(Math.sin(A1)));
        //Ángulo correspondiente al módulo (β)
        B = Math.toDegrees(Math.atan(MC/G));
        //operaciones matematicas para sacar los minutos del angulo obtenido
        int grados1 = (int) B;
        double minutosDecimales = (B - grados1) * 60;
        int minutos = (int) minutosDecimales;
        //Ángulo correspondiente al fondo del juego del dentado  (β’)
        B2 = Math.toDegrees(Math.atan(0.157*(MC/G)));
        //operaciones matematicas para sacar los minutos del angulo obtenido
        int grados2 = (int) B2;
        double minutosDecimales2 = (B2 - grados2) * 60;
        int minutos2 = (int) minutosDecimales2;
        //calculos angulo de inclinacion del divisor
        int AIDD2 = (A2*60) - ((grados1 * 60) + minutos + (grados2 * 60) + minutos2);
        int Grados3 = AIDD2/60;
        int Minutos3 = Math.abs(AIDD2 % 60);
        
        //Semiángulo del cono exterior (Δ)
        int tri = (A2*60) + ((grados1 * 60) + minutos);
        int grados_tri = tri/60;
        int minutos_tri = Math.abs(tri % 60);
        // Altura del diente en el diámetro exterior
        H = 2.167 * MC;
        //Diámetro exterior menor
        de = Demc*((G-LC)/G);
         //Número de dientes imaginarios para el cortador
         ZI = ZC / Math.cos(A1);
         
         // creacion de strings para ser enviados en el array 
        String Dpc1 = Utilidades.formatearNumero(Dpc),
               Demc1 = Utilidades.formatearNumero(Demc),
               Dimc1 = Utilidades.formatearNumero(Dimc),
               G1 = Utilidades.formatearNumero(G),
               //grados y minutos correspondiente al módulo
               gradosB1 = Utilidades.formatearNumero(grados1),
               minutosB1 = Utilidades.formatearNumero(minutos),  
               Bc1 = gradosB1 + "°" + minutosB1 + "'", 
                //grados y minutos correspondiente al  al fondo del juego del dentado
               gradosB2 = Utilidades.formatearNumero(grados2),
               minutosB2 = Utilidades.formatearNumero(minutos2), 
               Bc2 = gradosB2 + "°" + minutosB2 + "'",
               // angulo de inclinacion del divisor
               GradosAIDD3 = Utilidades.formatearNumero(Grados3),
               MinutosAIDD3 = Utilidades.formatearNumero(Minutos3),
               Bc3 = GradosAIDD3 + "°" + MinutosAIDD3 + "'", 
               //angulo de inclinacion del divisor
               grados_tri1 = Utilidades.formatearNumero(grados_tri),
               minutos_tri1 = Utilidades.formatearNumero(minutos_tri),
               Bc4 = grados_tri1 + "°" + minutos_tri1 + "'",
                // 
               H1 = Utilidades.formatearNumero(H),
               de1 = Utilidades.formatearNumero(de),
               ZI1 = Utilidades.formatearNumero(ZI);
                
        return new String[]{Dpc1,Demc1,Dimc1,G1,Bc1,Bc2,Bc3,Bc4,H1,de1,ZI1};
    }
}
 

    

    