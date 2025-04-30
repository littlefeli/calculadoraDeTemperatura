package br.dev.felipe.temperatura.model;

public class Temperatura {

    public static double converter(double valor, String origem, String destino) {
        if (origem.equals(destino)) return valor;

        switch (origem + "-" + destino) {
            case "Celsius-Fahrenheit":
                return (valor * 9 / 5) + 32;
            case "Celsius-Kelvin":
                return valor + 273.15;
            case "Fahrenheit-Celsius":
                return (valor - 32) * 5 / 9;
            case "Fahrenheit-Kelvin":
                return (valor - 32) * 5 / 9 + 273.15;
            case "Kelvin-Celsius":
                return valor - 273.15;
            case "Kelvin-Fahrenheit":
                return (valor - 273.15) * 9 / 5 + 32;
            default:
                throw new IllegalArgumentException("Conversão inválida.");
        }
    }
}