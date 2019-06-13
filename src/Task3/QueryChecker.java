package Task3;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;


public class QueryChecker {
    Map<Character, Character> brackets = ImmutableMap.of(
            '[', ']',
            '{', '}',
            '(', ')',
            '<', '>');

    private String query;
    private boolean isNormalized;

    public QueryChecker(String query) {
        this.query = query;
        this.isNormalized = isNormalized();
    }

    /**
     * Алгоритм проверки нормализации реализованный через Стек
     *
     * @return
     */
    public boolean isNormalized() {
        char[] charArray = query.toCharArray();
        Character[] charObjectArray = ArrayUtils.toObject(charArray);

        Stack<Character> actualBrackets = new Stack<>();
        for (Character ch : charObjectArray) {
            if (brackets.keySet().contains(ch)) {
                actualBrackets.add(ch);
            } else if (brackets.values().contains(ch) && ch.equals(brackets.get(actualBrackets.peek()))) {
                if (!actualBrackets.empty()) {
                    actualBrackets.pop();
                } else
                    return false;
            }
        }
        return actualBrackets.empty();
    }

    /**
     * Метод идентичный методу isNormalized,
     * но реализован с использованием Дэка (двусторонняя очередь)
     *
     * @return
     */
    public boolean isNormalized_() {
        char[] charArray = query.toCharArray();
        Character[] charObjectArray = ArrayUtils.toObject(charArray);

        Deque<Character> actualBracketsDequeue = Arrays.asList(charObjectArray).parallelStream()
                .filter(ch -> brackets.containsValue(ch) || brackets.containsKey(ch))
                .collect(Collectors.toCollection(ArrayDeque::new));

        if (actualBracketsDequeue.size() % 2 != 0)
            return false;

        while (!actualBracketsDequeue.isEmpty()) {
            if (brackets.get(actualBracketsDequeue.getFirst()).equals(actualBracketsDequeue.getLast())) {
                actualBracketsDequeue.removeFirst();
                actualBracketsDequeue.removeLast();
            } else
                return false;
        }
        return true;
    }



    public void setNormalized(boolean normalized) {
        isNormalized = normalized;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


}
