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

    @Override
    public String generate(int number) {
        String result = "";
        for (SymbolSet set : SYMBOL_SETS) {
            int count = number / set.one.number;
            number -= set.one.number * count;
            switch (count) {
                case 4:
                    result += set.one.toString() + set.five.toString();
                    count = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    result += set.five.toString();
                    count -= 5;
                    break;
                case 9:
                    result += set.one.toString() + set.ten.toString();
                    count = 0;
                    break;
            }
            for (int i = 0; i < count; i++) {
                result += set.one.toString();
            }
        }
        return result;
    }

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
        final Symbol one;
        final Symbol five;
        final Symbol ten;

        private SymbolSet(Symbol one, Symbol five, Symbol ten) {
            this.one = one;
            this.five = five;
            this.ten = ten;
        }
    }
}
