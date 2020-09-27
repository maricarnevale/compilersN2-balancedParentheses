package com.company;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Digite os simbolos que deseja validar - Alfabeto: { [ ( < > ) ] }");
            Scanner read = new Scanner(System.in);
            String symbols = read.nextLine();

            if(isValid(symbols)){
                System.out.println("Conjunto é válido.");
            } else{
                System.out.println("Conjunto é inválido.");
            }
        }catch(Exception error){
            System.out.println(error);
        }
    }

    static boolean isValid(String set){
        Stack<Character> stackOpenings = new Stack();
        for(int i = 0; i < set.length(); i++){
            if(!isValidChar(set.charAt(i))){
                System.out.println("Algum simbolo digitado não faz parte do alfabeto!");
                return false;
            }
            if(set.charAt(i) == '{' || set.charAt(i) == '[' || set.charAt(i) == '(' || set.charAt(i) == '<'){
                stackOpenings.push(set.charAt(i));
            }else{
                if(stackOpenings.isEmpty()){
                    return false;
                }
                if(isNotAPairOfSymbol(set.charAt(i), stackOpenings.peek())){
                    return false;
                }
                stackOpenings.pop();
            }
        }
        return stackOpenings.isEmpty();
    }

    static boolean isValidChar(char symbol){
        return symbol == '{' || symbol == '[' || symbol == '(' || symbol == '<' || symbol == '}' || symbol == ']' ||      symbol == ')' || symbol == '>';
    }

    static boolean isNotAPairOfSymbol(char symbolClosed, char symbolOpened){
        return symbolClosed == '}' && symbolOpened != '{' || symbolClosed == ']' && symbolOpened != '[' || symbolClosed == ')' && symbolOpened != '(' ||symbolClosed == '>' && symbolOpened != '<';
    }
}
