package lt.daivospakalikai.academysurvey.emailsend;

import java.util.ArrayList;

public class Admin {

    public ArrayList<String> emailProcess(AdminMails[] adminMails) {
        ArrayList<String> correctEmails = new ArrayList<String>();
        for (AdminMails adminEmail : adminMails) {
            String email = adminEmail.toString();
            String correctEmail = email.replace("at","@");
            correctEmail = correctEmail.replace("dot", ".");
            correctEmail = correctEmail.replace("dot", ".");
            correctEmails.add(correctEmail);
        }
        return correctEmails;
    }

    public String[] getAdminEmails(ArrayList<String> list) {
        String[] listArray = new String[list.size()];
        listArray = list.toArray(listArray);
        return listArray;
    }
}
