import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.IOException;
public class Main {

  public String makeInvoice(String []data) throws IOException{
        String path ="C:\\Users\\Akshay\\Desktop\\Invoice.pdf";
        PdfWriter pdfWriter=new PdfWriter(path);
        PdfDocument pdfDocument= new PdfDocument(pdfWriter);
        Document document=new Document(pdfDocument);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        float col=280f;
        float [] columnWidth={col, col};
        Table table=new Table(columnWidth);

        table.setBackgroundColor(new DeviceRgb(63,169,219))
                .setFontColor(new DeviceRgb(0, 0, 0));
        table.addCell(new Cell().add(new Paragraph("INVOICE"))
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setFontSize(30f)
                .setBorder(Border.NO_BORDER)
        );

        table.addCell(new Cell().add(new Paragraph("Rutuja Tate\nPune\n7559142457"))
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setBorder(Border.NO_BORDER)
                .setMarginRight(10f)


        );

        float [] colWidth={180,300,100,80};
        Table customerInfoTable=new Table(colWidth);

        customerInfoTable.addCell(new Cell(0,4)
                .add(new Paragraph("Customer Information"))
                .setBold()
                .setBorder(Border.NO_BORDER));

        customerInfoTable.addCell(new Cell().add(new Paragraph("Name:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Rajashri Tate.")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Invoice No.")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("478556")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Invoice Type:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Prime Billing")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Billing Category:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("MISC")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Settlement Period:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("20200304")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Date:")).setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add(new Paragraph("14/06/2024")).setBorder(Border.NO_BORDER));

        document.add(table);
        document.add(new Paragraph("\n"));
        document.add(customerInfoTable);
        document.close();
        System.out.println("Pdf Created");

        return  path;
    }

    public static void main(String[] args)throws IOException {
        try{
            String[] data = new String[10];  // an array with 10 elements

            Main m = new Main();
            String pdfFilePath =  m.makeInvoice(data);
            System.out.println("PDF file path :: "+ pdfFilePath);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}