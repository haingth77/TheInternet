package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Kiem tra so co phai la so chan khong?
        /*kiemTraSoChan(0);
        kiemTraSoChan(7);


        Character b = 'a';
        System.out.println(Character.isLetter(b));
        kiemTraNguyenAmHai(b);
        kiemTraSoNguyenTo(59);
        */
        int[] numbers ={1,6,9,2,5,6};
        for (int count=0; count< numbers.length; count++){
            System.out.println(numbers[count]);
        }


    }

    //Kiem tra so co phai la so chan khong?
    public static boolean kiemTraSoChan(int a) {
        if (a % 2 == 0) {
            System.out.println(a + " la so chan");
            return true;
        } else {
            System.out.println(a + " khong la so chan");
            return false;
        }
    }

    public static boolean kiemTraNguyenAm(Character letter) {
        if (Character.isLetter(letter)) {
            if (letter == 'o' || letter == 'u' || letter == 'e' || letter == 'a' || letter == 'i') {
                System.out.println(letter + " la nguyen am");
                return true;
            } else {
                System.out.println(letter + " khong la nguyen am");
                return false;
            }
        } else {
            System.out.println(letter + " khong phai la chu cai");
            return false;
        }
    }

    public static boolean kiemTraNguyenAmHai(Character letter) {
        Character[] nguyenAm = {'e', 'u', 'o', 'a', 'i', 'E', 'U', 'O', 'A', 'I'};
        int countNguyenAm = 0;
        if (Character.isLetter(letter)) {
            for (var i = 0; i < (nguyenAm.length); i = i+1){
                if (letter == (nguyenAm[i])) {
                    countNguyenAm ++;
                    i = nguyenAm.length;
                }
            }
        } else {
            System.out.println(letter + " khong la chu cai");
            return false;
        }
        if (countNguyenAm != 0) {
            System.out.println(letter + " la nguyen am");
            return true;
        } else {
            System.out.println(letter + " khong la nguyen am");
            return false;
        }
    }


    /*Kiểm tra một số nhập vào có phải là số nguyên tố hay không
    Chia cho 1 va chinh no -> khong chia cho so nao khac -> chia lan luot tu 1 den chinh no
    */

    public static boolean kiemTraSoNguyenTo(int inputNumber){
        int countDivision =0;
        if (inputNumber <=0) {
            System.out.println(inputNumber + " khong la so nguyen to");
            return false;
        } else {
            for (int countToInputNUmber =2; countToInputNUmber <= inputNumber; countToInputNUmber = countToInputNUmber + 1){
                if (inputNumber % countToInputNUmber == 0) {
                    countDivision++;
                }
            }
        }
        if (countDivision ==1) {
            System.out.println(inputNumber + " la so nguyen to");
            return true;
        } else {
            System.out.println(inputNumber + " khong la so nguyen to");
            return false;
        }

    }

}

    /**Kiem tra xem co phai nguyen am khong
     * kiem tra co phai ki tu hay khong
     * kiem tra co phai nguyen am khong
     * nguyen am la <euoai>
     **/
