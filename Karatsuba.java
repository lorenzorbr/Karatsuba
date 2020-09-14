import java.lang.Math;
public class Karat{
    public static void main(String args[]) {
            
            String res = karatsubaRecursivo(args[0], args[1]);
            System.out.println(res);
    }

    public static String karatsubaRecursivo(String x, String y){

        if(x.length()==1 && y.length()==1){
            int x1 = Integer.parseInt(x);
            int y1 = Integer.parseInt(y);
            int z1 = x1 * y1 ;
            String res = Integer.toString(z1);
            return res;
        }
        while(x.length()<y.length() || x.length()%3 != 0)
            x = "0"+x;
        while (y.length()<x.length()|| y.length()%3 != 0)
            y = "0"+y;
        

        int divX = x.length()/3;
        int divY = y.length()/3;
        
        String a = x.substring(0, divX);
        String b = x.substring(divX,divX+divX);
        String c = x.substring(divX+divX,x.length());

        String d = y.substring(0, divY);
        String e = y.substring(divY,divY+divY);
        String f = y.substring(divY+divY, y.length());

        int shiftA = x.length() - a.length();
        int shiftB = x.length() - b.length() - a.length();
        int shiftD = y.length() - d.length();
        int shiftE = y.length() - d.length() - e.length();
     
        String ad = karatsubaRecursivo(a, d) + concat(shiftA+shiftD);
        String ae = karatsubaRecursivo(a, e) + concat(shiftA+shiftE);
        String af = karatsubaRecursivo(a, f) + concat(shiftA);
        String bd = karatsubaRecursivo(b, d) + concat(shiftB+shiftD);
        String be = karatsubaRecursivo(b, e) + concat(shiftB+shiftE);
        String bf = karatsubaRecursivo(b, f) + concat(shiftB);
        String cd = karatsubaRecursivo(c, d) + concat(shiftD);
        String ce = karatsubaRecursivo(c, e) + concat(shiftE);
        String cf = karatsubaRecursivo(c, f);

        return soma(ad, soma(ae, soma(af, soma(bd, soma(be, soma(bf, soma(cd, soma(ce, cf))))))));

    }

    public static String concatEsq(String x, int zeros){
        for(int i = (x.length() % 3) ; i < zeros ; i ++ ){
            x = "0"+ x ;
        }
        return x ;
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
                if(soma >= 10 ){
                    soma = soma - 10;
                    resto = resto + 1;
                }     
                String aux = Integer.toString(soma);
                resultado = resultado + aux;
            }
        }
        if(resto >0){
            resultado = resultado + "1";
        }
        String z = new StringBuilder(resultado).reverse().toString();
        return z;
        }

    public static String concat(int shifts){
        String x = "";
        for(int i = 0 ; i < shifts ; i ++){
            x = x + "0";
        }
        return x ;
    }
}
