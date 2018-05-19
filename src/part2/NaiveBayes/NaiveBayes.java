package part2.NaiveBayes;

import part2.FileLoader.Instance;

import java.util.*;

/**
 * Naive Bayes Algorithm implementation
 *
 * Created by krishna kapadia on 15/05/2018.
 */
public class NaiveBayes {
    private Double[] spamAttProbs, notSpamAttProbs;
    private double spamProbability, notSpamProbability;

    public NaiveBayes(List<Instance> instances) {
        //            Spam Probability
        List<Instance> spam = new ArrayList<>(), notSpam = new ArrayList<>();

//        Separating instances by outcomes
        for(Instance i : instances) {
            if(i.getOutcomeValue() == 1) spam.add(i);
            else notSpam.add(i);
        }

//        Probabilities
        spamProbability = (double) spam.size() / (double) instances.size();
        notSpamProbability = (double) notSpam.size() / (double) instances.size();

//        Get count of true attributes and calculate probabilities
        spamAttProbs = calculateAttributesProbability(this.getTrueAttributeCount(spam), spam.size());
        notSpamAttProbs = calculateAttributesProbability(this.getTrueAttributeCount(notSpam), notSpam.size());
    }

    /**
     * Classifies the unknown outcome instances
     * @param instances, Unknown instances
     */
    public List<Instance> classify(List<Instance> instances) {

        for(Instance i : instances) {
            double spamProb = applyBayes(i, spamAttProbs, true);
            double notSpamProb = applyBayes(i, notSpamAttProbs, false);

            if(spamProb > notSpamProb) i.setOutcome(1);
            else i.setOutcome(0);
        }

        instances.forEach(Instance::print);

        return instances;
    }

    /**
     * Applies bayes algorithm to the given instance and returns the probability
     * @param i, instance to apply to
     * @param probabilities, learned probabilities
     * @param spam, whether spamProb or not
     * @return probability
     */
    private double applyBayes(Instance i, Double[] probabilities, boolean spam) {
        double likelihood = 1;
        Integer[] values = i.values();

        for (int j = 0; j < values.length; j++) {
            if(values[j] == 1) {
                likelihood *= probabilities[j];
            } else {
                likelihood *= (1 - probabilities[j]);
            }
        }

        return (spam) ? likelihood * spamProbability : likelihood * notSpamProbability;
    }

    /**
     * Calculates the probability of each double in the array given a size
     * @param array to calculate probabilities of
     * @param size used to calculate probabilities
     * @return Double[] probabilities
     */
    private Double[] calculateAttributesProbability(Double[] array, int size) {
        Double[] values = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            values[i] = array[i] / size;
        }

        return values;
    }

    /**
     * Returns the count of the true attributes in a list of instances
     * @param instances, list of instances
     * @return Integer[] counts
     */
    private Double[] getTrueAttributeCount(List<Instance> instances) {
        Double[] counts = new Double[instances.get(0).values().length];
        Arrays.fill(counts, 1d);

        for (Instance i : instances) {
            counts = sumArray(counts, i.values());
        }

        return counts;
    }

    /**
     * Returns the sum of 2 int arrays, assuming they are of the same length
     * @param a1, first array to sum with
     * @param a2, second array to sum with
     * @return Integer[] a1 + a2
     */
    private Double[] sumArray(Double[] a1, Integer[] a2) {
        Double[] result = new Double[a1.length];

        for (int i = 0; i < a1.length; i++) {
            result[i] = a1[i] + a2[i];
        }

        return result;
    }

}
