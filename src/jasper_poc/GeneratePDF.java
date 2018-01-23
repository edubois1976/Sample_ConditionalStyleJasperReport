package jasper_poc;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class GeneratePDF {

    public static void main(String[] args) {
        try {
            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader
                    .load("D:\\IDE\\user\\workspaceTCPMET181\\Sample_ConditionalStyleJasperReport\\report1.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            // - Paramètres à envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("parameter1", "Olives");
            parameters.put("parameter2", "à la méditerranéenne");
            parameters.put("parameter3", "0123456789123");
            parameters.put("parameter4", "*0123456789123*");

            JRDataSource jrDataSource = new JREmptyDataSource(1);

            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);

            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                    "D:\\IDE\\user\\workspaceTCPMET181\\Sample_ConditionalStyleJasperReport\\sample.pdf");

            System.out.println("PDF done");
        } catch (JRException e) {

            e.printStackTrace();
        }

    }

}
