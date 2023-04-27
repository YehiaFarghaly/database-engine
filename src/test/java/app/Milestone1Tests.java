package app;

import org.junit.jupiter.api.*;

import exceptions.DBAppException;

import java.awt.Polygon;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
//import main.java.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Milestone1Tests {
    @Test
    @Order(1)
    public void testSetPageSize() throws Exception {
        String configFilePath = "src/main/resources/";

        if (Files.exists(Paths.get(configFilePath, "DBApp.config"))) {
            configFilePath = Paths.get(configFilePath, "DBApp.config").toString();
        } else if (Files.exists(Paths.get(configFilePath, "DBApp.properties"))) {
            configFilePath = Paths.get(configFilePath, "DBApp.properties").toString();
        } else {
            throw new Exception("`DBApp.config` does not exist in resources directory");
        }

        List<String> config = Files.readAllLines(Paths.get(configFilePath));
        boolean lineFound = false;
        for (int i = 0; i < config.size(); i++) {
            if (config.get(i).toLowerCase().contains("page")) {
                config.set(i, config.get(i).replaceAll("\\d+", "250"));
                lineFound = true;
                break;
            }
        }

        if (!lineFound) {
            throw new Exception("Cannot set page size, make sure that key `MaximumRowsCountinTablePage` is present in DBApp.config");
        }

//        System.out.println("CONFIG" + configFilePath);
        Files.write(Paths.get(configFilePath), config);

    }

    @Test
    @Order(2)
    public void testClearMetaDataFile() throws Exception {

        String metaFilePath = "src/main/resources/metadata.csv";
        File metaFile = new File(metaFilePath);

        if (!metaFile.exists()) {
            throw new Exception("`metadata.csv` in Resources folder does not exist");
        }

        PrintWriter writer = new PrintWriter(metaFile);
        writer.write("");
        writer.close();
    }

    @Test
    @Order(3)
    public void testDataDirectory() throws Exception {
        DBApp dbApp = new DBApp();
        dbApp.init();

        String dataDirPath = "src/main/resources/data";
        File dataDir = new File(dataDirPath);

        if (!dataDir.isDirectory() || !dataDir.exists()) {
            throw new Exception("`data` Directory in Resources folder does not exist");
        }

        ArrayList<String> files = new ArrayList<>();
        try {
            files = Files.walk(Paths.get(dataDirPath))
                    .map(f -> f.toAbsolutePath().toString())
                    .filter(p -> !Files.isDirectory(Paths.get(p)))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(files);
        for (String file : files) {
            Files.delete(Paths.get(file));
        }
    }

    @Test
    @Order(4)
    public void testTableCreation() throws Exception {
        DBApp dbApp = new DBApp();
        dbApp.init();

        createStudentTable(dbApp);
        createCoursesTable(dbApp);
        createTranscriptsTable(dbApp);
        createPCsTable(dbApp);

        dbApp = null;
    }

    @Test
    @Order(5)
    public void testRecordInsertions() throws Exception {
        DBApp dbApp = new DBApp();
        dbApp.init();
        int limit = 500;

        insertStudentRecords(dbApp, limit);
        insertCoursesRecords(dbApp, limit);
        insertTranscriptsRecords(dbApp, limit);
        insertPCsRecords(dbApp, limit);
        dbApp = null;
    }

    @Test
    public void testExtraStudentsInsertion() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "students";
        Hashtable<String, Object> row = new Hashtable();
        row.put("id", "31-1235");
        row.put("first_name", "foo");
        row.put("middle_name", "bateekh");
        row.put("last_name", "bar");


        Date dob = new Date(1995 - 1900, 4 - 1, 1);
        row.put("dob", dob);

        row.put("gpa", 1.1);


        Assertions.assertThrows(DBAppException.class, () -> {
                    dbApp.insertIntoTable(table, row);
                }
        );

    }

    @Test
    public void testExtraCoursesInsertion() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "courses";
        Hashtable<String, Object> row = new Hashtable();

        Date date_added = new Date(2011 - 1900, 4 - 1, 1);
        row.put("date_added", date_added);

        row.put("course_id", "foo");
        row.put("course_name", "bar");
        row.put("hours", 13);
        row.put("semester", 5);

        Assertions.assertThrows(DBAppException.class, () -> {
                    dbApp.insertIntoTable(table, row);
                }
        );

    }

    @Test
    public void testExtraTranscriptsInsertion() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "transcripts";
        Hashtable<String, Object> row = new Hashtable();
        row.put("gpa", 1.5);
        row.put("student_id", "34-9874");
        row.put("course_name", "bar");
        row.put("elective", true);


        Date date_passed = new Date(2011 - 1900, 4 - 1, 1);
        row.put("date_passed", date_passed);


        Assertions.assertThrows(DBAppException.class, () -> {
                    dbApp.insertIntoTable(table, row);
                }
        );
    }


    @Test
    public void testExtraPCsInsertion() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "pcs";
        Hashtable<String, Object> row = new Hashtable();
        row.put("pc_id", 50);
        row.put("student_id", "31-12121");
        row.put("room", "C7.02");

        Assertions.assertThrows(DBAppException.class, () -> {
                    dbApp.insertIntoTable(table, row);
                }
        );
    }

    @Test
    public void testUpdateStudents() throws Exception {
        DBApp dbApp = new DBApp();
        dbApp.init();


        BufferedReader studentsTable = new BufferedReader(new FileReader("src/main/resources/students_table.csv"));
        String record;
        int c = 1;

        String clusteringKey = "";
        Hashtable<String, Object> row = new Hashtable<>();
        while ((record = studentsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");
            clusteringKey = fields[0];
            c--;
        }
        studentsTable.close();

        String table = "students";

        row.put("first_name", "foo");
        row.put("last_name", "bar");

        Date dob = new Date(1992 - 1900, 9 - 1, 8);
        row.put("dob", dob);
        row.put("gpa", 1.1);

        dbApp.updateTable(table, clusteringKey, row);
        dbApp = null;
    }

    @Test
    public void testUpdateCourses() throws Exception {
        DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "courses";

        BufferedReader coursesTable = new BufferedReader(new FileReader("src/main/resources/courses_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = 1;

        String clusteringKey = "";
        while ((record = coursesTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");
            clusteringKey += fields[0].trim().substring(0, 4);
            clusteringKey += "-";
            clusteringKey += fields[0].trim().substring(5, 7);
            clusteringKey += "-";
            clusteringKey += fields[0].trim().substring(8);

            c--;
        }

        coursesTable.close();

        row.put("course_id", "1100");
        row.put("course_name", "bar");
        row.put("hours", 13);


        dbApp.updateTable(table, clusteringKey, row);
        dbApp = null;
    }

    @Test
    public void testUpdateTranscripts() throws Exception {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "transcripts";
        Hashtable<String, Object> row = new Hashtable();

        BufferedReader transcriptsTable = new BufferedReader(new FileReader("src/main/resources/transcripts_table.csv"));
        String record;

        int c = 1;
        String clusteringKey = "";
        while ((record = transcriptsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");
            clusteringKey = fields[0].trim();

            c--;
        }

        transcriptsTable.close();

        row.put("student_id", "43-9874");
        row.put("course_name", "bar");

        Date date_passed = new Date(2011 - 1900, 4 - 1, 1);
        row.put("date_passed", date_passed);

        dbApp.updateTable(table, clusteringKey, row);
    }

    @Test
    public void testUpdatePCs() throws Exception {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "pcs";
        Hashtable<String, Object> row = new Hashtable();
        row.put("student_id", "51-3808");

        BufferedReader pcsTable = new BufferedReader(new FileReader("src/main/resources/pcs_table.csv"));
        String record;

        int c = 1;
        String clusteringKey = "";

        while ((record = pcsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");
            clusteringKey = fields[0].trim();
            c--;

        }

        pcsTable.close();
         
        dbApp.updateTable(table, clusteringKey, row);

    }

    @Test
    public void testUpdateStudentsExtra() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "students";
        Hashtable<String, Object> row = new Hashtable();
        row.put("first_name", "foo");
        row.put("middle_name", "hamada");
        row.put("last_name", "bar");

        Date dob = new Date(1992 - 1900, 9 - 1, 8);
        row.put("dob", dob);
        row.put("gpa", 1.1);

        Assertions.assertThrows(DBAppException.class, () -> {
            dbApp.updateTable(table, "82-8772", row);
        });

    }

    @Test
    public void testUpdateCoursesExtra() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "courses";
        Hashtable<String, Object> row = new Hashtable();
        row.put("elective", true);
        row.put("course_id", "foo");
        row.put("course_name", "bar");
        row.put("hours", 13);
        row.put("semester", 5);


        Assertions.assertThrows(DBAppException.class, () -> {
            dbApp.updateTable(table, "2000-04-01", row);
        });
    }

    @Test
    public void testUpdateTranscriptsExtra() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "transcripts";
        Hashtable<String, Object> row = new Hashtable();

        row.put("student_id", "34-9874");
        row.put("course_name", "bar");

        Date date_passed = new Date(2011 - 1900, 4 - 1, 1);
        row.put("date_passed", date_passed);

        row.put("elective", true);

        Assertions.assertThrows(DBAppException.class, () -> {
            dbApp.updateTable(table, "1.57", row);
        });

    }

    @Test
    public void testUpdatePCsExtra() {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "pcs";
        Hashtable<String, Object> row = new Hashtable();

        row.put("student_id", "79-0786");
        row.put("os", "linux");

        Assertions.assertThrows(DBAppException.class, () -> {

            dbApp.updateTable(table, "00353", row);

        });


    }

    @Test
    public void testStudentsDeletionComplex() throws Exception {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        String table = "students";
        Hashtable<String, Object> row = new Hashtable();

        BufferedReader studentsTable = new BufferedReader(new FileReader("src/main/resources/students_table.csv"));
        String record;
        int c = 0;
        int finalLine = 1;


        while ((record = studentsTable.readLine()) != null && c <= finalLine) {
            if (c == finalLine) {
                String[] fields = record.split(",");
                row.put("id", fields[0]);

                int year = Integer.parseInt(fields[3].trim().substring(0, 4));
                int month = Integer.parseInt(fields[3].trim().substring(5, 7));
                int day = Integer.parseInt(fields[3].trim().substring(8));


                Date dob = new Date(year - 1900, month - 1, day);
                row.put("dob", dob);

                double gpa = Double.parseDouble(fields[4].trim());

                row.put("gpa", gpa);

            }
            c++;
        }
        studentsTable.close();


        dbApp.deleteFromTable(table, row);

    }

    @Test
    public void testCoursesDeleteComplex() throws Exception {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        BufferedReader coursesTable = new BufferedReader(new FileReader("src/main/resources/courses_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = 0;
        int finalLine = 1;
        while ((record = coursesTable.readLine()) != null && c <= finalLine) {
            if (c == finalLine) {
                String[] fields = record.split(",");

                int year = Integer.parseInt(fields[0].trim().substring(0, 4));
                int month = Integer.parseInt(fields[0].trim().substring(5, 7));
                int day = Integer.parseInt(fields[0].trim().substring(8));

                Date dateAdded = new Date(year - 1900, month - 1, day);
                row.put("date_added", dateAdded);
                row.put("course_name", fields[2]);


            }
            c++;
        }


        String table = "courses";

        dbApp.deleteFromTable(table, row);
    }


    @Test
    public void testTranscriptsDeleteComplex() throws Exception {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        BufferedReader transcriptsTable = new BufferedReader(new FileReader("src/main/resources/transcripts_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = 0;
        int finalLimit = 1;
        while ((record = transcriptsTable.readLine()) != null && c <= finalLimit) {
            if (c == finalLimit) {
                String[] fields = record.split(",");
                row.put("gpa", Double.parseDouble(fields[0].trim()));
                row.put("course_name", fields[2].trim());
            }
            c++;
        }

        transcriptsTable.close();

        String table = "transcripts";

        dbApp.deleteFromTable(table, row);
    }

    @Test
    public void testPCsDeleteComplex() throws Exception {
        final DBApp dbApp = new DBApp();
        dbApp.init();

        BufferedReader pcsTable = new BufferedReader(new FileReader("src/main/resources/pcs_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = 0;
        int finalLine = 1;
        while ((record = pcsTable.readLine()) != null && c <= finalLine) {
            if(c == finalLine) {
                String[] fields = record.split(",");

                row.put("pc_id", Integer.parseInt(fields[0].trim()));
                row.put("student_id", fields[1].trim());
            }
            c++;
        }


        String table = "pcs";
        dbApp.deleteFromTable(table, row);
    }


    private void insertStudentRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader studentsTable = new BufferedReader(new FileReader("src/main/resources/students_table.csv"));
        String record;
        int c = limit;
        if (limit == -1) {
            c = 1;
        }

        Hashtable<String, Object> row = new Hashtable<>();
        while ((record = studentsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");

            row.put("id", fields[0]);
            row.put("first_name", fields[1]);
            row.put("last_name", fields[2]);

            int year = Integer.parseInt(fields[3].trim().substring(0, 4));
            int month = Integer.parseInt(fields[3].trim().substring(5, 7));
            int day = Integer.parseInt(fields[3].trim().substring(8));

            Date dob = new Date(year - 1900, month - 1, day);
            row.put("dob", dob);

            double gpa = Double.parseDouble(fields[4].trim());

            row.put("gpa", gpa);

            dbApp.insertIntoTable("students", row);
            row.clear();
            if (limit != -1) {
                c--;
            }
        }
        studentsTable.close();
    }

    private void insertCoursesRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader coursesTable = new BufferedReader(new FileReader("src/main/resources/courses_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = limit;
        if (limit == -1) {
            c = 1;
        }
        while ((record = coursesTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");


            int year = Integer.parseInt(fields[0].trim().substring(0, 4));
            int month = Integer.parseInt(fields[0].trim().substring(5, 7));
            int day = Integer.parseInt(fields[0].trim().substring(8));

            Date dateAdded = new Date(year - 1900, month - 1, day);

            row.put("date_added", dateAdded);

            row.put("course_id", fields[1]);
            row.put("course_name", fields[2]);
            row.put("hours", Integer.parseInt(fields[3]));

            dbApp.insertIntoTable("courses", row);
            row.clear();

            if (limit != -1) {
                c--;
            }
        }

        coursesTable.close();
    }

    private void insertTranscriptsRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader transcriptsTable = new BufferedReader(new FileReader("src/main/resources/transcripts_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = limit;
        if (limit == -1) {
            c = 1;
        }
        while ((record = transcriptsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");

            row.put("gpa", Double.parseDouble(fields[0].trim()));
            row.put("student_id", fields[1].trim());
            row.put("course_name", fields[2].trim());

            String date = fields[3].trim();
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8));

            Date dateUsed = new Date(year - 1900, month - 1, day);
            row.put("date_passed", dateUsed);

            dbApp.insertIntoTable("transcripts", row);
            row.clear();

            if (limit != -1) {
                c--;
            }
        }

        transcriptsTable.close();
    }

    private void insertPCsRecords(DBApp dbApp, int limit) throws Exception {
        BufferedReader pcsTable = new BufferedReader(new FileReader("src/main/resources/pcs_table.csv"));
        String record;
        Hashtable<String, Object> row = new Hashtable<>();
        int c = limit;
        if (limit == -1) {
            c = 1;
        }
        while ((record = pcsTable.readLine()) != null && c > 0) {
            String[] fields = record.split(",");

            row.put("pc_id", Integer.parseInt(fields[0].trim()));
            row.put("student_id", fields[1].trim());

            dbApp.insertIntoTable("pcs", row);
            row.clear();

            if (limit != -1) {
                c--;
            }
        }

        pcsTable.close();
    }

    private void createStudentTable(DBApp dbApp) throws Exception {
        // String CK
        String tableName = "students";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("id", "java.lang.String");
        htblColNameType.put("first_name", "java.lang.String");
        htblColNameType.put("last_name", "java.lang.String");
        htblColNameType.put("dob", "java.util.Date");
        htblColNameType.put("gpa", "java.lang.Double");

        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("id", "43-0000");
        minValues.put("first_name", "AAAAAA");
        minValues.put("last_name", "AAAAAA");
        minValues.put("dob", "1990-01-01");
        minValues.put("gpa", "0.7");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("id", "99-9999");
        maxValues.put("first_name", "zzzzzz");
        maxValues.put("last_name", "zzzzzz");
        maxValues.put("dob", "2000-12-31");
        maxValues.put("gpa", "5.0");

        dbApp.createTable(tableName, "id", htblColNameType, minValues, maxValues);
    }


    private void createCoursesTable(DBApp dbApp) throws Exception {
        // Date CK
        String tableName = "courses";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("date_added", "java.util.Date");
        htblColNameType.put("course_id", "java.lang.String");
        htblColNameType.put("course_name", "java.lang.String");
        htblColNameType.put("hours", "java.lang.Integer");


        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("date_added", "1901-01-01");
        minValues.put("course_id", "0000");
        minValues.put("course_name", "AAAAAA");
        minValues.put("hours", "1");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("date_added", "2020-12-31");
        maxValues.put("course_id", "9999");
        maxValues.put("course_name", "zzzzzz");
        maxValues.put("hours", "24");

        dbApp.createTable(tableName, "date_added", htblColNameType, minValues, maxValues);

    }

    private void createTranscriptsTable(DBApp dbApp) throws Exception {
        // Double CK
        String tableName = "transcripts";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("gpa", "java.lang.Double");
        htblColNameType.put("student_id", "java.lang.String");
        htblColNameType.put("course_name", "java.lang.String");
        htblColNameType.put("date_passed", "java.util.Date");

        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("gpa", "0.7");
        minValues.put("student_id", "43-0000");
        minValues.put("course_name", "AAAAAA");
        minValues.put("date_passed", "1990-01-01");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("gpa", "5.0");
        maxValues.put("student_id", "99-9999");
        maxValues.put("course_name", "zzzzzz");
        maxValues.put("date_passed", "2020-12-31");

        dbApp.createTable(tableName, "gpa", htblColNameType, minValues, maxValues);
    }


    private void createPCsTable(DBApp dbApp) throws Exception {
        // Integer CK
        String tableName = "pcs";

        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("pc_id", "java.lang.Integer");
        htblColNameType.put("student_id", "java.lang.String");


        Hashtable<String, String> minValues = new Hashtable<>();
        minValues.put("pc_id", "0");
        minValues.put("student_id", "43-0000");

        Hashtable<String, String> maxValues = new Hashtable<>();
        maxValues.put("pc_id", "20000");
        maxValues.put("student_id", "99-9999");

        dbApp.createTable(tableName, "pc_id", htblColNameType, minValues, maxValues);
    }
}

