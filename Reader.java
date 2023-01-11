import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) throws IOException {
        FileReader FRTrack1 = new FileReader("src/Pure_Furies__Whereabouts_of_the_Heart_Track1.txt");
        FileReader FRTrack2 = new FileReader("src/Pure_Furies__Whereabouts_of_the_Heart_Track2.txt");

        String fq1 = "";
        int fq1Size = 0;
        String fd1 = "";
        int fd1Size = 0;
        int track1Duration = 0;
        String temp = "";
        boolean isFrequency = true;
        int character;
        while(true){
            character=FRTrack1.read();
            if(Character.isDigit((char)character)) temp = temp.concat(String.valueOf((char)character));
            else if((char)character == ';') {
                if(temp.equals("")) continue;
                if(isFrequency){
                    fq1 = fq1.concat(temp + ", ");
                    isFrequency = false;
                    fq1Size++;
                }
                else{
                    fd1 = fd1.concat(temp + ", ");
                    track1Duration+=Integer.parseInt(temp);
                    isFrequency = true;
                    fd1Size++;
                }
                temp = "";
            }
            else if(character == -1) break;
        }
        System.out.println(fq1);
        System.out.println("Frequency Track 1 size: " + fq1Size);
        System.out.println(fd1);
        System.out.println("Duration Track 1 size: " + fd1Size + ". Duration: " + track1Duration/1000 + " Seconds(" + track1Duration/60000 + ":" + (track1Duration/1000)%60 + ")." + "\n");


        String fq2 = "";
        int fq2Size = 0;
        String fd2 = "";
        int fd2Size = 0;
        int track2Duration = 0;
        temp = "";
        isFrequency = true;
        while(true){
            character=FRTrack2.read();
            if(Character.isDigit((char)character)) temp = temp.concat(String.valueOf((char)character));
            else if((char)character == ';') {
                if(temp.equals("")) continue;
                if(isFrequency){
                    fq2 = fq2.concat(temp + ", ");
                    isFrequency = false;
                    fq2Size++;
                }
                else{
                    fd2 = fd2.concat(temp + ", ");
                    track2Duration+=Integer.parseInt(temp);
                    isFrequency = true;
                    fd2Size++;
                }
                temp = "";
            }
            else if(character == -1) break;
        }
        System.out.println(fq2);
        System.out.println("Frequency Track 2 size: " + fq2Size);
        System.out.println(fd2);
        System.out.println("Duration Track 2 size: " + fd2Size + ". Duration: " + track2Duration/1000 + " Seconds(" + track2Duration/60000 + ":" + (track2Duration/1000)%60 + ").");
    }
}