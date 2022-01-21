package com.example.isa212.Services.Implementations;

import com.example.isa212.Model.Adventure;
import com.example.isa212.Model.Boat;
import com.example.isa212.Model.Cottage;
import com.example.isa212.Model.Reservation;
import com.example.isa212.Model.Users.Admin;
import com.example.isa212.Model.Users.Users;
import com.google.zxing.WriterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Component
public class ServiceForEmail {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private Environment environment;

    //https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch26s03.html


    public void emailForValidationAccount(Users user) throws MessagingException, IOException, WriterException {

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Validation link");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(user.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Welcome to our system. Please verify your account.</H1>" +
                "<a href=http://localhost:3000/Verify/"+user.getId()+"> Click here! </a>";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void SendLinkWithPassword(Admin user, String pass) throws MessagingException {

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Validation link");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(user.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Welcome to our system.Pleas sing in to change password!.</H1>" +
                "<p> Your password now is: " + pass +" </p>" +
                "<a href=http://localhost:3000/ChangeAdminPass/"+user.getId()+"> Click here! </a>";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();

    }

    public void disapproveEmail(Users users, String text) throws MessagingException {

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Registration denid");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(users.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Your account has been denid! <h1>" +
                "<p>"+ text+ " </p>";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }


    public void SendInformationAboutReservationCottage(Users user, Reservation r, Cottage cottage) throws MessagingException {

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Reserved successeffully!");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(user.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Successeffully reservec Cottage! <h1>"
                +"<p> Cottage name:"+ cottage.getName() + " </p>"
                +"<p> Cottage address:"+ cottage.getAddress() + " </p>"
                +"<p> Reservation date:"+ r.getStartDate() + " </p>"
                +"<p> Num day:"+ r.getNumDays() + " </p>"
                +"<p> Reservation type Action/Standard"+ r.getReservationFastType() + " </p>";



        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();





    }

    public void SendInformationAboutReservationBoat(Users user, Reservation r, Boat boats) throws MessagingException {

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Reserved successeffully!");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(user.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Successeffully reservec Boat! <h1>"
                +"<p> Boat name:"+ boats.getName() + " </p>"
                +"<p> Boat address:"+ boats.getAddress() + " </p>"
                +"<p> Reservation date:"+ r.getStartDate() + " </p>"
                +"<p> Num day:"+ r.getNumDays() + " </p>"
                +"<p> Reservation type Action/Standard"+ r.getReservationFastType() + " </p>";



        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void SendInformationAboutReservationAdventure(Users user, Reservation r, Adventure adventure) throws MessagingException {
        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Reserved successeffully!");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(user.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Successeffully reservec Adventure! <h1>"
                +"<p> Adventure name:"+ adventure.getName() + " </p>"
                +"<p> Adventure address:"+ adventure.getAddress() + " </p>"
                +"<p> Reservation date:"+ r.getStartDate() + " </p>"
                +"<p> Num day:"+ r.getNumDays() + " </p>"
                +"<p> Reservation type Action/Standard"+ r.getReservationFastType() + " </p>";



        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();

    }

    /*public void sendingAnEmailToAcceptTheOffer (DrugOrder order, Offer offer) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+offer.getSupplier().getEmail() );

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello, the offer you made for pharmacy: "+ order.getPharmacyAdmin().getPharmacy().getName()+ " is accepted</p>" +
                        "<p>Thank You.We are looking forward to future business</p>";
        helper.setText(htmlMsg, true);
        helper.setTo(offer.getSupplier().getEmail());
        helper.setSubject("Rejected absence");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingAnEmailToRejectTheOffer (DrugOrder order, Offer offer) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+offer.getSupplier().getEmail() );

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello, the offer you made for pharmacy: "+ order.getPharmacyAdmin().getPharmacy().getName()+ " is rejected </p>";

        helper.setText(htmlMsg, true);
        helper.setTo(offer.getSupplier().getEmail());
        helper.setSubject("Rejected absence");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingMailToPatientForExamination(Examination ex,Patient patient) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+patient.getEmail());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>You have successfully scheduled an examination!" +
                        ex.getDate()+" "+ex.getStartTime()+"-"+ex.getEndTime()+"</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Schedule examination");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }

    public void sendingMailToPatientForReservattion(Integer idReservation,Patient patient) throws MessagingException {
        // TODO Auto-generated method stub
        System.out.println("usao u funkc za slanje mejla "+patient.getEmail());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>You have successfully reserve an drug!" +"Unique number of Reservation:"
                        +idReservation+"</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Reserve drug");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }
/*
    public void sendEmailForPasswordChange(String email, String password) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p><b> Welcome! " + email  + " </b> You are the one of admin of the pharmacy system.</p><br>"
                        + " <p>Your password for login: " + password + "."
                        + "<p>Please login to page: </p>"
                        + "<a> http://localhost:3000/login </a>";

        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject("M-PHARMACY ADMIN");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");


    }

*/


    /*public void sendingAnEmailToInformPatientAboutExamination (ExaminationDTO examinationDTO) throws MessagingException {

       // System.out.println("usao u funkc za slanje mejla "+offer.getSupplier().getEmail() );
        Patient patient=patientService.findById(examinationDTO.getIdPatient());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello,you have an appointment at the pharmacy  "+ examinationDTO.getName()+ " Date of examination :"+examinationDTO.getDate()+" .Start date "+examinationDTO.getStart()+" </p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Rejected absence");
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingEmailsForActionAndPromotions (Patient patient,String pharmacyName,String text) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello,pharmacy "+pharmacyName+"has new action:"+text+"</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingEmailToAcceptRequestForVacation (RequestForVacation requestForVacation) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello "+requestForVacation.getStaff().getName() +", Your request for vacation is accept.</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(requestForVacation.getStaff().getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }

    public void sendingEmailToRejectRequestForVacation (RequestForVacation requestForVacation,String text) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello "+requestForVacation.getStaff().getName() +", Your request for vacation is reject because "+text+" .</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(requestForVacation.getStaff().getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }


    public void sendingEmailToInformPatient (Patient patient) throws MessagingException {
        // TODO Auto-generated method stub


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg =
                "<p>Hello ,  Patient successfully took the drug</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(patient.getEmail());
        helper.setSubject("Rejected absence");///////////////////////ovo promijeni
        helper.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(mimeMessage);
        System.out.println("kraj funkc!");
    }

    public void sendERecepieToPatient(ERecipe eRecipe) throws MessagingException, IOException, WriterException {
        String fileName = eRecipe.getName() + "_" +eRecipe.getSurname() + "_" + eRecipe.getDateOfIssue() +"_" + eRecipe.getIdRecipe();
        String QR_CODE_IMAGE_PATH = "./qrCodes/" + fileName +".png";
        createqrCodeForEReceie(eRecipe);

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("eRecepie QR CODE");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(eRecipe.getPatient().getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Please, download this pictur than upload to yout profile page qrCode eRecpeti.</H1><img src=\"cid:image\">";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource
                (QR_CODE_IMAGE_PATH);
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID","<image>");

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    private void createqrCodeForEReceie(ERecipe eRecipe) throws IOException, WriterException {
        String fileName = eRecipe.getName() + "_" +eRecipe.getSurname() + "_" + eRecipe.getDateOfIssue() +"_"+eRecipe.getIdRecipe();
        String QR_CODE_IMAGE_PATH = "./qrCodes/" + fileName +".png";
        generateQRCodeImage(eRecipe, QR_CODE_IMAGE_PATH);



    }

    public static void generateQRCodeImage(ERecipe eRecipe, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(eRecipe.toString(), BarcodeFormat.QR_CODE, 400, 400);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    //Cita sa qrCoda
    public byte[] getQRCodeImage() throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("EJ TII ", BarcodeFormat.QR_CODE, 400, 400);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }*/



    /*public void emailForUnsubscribe(Pharmacy pharmacy, String email) throws MessagingException, IOException, WriterException {
        /*String fileName = eRecipe.getName() + "_" +eRecipe.getSurname() + "_" + eRecipe.getDateOfIssue() +"_" + eRecipe.getIdRecipe();
        String QR_CODE_IMAGE_PATH = "./qrCodes/" + fileName +".png";
        createqrCodeForEReceie(eRecipe);*/

        /*Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Info from " + pharmacy.getName());
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(email));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>You are now unsubscribe from our pharmacy. You will no longer get our notification..</H1>" +
                "<p>Name: "+ pharmacy.getName() + "</p>" +
                "<p>Address:"+ pharmacy.getAddress()+","+pharmacy.getCity() +".</p>";
        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void sendVerification(String email) throws MessagingException {

        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Verify your email");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(email));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1> Welcome to our pharmacy comunity.. we are glade to have you.</H1>" +
                "<p> You can now se what we have in offer, schedule your examination and so more.. </p>" +
                "<a href='http://localhost:3000/login'>Click on this to go to your account. </a>" +
                "<p> You are welcome here. </p>";

        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void sendEmailAnswerComplain(String text, Patient patient) throws MessagingException {
      Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Complain answer:");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(patient.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H4> Dear " +patient.getName() +" " + patient.getSurname() +",</H4>" +
                "<p>" + text + "</p>" +
                "<p> System admin. </p>";

        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();



    }

    public void sendERecepieVerification(Patient patient, Pharmacy pharmacy) throws MessagingException {
        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("eRecepie approved");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(patient.getEmail()));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H4> Dear " +patient.getName() +" " + patient.getSurname() +",</H4>" +
                "<p>You successeffuly buy drugs in " + pharmacy.getName() + ". </p>" +
                "<p> System admin. </p>";

        messageBodyPart.setContent(htmlText, "text/html");

        multipart.addBodyPart(messageBodyPart);


        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();


    }


    public void sendRegistrationEmail(String email, String name, String lastname) throws MessagingException {
        Properties props = new Properties();
        //props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session mailSession = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("blackcetkica@gmail.com", "maja.maja98");
                    }
                });
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Password reReset");
        message.setFrom(new InternetAddress("me@sender.com"));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(email));

        MimeMultipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H4> Dear " + name +" " + lastname + ". </p>" +
                "<p> You have been successeffully registered in phamracy. </p>" +
                "<p> Your current password is: <b> 123 </b></p>" +
                "<p> Pleas check <a href='http://localhost:3000/login'> this link  </a> and insert password in order to change it. </p>" +
                "<p> System admin. </p>";

        messageBodyPart.setContent(htmlText, "text/html");
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();


    }



    /*



    	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>



		spring.mail.host = smtp.gmail.com
spring.mail.username = kristinamucibabic321@gmail.com
spring.mail.password =
spring.mail.port=587
spring.mail.properties.mail.smtp.starttls.enable = true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.auth=true



     */

/*

    @Autowired
    private Environment environment;
*/





    //https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch26s03.html
}
