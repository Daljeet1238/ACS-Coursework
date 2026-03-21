import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
public class Lottery{
    private String date;
    private Lottery lotteryTicket;
    
    public Lottery(){
        date = "unknown";
    }
    public Lottery(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public Lottery getLotteryTicket(){
        return lotteryTicket;
    }
    public void setLotteryticket(Lottery lotteryTicket){
        this.lotteryTicket = lotteryTicket;
    }
}
