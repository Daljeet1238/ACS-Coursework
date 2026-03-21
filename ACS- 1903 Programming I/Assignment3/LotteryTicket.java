import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
public class LotteryTicket{
    private ArrayList<Integer> numbers;
    private ArrayList<Lottery> lottery;
    
    public LotteryTicket(){
        numbers = new ArrayList<>();
    }
    public LotteryTicket(ArrayList<Integer> numbers){
        this.numbers = numbers;
    }
    public ArrayList getnumbres(){
        return numbers;
    }
    public void setArrayList(ArrayList<Integer> numbers){
        this.numbers = numbers;
    }
    public ArrayList<Lottery> getLottery(){
        return lottery;
    }
    public void setLottery(ArrayList<Lottery> lottery){
        this.lottery = lottery;
    }
    public void addLottery(Lottery l){
        lottery.add(l);
    }
}