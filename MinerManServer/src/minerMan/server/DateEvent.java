package minerMan.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;

public class DateEvent {
	final String netLoc = "https://raw.github.com/lepakko683/LeCraft/master/DateEvents.txt";
	String[] months = new String[]{
			"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"
	};
	private String begin;
	private String end;
	private String name;
	private String desc;
	Calendar cal;
	
	public DateEvent(String begin, String end, String name){
		this.begin=begin;
		this.end=end;
		this.name=name;
		this.desc="Default Description";
		cal = Calendar.getInstance();
	}
	
	public boolean isActive(){
		//cal.set(2013, 11, 01);
		String cda = cal.getTime().toString();
		//System.out.println(cda);
		cda = this.getDate(cda);
		//System.out.println(cda);
		
		int month = Integer.parseInt(cda.substring(3,5));
		int day = Integer.parseInt(cda.substring(0, 2));
		if(month >= Integer.parseInt(this.begin.substring(3, 5)) && month <= Integer.parseInt(this.end.substring(3, 5))){
			if(day >= Integer.parseInt(this.begin.substring(0, 2)) && day <= Integer.parseInt(this.end.substring(0, 2))){
				return true;
			}
		}
		
		return false;
	}
	
	public String getDate(String cda){
		String ret = "";
		String day = cda.substring(8, 10);
		String month = cda.substring(4, 7);
		
		for(int q=0;q<months.length;q++){
			if(month.toLowerCase().equals(months[q])){
				//System.out.println("help");
				if(q+1<10){
					month="0"+Integer.toString(q+1);
				}else{
					month=Integer.toString(q+1);
				}
			}
		}
		ret=day+"."+month;
		
		return ret;
	}
	public String getDesc(){
		return this.desc;
	}
	
	public void setDesc(String str){
		this.desc = str;
	}
	public String toString(){
		return "DateEvent - " + this.name + " Desc: " + this.getDesc() + " B: " + this.begin + " E: " + this.end + " A: " + this.isActive();
	}
}
