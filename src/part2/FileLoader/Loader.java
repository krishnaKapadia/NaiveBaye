package part2.FileLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Loader to load files
 * Created by krishna kapadia on 15/05/2018.
 */
public class Loader {

    /**
     * Loads a file and generates a list of instances based off the data
     * @param filepath String path to file
     * @param test, whether test file or not
     * @return List<Instance> List of instances
     */
    public static List<Instance> load(String filepath, boolean test) {
        File target = new File(filepath);
        List<Instance> instances = new ArrayList<>();

        try {
            Scanner scan = new Scanner(target);

            while(scan.hasNext()) {
                Integer[] values = new Integer[12];
                for (int i = 0; i < 12; i++) {
                    values[i] = scan.nextInt();
                }

                if(test) {
                    instances.add(new Instance(values));
                }else {
                    int outcome = scan.nextInt();
                    instances.add(new Instance(outcome, values));
                }
            }

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return instances;
    }

    /**
     * Writes instance list to file
     * @param instances, to save
     * @throws IOException
     */
    public static void write(List<Instance> instances) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("sampleoutput.txt"));

        for(Instance i : instances) {
            writer.append(i.toString());
        }

        writer.close();
    }

    /**
     * Takes a String[] and converts it to a Integer[]
     * @param values, String[] to convert
     * @return Integer[] equivalent
     */
    public static Integer[] toIntArray(String[] values) {
        Integer[] intValues = new Integer[values.length];
        for(String s : values) System.out.println(s);
        return intValues;
    }

}
