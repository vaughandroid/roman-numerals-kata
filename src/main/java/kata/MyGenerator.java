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
        StringBuilder stringBuilder = new StringBuilder();
        for (SymbolSet set : SYMBOL_SETS) {
            int count = number / set.one.number;
            number -= set.one.number * count;
            switch (count) {
                case 4:
                    stringBuilder.append(set.one).append(set.five);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    stringBuilder.append(set.five);
                    for (int i = 5; i < count; i++) {
                        stringBuilder.append(set.one);
                    }
                    break;
                case 9:
                    stringBuilder.append(set.one).append(set.ten);
                    break;
                default:
                    for (int i = 0; i < count; i++) {
                        stringBuilder.append(set.one);
                    }
                    break;
            }
        }
        return stringBuilder.toString();
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
