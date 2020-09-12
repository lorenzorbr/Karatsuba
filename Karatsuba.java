import java.lang.Math;

public class Karatsuba{
    public static void main(final String args[]) {
        String x = args[0].toString();
        String y = args[1].toString();
        String res = karatsubaRecursivo(x, y);
        System.out.println(res);
    }

    public static String karatsubaRecursivo(String x, String y){
    if(x.length() != y.length()){
        if(x.length()> y.length()){
            Integer dif = x.length() - y.length();
            for(int i = 0; i < dif ; i++){
                y = "0"+y;
            }
        }else{
            Integer dif = y.length()-x.length();
            for(int i =0 ; i<dif; i++){
                x="0"+x;
            }
        }
    }
     String a = "";
     String b = "";
     String c = "";
     String d = "";
     String e = "";
     String f = "";

    Integer tamx = x.length();
    Integer tamy = y.length();
        if(x.length()==1 && y.length()==1){
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            int z1 = x1 * y1 ;
            String res = Integer.toString(z1);
            return res;
        }

        if(x.length()==2){
            x = "0" + x;
        }

        if(y.length()==2){
            y = "0" + y;
        }
        

        if((x.length()) % 3 == 0){
            Integer div = x.length()/3;
            a = x.substring(0, div);
            b = x.substring(div, div+div);
            c = x.substring(div + div, div+div+div);
        }else if(((x.length() % 3) != 0) && x.length()>3){
            Integer inteiro = x.length()/3;
            Integer resto = x.length() % 3;
            
            a = x.substring(0, inteiro);
            b = x.substring(inteiro , inteiro + inteiro);
            c = x.substring(inteiro + inteiro, inteiro + inteiro + resto);
        }

        if((y.length()) % 3 == 0){
            Integer div = y.length()/3;
            d = y.substring(0, div);
            e = y.substring(div, div + div);
            f = y.substring(div+div, div+div+div);
            
        }else if(((y.length() % 3) != 0) && y.length()>3 ){
            Integer inteiro = y.length()/3;
            Integer resto = y.length() % 3;
            
            c = y.substring(0, inteiro);
            d = y.substring(inteiro, inteiro + inteiro);
            f = y.substring(inteiro + inteiro, inteiro + inteiro + resto);

        }
        /*String shiftA = x.length() -  a.length();
        String shiftB = x.length() - (b.length() + a.length() );
        String shiftC = x.length() - (a.length()+ b.length()+ c.length() );

        String shiftD = y.length() -  d.length();
        String shiftE = y.length() - (d.length() + e.length() );
        String shiftF = y.length() - (d.length() + e.length() + f.length());*/
        //9 filhos
        String ad = karatsubaRecursivo(a, d);
        String ae = karatsubaRecursivo(a, e); 
        String af = karatsubaRecursivo(a, f); 
        String bd = karatsubaRecursivo(b, d); 
        String be = karatsubaRecursivo(b, e); 
        String bf = karatsubaRecursivo(b, f); 
        String cd = karatsubaRecursivo(c, d); 
        String ce = karatsubaRecursivo(c, e); 
        String cf = karatsubaRecursivo(c, f); 
      
        return "";
    }

    private static String shift(String x, String y){
        return "";
    }

    private static String soma(String a, String b){
        if(a.length()>b.length()){
            int dif = a.length() - b.length();
            for(int i = 0; i<dif ;i ++){
                b = "0" + b;
            }
        } 
        if(b.length()>a.length()){
            int dif = b.length() - a.length();
            for(int i = 0; i<dif ;i ++){
                a = "0" + a;
            }
        }
    
        String x = new StringBuilder(a).reverse().toString();
        String y = new StringBuilder(b).reverse().toString();
        int resto = 0;
        String resultado="";
        
        if(a.length() == b.length()){
            for(int i = 0 ; i< a.length(); i++){
                int c = Integer.parseInt(x.substring(i,i+1));
                int d = Integer.parseInt(y.substring(i,i+1));
                int soma = c+d;
                if(resto>0){
                    soma = soma + resto;
                    resto = 0;
                }
                if(soma > 10){
                    soma = soma - 10;
                    resto = resto + 1;
                }
                String aux = Integer.toString(soma);
                resultado = resultado + aux;
            }
        }
        String z = new StringBuilder(resultado).reverse().toString();
        return z;
    }

    
}
