import java.util.Scanner;
class ZTableCalc{

    public static void main(String[] args) {
        
        opPicker();
        
        
    }



    public static void opPicker(){
        while(true){
            Scanner myOp = new Scanner(System.in);
            System.out.println("What would you like to use: ");
            System.out.println("[Z] ZTable      [C] Choose operation    [F] Factorial    [E] Exit");
            String myChar = myOp.next();
            switch(myChar){
                case "Z":
                    double[][] table = sizeInput();
                    zTableIn(table);
                    break;
                case "C":
                    chooseOp();
                    break;
                case "F":
                    factorialChosen();
                    break;
                case "E":
                    return;
            }
        }   



    }

    public static double[][] sizeInput(){
        Scanner mySize = new Scanner(System.in);

        System.out.print("Enter zTable max: ");
        double max = mySize.nextDouble();
        System.out.println("");
        System.out.print("Enter zTable min: ");
        double min = mySize.nextDouble();

        double[][] myTable = buildZTable(min, max);
        return myTable;
    }

    public static void chooseOp(){
        Scanner userZIn = new  Scanner(System.in);
        System.out.println("");
        double firstDouble;
        double secondDouble;
        while(true){
            System.out.println("Enter first number:");
            String myChar = userZIn.next();
            if(myChar.equals("C"))
                return;
            else
                firstDouble = Double.parseDouble(myChar);

            System.out.println("Enter second number:");
            myChar = userZIn.next();
            if(myChar.equals("C"))
                return;
            else
                secondDouble = Double.parseDouble(myChar);
        }
    }

    public static void factorialChosen(){
        Scanner userZIn = new  Scanner(System.in);
        System.out.println("");
        double myNum;
        while(true){
            System.out.println("Enter number:");
                String myChar = userZIn.next();
                if(myChar.equals("C"))
                    return;
                else
                    myNum = Double.parseDouble(myChar);
            
        
            System.out.println(factorial(myNum)); 
    }
    } 

    
    public static double cEquation(double n, double k){
        return (factorial(n))/((factorial(n - k))*factorial(k));

    }
        


    public static double factorial(double n){
        if(n == 0)
            return 1 ;
        return n * factorial(n - 1);
    }

    public static void zTableIn(double[][] zTable){
        
        Scanner userZIn = new  Scanner(System.in);
        System.out.println("");
        while(true){
            double myIn;
            System.out.print("Enter value for zTable: ");
            
            //double myIn = userZIn.nextDouble();
            String myChar = userZIn.next();
            if(myChar.equals("C"))
                return;
            else
                myIn = Double.parseDouble(myChar);
            int y = (int) ((int)((myIn) * 10) + 34);
            int x = (int) (myIn*100%10); 
            
            System.out.println(zTable[y][x]);
        }

        
    }



    // Builds Z-table from startZ to endZ (inclusive)
    // Rows: 0.1 steps (e.g. -3.0, -2.9, ..., 3.0)
    // Columns: 0.00 to 0.09
    public static double[][] buildZTable(double startZ, double endZ) {
        int rows = (int) ((endZ - startZ) * 10) + 1;
        double[][] table = new double[rows][10];

        for (int i = 0; i < rows; i++) {
            double zBase = startZ + i * 0.1;

            for (int j = 0; j < 10; j++) {
                double z = zBase + j * 0.01;
                table[i][j] = normalCDF(z);
            }
        }

        return table;
    }

    // Standard normal CDF using erf approximation
    public static double normalCDF(double z) {
        return 0.5 * (1.0 + erf(z / Math.sqrt(2.0)));
    }

    // Approximation of erf (Abramowitz and Stegun)
    public static double erf(double x) {
        double sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);

        double a1 = 0.254829592;
        double a2 = -0.284496736;
        double a3 = 1.421413741;
        double a4 = -1.453152027;
        double a5 = 1.061405429;
        double p = 0.3275911;

        double t = 1.0 / (1.0 + p * x);
        double y = 1.0 - (((((a5 * t + a4) * t) + a3) * t + a2) * t + a1) * t * Math.exp(-x * x);

        return sign * y;
    }
}
    





