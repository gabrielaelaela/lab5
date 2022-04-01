package itmo.commands;

import com.google.gson.Gson;
import itmo.organization.Organization;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Deserializing collection from JSON
 */
public class PriorityQueueDeserializer {

    /**
     * name of the file with JSON
     */
    private String filename;

    /**
     * @param filename
     */
    public PriorityQueueDeserializer(String filename) {
        this.filename = filename;
    }

    /**
     * @return collection
     * @throws IOException
     */
    public UpgradedPriorityQueue deserialize() throws IOException {
        UpgradedPriorityQueue<Organization> upgradedPriorityQueue = new UpgradedPriorityQueue<>();

        Reader reader = Files.newBufferedReader(Paths.get(filename));

        try {
            Gson gson = new Gson();
            Organization[] organizations = gson.fromJson(reader, Organization[].class);
            for (Organization organization: organizations) {
                upgradedPriorityQueue.add(organization);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            reader.close();
        }

        return upgradedPriorityQueue;
    }
}
