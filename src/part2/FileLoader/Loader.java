package part2.FileLoader;

import java.io.File;
import java.io.FileNotFoundException;
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
     * @return List<Instance> List of instances
     */
    public static List<Instance> load(String filepath) {
        File target = new File(filepath);
        List<Instance> instances = new ArrayList<>();

        try {
            Scanner scan = new Scanner(target);

            while(scan.hasNext()) {
                Integer[] values = new Integer[13];
                for (int i = 0; i < 13; i++) {
                    values[i] = scan.nextInt();
                }

                instances.add(new Instance(values));
            }

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return instances;
    }

    /**
     * Takes a String[] and converts it to a Integer[]
     * @param values, String[] to convert
     * @return Integer[] equivalent
     */
    public static Integer[] toIntArray(String[] values) {
        Integer[] intValues = new Integer[values.length];
        for(String s : values) System.out.println(s);

//        intValues = ((Integer[])Arrays.stream(values).map(Integer::parseInt).toArray());
        return intValues;
    }

}
