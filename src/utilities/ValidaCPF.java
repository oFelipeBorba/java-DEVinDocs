package utilities;

import java.util.InputMismatchException;

public class ValidaCPF {
    public static boolean verificaCPF(String cpf) {
        //realizo uma verificacao para ver se foram inseridos digitos iguais ou uma string menor que 11 caracteres
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11))
            return(false);

        //variaveis de interesse para realizar os calculos de validação
        char dv10, dv11;
        int somaParcela, i, resto, num, peso;

        try {
            //encontra o primeiro digito verificador
            somaParcela = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                //realiza conversao para inteiro
                num = (int)(cpf.charAt(i) - 48);
                somaParcela = somaParcela + (num * peso);
                peso = peso - 1;
            }

            resto = 11 - (somaParcela % 11);
            if ((resto == 10) || (resto == 11))
                dv10 = '0';
            else dv10 = (char)(resto + 48);

            //encontra o segundo digito verificador
            somaParcela = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                somaParcela = somaParcela + (num * peso);
                peso = peso - 1;
            }

            resto = 11 - (somaParcela % 11);
            if ((resto == 10) || (resto == 11))
                dv11 = '0';
            else dv11 = (char)(resto + 48);

            if ((dv10 == cpf.charAt(9)) && (dv11 == cpf.charAt(10)))

                //caso a logica seja validada, retorna true
                return(true);
            else return(false);
        } catch (InputMismatchException err) {
            return(false);
        }
    }

    public static String montaCpfApresentacao(String cpf) {
        return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
    }
}