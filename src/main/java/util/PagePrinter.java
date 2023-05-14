package util;

import datamanipulation.CsvReader;
import exceptions.DBAppException;
import util.filecontroller.Serializer;
import storage.Cell;
import storage.Page;
import storage.Table;
import storage.Tuple;
import java.util.ArrayList;

public class PagePrinter {

    Page page;
    ArrayList<String> colOrder;
    String line;
    
    public PagePrinter(Page page) throws DBAppException {
        this.page = page;
        colOrder = getColOrder();
        line = createLine();
    }

    public void printPage() throws DBAppException {
        printColName();
        println();
        printData();


    }

    public ArrayList<String> getColOrder() throws DBAppException {
        CsvReader readInfo = new CsvReader();
        ArrayList<String[]> colsInfo = readInfo.readTable(page.getTableName());
        Table table = Serializer.deserializeTable(page.getTableName());

        ArrayList<String> colOrder = new ArrayList<>();
        colOrder.add(table.getPKColumn());
        for (String [] colProp : colsInfo)
            if (!colProp[1].equals(table.getPKColumn()))
                colOrder.add(colProp[1]);

        return colOrder;
    }

    public void printColName() {
        for (String colName:colOrder)
            System.out.print(completeString(colName)+'|');
    }
    
    public void printData() {
        for (Tuple tuple : page.getTuples()) {
            printDataOrdered(tuple);
            println();
        }
    }

    private void printDataOrdered(Tuple tuple) {
        for (String col : colOrder) {
            printcell(col, tuple);
        }
    }

    private void printcell(String col, Tuple tuple) {
        for (Cell cell : tuple.getCells()) {
            if (cell.getKey().equals(col))
                System.out.print(completeString(cell.getValue().toString())+"|");
        }
    }

    public void println() {
        System.out.println();
        System.out.println(line);
    }

    public String createLine() {
        String line = "----------";
        for (int i=1; i!= colOrder.size(); i++) {
            for (int j=0; j!= 10; j++)
                line+="-";
        }
        return line;
    }

    public String completeString(String data) {
        while (data.length()<10)
            data+=" ";
        return data;
    }

}
