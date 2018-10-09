package cloud.assignment2.cloudassignment2.Receipt;

import cloud.assignment2.cloudassignment2.Expense.ExpensePojo;
import cloud.assignment2.cloudassignment2.Expense.ExpenseRepository;
import cloud.assignment2.cloudassignment2.user.UserDao;
import com.google.gson.JsonObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@Configuration
@Profile("local")
public class ReceiptController {

    @Autowired
    UserDao userDao;

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    ReceiptRepository receiptRepository;


    @RequestMapping(value="/transaction/{id}/attachments" , method = RequestMethod.POST)
    public String receiptUpload(@PathVariable(value="id") String transactionId, @RequestParam ("file") MultipartFile file, HttpServletRequest req,
                                HttpServletResponse res){

        System.out.println("DEV Environment");

        JsonObject json = new JsonObject();
        String filePath = "/home/namanbhargava/Documents/";
        String fileName = file.getOriginalFilename();
        String NewPath = filePath + fileName;
        System.out.println("PATH IS " + filePath);
        String header = req.getHeader("Authorization");
        if(header != null) {
            int result = userDao.authUserCheck(header);
            if(result>0)
            {
                List<ExpensePojo> expensePojoRecord = expenseRepository.findAllById(transactionId);
                if(expensePojoRecord.size()>0){
                    ExpensePojo expenseRecord = expensePojoRecord.get(0);
                    if(Integer.parseInt(expenseRecord.getUserId()) == result)
                    {

                        File dest = new File(NewPath);
                        try {
                            file.transferTo(dest);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ReceiptPojo receiptPojo = new ReceiptPojo();
                        receiptPojo.setTaskId(transactionId);
                        receiptPojo.setUrl(NewPath);
                        receiptPojo.setUserId(String.valueOf(result));
                        receiptRepository.save(receiptPojo);
                        res.setStatus(HttpServletResponse.SC_OK);
                        json.addProperty("message","File uploaded");
                    }
                    else{
                        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        json.addProperty("message","You are unauthorized. UserId do not match");
                    }

                }
                else{
                    res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    json.addProperty("message","Bad Request! No id found");
                }
            }
            else{
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                json.addProperty("message","You are unauthorized");
            }

        }else{
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            json.addProperty("message","You are unauthorized");
        }
        return json.toString();
    }

}
