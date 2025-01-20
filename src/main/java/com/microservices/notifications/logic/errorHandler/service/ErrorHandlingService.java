package com.microservices.notifications.logic.errorHandler.service;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.microservices.notifications.commons.SequenceGeneratorService;
import com.microservices.notifications.logic.errorHandler.repository.ErrorHandlerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

import static com.microservices.shared_utils.barcodeUtility.BarcodeUtility.generateBarCode;


@Service
public class ErrorHandlingService {
    private static final String ERROR_REPORTING_TEMPLATE_NAME = "system_error_reporting";


    // @Autowired
    // private ContextAwareMultiThread executorService;

    @Autowired
    private ErrorHandlerRepo errorHandlerRepo;

    @Autowired
    private SequenceGeneratorService seqService;

    /*public StatusResponse handleError(String serviceName, String exMessage, String exFullInfo) throws Exception {
        ErrorHandler errorHandler = new ErrorHandler(); // Assuming ErrorHandler is your entity class
        errorHandler.setId(seqService.getSequenceNumber(ErrorHandler.SEQUENCE_COMMENTS));
        errorHandler.setServiceName(serviceName);
        errorHandler.setExMessage(exMessage);
        errorHandler.setExFullInfo(exFullInfo);
        errorHandler.setCreatedAt(new Date());
        errorHandlerRepo.save(errorHandler);

        // Chinmay
        HttpResponse<String> httpResponse = CentralEngagementOps.getTriggerAPIBuilder(CentralEngagementOps.getWhatsAppRequestBody(new ArrayList<>(List.of(new String[]{serviceName, exMessage, exFullInfo})), ERROR_REPORTING_TEMPLATE_NAME, null, "919011103061"));
        executorService.execute(() -> {
            try {

                // LTR Service (Office No)
                // CentralEngagementOps.getTriggerAPIBuilder(CentralEngagementOps.getWhatsAppRequestBody(new ArrayList<>(List.of(new String[]{serviceName, exMessage, exFullInfo})), ERROR_REPORTING_TEMPLATE_NAME, null, "919416821903"));

                // Prachi - Frontend Dev
                CentralEngagementOps.getTriggerAPIBuilder(CentralEngagementOps.getWhatsAppRequestBody(new ArrayList<>(List.of(new String[]{serviceName, exMessage, exFullInfo})), ERROR_REPORTING_TEMPLATE_NAME, null, "919284061931"));

                // Dipak - Frontend Dev
                CentralEngagementOps.getTriggerAPIBuilder(CentralEngagementOps.getWhatsAppRequestBody(new ArrayList<>(List.of(new String[]{serviceName, exMessage, exFullInfo})), ERROR_REPORTING_TEMPLATE_NAME, null, "919112751660"));

                // Satish - Backend
                CentralEngagementOps.getTriggerAPIBuilder(CentralEngagementOps.getWhatsAppRequestBody(new ArrayList<>(List.of(new String[]{serviceName, exMessage, exFullInfo})), ERROR_REPORTING_TEMPLATE_NAME, null, "919552021923"));

                // Nitin - UX Researcher
                CentralEngagementOps.getTriggerAPIBuilder(CentralEngagementOps.getWhatsAppRequestBody(new ArrayList<>(List.of(new String[]{serviceName, exMessage, exFullInfo})), ERROR_REPORTING_TEMPLATE_NAME, null, "917666558443"));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        System.out.println("Error reported :- " + httpResponse.getStatus() + " => " + httpResponse.getBody());
        return new StatusResponse(
                true,
                "Error Reported"
        );
    }*/


    public ResponseEntity<Object> createBarcode(String text, Integer height, Integer width) {
//       Optional<Items> item = itemRepo.findById(itemId);
//       if (item.isEmpty())
//           return ResponseEntity.ok(new StatusResponse(false, "Item Not Exist"));

        byte[] barcodeImage = generateBarCode(text, height, width, null).getBody();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);

        ImageData imageData = ImageDataFactory.create(barcodeImage);
        PdfDocument pdfDocument = new PdfDocument(writer);
        pdfDocument.setDefaultPageSize(new PageSize(imageData.getWidth(), imageData.getHeight()));

        Document document = new Document(pdfDocument, new PageSize(imageData.getWidth(), imageData.getHeight()));
        document.setMargins(0, 0, 0, 0);

        Image image = new Image(imageData);
        image.setFixedPosition(0, 0);
        document.add(image);
        document.close();

        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Items_Barcode.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }

}
