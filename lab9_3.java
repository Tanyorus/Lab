public class lab9_3 {
    public static void main(String[] args) {
        try {
            TriangleWithException t1 = new TriangleWithException(1.5, 2, 3);
            //valid Triangle
            System.out.println("Perimeter for t1: " + t1.getPerimeter());
            System.out.println("Area for t1: " + t1.getArea());

            TriangleWithException t2 = new TriangleWithException(1, 2, 3);
            //Invalid Triangle
            System.out.println("Perimeter for t2: " + t2.getPerimeter());
            System.out.println("Area for t2: " + t2.getArea());
        } catch (IllegalTriangleException ex) {
            System.out.println("Illegal triangle");
            System.out.println("Side1: " + ex.getSide1());
            System.out.println("Side2: " + ex.getSide2());
            System.out.println("Side3: " + ex.getSide3());
        }
    }
}
    class IllegalTriangleException extends Exception {
        private final double Side1;
        private final double Side2;
        private final double Side3;
        public IllegalTriangleException(double Side1, double Side2, double Side3) throws IllegalTriangleException {
            this.Side1 = Side1;
            this.Side2 = Side2;
            this.Side3 = Side3;
        }
        public double getSide1(){
            return Side1;
        }
        public double getSide2(){
            return Side2;
        }
        public double getSide3(){
            return Side3;
        }
    }


    class TriangleWithException extends Object{
        private final double Side1;
        private final double Side2;
        private final double Side3;
        
        public double getArea(){
            double s = (Side1 + Side2 + Side3) / 2;
        return Math.sqrt(s * (s - Side1) * (s - Side2) * (s - Side3));
        }
    
        public double getPerimeter(){
             double I = Side1+Side2+Side3;
             return I;
        }
    
        public TriangleWithException(double Side1, double Side2, double Side3)
            throws IllegalTriangleException{
            this.Side1 = Side1;
            this.Side2 = Side2;
            this.Side3 = Side3;
            if(Side1 + Side2 <= Side3 || Side2 + Side3 <= Side1 || Side1 + Side3 <= Side2)
        {
            throw new IllegalTriangleException(Side1, Side2, Side3);
        }

        }  
    }


