package kata;

public class MyGenerator implements RomanNumeralGenerator {

    @Override
    public String generate(int number) {
        for (Symbol s : Symbol.values()) {
            if (number == s.number) {
                return s.toString();
            }
        }

        switch(number) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            default: return null;
        }
    }

    private enum Symbol {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        public final int number;

        Symbol(int number) {

            this.number = number;
        }
    }
}
