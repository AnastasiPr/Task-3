package com.company;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//3 задачи

public class Main {

    private static void millionsRounding(Map<String,Integer> namemapa){  //Map это сборник ключей и значений, как список
        for (Map.Entry strochka: namemapa.entrySet()){ //strochka это название entry - как строка с ключом и значением, внутри Map много энтров (я их назвала strochka)
            Integer newval = (Integer)strochka.getValue(); //извлекаем строчки(энтры) из Map
            newval = (Math.round(newval/1000000))*1000000;
            namemapa.put((String)strochka.getKey(), (newval)); //getKey возвращает абстрактный тип object и мы приводим его к String

        };
        for (Map.Entry k: namemapa.entrySet()){
            System.out.println ("["+"\""+k.getKey()+"\","+ k.getValue() +"],"); // \" - ставит кавычки
        }
    }

    private static String OtherSides (double sh){
        double ln=(double)Math.round(2*sh*100)/100;
        double mid=(double)Math.round(sh*Math.sqrt(3)*100)/100;
        return ln+" "+mid;
    }

    public static String Rps(String s1, String s2) {
        switch (s1){
            case("камень"):
                switch (s2){
                    case("камень"): return("Ничья");
                    case("ножницы"):return("Победа первого");
                    case("бумага"):return("Победа второго");
                }
            case("бумага"):
                switch (s2){
                    case("камень"): return("Победа первого");
                    case("ножницы"):return("Победа второго");
                    case("бумага"):return("Ничья");
                }
            case("ножницы"):
                switch (s2){
                    case("камень"): return("Победа второго");
                    case("ножницы"):return("Ничья");
                    case("бумага"):return("Победа первого");
                }
        }
        return("Ошибка ввода!");
    }

    public static int WarOfNumbers(int[] a){
        int chet=0, nechet=0;
        for (int n:a) {  //for each, берет каждый элемент из массива а и делает что-то с ним
            if (n % 2 == 0)  chet+=n;
            else nechet+=n;
        }
        return Math.abs(chet-nechet);
    }

    public static String ReverseCase(String str){
        char[] newstr = str.toCharArray();
        for (int i=0; i<newstr.length; i++ ) {
            if (Character.isLowerCase(newstr[i]))  newstr[i]=Character.toUpperCase(newstr[i]);
            else newstr[i]=Character.toLowerCase(newstr[i]);
        }
        return String.valueOf(newstr); //valueOf - метод, превращающий символьный массив в строку
    }

    public static String Inator(String str){
        char[] sim = str.toCharArray();
        if (sim[sim.length - 1] == 'a' || sim[sim.length-1]=='o' || sim[sim.length-1]=='e' || sim[sim.length-1]=='u'
                || sim[sim.length-1]=='y' || sim[sim.length-1]=='i')
            return str +"-inator "+ sim.length + "000";
        return str + "inator " + sim.length+"000";
    }

    public static boolean combo(int brickA, int brickB, int holeA, int holeB){  //метод для комбинации всех параметров
        if ((holeA-brickA>=0 && holeB-brickB>=0) || (holeA-brickB>=0 && holeB-brickA>=0)) //разные расположения кирпича относительно hole
            return true;
        return false;
    }
    public static boolean doesBrickFit(int brickA, int brickB, int brickC, int holeA, int holeB){
        if (combo(brickA,brickB,holeA,holeB) ||
                combo(brickA,brickC,holeA,holeB) ||
                combo(brickB,brickC,holeA,holeB))
            return true;
        return false;
    }

    public static double TotalDistance(double bensin, double rasxod, int pass, boolean air){
        rasxod = rasxod + rasxod*0.05*pass;
        if (air)
            rasxod += rasxod*0.1;

        return Math.floor(bensin*10000/rasxod)/100;
    }

    public static boolean ParityAnalysis(int num){
        int sum=0;
        int n = num;
        while (num>=1){
            sum+=num %10;
            num= num / 10;
        }
        return sum % 2 == n % 2;
    }

    public static double Mean(int[] arr){
        double av=0;
        for (int num:arr) {
            av+=num;
        }
        av=av/arr.length;
        return Math.floor(av*100)/100;
    }

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

        //1

        Map<String, Integer> hashMap = new HashMap<>(); //hashMap - имя мапы
        hashMap.put ("New York", 102365489);
        millionsRounding(hashMap);

	    //2

        System.out.println(OtherSides(scan.nextDouble()));

        //3

        System.out.println(Rps(scan.nextLine(),scan.nextLine()));

        //4

        System.out.println(WarOfNumbers(new int[] {2, 8, 7, 5}));

        //5

        System.out.println(ReverseCase(scan.nextLine()));

        //6

        System.out.println(Inator(scan.nextLine()));

        //7

        System.out.println(doesBrickFit(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt()));

        //8

        System.out.println(TotalDistance(scan.nextDouble(),scan.nextDouble(),scan.nextInt(),scan.nextBoolean()));

        //9

        System.out.println(Mean(new int[]{2, 3, 2, 3}));
        System.out.println(Mean(new int[]{2, 3, 2, 3, 0}));

        //10

        System.out.println(ParityAnalysis(scan.nextInt()));
    }
}
