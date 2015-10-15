import java.util.*;

public class ExpressionChecker {
    private static class Pair<T> {
        T start ,end;

        private Pair(T end, T start) {
            this.end = end;
            this.start = start;
        }

        public T get(T tag){
            if (start.equals(tag)) {
                return end;
            } else if (end.equals(tag)) {
                return start;
            }

            throw new RuntimeException("Not found related pair.");
        }
    }

    static class Pairs {
        static List<Pair<Character>> pairs = new ArrayList<Pair<Character>>();
        static {
            pairs.add(new Pair('{','}'));
            pairs.add(new Pair('(',')'));
            pairs.add(new Pair('[',']'));
        }

        static boolean contains(char tag) {
            for (Pair<Character> p : pairs) {
                if (p.start == tag || p.end == tag){
                    return true;
                }
            }

            return false;
        }

        static char get(char tag) {
            for (Pair<Character> p: pairs) {
                if (p.start == tag) {
                    return p.end;
                }

                if (p.end == tag) {
                    return p.start;
                }
            }

            throw new RuntimeException("Not found tag " + tag);
        }
    }

    public boolean chkLegal(String A) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (char ch : A.toCharArray()) {
            if (!Pairs.contains(ch)) {
                continue;
            }

            if (m.containsKey(ch)) {
                m.put(ch, (int) m.get(ch) + 1);
            } else {
                m.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            char key = entry.getKey();
            char verseKey = Pairs.get(key);
            int v = entry.getValue();
            if(!m.containsKey(verseKey)) {
                return false;
            }
            int verseV = m.get(verseKey);
            if (v != verseV) {
                return false;
            }
        }

        return true;
    }
}