package teamu.sprint2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SessionList {

    private static final String FIRST_FIELD_NAME = "Course_ID";
    private static final String SEPARATOR = ";";
    private List<Session> sessions;

    public SessionList(String filepath) {
        this.sessions = new ArrayList<Session>();
        Scanner fd;

        try {
            fd = new Scanner(new FileReader(filepath));
            while (fd.hasNextLine()) {
                String[] line = fd.nextLine().split(SEPARATOR);
                if (line[0].equals(FIRST_FIELD_NAME)) {
                    continue;
                }

                Session s = new Session();
                s.setName(line[1]);
                s.setStartDate(line[2]);
                s.setEndDate(line[3]);
                s.setTime(line[4]);
                s.setDuration(Integer.parseInt(line[5]));
                s.setRepeated(Integer.parseInt(line[6]));
                s.setCompulsory(line[7]);
                s.setLecturer(line[8]);
                s.setVenue(line[9]);
                s.setMaxCapacity(Integer.parseInt(line[10]));

                this.sessions.add(s);
            }

            fd.close();
        } catch (FileNotFoundException e) {
            System.err.printf("Error Opening %s\n", filepath);
        }
    }

    public void add(Session session) {
        this.sessions.add(session);
    }

    public List<Session> getAll() {
        return this.sessions;
    }
}
