package kata;

import java.util.ArrayList;
import java.util.List;

import static kata.MyGenerator.Symbol.*;

public class MyGenerator implements RomanNumeralGenerator {

    private static final List<SymbolSet> SYMBOL_SETS;

    static {
        SYMBOL_SETS = new ArrayList<>(4);
        SYMBOL_SETS.add(new SymbolSet(M, null, null));
        SYMBOL_SETS.add(new SymbolSet(C, D, M));
        SYMBOL_SETS.add(new SymbolSet(X, L, C));
        SYMBOL_SETS.add(new SymbolSet(I, V, X));
    }

    /**
     * Express a given number as Roman numerals, according to the "standard" form described
     * <a href="https://en.wikipedia.org/wiki/Roman_numerals">here</a>.
     *
     * @param number value to be represented, must be between 1 and 3999
     * @return the value expressed as Roman numerals, or 0 if the value is out of range
     */
    @Override
    public String generate(int number) {
        if (number <= 0 || number >= 4000) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (SymbolSet set : SYMBOL_SETS) {
            int count = number / set.single.number;
            switch (count) {
                case 4:
                    stringBuilder.append(set.single).append(set.five);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    stringBuilder.append(set.five);
                    for (int i = 5; i < count; i++) {
                        stringBuilder.append(set.single);
                    }
                    break;
                case 9:
                    stringBuilder.append(set.single).append(set.ten);
                    break;
                default:
                    for (int i = 0; i < count; i++) {
                        stringBuilder.append(set.single);
                    }
                    break;
            }
            number -= set.single.number * count;
        }

        return stringBuilder.toString();
    }

    /**
     * A Roman numeral symbol, and its numeric value.
     */
    enum Symbol {
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

    private static class SymbolSet {
        final Symbol single;
        final Symbol five;
        final Symbol ten;

        private SymbolSet(Symbol single, Symbol five, Symbol ten) {
            this.single = single;
            this.five = five;
            this.ten = ten;
        }
    }
}
