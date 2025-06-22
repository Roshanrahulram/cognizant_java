
import java.util.*;

interface Document{
    void open();
    void save();
    void close();
}

class WordDocument implements Document{
    @Override
    public void open(){
        System.out.println("Open word document...");
    }

    @Override
    public void save(){
        System.out.println("Save Word document...");
    }

    @Override
    public void close(){
        System.out.println("Close Word Document...");
    }
}
class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Open PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Save PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Close PDF document...");
    }
}
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Open Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Save Excel document...");
    }

    @Override
    public void close() {
        System.out.println("Close Excel document...");
    }
}
abstract class DocumentFactory {
    public abstract Document createDocument();
}
class WordFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
public class Factory {
    public static void main(String[] args) {
       
        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PdfFactory();
        DocumentFactory excelFactory = new ExcelFactory();

     
        Document wordDocument = wordFactory.createDocument();
        Document pdfDocument = pdfFactory.createDocument();
        Document excelDocument = excelFactory.createDocument();

     
        wordDocument.open();
        wordDocument.save();
        wordDocument.close();

        pdfDocument.open();
        pdfDocument.save();
        pdfDocument.close();

        excelDocument.open();
        excelDocument.save();
        excelDocument.close();
    }
}
