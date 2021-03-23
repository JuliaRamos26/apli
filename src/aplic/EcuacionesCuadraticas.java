package aplic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Julia Ramos Lopez
 */
public class EcuacionesCuadraticas extends JFrame {
    private JLabel a, b, c;
    private JTextField at,bt,ct,x1,x2;
    private JLabel xOne, xTwo;
    private JButton boton;

      public EcuacionesCuadraticas(){
         setTitle("Ecuaciones Cuadraticas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(true);
       Componentes();
}

    private void Componentes() {
      JPanel panel = new JPanel ();
panel.setLayout(null);
     this.getContentPane().add(panel);
     
        a = new JLabel ();
        a.setText("a");
        a.setBounds(10,10,50,30);
        panel.add(a);
        
      
        at = new JTextField();
         at.setBounds(30,10,60,30) ;
        panel.add(at);
        
              b =new JLabel ("B");
        b.setBounds(110,10,120,30);
        panel.add(b);
        
         bt = new JTextField();
         bt.setBounds(130,10,60,30) ;
        panel.add(bt);
        
          c =new JLabel ("C");
        c.setBounds(200,10,120,30);
        panel.add(c);
        
         ct = new JTextField();
         ct.setBounds(220,10,60,30) ;
        panel.add(ct);
        
        
 boton = new JButton ("Solucionar");
 boton.setBounds (100,70,110,50);
panel.add(boton);

       xOne=new JLabel ("x1");
        xOne.setBounds(60,140,120,30);
        panel.add(xOne);
               JTextField   Respuesta1 = new JTextField();
         Respuesta1.setBounds(90,140,60,30) ;
        panel.add(Respuesta1);

   xTwo =new JLabel ("x2");
        xTwo.setBounds(180,140,120,30);
        panel.add(xTwo);
        
   x1 = new JTextField();
         x1.setBounds(210,140,60,30) ;
        panel.add(x1);
              
        boton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptarActionPerformed(e);
            }
private void aceptarActionPerformed(ActionEvent e) {
                DecimalFormat formatonumero = new DecimalFormat("####.###"); 
                      try {                                                                 //try-catch             

                        double a1, b1, c1, primerR, segundaR, denominador, primeraX = 0, segundaX = 0;

                    a1 = Double.parseDouble(at.getText());
                    b1 = Double.parseDouble(bt.getText());
                    c1 = Double.parseDouble(ct.getText());

                    //Sacando la raiz de 4ac
                    primerR = (4 * a1 * c1);
                    //Sacando la b elevado al cuadrado
                    segundaR = ((b1 * b1) - (primerR));
                    //Denominador
                    denominador = ((2) * (a1));

                    //Si es mayor a cero
                    if (segundaR > 0) {
                        //primeraX guarda el resulatado
                        primeraX = ((-1 * b1) + Math.sqrt(segundaR)) / denominador;
                        //A primeraX se le da el formato que queremos, luego valueOf lo convierte a String y lo guarda en la variable
                        //Cadena
                        String cadena1 = String.valueOf(formatonumero.format(primeraX));
                        x1.setText(cadena1);

                        segundaX = ((-1 * b1) - Math.sqrt(segundaR)) / denominador;
                        String cadena2 = String.valueOf(formatonumero.format(segundaX));
                        x2.setText(cadena2);

                    }
                    //Numero imaginario, no tiene raiz en los numeros reales
                    else{
                        x1.setText((-1*b1)+"+"+"√"+segundaR+"i"+"/"+(2*a1)); // si es un numero imaginario
                        x2.setText((-1*b1)+"-"+"√"+segundaR+"i"+"/"+(2*a1));
                    }

                } catch (NumberFormatException evento) {
                    x1.setText("Error");
                    x2.setText("Error");
                }
            }

        
                
                });
    }
}

