package part2.FileLoader;

/**
 * Represents a single Email instance.
 * Contains a int array of values, Outcome as a string, outcome as an integer
 * Created by krishna kapadia on 15/05/2018.
 */
public class Instance {
    private Integer[] values;
    private String outcome;
    private int outcomeValue;

    public Instance(Integer... values) {
        this.values = values;
        outcomeValue = values[values.length - 1];
        outcome = (outcomeValue == 1) ? "spam" : "not spam";
    }

    public Instance(int outcomeValue, Integer... values) {
        this.values = values;
        this.outcomeValue = outcomeValue;
        outcome = (outcomeValue == 1) ? "spam" : "not spam";
    }

    /**
     * Gets the string representation of the outcome
     * @return String either "spam" or "not spam"
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * Gets the outcome as an int value()
     * @return int outcomeValue
     */
    public int getOutcomeValue() {
        return outcomeValue;
    }

    /**
     * Sets the outcome of the instance
     * @param outcome to set to
     */
    public void setOutcome(int outcome) {
        this.outcomeValue = outcome;
        this.outcome = (outcomeValue == 1) ? "spam" : "not spam";
        System.out.println(outcome);
    }

    /**
     * Returns a array of instance values
     * @return Integer[] values
     */
    public Integer[] values() {
        return values;
    }

    /**
     * Prints the instances values
     */
    public void print() {
        System.out.print("Instance: [");
        for(Integer i : values) System.out.print(i + ", ");
        System.out.print(outcome);
        System.out.print("]\n");
    }

    public String toString() {
        StringBuilder b = new StringBuilder("Instance: [");

        for(Integer i : values) {
            b.append(i);
            b.append(", ");
        }

        b.append(outcomeValue);
        b.append(", Classification: ");
        b.append(outcome);
        b.append("]\n");

        return b.toString();
    }

}
