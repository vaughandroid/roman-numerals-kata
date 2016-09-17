package kata;

public class MyGenerator implements RomanNumeralGenerator {

    @Override
    public String generate(int number) {
        String result = "";
        for (Symbol s : Symbol.values()) {
            while (number >= s.number) {
                result += s.toString();
                number -= s.number;
            }
        }
        return result;
    }

    private enum Symbol {
        M(1000),
        D(500),
        C(100),
        L(50),
        X(10),
        V(5),
        I(1);

        public final int number;

        Symbol(int number) {

            this.number = number;
        }
    }
}
