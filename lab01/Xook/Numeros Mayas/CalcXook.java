    import java.awt.Component;
    import java.awt.Graphics;
    import java.awt.Image;
    import javax.swing.Icon;
    import javax.swing.ImageIcon;
    import java.util.ArrayList;
    import javax.swing.JOptionPane;
    import java.lang.Math;
    
    /**
     * Calculadora en numeracion maya (resta, suma, division, 
     * multiplicacion y factorial)
     *
     * @author Javier Esteban López Peña
     * @version 1.0 01/29/2020
     */
    public class CalcXook
    {
        // instance variables - replace the example below with your own
        private ArrayList<Xook> stack;
        private String color="black";
        private int number;
        private int contHorizontal=0;
        private Xook a;
        private Xook b;
        public Boolean ModoEstudio=false;
        private int fact;
    
        /**
         * Constructor for objects of class CalcXook
         */
        public CalcXook()
        {
            
            JOptionPane.showMessageDialog(null, 
            "Bienvenido a la calculadora en numeración maya", "Tutorial", 
            JOptionPane.DEFAULT_OPTION, null);
            
            color = JOptionPane.showInputDialog(null, "Colores disponibles: red - yellow - blue - green - magenta - black.", "Seleccione Color");
            
            JOptionPane.showMessageDialog(null, 
            "Introduzca los numeros en entero con el metodo addInteger() y apareceran en numeracion maya de izquierda a derecha del canvas", "Tutorial", 
            JOptionPane.DEFAULT_OPTION, null);
            
            JOptionPane.showMessageDialog(null, 
            "Cuando tenga una pila hecha use los metodos suma(), resta(), multiplicacion() y division() y los numeros se iran operando de a dos, de derecha a izquierda", "Tutorial", 
            JOptionPane.DEFAULT_OPTION, null);
            
            JOptionPane.showMessageDialog(null, 
            "No se puede representar en maya los numeros negativos y en la division tomara el piso del numero si el resultado es flotante", "Tener en cuenta", 
            JOptionPane.DEFAULT_OPTION, null);
            
            JOptionPane.showMessageDialog(null, 
            "Realizado por: Javier Esteban López Peña. Lab01 POOB", "Creditos", 
            JOptionPane.DEFAULT_OPTION, null);
            // initialise instance variables
            stack = new ArrayList<Xook>();
        }
        
         /**
         * @return ModoEstudio booleano que dice si esta activado el modoEstudio
         */
        public Boolean modoEstudio()
        {
            return ModoEstudio;
        }
        
        /**
         * Activa el modo estudio, conviertiendo en true ModoEstudio
         */
        public void activarModoEstudio()
        {
            JOptionPane.showMessageDialog(null, 
            "Debera, antes de que la calculadora de respuesta, dar una respuesta que sera comparada por la calculadora", "Modo Estudio", 
            JOptionPane.DEFAULT_OPTION, null);   
            ModoEstudio=true;     
        }
        
         /**
         * Desactiva el modo estudio, conviertiendo en false ModoEstudio
         */
        public void desactivarModoEstudio()
        {
            JOptionPane.showMessageDialog(null, 
            "Modo Estudio desactivado", "Modo Estudio", 
            JOptionPane.DEFAULT_OPTION, null);   
            ModoEstudio=false;     
        }
    
        /**
         * Entra un entero para pintarlo sobre el canvas y ponerlo en la pila
         *
         * @param number es un entero  
         */
        
        public void addInteger(int number)
        {              
            Xook c=new Xook(number, color);
            stack.add(c);
            stack.get(stack.size()-1).makeVisible();
            stack.get(stack.size()-1).moveHorizontal(contHorizontal);
            contHorizontal+=100;                    
        }
        
        /*private void draw()
        {      
            contHorizontal=0;
            for (int i=0 ; i<stack.size() ; i++)
            {                        
                stack.get(i).makeVisible();
                stack.get(i).moveHorizontal(contHorizontal);
                contHorizontal+=100;
            }
        }
        
        public void erase()
        {           
            for (int j=stack.size()-1 ; j>=0 ; j--)
            {      
                System.out.println(j);
                stack.get(j).makeInvisible();
            }
        }*/
           
        private Xook popMaya()
        {
            stack.get(stack.size()-1).makeInvisible();
            return stack.remove(stack.size()-1);
        }
        
        /**
         * Realiza la suma de el primer numero en la pila
         */
        public void Suma()
        {
            Xook c;
            if(stack.size()>=2)
            {
                //System.out.println(stack);
                //pop();            
                contHorizontal-=200;
                a = popMaya();
                b = popMaya();
                if (ModoEstudio)
                {
                    String res = JOptionPane.showInputDialog(null, "¿Cual es el resultado?", "0");
                    int numEntero=a.getValue()+b.getValue();
                    if (numEntero == Integer.parseInt(res))
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Correcto", "¡Felicidades!", 
                        JOptionPane.DEFAULT_OPTION, null);
                    } else
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Incorrecto", "Sigue intentando", 
                        JOptionPane.DEFAULT_OPTION, null);
                    }
                }
                addInteger(a.getValue()+b.getValue());
                //System.out.println(stack.get(0).getValue());
                //draw();
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "No hay valores para sumar", "No se pudo realizar la suma", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        /**
         * Realiza la resta de el primer numero en la pila
         */
        public void Resta()
        {
            Xook c;
            if(stack.size()>=2)
            {
                //System.out.println(stack);
                //pop();            
                contHorizontal-=200;
                a = popMaya();
                b = popMaya();
                
                if (ModoEstudio)
                {
                    String res = JOptionPane.showInputDialog(null, "¿Cual es el resultado?", "0");
                    int numEntero=b.getValue()-a.getValue();
                    if (numEntero == Integer.parseInt(res))
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Correcto", "¡Felicidades!", 
                        JOptionPane.DEFAULT_OPTION, null);
                    } else
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Incorrecto", "Sigue intentando", 
                        JOptionPane.DEFAULT_OPTION, null);
                    }
                }
                
                if (a.getValue()>b.getValue())
                {
                    JOptionPane.showMessageDialog(null, "No permitidos numeros negativos", "No se pudo realizar la resta", JOptionPane.ERROR_MESSAGE);
                } else 
                {
                    addInteger(b.getValue()-a.getValue());
                    //System.out.println(stack.get(0).getValue());
                }
                //draw();
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "No hay valores para resta", "No se pudo realizar la resta", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        /**
         * Realiza la Multiplicacion de el primer numero en la pila
         */
        public void Multiplicacion()
        {
            Xook c;
            if(stack.size()>=2)
            {
                //System.out.println(stack);
                //pop();            
                contHorizontal-=200;
                a = popMaya();
                b = popMaya();
                if (ModoEstudio)
                {
                    String res = JOptionPane.showInputDialog(null, "¿Cual es el resultado?", "0");
                    int numEntero=a.getValue()*b.getValue();
                    if (numEntero == Integer.parseInt(res))
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Correcto", "¡Felicidades!", 
                        JOptionPane.DEFAULT_OPTION, null);
                    } else
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Incorrecto", "Sigue intentando", 
                        JOptionPane.DEFAULT_OPTION, null);
                    }
                }
                addInteger(a.getValue()*b.getValue());
                //System.out.println(stack.get(0).getValue());
                //draw();
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "No hay valores para multiplicar", "No se pudo realizar la multiplicacion", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        /**
         * Realiza la division de el primer numero en la pila
         */
        public void Division()
        {
            Xook c;
            if(stack.size()>=2)
            {
                //System.out.println(stack);
                //pop();            
                contHorizontal-=200;
                a = popMaya();
                b = popMaya();
                
                if (ModoEstudio)
                {
                    String res = JOptionPane.showInputDialog(null, "¿Cual es el resultado?", "0");
                    int numEntero=b.getValue()/a.getValue();
                    if (numEntero == Integer.parseInt(res))
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Correcto", "¡Felicidades!", 
                        JOptionPane.DEFAULT_OPTION, null);
                    } else
                    {
                        JOptionPane.showMessageDialog(null, 
                        "Incorrecto", "Sigue intentando", 
                        JOptionPane.DEFAULT_OPTION, null);
                    }
                }
                
                addInteger(b.getValue()/a.getValue());
                //System.out.println(stack.get(0).getValue());
                //draw();
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "No hay valores para división", "No se pudo realizar la division", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        /**
         * Realiza el factorial de el primer numero en la pila
         */
        public void Factorial()
        {
            //int numEntero;
            int fact =1;
            Xook c;
            if(stack.size()>=1)
            {
                //System.out.println(stack);
                //pop();            
                contHorizontal-=100;
                a = popMaya();                
                for (int i=0; i<a.getValue(); i++)
                {
                    fact= fact*(a.getValue()-i);
                }
                System.out.println(fact);
                addInteger(fact);
                //System.out.println(stack.get(0).getValue());
                //draw();
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "No hay valores para Factorial", "No se pudo realizar el Factorial", JOptionPane.ERROR_MESSAGE);
            }
    }
}
