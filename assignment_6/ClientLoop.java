import java.net.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class ClientLoop {
    static String[] firstNames = { "Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank",
            "George",
            "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul",
            "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter" };

    static String[] lastNames = { "Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon",
            "Cast",
            "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson",
            "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser",
            "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel",
            "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney",
            "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail",
            "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein",
            "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal",
            "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis",
            "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher",
            "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen",
            "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff",
            "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson",
            "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom",
            "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan",
            "Tisler" };

    static String[] cities = {
            "New York",
            "Los Angeles",
            "Chicago",
            "Houston",
            "Phoenix",
            "Philadelphia",
            "San Antonio",
            "San Diego",
            "Dallas",
            "San Jose",
            "Detroit",
            "Jacksonville",
            "Indianapolis",
            "San Francisco",
            "Columbus",
            "Austin",
            "Memphis",
            "Fort Worth",
            "Baltimore",
            "Charlotte",
            "El Paso",
            "Boston",
            "Seattle",
            "Washington",
            "Milwaukee",
            "Denver",
            "Louisville/Jefferson County",
            "Las Vegas",
            "Nashville-Davidson",
            "Oklahoma City",
            "Portland",
            "Tucson",
            "Albuquerque",
            "Atlanta",
            "Long Beach",
            "Fresno",
            "Sacramento",
            "Mesa",
            "Kansas City",
            "Cleveland",
            "Virginia Beach",
            "Omaha",
            "Miami",
            "Oakland",
            "Tulsa",
            "Honolulu",
            "Minneapolis",
            "Colorado Springs",
            "Arlington",
            "Wichita",
            "Raleigh",
            "St. Louis",
            "Santa Ana",
            "Anaheim",
            "Tampa",
            "Cincinnati",
            "Pittsburgh",
            "Bakersfield",
            "Aurora",
            "Toledo",
            "Riverside",
            "Stockton",
            "Corpus Christi",
            "Newark",
            "Anchorage",
            "Buffalo",
            "St. Paul",
            "Lexington-Fayette",
            "Plano",
            "Fort Wayne",
            "St. Petersburg",
            "Glendale",
            "Jersey City",
            "Lincoln",
            "Henderson",
            "Chandler",
            "Greensboro",
            "Scottsdale",
            "Baton Rouge",
            "Birmingham",
            "Norfolk",
            "Madison",
            "New Orleans",
            "Chesapeake",
            "Orlando",
            "Garland",
            "Hialeah",
            "Laredo",
            "Chula Vista",
            "Lubbock",
            "Reno",
            "Akron",
            "Durham",
            "Rochester",
            "Modesto",
            "Montgomery",
            "Fremont",
            "Shreveport",
            "Arlington",
            "Glendale",
    };

    public static void main(String[] args) {
        DatagramSocket socket = null;
        int i = 0;

        try {
            socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(args[0]);

            for (;;) {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);

                String name = firstNames[ThreadLocalRandom.current().nextInt(0, firstNames.length)]
                        + " " + lastNames[ThreadLocalRandom.current().nextInt(0, lastNames.length)];

                Person p = new Person(
                        name,
                        cities[ThreadLocalRandom.current().nextInt(0, cities.length)],
                        i++);

                oos.writeObject(p);
                byte[] data = os.toByteArray();

                DatagramPacket packet = new DatagramPacket(data, data.length, ip, Integer.parseInt(args[1]));
                socket.send(packet);

                long delay = Math.round(Math.random() * Integer.parseInt(args[2]));
                System.out.println("Sent " + name + " number " + i + ", sleeping for: " + delay + " ms");
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

}
