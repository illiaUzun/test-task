package Task3;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * class QueryChecker stores a query and checks it's normalization
 * after creation
 *
 * two methods of normalization validation are present:
 * -checkNormalizationStack:
 * uses Stack as base of alghoritm - a method with a bit higher performance,
 * so i use it as default
 *
 * -checkNormalizationDeque
 * uses Deque as base of it's alghoritm
 *
 */
public class QueryChecker {

    //Using Guava to make code a bit nicer
    Map<Character, Character> brackets = ImmutableMap.of(
            '[', ']',
            '{', '}',
            '(', ')',
            '<', '>');

    private String query;
    private boolean isNormalized;

    public QueryChecker(String query) {
        this.query = query;
        this.isNormalized = checkNormalizationStack();
    }

    /**
     * Method to check normalization using algorithm based on Stack
     * <p>
     * We push an open bracket, when we meet one, into stack
     * and then pop it when we meet the closing one which together
     * create pair of brackets
     * <p>
     * If we meet closing brackets before open brackets - that means
     * that query is not normalized
     * <p>
     * At the end, when stack is not empty - that means that query is
     * not normalized
     *
     * Using standard SDK features (only immutable Map from Guava lib
     * to simplify the code)
     *
     * @return boolean - isNormalized
     */
    public boolean checkNormalizationStack() {
        long startTime = System.currentTimeMillis();

        char[] charArray = query.toCharArray();

        Stack<Character> actualBrackets = new Stack<>();
        for (Character ch : charArray) {
            if (brackets.keySet().contains(ch)) {
                actualBrackets.add(ch);
            } else if (brackets.values().contains(ch) && ch.equals(brackets.get(actualBrackets.peek()))) {
                if (!actualBrackets.empty()) {
                    actualBrackets.pop();
                } else
                    return false;
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);

        return actualBrackets.empty();
    }

    /**
     * Method to check normalization using algorithm based on Deque
     * <p>
     * A bit less efficient then checkNormalizationStack method
     * <p>
     * Using Stream we filter the query, so we could have only brackets
     * and collect the result to Deque
     * <p>
     * Then we check if size of resulting Deque is even number and if not
     * - query is not normalized
     * <p>
     * If it is odd - we remove first and last chars from deque only if
     * they are equal in each iteretion, if not - query is not normalized
     *
     * Using immutable Map from Guava to store key-values pairs
     * and ArrayUtils to convert char Array to Character array
     *
     * @return boolean - isNormalized
     */
    public boolean checkNormalizationDeque() {
        char[] charArray = query.toCharArray();
        Character[] characterArray = ArrayUtils.toObject(charArray);

        Deque<Character> actualBrackets = Arrays.asList(characterArray).parallelStream()
                .filter(ch -> brackets.containsValue(ch) || brackets.containsKey(ch))
                .collect(Collectors.toCollection(ArrayDeque::new));

        if (actualBrackets.size() % 2 != 0)
            return false;

        while (!actualBrackets.isEmpty()) {
            if (brackets.get(actualBrackets.getFirst()).equals(actualBrackets.getLast())) {
                actualBrackets.removeFirst();
                actualBrackets.removeLast();
            } else
                return false;
        }
        return true;
    }

    public boolean isNormalized() {
        return isNormalized;
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
