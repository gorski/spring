package com.trainings.spring.basic.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class QrController {

    @Inject
    QRCodeWriter wr;

    @RequestMapping("/qr/{text:.+}")
    public void getQr(@PathVariable("text") String txt, HttpServletResponse r) throws WriterException, IOException {
        MatrixToImageWriter.writeToStream(
                wr.encode(txt, BarcodeFormat.QR_CODE, 600, 600), "png", r.getOutputStream());
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody Test test(){
        return new Test();
    }
}
