package part2;

import part2.FileLoader.Instance;
import part2.FileLoader.Loader;
import part2.NaiveBayes.NaiveBayes;

import java.util.List;

/**
 * Runs the Naive Bayes algorithm
 * Created by krishna kapadia on 15/05/2018.
 */
public class Main {

    public Main() {
//        Load in data
        List<Instance> instances = Loader.load("src/part2/spamLabelled.dat");

        NaiveBayes naiveBayes = new NaiveBayes(instances);

    }

    public static void main(String[] args) {
        new Main();
    }

}
