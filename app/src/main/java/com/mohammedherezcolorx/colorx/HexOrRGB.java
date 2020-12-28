package com.mohammedherezcolorx.colorx;

class HexOrRGB {

    //Vars
    private int[] rgb = {255, 255, 255};
    private String[] rgbHex = {"FF", "FF", "FF"};
    private char[] HexChar = {'A', 'B', 'C', 'D', 'E', 'F'};

    //Setsters
    public void setR(int R) {rgb[0] = R; rgbHex[0] = rgb_to_hex(R);}
    public void setG(int G) {rgb[1] = G; rgbHex[1] = rgb_to_hex(G);}
    public void setB(int B) {rgb[2] = B; rgbHex[2] = rgb_to_hex(B);}
    public void setRgb(int R,int G,int B){setR(R); setG(G); setB(B);}
    public void setHex(String hex){

        rgb[0] = (LettersToNumbers(hex.charAt(1))*16) + LettersToNumbers(hex.charAt(2));
        rgb[1] = (LettersToNumbers(hex.charAt(3))*16) + LettersToNumbers(hex.charAt(4));
        rgb[2] = (LettersToNumbers(hex.charAt(5))*16) + LettersToNumbers(hex.charAt(6));

    }

    //Getters
    public String getR() {return String.valueOf( rgb[0]);}
    public String getG() {return String.valueOf( rgb[1]);}
    public String getB() {return String.valueOf( rgb[2]);}
    public int[] getRgb()  {return rgb;}
    public String getHex() {return "#"+rgb_to_hex(rgb[0])+rgb_to_hex(rgb[1])+rgb_to_hex(rgb[2]);}

    //Processes
    private String rgb_to_hex(int rgbNum) {return NumbersToLetters(rgbNum / 16) + NumbersToLetters(rgbNum % 16);}
    private void hex_to_rgb(String hex) {

    }

    //More
    private String NumbersToLetters(int num) {
        if (num < 10) return String.valueOf(num);
        else return String.valueOf(HexChar[num - 10]);
    }
    public int LettersToNumbers(char val) {
        int num = 0; boolean flat = true;
        for (int i = 0; i < 6; i++){ if(val == HexChar[i]){ num = 10 + i; flat=false;}}
        if(flat) num = Integer.parseInt(String.valueOf(val));
        return num;
    }
}