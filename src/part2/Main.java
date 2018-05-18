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
        List<Instance> training = Loader.load("src/part2/spamLabelled.dat", false);
        List<Instance> test = Loader.load("src/part2/spamUnLabelled.dat", true);

        NaiveBayes naiveBayes = new NaiveBayes(training);
        naiveBayes.classify(test);
    }

    public static void main(String[] args) {
        new Main();
    }

}
