import com.playtika.user.Day;
import com.playtika.user.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Nu am avut voie sa folosim Liste in rezolvarea problemei, doar vectori simpli.
// Daca as fi avut voie as fi rezolvat altfel , as fi creat un camp in clasa Day care sa fie un arrayList cu toti useri pt ziua respectiva
// Cu vectori normali nu pot sa fac asa pentru ca nu stiu dimensiunea initiala a vectorului , as fi putut initializa acei vectori cu dimensiunea
// vectorului de input si sa fiu atent sa nu accesez elemente nule , dar ar fi fost o risipa de memorie.
public class Main {
    public static void main(String[] args) {
        String[] playerList = { "24.07.2021 abcd.defg12 5.4" ,
                "25.07.2021 abcd.defg12 4.3",
                "24.07.2021 abhjd.hasghd 3.5",
                "26.07.2021 $sdhsgdh.ahdgh12 1.2",
                "25.07.2021 alex.ionescu93 2.7",
                "24.07.2021 dan.ion 2.9",
                "24.07.2021 ana.popescu00 3.1",
                "24.07.2021 ioanavasilescu12 3.5",
                "26.07.2021 gloria.abcd23 1.9",
                "25.07.2021 fast.4you23 1.5",
                "25.07.2021 dan.marin45 5.3"  };

        // users - vectorul care va detine informatii despre toti userii din joc
        User[] users = new User[playerList.length];

        Pattern p = Pattern.compile("[a-z]{2,}\\.[a-z]{2,}\\d{2}$");

        for (int i = 0; i < playerList.length; i++) {

            // parcurgem fiecare element din vectorul din input si facem split dupa caracterul " "
            String[] split = playerList[i].split(" ");
            // in splite[0] va fi data pe care o formatam intr-un LocaleDate
            String date = split[0];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            // in splite[1] va fi username-ul
            String username = split[1];
            // in splite[2] va fi timpul
            float time = Float.parseFloat(split[2]);
            // introducem in vectorul noul user
            users[i] = new User(localDate, username, time);

        }

        // parcurgem vectorul de useri si pentru fiecare data de timp noua se creeaza un obicet de tip Day
        // dupa aceea se parcurge vectorul cautand toti userii care s-au jucat in acea zi
        // se aduna timpul lor si se incrementeaza numarul de jucatori in obiectul Day
        // de altfel , acest user care s-a jucat in acea zi este marcat ca bifat prin setarea campului 'isCalculated'
        // pentru ca acesta sa nu mai fie luat din nou in considerare la parcurgerea ulterioara a vectorului de useri
        for (int i = 0; i < users.length; i++) {
            Matcher m = p.matcher(users[i].getUsername());

            if(!users[i].isCalculated() && m.matches()) {
                Day day = new Day(users[i].getDateTime(), users[i].getTime());

                for (int j = i + 1; j < users.length; j++) {
                    Matcher m2 = p.matcher(users[j].getUsername());

                    if(users[j].getDateTime().equals(day.getLocalDate()) && !users[i].isCalculated() && m2.matches()) {
                        day.incrementCount();
                        day.addTime(users[j].getTime());
                        users[j].setCalculated(true);
                    }
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd eeee");
                System.out.println(day.getLocalDate().format(formatter) + ". Avg playing time: " + day.getAverage()+ " h");
            }
        }
    }
}
