package br.pucpr.ed;

public class HashFunctionApp {

    public static void main(String[] args) {
        char c = 'T';
        byte b = 0;
        short s = (short) 45;
        float f = 32.4f;
        int cInt = (int) c;
        int bInt = b;
        int sInt = s;
        int fInt = Float.floatToIntBits(f);
        System.out.println("Representação de " + c + " como inteiro: " + cInt);
        System.out.println("Representação de " + b + " como inteiro: " + bInt);
        System.out.println("Representação de " + s + " como inteiro: " + sInt);
        System.out.println("Representação de " + f + " como inteiro: " + fInt);
    }
}
