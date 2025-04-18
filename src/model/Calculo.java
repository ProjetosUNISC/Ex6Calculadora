package model;


import java.util.regex.Pattern;

public class Calculo {


    // Função para calcular a expressão com a ordem de precedência
    public static double calcularExpressao(String expressao) {
        // Resolve multiplicação e divisão primeiro
        expressao = resolverMultiplicacaoDivisao(expressao);

        // Depois resolve soma e subtração
        expressao = resolverSomaSubtracao(expressao);

        // Retorna o resultado final
        return Double.parseDouble(expressao); // Converte o texto final para double
    }

    public static String resolverMultiplicacaoDivisao(String expressao) {
        // Lida com multiplicação (*)
        while (expressao.contains("*") || expressao.contains("/")) {
            int posicaoOperador = encontrarProximaMultiplicacaoOuDivisao(expressao);
            String operador = expressao.substring(posicaoOperador, posicaoOperador + 1);

            // Divide a expressão em números
            String[] partes = expressao.split(Pattern.quote(operador));
            double num1 = Double.parseDouble(partes[0].trim());
            double num2 = Double.parseDouble(partes[1].trim());

            // Calcula o resultado de multiplicação ou divisão
            double resultado = 0;
            if (operador.equals("*")) {
                resultado = num1 * num2;
            } else if (operador.equals("/")) {
                resultado = num1 / num2;
            }

            // Substitui a operação pela resposta
            expressao = expressao.replace(partes[0] + operador + partes[1], String.valueOf(resultado));
        }
        return expressao;
    }

    // Função para resolver soma e subtração
    public static String resolverSomaSubtracao(String expressao) {
        // Lida com soma (+) e subtração (-)
        if (expressao.contains("+") || expressao.contains("-")) {
            int posicaoOperador = encontrarProximaSomaOuSubtracao(expressao);
            String operador = expressao.substring(posicaoOperador, posicaoOperador + 1);

            // Divide a expressão em números
            String[] partes = expressao.split((operador));
            double num1 = Double.parseDouble(partes[0].trim());
            double num2 = Double.parseDouble(partes[1].trim());

            // Calcula o resultado de soma ou subtração
            double resultado = 0;
            if (operador.equals("+")) {
                resultado = num1 + num2;
            } else if (operador.equals("-")) {
                resultado = num1 - num2;
            }

            // Substitui a operação pela resposta
            expressao = expressao.replace(partes[0] + operador + partes[1], String.valueOf(resultado));
        }
        return expressao;
    }

    // Função para encontrar a próxima multiplicação ou divisão na expressão
    public static int encontrarProximaMultiplicacaoOuDivisao(String expressao) {
        int posicaoMultiplicacao = expressao.indexOf("*");
        int posicaoDivisao = expressao.indexOf("/");

        // Retorna a posição do primeiro operador de multiplicação ou divisão encontrado
        if (posicaoMultiplicacao == -1) {
            return posicaoDivisao;
        } else if (posicaoDivisao == -1) {
            return posicaoMultiplicacao;
        } else {
            return Math.min(posicaoMultiplicacao, posicaoDivisao);
        }
    }

    // Função para encontrar a próxima soma ou subtração na expressão
    public static int encontrarProximaSomaOuSubtracao(String expressao) {
        int posicaoSoma = expressao.indexOf("+");
        int posicaoSubtracao = expressao.indexOf("-");

        // Retorna a posição do primeiro operador de soma ou subtração encontrado
        if (posicaoSoma == -1) {
            return posicaoSubtracao;
        } else if (posicaoSubtracao == -1) {
            return posicaoSoma;
        } else {
            return Math.min(posicaoSoma, posicaoSubtracao);
        }
    }

    //funcao calculo cientifico
    public double calcular(String operacao, double valor) {
        switch (operacao.toLowerCase()) {
            case "sqrt":
                return Math.sqrt(valor);
            case "1/x":
                return 1 / valor;
            case "sin":
                return Math.sin(Math.toRadians(valor));
            case "cos":
                return Math.cos(Math.toRadians(valor));
            case "tan":
                return Math.tan(Math.toRadians(valor));
            case "x^2":
                return Math.pow(valor, 2);
            case "x^3":
                return Math.pow(valor, 3);
            case "n!":
                return fatorial((int) valor);
            case "%":
                return valor / 100;
            case "exp":
                return Math.exp(valor);
            case "in":
                return Math.log(valor);
            case "sec":
                return 1 / Math.cos(Math.toRadians(valor));
            default:
                throw new IllegalArgumentException("Operação inválida: " + operacao);
        }
    }

    private double fatorial(int n) {
        if (n < 0) return Double.NaN;
        double resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }



}
